package edu.hkust.cse.phoneAdapter.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import edu.hkust.cse.phoneAdapter.R;
import edu.hkust.cse.phoneAdapter.context.ContextType;
import edu.hkust.cse.phoneAdapter.database.MyDbAdapter;

/**
 * The Class records context constants (e.g., the GPS coordinate of home)
 * @author andrew
 */
public class CreateContextConstantActivity extends Activity {
	
	/* editable text views */
	private EditText mLocationName;
	private EditText mDeviceName;
	private EditText mLatitude;
	private EditText mLongitude;
	private EditText mMacAddr;
	
	/* buttons */
	private Button mFillLocation;
	private Button mSaveLocation;
	private Button mSearchDevice;
	private Button mSaveDevice;
	private Button mQuit;

	/* SQLite adapter */
	private MyDbAdapter mDbHelper;
	
	private LocationManager mLocationManager;
	
	private String mLocName;
	private String mLat;
	private String mLon;
	private String mDevName;
	private String mMac;

	/* database cursors */
	private Cursor mLocCursor;
	private Cursor mBtCursor;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		/* set GUI layout*/
		setContentView(R.layout.record_context);
		
		/* open database */
		mDbHelper=new MyDbAdapter(this);
		mDbHelper.open();
		
		/* retrieve all widgets */ 
		mLocationName=(EditText) findViewById(R.id.location_name_textbox_in_record_constant);
		mDeviceName=(EditText) findViewById(R.id.bt_name_textbox_in_record_constant);
		mLatitude=(EditText) findViewById(R.id.latitude_textbox_in_record_constant);
		mLongitude=(EditText) findViewById(R.id.longitude_textbox_in_record_constant);
		mMacAddr=(EditText) findViewById(R.id.bt_mac_textbox_in_record_constant);
		mFillLocation=(Button) findViewById(R.id.fill_in_current_location_btn_in_record_constant);
		mSaveLocation=(Button) findViewById(R.id.save_location_btn_in_record_constant);
		mSearchDevice=(Button) findViewById(R.id.detect_device_btn_in_record_constant);
		mSaveDevice=(Button) findViewById(R.id.save_device_btn_in_record_constant);
		mQuit=(Button) findViewById(R.id.quit_btn_in_create_context_constant);
		
		/* new location manager */
		mLocationManager=(LocationManager)getSystemService(LOCATION_SERVICE);
		
