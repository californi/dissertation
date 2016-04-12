package edu.hkust.cse.phoneAdapter.context;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import android.app.IntentService;
import android.app.Notification;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;
import edu.hkust.cse.phoneAdapter.R;
import edu.hkust.cse.phoneAdapter.activity.MainActivity;

/**
 * The Class ContextManager.
 * @author andrew
 */
//[SERVICE-EA-BEGIN-ContextManager]
public class ContextManager extends IntentService {
	private boolean mGpsAvailable;
	
	private String mLocation;
	
	private double mSpeed;
	
	private ArrayList<String> mBtDeviceList;
	
	private String mTime;
	
	private String mWeekday;
	
	private SimpleDateFormat mTimeFormat;
	
	//[RG-EA-Clock]
	private Calendar mCal;
	
	//[RG-EA-GPS]
	private LocationManager mLocManager;
	
	private long mLastTime;
	
	private String mLastLocation;
	
	private Handler mHandler;
	
	//[RG-EA-Bluetooth]
	private BluetoothAdapter mBtAdapter;
	
	private MyBroadcastReceiver mReceiver;
	
	private boolean mStop;
	
	private static final String TAG = "PhoneAdapterContextLog";
	
	private BufferedWriter bw;
	
	private BufferedWriter bwService;
	
	private LocationListener mLocListener;
	
	private static boolean running;
	
	/**
	 * Instantiates a new context manager.
	 */
	public ContextManager(){
		super("ContextManager");
	}
	
	//[THREAD-EA-BEGIN-onCreate]
	@Override
	public void onCreate() {
		super.onCreate();
		
		//Sensor de lugar
		mLocManager=(LocationManager) getSystemService(LOCATION_SERVICE);
		mLocListener=new MyLocationListener();
		mLocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0, 0, mLocListener);
		
		mBtDeviceList=new ArrayList<String>();
		mCal=Calendar.getInstance();
		mTimeFormat=new SimpleDateFormat("HH:mm:ss");
		mLastTime=0;
		mHandler=new Handler();
		
		mBtAdapter=BluetoothAdapter.getDefaultAdapter();
		if(mBtAdapter==null){
			//[IMPREVISIBILIDADE-TRACE]
			Toast.makeText(getApplicationContext(), "Bluetooth is not supported on this device!", Toast.LENGTH_SHORT).show();
		} else{
			mBtAdapter.enable();
		}
		mReceiver=new MyBroadcastReceiver();
		IntentFilter iFilter = new IntentFilter();
		iFilter.addAction("edu.hkust.cse.phoneAdapter.stopService");
		if(mBtAdapter != null){
			if(mBtAdapter.isEnabled()){
				iFilter.addAction(BluetoothDevice.ACTION_FOUND);
				iFilter.addAction(BluetoothAdapter.ACTION_DISCOVERY_STARTED);
				iFilter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
			}
		}
		registerReceiver(mReceiver, iFilter);
		mStop=false;
		mLocation=new String();
		
		/* create a buffered writer to write context data to sd card */
		File dir = Environment.getExternalStorageDirectory();
		if(dir != null && dir.canWrite()){
			File file = new File(dir + "/contextLog");
			try{
				if(!file.exists()){
					file.createNewFile();
				}
				bw = new BufferedWriter(new FileWriter(file, true));
			} catch(Exception e){
				Log.e(TAG, "cannot log context, "+e.getMessage());
			}
		} else{
			//[IMPREVISIBILIDADE-TRACE]
			Toast.makeText(getApplicationContext(), "No writtable SD card!", Toast.LENGTH_SHORT).show();
		}
		
		/* for experiment, to study how service got destroyed */
		if(dir != null && dir.canWrite()){
			File file = new File(dir + "/serviceLog");
			try{
				if(!file.exists()){
					file.createNewFile();
				}
				bwService = new BufferedWriter(new FileWriter(file, true));
				bwService.write(mCal.getTime().toString()+ "service starts" +System.getProperty("line.separator"));
				bwService.flush();
			} catch(Exception e){
				Log.e(TAG, "cannot log service life cycle issues, "+e.getMessage());
			}
		} else{
			//[IMPREVISIBILIDADE-TRACE]
			Toast.makeText(getApplicationContext(), "No writtable SD card!", Toast.LENGTH_SHORT).show();
		}
		
		/**start foreground service**/
		// step 1: instantiate the notification
		int icon = R.drawable.icon;
		CharSequence tickerText = "hello";
		long when = System.currentTimeMillis();
		Notification noti = new Notification(icon, tickerText, when);
		
