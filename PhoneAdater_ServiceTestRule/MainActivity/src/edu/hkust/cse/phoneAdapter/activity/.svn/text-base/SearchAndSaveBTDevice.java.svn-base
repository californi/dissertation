package edu.hkust.cse.phoneAdapter.activity;

import java.util.ArrayList;
import java.util.Set;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import edu.hkust.cse.phoneAdapter.R;
import edu.hkust.cse.phoneAdapter.context.ContextType;
import edu.hkust.cse.phoneAdapter.database.MyDbAdapter;

/**
 * The Class SearchAndSaveBTDevice.
 * @author andrew
 */
public class SearchAndSaveBTDevice extends Activity implements Runnable {
	
	private BluetoothAdapter mBtAdapter;
	
	private BroadcastReceiver mReceiver;
	
	private ArrayList<String> mDeviceNameList;
	private ArrayList<String> mDeviceMacList;
	
	private ProgressDialog mPd;
	
	private boolean mScanning=false;
	
	private ListView mLv;
	
	private Button mSaveBtn;
	private Button mCancelBtn;
	
	private MyDbAdapter mDbHelper;
	
	private Cursor mCursor;
	
	private String mDeviceName;
	private String mDeviceMac;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mDbHelper=new MyDbAdapter(this);
		mDbHelper.open();
		
		/* get the reference of widgets*/
		mLv=(ListView) findViewById(R.id.list_view_in_search_bt_device);
		mSaveBtn=(Button) findViewById(R.id.save_selected_device);
		mCancelBtn=(Button) findViewById(R.id.cancel_btn_in_search_and_save_bt_devices);
		
		/* get Bluetooth adapter and enable Bluetooth when necessary */
		mBtAdapter=BluetoothAdapter.getDefaultAdapter();
		if(mBtAdapter==null){
			Toast.makeText(getApplicationContext(), "Bluetooth is not supported by this device!", Toast.LENGTH_SHORT).show();
			setResult(RESULT_CANCELED);
			finish();
		} else
		{
			if(!mBtAdapter.isEnabled()){
				mBtAdapter.enable();
				Toast.makeText(this, "Bluetooth is enabled!", Toast.LENGTH_SHORT).show();
				if(mBtAdapter.isEnabled()){
					mDeviceNameList=new ArrayList<String>();
					mDeviceMacList=new ArrayList<String>();
					/* query paired devices */
					Set<BluetoothDevice> pairedDevices=mBtAdapter.getBondedDevices();
					if(pairedDevices.size()>0){
						for(BluetoothDevice d : pairedDevices){
							mDeviceNameList.add(d.getName());
							mDeviceMacList.add(d.getAddress());
						}
					}
					
					/* discover devices */
					mReceiver=new BroadcastReceiver() {
						@Override
						public void onReceive(Context c, Intent i) {
							String action=i.getAction();
							if(BluetoothAdapter.ACTION_DISCOVERY_STARTED.equals(action)){
								/* start a progress bar, the ending time is unknown until the discovery-finished msg is broadcasted */ 
								mPd=ProgressDialog.show(SearchAndSaveBTDevice.this, "Searching Device", "Please wait...",true,false);
								mScanning=true;
							}
							
							/* when finding a new device */
							if(BluetoothDevice.ACTION_FOUND.equals(action)){
								BluetoothDevice device=i.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
								mDeviceNameList.add(device.getName());
								mDeviceMacList.add(device.getAddress());
							}
							
							/* when discovery is finished */
							if(BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)){
								mScanning=false;
							}
						}
					};
					/* register the broadcast receiver */
					IntentFilter iFilter=new IntentFilter(BluetoothDevice.ACTION_FOUND);
					iFilter.addAction(BluetoothAdapter.ACTION_DISCOVERY_STARTED);
					iFilter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
					registerReceiver(mReceiver,iFilter);
					mBtAdapter.startDiscovery();
				}
			}
		}

	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		if(mCursor!=null){
			mCursor.close();
		}
		mDbHelper.close();
		try{
			unregisterReceiver(mReceiver);
		} catch(Exception e){
			Toast.makeText(getApplicationContext(), "Unregistering broadcast receiver failed!", Toast.LENGTH_SHORT);
		}
	}
	
	/**
	 * Fill data. The function uses discovered devices to populate a list view
	 */
	private void fillData(){
		String[] s=new String[mDeviceNameList.size()];
		for(int i=0;i<mDeviceNameList.size();i++){
			s[i]=mDeviceNameList.get(i)+"("+mDeviceMacList.get(i)+")";
		}
		mLv.setAdapter(new ArrayAdapter<String>(SearchAndSaveBTDevice.this, android.R.layout.simple_list_item_multiple_choice,s));
		mLv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
	}

	@Override
	public void run() {
		while(mScanning){
		}
		mPd.dismiss();
		fillData();
	}
	
	/**
	 * Register listener for save button.
	 */
	public void registerListenerForSaveBtn(){
		mSaveBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				/*
				 * get the name and mac address of each device
				 * if the device with the same name already exists, ask user whether to update or cancel
				 * don't store devices without name
				 */
				AlertDialog.Builder builder;
				SparseBooleanArray checkedItems=mLv.getCheckedItemPositions();
				for(int i=0;i<mDeviceNameList.size();i++){
					if(checkedItems.get(i)){
						mDeviceName=mDeviceNameList.get(i);
						mDeviceMac=mDeviceMacList.get(i);
						if(mDeviceName==null || mDeviceName.length()==0){
							Toast.makeText(getApplicationContext(), "Anonymous devices are not stored!", Toast.LENGTH_SHORT).show();
							continue;
						}
						mCursor=mDbHelper.fetchContextConstantByNameAndType(mDeviceName, ContextType.BLUETOOTH);
						startManagingCursor(mCursor);
						if(mCursor.getCount()==0){
							mDbHelper.insertContextConstant(ContextType.BLUETOOTH, mDeviceName, mDeviceMac);
							/* show a notification that the data is inserted */
							String msg="Device "+mDeviceName+") is saved!";
							Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
						} else{
							/* get the _id of the profile and update the database record, before that let user choose it using a dialog */
							builder=new AlertDialog.Builder(SearchAndSaveBTDevice.this);
							builder.setMessage("A Bluetooth device with the same name exists in database!")
							.setCancelable(false)
							.setPositiveButton("Update", new DialogInterface.OnClickListener() {						
								@Override
								public void onClick(DialogInterface arg0, int arg1) {
									/* get the id */
									mCursor.moveToFirst();
									Long rowId=mCursor.getLong(mCursor.getColumnIndex(MyDbAdapter.KEY_ROW_ID));
									if(mDbHelper.updateContextConstant(rowId, ContextType.BLUETOOTH, mDeviceName, mDeviceMac)){
										Toast.makeText(getApplicationContext(), "update successful!", Toast.LENGTH_SHORT).show();
									} else{
										Toast.makeText(getApplicationContext(), "Nothing is updated", Toast.LENGTH_SHORT).show();
									}
								}
							})
							.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog, int arg1) {
									dialog.cancel();
								}
							});
							AlertDialog alert=builder.create();
							alert.show();
						}
					}
				}
			}
		});
	}
	
	/**
	 * Register listener for cancel btn.
	 */
	public void registerListenerForCancelBtn(){
		mCancelBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				setResult(RESULT_CANCELED);
				finish();
			}
		});
	}
}