		/* register button listeners */
		registerListenerForFillLocationBtn();
		registerListenerForSaveDeviceBtn();
		registerListenerForSaveLocationBtn();
		registerListenerForSearchDeviceBtn();
		registerListenerForQuitBtn();
		registerListenerForLocationManager();
		
	}
	
	/**
	 * Register listener for fill location button. When the button is clicked, application tries to get the last sensed location and fill the GPS coordinate text box (latitude and longitude).
	 */
	private void registerListenerForFillLocationBtn(){
		mFillLocation.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Location loc=mLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
				if(loc!=null){
					mLatitude.setText(new Double(loc.getLatitude()).toString());
					mLongitude.setText(new Double(loc.getLongitude()).toString());
				} else{
					Toast.makeText(getApplicationContext(), "GPS data is not available now! Please wait patiently.", Toast.LENGTH_SHORT).show();
				}
			}
		});		
	}
	
	/**
	 * Register listener for save location button. When the button is clicked, application first validates -90 <= latitude <= 90 and -180 <= longitude <= 180. 
	 * Then it records the coordinate and associate it with the name specified in the Location Home text box.
	 */
	private void registerListenerForSaveLocationBtn(){
		mSaveLocation.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				/* get the location name specified by user */
				mLocName=mLocationName.getText().toString();
				
				/* get the GPS coordinate */
				mLat=mLatitude.getText().toString();
				mLon=mLongitude.getText().toString();
				
				if(mLat==null || mLon==null || mLat.length()==0 || mLon.length()==0 || mLocName==null || mLocName.length()==0){
					Toast.makeText(getApplicationContext(), "Empty location name or GPS coordinate!", Toast.LENGTH_SHORT).show();
				} else{
					try{
						double latitude=Double.parseDouble(mLat);
						double longitude=Double.parseDouble(mLon);
						
						/* validate the coordinate and location name
						 * if-case: valid data, try to save it to database
						 * else-case: invalid data, alert user 
						 */
						if(latitude>=-90.0 && latitude<=90.0 && longitude>=-180.0 && longitude<=180.0){
							/*range is ok, insert to database, gps data is stored as "lat,lon". Before insertion, check whether the GPS data with the same name exists */
							mLocCursor=mDbHelper.fetchContextConstantByNameAndType(mLocName, ContextType.GPS_LOCATION);
							startManagingCursor(mLocCursor);
							
							/* if-case: the location has not been stored before, simply insert it to database and notify user 
							 * else-case: the location has been store before, pop up a dialog to ask user whether he wants to update the location data 
							 */
							if(mLocCursor.getCount()==0){
								if(mDbHelper.insertContextConstant(ContextType.GPS_LOCATION,mLocName, mLat+","+mLon)>0){
									Toast.makeText(getApplicationContext(), "Location saved!", Toast.LENGTH_SHORT).show();
									setResult(RESULT_OK);
									finish();
								} else{
									Toast.makeText(getApplicationContext(), "Errors in saving, please try again!", Toast.LENGTH_SHORT).show();
								}								
							} else{
								AlertDialog.Builder builder=new AlertDialog.Builder(CreateContextConstantActivity.this);
								builder.setMessage("A location record with the same name exists in database!")
								.setCancelable(false)
								.setPositiveButton("Update", new DialogInterface.OnClickListener() {						
									@Override
									public void onClick(DialogInterface arg0, int arg1) {
										/* update database */
										mLocCursor.moveToFirst();
										Long rowId=mLocCursor.getLong(mLocCursor.getColumnIndex(MyDbAdapter.KEY_ROW_ID));
										if(mDbHelper.updateContextConstant(rowId, ContextType.GPS_LOCATION, mLocName, mLat+","+mLon)){
											Toast.makeText(getApplicationContext(), "update successful!", Toast.LENGTH_SHORT).show();
											setResult(RESULT_OK);
											finish();
										} else{
											Toast.makeText(getApplicationContext(), "Nothing is updated", Toast.LENGTH_SHORT).show();
										}
									}
								})
								.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
									/* user chooses not to update the database */
									@Override
									public void onClick(DialogInterface dialog, int arg1) {
										dialog.cancel();
									}
								});
								AlertDialog alert=builder.create();
								alert.show();
							}

						} else{
							Toast.makeText(getApplicationContext(), "Invalid data! Latitude should be within [-90.0,90.0] and longitude [-180.0,180.0].", Toast.LENGTH_SHORT).show();
						}
					} catch(NumberFormatException e){
						Toast.makeText(getApplicationContext(), "Invalid format! Double is expected!", Toast.LENGTH_SHORT).show();
					}
				}
			}
		});
	}
	
	/**
	 * Register listener for search device button. When the button is clicked, the search and save BT device activity will be started.
	 * @see SearchAndSaveBTDevice
	 */
	private void registerListenerForSearchDeviceBtn(){
		mSearchDevice.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent i=new Intent(CreateContextConstantActivity.this, SearchAndSaveBTDevice.class);
				startActivity(i);
			}
		});
	}
	
	/**
	 * Register listener for save device button. When the button is clicked, application tries to store a BT device info into database
	 */
	private void registerListenerForSaveDeviceBtn(){
		mSaveDevice.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				/* get the device name and MAC address */
				mDevName=mDeviceName.getText().toString();
				mMac=mMacAddr.getText().toString();
				
				if(mDevName==null || mDevName.length()==0 || mMac==null || mMac.length()==0){
					Toast.makeText(getApplicationContext(), "Empty data!", Toast.LENGTH_SHORT).show();
				} else{
					/* validate MAC address format dd:dd:dd:dd:dd:dd */
					if(mMac.matches("([0-9a-fA-F][0-9a-fA-F]:){5}([0-9a-fA-F][0-9a-fA-F])")){
						/* check whether the device with the same name is already in database */
						mBtCursor=mDbHelper.fetchContextConstantByNameAndType(mDevName, ContextType.BLUETOOTH);
						startManagingCursor(mBtCursor);
						
						/*
						 * if-case: no bluetooth device with the same name is found in database, simply save it and notify user
						 * else-case: a bluetooth device with the same name already exists in database, ask the user whether he wants to update
						 */
						if(mBtCursor.getCount()==0){
							if(mDbHelper.insertContextConstant(ContextType.BLUETOOTH,mDevName, mMac)>0){
								Toast.makeText(getApplicationContext(), "BT device saved!", Toast.LENGTH_SHORT).show();
								setResult(RESULT_OK);
								finish();
							} else{
								Toast.makeText(getApplicationContext(), "Errors in saving, please try again!", Toast.LENGTH_SHORT).show();
							}								
						} else{
							AlertDialog.Builder builder=new AlertDialog.Builder(CreateContextConstantActivity.this);
							builder.setMessage("A Bluetooth device with the same name already exists in database!")
							.setCancelable(false)
							.setPositiveButton("Update", new DialogInterface.OnClickListener() {						
								@Override
								public void onClick(DialogInterface arg0, int arg1) {
									/* update the device information */
									mBtCursor.moveToFirst();
									Long rowId=mBtCursor.getLong(mBtCursor.getColumnIndex(MyDbAdapter.KEY_ROW_ID));
									if(mDbHelper.updateContextConstant(rowId, ContextType.BLUETOOTH, mDevName, mMac)){
										Toast.makeText(getApplicationContext(), "update successful!", Toast.LENGTH_SHORT).show();
										setResult(RESULT_OK);
										finish();
									} else{
										Toast.makeText(getApplicationContext(), "Nothing is updated", Toast.LENGTH_SHORT).show();
									}
								}
							})
							.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
								/* user chooses not to update */
								@Override
								public void onClick(DialogInterface dialog, int arg1) {
									dialog.cancel();
								}
							});
							AlertDialog alert=builder.create();
							alert.show();
						}
					} else{
						Toast.makeText(getApplicationContext(), "Invalid format!", Toast.LENGTH_SHORT).show();
					}
				}
			}
		});
	}
	
	/**
	 * Register listener for quit btn. When the button is clicked, the current activity is finished.
	 */
	private void registerListenerForQuitBtn(){
		mQuit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				setResult(RESULT_CANCELED);
				finish();
			}
		});
	}
	
	/**
	 * Register listener for location manager. 
	 */
	private void registerListenerForLocationManager(){
		mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, new MyLocationListener());
	}
	
	/**
	 * MyLocationListerner class implements the abstract interface Location Listener
	 * @see LocationListener
	 */
	public class MyLocationListener implements LocationListener{
		@Override
		public void onLocationChanged(Location arg0) {
		}

		@Override
		public void onProviderDisabled(String arg0) {
			Toast.makeText(getApplicationContext(), "GPS is turned off!", Toast.LENGTH_SHORT).show();	
		}

		@Override
		public void onProviderEnabled(String arg0) {
			Toast.makeText(getApplicationContext(), "GPS is turned on!", Toast.LENGTH_SHORT).show();
		}

		@Override
		public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		}
	}

	@Override
	protected void onDestroy() {
		if(mLocCursor!=null){
			mLocCursor.close();
		}
		if(mBtCursor!=null){
			mBtCursor.close();
		}
		mDbHelper.close();
		super.onDestroy();
	}
}