		//step 2: define the notification's message and PendingIntent
		Context context = getApplicationContext();
		CharSequence contentTitle = "PhoneAdapter";
		CharSequence contentText = "Context manager is running";
		Intent notiIntent = new Intent(this, MainActivity.class);
		PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notiIntent, 0);
		noti.setLatestEventInfo(context, contentTitle, contentText, contentIntent);
		
		startForeground(1346, noti);
		
		ContextManager.running = true;
	}
	//[THREAD-EA-END-onCreate]
	
	@Override
	public void onDestroy() {
		try{
			unregisterReceiver(mReceiver);
			mLocManager.removeUpdates(mLocListener);
			bw.flush();
			bw.close();
			bwService.write(mCal.getTime().toString()+ "service stops" +System.getProperty("line.separator"));
			bwService.flush();
			bwService.close();
		} catch(Exception e){
			mHandler.post(new Runnable() {
				@Override
				public void run() {
					//[IMPREVISIBILIDADE-TRACE]
					Toast.makeText(getApplicationContext(), "Failed to unregister broadcast receiver!", Toast.LENGTH_SHORT).show();
				}
			});
		}
		/**stop foreground service**/
		stopForeground(true);
		
		ContextManager.running = false;
		
		super.onDestroy();
	}

	@Override
	//[INTERATION-EA-EVENT-BEGIN-devido à herança de intentservice]
	//[RG-SENSOR-GET-BEGIN]
	protected void onHandleIntent(Intent arg0) {
		/*
		 * collect contexts every a while and broadcast the context change
		 * context type includes
		 * (1) gps availability
		 * (2) gps location
		 * (3) gps speed
		 * (4) bluetooth devices
		 * (5) bluetooth count
		 * (6) time
		 * (7) weekday
		 */
		//[GA-MONITOR-BEGIN-coleta informações dos sensores para determinar contexto]
		while(!mStop){
			/* get weekday */
			//[GA-MONITOR-GETDATA-BEGIN-dataHora]
			mCal=Calendar.getInstance();
			//[GA-MONITOR-GETDATA-END-dataHora]
			
			//[GA-MONITOR-PREPROCESS-BEGIN - de DataHora para Dia da semana]
			mTime=mTimeFormat.format(mCal.getTime());
			switch(mCal.get(Calendar.DAY_OF_WEEK)){
			case 1:
				mWeekday="sunday";
				break;
			case 2:
				mWeekday="monday";
				break;
			case 3:
				mWeekday="tuesday";
				break;
			case 4:
				mWeekday="wednesday";
				break;
			case 5:
				mWeekday="thursday";
				break;
			case 6:
				mWeekday="friday";
				break;
			case 7:
				mWeekday="saturday";
				break;
			default:
				break;
			}
			//[GA-MONITOR-PREPROCESS-END - de DataHora para Dia da semana]
			
			if(mBtAdapter != null){
				/* start a new thread to perform Bluetooth device search */
				if(!mBtAdapter.isEnabled()){
					mHandler.post(new Runnable() {
					@Override
					public void run() {
						//[IMPREVISIBILIDADE-TRACE]
						Toast.makeText(getApplicationContext(), "enabling bt adapter.", Toast.LENGTH_SHORT).show();
					}
				});
					mBtAdapter.enable();
				}
				mBtAdapter.cancelDiscovery();
				mBtAdapter.startDiscovery();
			}
			
			mHandler.post(new Runnable() {
				@Override
				public void run() {
					/* broadcast new context*/
					//[GA-MONITOR-UPDATE-BEGIN]
					Intent i=new Intent();
					//[GA-MONITOR-FLAGANALISADOR-BEGIN-sinaliza um novo contexto gerado]
					i.setAction("edu.hkust.cse.phoneAdapter.newContext");
					//[GA-MONITOR-FLAGANALISADOR-END-sinaliza um novo contexto gerado]
					i.putExtra(ContextName.GPS_AVAILABLE, mGpsAvailable);
					i.putExtra(ContextName.GPS_LOCATION, mLocation);
					i.putExtra(ContextName.GPS_SPEED, mSpeed);
					i.putExtra(ContextName.BT_DEVICE_LIST, transformListToArray(mBtDeviceList));
					i.putExtra(ContextName.BT_COUNT, mBtDeviceList.size());
					i.putExtra(ContextName.TIME,mTime);
					i.putExtra(ContextName.WEEKDAY, mWeekday);
					sendBroadcast(i);
					//[GA-MONITOR-UPDATE-END-sinaliza um novo contexto gerado]
					
					/* Log de contexto para an�lise  */
					StringBuffer sb = new StringBuffer();
					sb.append(mGpsAvailable);
					sb.append('@');
					sb.append(mLocation);
					sb.append('@');
					sb.append(mSpeed);
					sb.append('@');
					for(int index=0; index< mBtDeviceList.size(); index++){
						sb.append(mBtDeviceList.get(index));
						sb.append('@');
					}
					sb.append(mBtDeviceList.size());
					sb.append('@');
					sb.append(mTime);
					sb.append('@');
					sb.append(mWeekday);
					
					/* Log de contexto para an�lise  */
					Log.i("Testing-SA-Entrada", sb.toString());
					
					/* write context-data to external storage (SD card) */
					String eol = System.getProperty("line.separator");
					if(bw != null){
						try{
							bw.write(sb.toString() + eol);
							bw.flush();
//							mHandler.post(new Runnable() {
//								
//								@Override
//								public void run() {
//									Toast.makeText(getApplicationContext(), "one entry added", Toast.LENGTH_SHORT).show();
//								}
//							});
						} catch(Exception e){
							Log.e(TAG, "cannot log context, " + e.getMessage());
						}
					}
				}
			});
			try{
				//[INTERATION-EA-TIME-BEGIN-a cada 2 minutos o codigo deste bloco é executado]
				//[GA-MONITOR-REINICIA-BEGIN-a cada 2 minutos o codigo deste bloco é executado]
				Thread.sleep(120000);
				//[GA-MONITOR-REINICIA-END-a cada 2 minutos o codigo deste bloco é executado]
				//[INTERATION-EA-TIME-END-a cada 2 minutos o codigo deste bloco é executado]
			} catch(Exception e){
				Log.e("edu.hkust.cse.phoneAdapter.error", "Thread sleep exception");
			}
		}
		//[GA-MONITOR-END-coleta informações dos sensores para determinar contexto]
	}
	//[RG-SENSOR-GET-END]
	//[INTERATION-EA-EVENT-END-devido à herança de intentservice]
	
	// the unit of duration is millisecond
	/**
	 * Calculate speed.
	 *
	 * @param lastLoc the previously sensed location (GPS coordinate)
	 * @param curLoc the current location
	 * @param duration the unit of duration is millisecond
	 * @return speed
	 */
	private double calculateSpeed(String lastLoc, String curLoc, int duration){
		double d=AdaptationManager.calculateDist(lastLoc, curLoc);
		double result=d/(duration/1000.0);
		return result;
	}
	
	/**
	 * Check whether a specific MAC address is contained in a list.
	 * @param macList the list of MAC addresses
	 * @param mac the specific MAC
	 * @return true if the list contains the specific MAC, and false otherwise
	 */
	private boolean listContainsMac(ArrayList<String> macList, String mac){
		for(int i=0;i<macList.size();i++){
			if(macList.get(i).equals(mac)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Transform a list of strings to an array of strings.
	 *
	 * @param list the list of strings
	 * @return a string array
	 */
	private String[] transformListToArray(ArrayList<String> list){
		String[] s=new String[list.size()];
		for(int i=0;i<list.size();i++){
			s[i]=list.get(i);
		}
		return s;
	}
	
	/** indicate whether the service is running or not*/
	
	public static boolean isRunning(){
		return ContextManager.running;
	}
	
	/**
	 * The Class MyBroadcastReceiver.
	 */
	//[THREAD-EA-BEGIN-Verificar dispositivos]
	//[RG-SENSOR-LISTENER-BEGIN-Bluetooth]
	private class MyBroadcastReceiver extends BroadcastReceiver{

		@Override
		//[INTERATION-EA-EVENT-BEGIN-devido ao listener com filtro para Bluetooth]
		//[RG-SENSOR-CHANGED-BEGIN-Bluetooth] 
		public void onReceive(Context c, Intent i) {		
			//[GA-MONITOR-BEGIN-coleta informações dos dispositivos de bluetooth conectados]
			//[GA-MONITOR-GETDATA-BEGIN-Bluetooth]
			String action=i.getAction();
			//[GA-KNOWLEDGE-ESTATICO-BEGIN-verifica o tipo de ação do recurso gerenciado]
			if(action.equals(BluetoothAdapter.ACTION_DISCOVERY_STARTED)){
				mBtDeviceList=new ArrayList<String>();
				/* Log de contexto para an�lise  */
				Log.i("Testing-SA-Sensor-BT", "BluetoothAdapter.ACTION_DISCOVERY_STARTED");
			} 
			else if( action.equals(BluetoothDevice.ACTION_FOUND)){
				//[GA-MONITOR-PREPROCESS-BEGIN - verifica se o bluetooth encontrado está presente na lista de dispositivos]
				BluetoothDevice device=i.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
				Log.i("Testing-SA-Sensor-BT", "BluetoothDevice.EXTRA_DEVICE");
				
				if(!listContainsMac(mBtDeviceList, device.getAddress())){
					mBtDeviceList.add(device.getAddress());
				}
				//[GA-MONITOR-PREPROCESS-END - verifica se o bluetooth encontrado está presente na lista de dispositivos]
			} 
			else if(action.equals(BluetoothAdapter.ACTION_DISCOVERY_FINISHED)){
				Log.i("Testing-SA-Sensor-BT", "BluetoothAdapter.ACTION_DISCOVERY_FINISHED");
			} 
			else if(action.equals("edu.hkust.cse.phoneAdapter.stopService")){
				mStop=true;
				stopSelf();
			} 
			else {
			}
			//[GA-KNOWLEDGE-ESTATICO-END-verifica o tipo de ação do recurso gerenciado]
			//[GA-MONITOR-GETDATA-END-Bluetooth]
			//[GA-MONITOR-END-coleta informações dos dispositivos de bluetooth conectados]
		}
		//[RG-SENSOR-CHANGED-END-Bluetooth] 
		//[INTERATION-EA-EVENT-END-devido ao listener com filtro para Bluetooth]
	}
	//[RG-SENSOR-LISTENER-END-Bluetooth]
	//[THREAD-EA-END-Verificar dispositivos]
			
	
	/**
	 * The listener interface for receiving myLocation events.
	 * The class that is interested in processing a myLocation
	 * event implements this interface, and the object created
	 * with that class is registered with a component using the
	 * component's <code>addMyLocationListener<code> method. When
	 * the myLocation event occurs, that object's appropriate
	 * method is invoked.
	 *
	 * @see MyLocationEvent
	 */
	//[GA-MONITOR-BEGIN-coleta informações da localização do gps]
	//[THREAD-EA-BEGIN-Verificar localização]
	//[RG-SENSOR-LISTENER-BEGIN-GPS] 
	private class MyLocationListener implements LocationListener{

		@Override
		//[INTERATION-EA-EVENT-BEGIN-devido à mudança de localização]
		//[RG-SENSOR-CHANGED-BEGIN-GPS] 
		public void onLocationChanged(Location loc) {
			
			Log.i("Testing-SA-Sensor-GPS", "onLocationChanged");
			Log.d("Testing-SA-Sensor-GPS", "onLocationChanged");
			
			/*
			 * sense the current location, caculate speed, and set the current time
			 */
			//[GA-MONITOR-GETDATA-BEGIN-GPS]
			mLocation=loc.getLatitude()+","+loc.getLongitude();
			//[GA-MONITOR-GETDATA-END-GPS]
			
			
			/* calculate speed and update current time */
			//[GA-MONITOR-PREPROCESS-BEGIN - obtêm velocidade e tempo entre a ultima localização e a atual]
			long curTime=System.currentTimeMillis();
			//[GA-KNOWLEDGE-ESTATICO-BEGIN-verifica se ultimo tempo diferente de zero]
			if(mLastTime!=0 && mLastLocation!=null){
				int duration=(int)(curTime-mLastTime);
				mSpeed=calculateSpeed(mLastLocation, mLocation, duration);
			} else{
				mSpeed=-1;
			}
			//[GA-KNOWLEDGE-ESTATICO-END-verifica se ultimo tempo diferente de zero]
			mLastLocation=mLocation;
			mLastTime=curTime;
			//[GA-MONITOR-PREPROCESS-END - obtêm velocidade e tempo entre a ultima localização e a atual]
			
			
		}
		//[RG-SENSOR-CHANGED-END-GPS] 
		//[INTERATION-EA-EVENT-END-devido à mudança de localização]

		@Override
		public void onProviderDisabled(String arg0) {
			/* set mLocation to null, set last location to null and update last time to 0 */			
			mGpsAvailable=false;
			mLocation=null;
			mLastLocation=null;
			mLastTime=0;
		}

		@Override
		public void onProviderEnabled(String arg0) {
			mGpsAvailable=true;
		}

		@Override
		public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
			
		}
	}
	//[RG-SENSOR-LISTENER-END-GPS] 
	//[THREAD-EA-END-Verificar localização]
	//[GA-MONITOR-BEGIN-coleta informações da localização do gps]
}
//[SERVICE-EA-END-ContextManager]
