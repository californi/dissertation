package edu.hkust.cse.phoneAdapter.activity;

import java.util.ArrayList;
import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;
import edu.hkust.cse.phoneAdapter.R;
import edu.hkust.cse.phoneAdapter.context.ContextOperator;
import edu.hkust.cse.phoneAdapter.context.ContextType;
import edu.hkust.cse.phoneAdapter.database.MyDbAdapter;

/**
 * The Class CreateFilterActivity. Each filter is an atomic proposition made on a context variable (e.g., is location near home?, the filter is "GPS_LOCATION == HOME")
 * @author andrew
 */
public class CreateFilterActivity extends Activity{
	
	/* database adpater */
	private MyDbAdapter mDbHelper;
	
	private Spinner mContextTypeSpinner;
	private Spinner mContextOpSpinner;

	private RadioButton mSelfDefineRadioBtn;
	private RadioButton mChooseFromDbRadioBtn;

	private EditText mSelfDefinedValue;
	
	private Spinner mChoicesSpinner;
	
	private Button mConfirmBtn;
	private Button mCancelBtn;
	
	private int mChosenContextType;
	private int mChosenContextOp;
	
	private String mContextValue;

	private boolean mSelfDefine;
	private boolean mChooseFromDb;
	
	private ArrayList<String> mLocationNameList;
	private ArrayList<String> mLocationDataList;
	private ArrayList<String> mDeviceNameList;
	private ArrayList<String> mDeviceMacList;

	private Long mRuleRowId;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		/* set GUI layout */
		setContentView(R.layout.create_filter);
		
		/* By default, application asks users to define context constant (e.g., in the rule "when location = office, put the phone on silent mode", "office" is a constant)*/
		mSelfDefine=true;
		mChooseFromDb=false;
		
		/* open database */
		mDbHelper=new MyDbAdapter(this);
		mDbHelper.open();
		
		/* get the reference of widgets */
		mContextTypeSpinner=(Spinner) findViewById(R.id.context_type_spinner);
		mContextOpSpinner=(Spinner) findViewById(R.id.context_op_spinner);
		mSelfDefineRadioBtn=(RadioButton) findViewById(R.id.self_define_radio);
		mChooseFromDbRadioBtn=(RadioButton) findViewById(R.id.choose_from_db_radio);
		mSelfDefinedValue=(EditText) findViewById(R.id.context_value_edit_text);
		mChoicesSpinner=(Spinner) findViewById(R.id.context_value_spinner);
		mConfirmBtn=(Button) findViewById(R.id.confirm_btn);
		mCancelBtn=(Button) findViewById(R.id.cancel_btn);
		
		/* set up the context type spinner */
		ArrayAdapter<CharSequence> adapterForContextTypeSpinner=ArrayAdapter.createFromResource(this, R.array.context_variable_types, android.R.layout.simple_spinner_item);
		adapterForContextTypeSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mContextTypeSpinner.setAdapter(adapterForContextTypeSpinner);
		registerListenerForContextTypeSpinner();
		
		/* set up the context op spinner */
		ArrayAdapter<CharSequence> adapterForContextOpSpinner=ArrayAdapter.createFromResource(this, R.array.context_operators, android.R.layout.simple_spinner_item);
		adapterForContextOpSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mContextOpSpinner.setAdapter(adapterForContextOpSpinner);
		registerListenerForContextOpSpinner();
		
		/* set up the radio buttons */
		registerListenerForSelfDefineRadioBtn();
		registerListenerForChooseFromDbRadioBtn();
		
		/* set up the choice spinner */
		registerListenerForChoiceSpinner();
		
		/* set up the confirm and cancel buttons */
		registerListenerForConfirmBtn();
		registerListenerForCancelBtn();
		
		mRuleRowId = (savedInstanceState == null) ? null :
            (Long) savedInstanceState.getSerializable(MyDbAdapter.KEY_ROW_ID);
        if (mRuleRowId == null) {
            Bundle extras = getIntent().getExtras();
            mRuleRowId = extras != null ? extras.getLong(MyDbAdapter.KEY_ROW_ID) : null;
        }
	}
	
	/**
	 * Register listener for context type spinner.
	 */
	private void registerListenerForContextTypeSpinner(){
		mContextTypeSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int pos, long id) {
					mChosenContextType=pos+1;
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				
			}
			
		});
	}
	
	/**
	 * Register listener for context op spinner.
	 */
	private void registerListenerForContextOpSpinner(){
		mContextOpSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int pos, long id) {
					mChosenContextOp=pos+1;
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				
			}
			
		});
		
	}
	
	/**
	 * Register listener for self define radio button. When self define button is clicked, users will input the context constants manually.
	 */
	private void registerListenerForSelfDefineRadioBtn(){
		mSelfDefineRadioBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				mSelfDefine=true;
				mChooseFromDb=false;
				
				/* display hint in text box according to the chosen context type */
				switch(mChosenContextType){
				case ContextType.GPS_ISVALID:
					mChoicesSpinner.setEnabled(false);
					mSelfDefinedValue.setEnabled(true);
					mSelfDefinedValue.setHint("true/false (case insensitive)");				
					break;
					
				case ContextType.GPS_LOCATION:
					mChoicesSpinner.setEnabled(false);
					mSelfDefinedValue.setEnabled(true);
					mSelfDefinedValue.setHint("latitude,longitude (double,double)");
					break;
					
				case ContextType.GPS_SPEED:
					mChoicesSpinner.setEnabled(false);
					mSelfDefinedValue.setEnabled(true);
					mSelfDefinedValue.setHint("in km/h (double)");
					break;
					
				case ContextType.BLUETOOTH:
					mChoicesSpinner.setEnabled(false);
					mSelfDefinedValue.setEnabled(true);
					mSelfDefinedValue.setHint("MAC address");
					break;
					
				case ContextType.BLUETOOTH_COUNT:
					mChoicesSpinner.setEnabled(false);
					mSelfDefinedValue.setEnabled(true);
					mSelfDefinedValue.setHint("integer");
					break;
					
				case ContextType.TIME:
					mChoicesSpinner.setEnabled(false);
					mSelfDefinedValue.setEnabled(true);
					mSelfDefinedValue.setHint("hh:mm:ss");
					break;
					
				case ContextType.WEEKDAY:
					mChoicesSpinner.setEnabled(false);
					mSelfDefinedValue.setEnabled(true);
					mSelfDefinedValue.setHint("Monday (case insensitive)");
					break;
					
				default:
					mSelfDefinedValue.setEnabled(false);
					mChoicesSpinner.setEnabled(false);	
					break;
				}
			}
		});
	}
	
	/**
	 * Register listener for choose from db radio button. If the radio button is clicked, users can choose context constant from database. To store context constants, create context constant activity can be performed.
	 * @see CreateContextConstantActivity
	 */
	private void registerListenerForChooseFromDbRadioBtn(){
		mChooseFromDbRadioBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				mChooseFromDb=true;
				mSelfDefine=false;
				
				switch(mChosenContextType){
				/* GPS_ISVALID can have only boolean values, so users do not need to load possible constants from database.
				 * Simply ask user to specify.
				 */
				case ContextType.GPS_ISVALID:
					mSelfDefineRadioBtn.setChecked(true);
					mSelfDefine=true;
					mChooseFromDb=false;
					mChoicesSpinner.setEnabled(false);
					mSelfDefinedValue.setEnabled(true);
					mSelfDefinedValue.setHint("true/false (case insensitive)");										
					break;
					
				case ContextType.GPS_LOCATION:
					mSelfDefinedValue.setEnabled(false);
					mChoicesSpinner.setEnabled(true);
					/* fetch data from database and populate the spinner */
					mLocationNameList=fetchAllSavedLocationNames();
					mLocationDataList=fetchAllSavedLocationDatas();
					if(mLocationNameList.size()==0){
						Toast.makeText(getApplicationContext(), "No stored location data, please input manually!", Toast.LENGTH_SHORT).show();
					} else{
						ArrayAdapter<String> adapter=new ArrayAdapter<String>(CreateFilterActivity.this, android.R.layout.simple_spinner_item, mLocationNameList);
						adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
						mChoicesSpinner.setAdapter(adapter);
					}
					break;
				
				/* GPS_SPEED is easy to specify.Simply ask user to set it manually */	
				case ContextType.GPS_SPEED:
					mSelfDefineRadioBtn.setChecked(true);
					mSelfDefine=true;
					mChooseFromDb=false;
					mChoicesSpinner.setEnabled(false);
					mSelfDefinedValue.setEnabled(true);
					mSelfDefinedValue.setHint("in km/h (double)");
					break;
					
				case ContextType.BLUETOOTH:
					mSelfDefinedValue.setEnabled(false);
					mChoicesSpinner.setEnabled(true);
					
					/* fetch data from database and populate the spinner */
					mDeviceNameList=fetchAllSavedDeviceNames();
					mDeviceMacList=fetchAllSavedDeviceMacs();
					if(mDeviceNameList.size()==0){
						Toast.makeText(getApplicationContext(), "No stored device data, please input manually!", Toast.LENGTH_SHORT).show();
					} else{
						ArrayAdapter<String> adapter=new ArrayAdapter<String>(CreateFilterActivity.this, android.R.layout.simple_spinner_item, mDeviceNameList);
						adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
						mChoicesSpinner.setAdapter(adapter);
					}
					break;
				
				/* BLUETOOTH_COUNT is easy to specify.Simply ask user to set it manually */
				case ContextType.BLUETOOTH_COUNT:
					mSelfDefineRadioBtn.setChecked(true);
					mSelfDefine=true;
					mChooseFromDb=false;
					mChoicesSpinner.setEnabled(false);
					mSelfDefinedValue.setEnabled(true);
					mSelfDefinedValue.setHint("integer");
					break;
				
				/* TIME is easy to specify.Simply ask user to set it manually */	
				case ContextType.TIME:
					mSelfDefineRadioBtn.setChecked(true);
					mSelfDefine=true;
					mChooseFromDb=false;
					mChoicesSpinner.setEnabled(false);
					mSelfDefinedValue.setEnabled(true);
					mSelfDefinedValue.setHint("hh:mm:ss");
					break;
				
				/* WEEKDAY is easy to specify.Simply ask user to set it manually */
				case ContextType.WEEKDAY:
					mSelfDefineRadioBtn.setChecked(true);
					mSelfDefine=true;
					mChooseFromDb=false;
					mChoicesSpinner.setEnabled(false);
					mSelfDefinedValue.setEnabled(true);
					mSelfDefinedValue.setHint("Monday (case insensitive)");
					break;
					
				default:
					mSelfDefinedValue.setEnabled(false);
					mChoicesSpinner.setEnabled(false);	
					break;
				}
			}
		});
	}
	
	/**
	 * Register listener for choice spinner. Uses can use this spinner to choose pre-recorded location info (GPS Coordinate) or BT device info (MAC Addr)
	 */
	private void registerListenerForChoiceSpinner(){
		mChoicesSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int pos, long id) {
				if(mChosenContextType==ContextType.GPS_LOCATION){
					mContextValue=mLocationDataList.get(pos);
				}
				if(mChosenContextType==ContextType.BLUETOOTH){
					mContextValue=mDeviceMacList.get(pos);
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
	}
	
	/**
	 * Register listener for confirm button.
	 */
	private void registerListenerForConfirmBtn(){
		mConfirmBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				if(mSelfDefine){
					mContextValue=mSelfDefinedValue.getText().toString();
				}
				
				/* validate the format and consistency of data */
				boolean valid=true;
				switch(mChosenContextType){
				case ContextType.GPS_ISVALID:
					mContextValue=mSelfDefinedValue.getText().toString();
					if(mContextValue==null){
						valid=false;
						Toast.makeText(getApplicationContext(), "Please set context value!", Toast.LENGTH_SHORT).show();
						break;
					} else{
						if(mChosenContextOp!=ContextOperator.EQUAL && mChosenContextOp!=ContextOperator.NOTEQUAL){
							valid=false;
							Toast.makeText(getApplicationContext(), "You can only choose = or !=", Toast.LENGTH_SHORT).show();
							break;
						} else{
							mContextValue=mContextValue.toLowerCase();
							if(!mContextValue.matches("true") && !mContextValue.matches("false")){
								valid=false;
								Toast.makeText(getApplicationContext(), "Value can only be true or false!", Toast.LENGTH_SHORT).show();
							}
						}
					}
					break;
					
				case ContextType.GPS_LOCATION:
					if(mContextValue==null){
						valid=false;
						Toast.makeText(getApplicationContext(), "Please set context value!", Toast.LENGTH_SHORT).show();
						break;
					} else{
						if(mChosenContextOp!=ContextOperator.EQUAL && mChosenContextOp!=ContextOperator.NOTEQUAL){
							valid=false;
							Toast.makeText(getApplicationContext(), "You can only choose = or !=", Toast.LENGTH_SHORT).show();
							break;
						}
						/* split the context value at the position of "," to get latitude and longitude */
						String[] locData=mContextValue.split(",");
						if(locData.length!=2){
							valid=false;
							Toast.makeText(getApplicationContext(), "Invalid location format! Example (20.34,41.78)!", Toast.LENGTH_SHORT).show();
						} else{
							try{
								double lat=Double.parseDouble(locData[0]);
								double lon=Double.parseDouble(locData[1]);
								if(!(lat >= -90.0 && lat <= 90.0 && lon >= -180.0 && lon <= 180.0)){
									valid=false;
									Toast.makeText(getApplicationContext(), "Invalid range! -90.0 <= latitue <= 90.0 and -180.0 <= longitude <= 180.0", Toast.LENGTH_SHORT).show();
								}
							} catch(NumberFormatException e){
								valid=false;
								Toast.makeText(getApplicationContext(), "Invalid location format! Example (20.34,41.78)!", Toast.LENGTH_SHORT).show();
							}
						}
					}
					break;
					
				case ContextType.GPS_SPEED:
					mContextValue=mSelfDefinedValue.getText().toString();
					if(mContextValue==null){
						valid=false;
						Toast.makeText(getApplicationContext(), "Please set context value!", Toast.LENGTH_SHORT).show();
						break;
					} else{
						try{
							int speed=Integer.parseInt(mContextValue);
							if(speed < 0){
								valid=false;
								Toast.makeText(getApplicationContext(), "Speed must be a positive number!", Toast.LENGTH_SHORT).show();
							}
						} catch(NumberFormatException e){
							valid=false;
							Toast.makeText(getApplicationContext(), "Invalid format! Integer expected!", Toast.LENGTH_SHORT).show();
						}
					}
					break;
					
				case ContextType.BLUETOOTH:
					if(mContextValue==null){
						valid=false;
						Toast.makeText(getApplicationContext(), "Please set context value!", Toast.LENGTH_SHORT).show();
						break;
					} else{
						if(mChosenContextOp!=ContextOperator.EQUAL && mChosenContextOp!=ContextOperator.NOTEQUAL){
							valid=false;
							Toast.makeText(getApplicationContext(), "You can only choose = or !=", Toast.LENGTH_SHORT).show();
						} else{
							if(!mContextValue.matches("([0-9a-fA-F][0-9a-fA-F]:){5}([0-9a-fA-F][0-9a-fA-F])")){
								valid=false;
								Toast.makeText(getApplicationContext(), "MAC format: dd:dd:dd:dd:dd:dd", Toast.LENGTH_SHORT).show();
							}
						}
					}
					break;
					
				case ContextType.BLUETOOTH_COUNT:
					mContextValue=mSelfDefinedValue.getText().toString();
					if(mContextValue==null){
						valid=false;
						Toast.makeText(getApplicationContext(), "Please set context value!", Toast.LENGTH_SHORT).show();
						break;
					} else{
						try{
							int count=Integer.parseInt(mContextValue);
							if(count < 0){
								valid=false;
								Toast.makeText(getApplicationContext(), "The number of discovered Bluetooth device must be a positive integer!", Toast.LENGTH_SHORT).show();
							}
						} catch(NumberFormatException e){
							valid=false;
							Toast.makeText(getApplicationContext(), "Invalid format! Integer expected!", Toast.LENGTH_SHORT).show();
						}
					}
					break;
					
				case ContextType.TIME:
					mContextValue=mSelfDefinedValue.getText().toString();
					if(mContextValue==null){
						valid=false;
						Toast.makeText(getApplicationContext(), "Please set context value!", Toast.LENGTH_SHORT).show();
						break;
					} else{
						String[] time=mContextValue.split(":");
						if(time.length!=3){
							valid=false;
							Toast.makeText(getApplicationContext(), "Format: hh:mm:ss", Toast.LENGTH_SHORT).show();
							break;
						} else{
							try{
								int hour=Integer.parseInt(time[0]);
								int minute=Integer.parseInt(time[1]);
								int second=Integer.parseInt(time[2]);
								if(hour<0 || hour>23){
									valid=false;
									Toast.makeText(getApplicationContext(), "hour should be with [0,23]!", Toast.LENGTH_SHORT).show();
									break;
								}
								if(minute<0 || minute>59){
									valid=false;
									Toast.makeText(getApplicationContext(), "minute should be with [0,59]!", Toast.LENGTH_SHORT).show();
									break;
								}
								if(second<0 || second>59){
									valid=false;
									Toast.makeText(getApplicationContext(), "second should be with [0,23]!", Toast.LENGTH_SHORT).show();
									break;
								}
									
							} catch(NumberFormatException e){
								valid=false;
								Toast.makeText(getApplicationContext(), "Invalid format! Integer expected!", Toast.LENGTH_SHORT).show();
							}
						}
					}
					break;
					
				case ContextType.WEEKDAY:
					mContextValue=mSelfDefinedValue.getText().toString();
					if(mContextValue==null){
						valid=false;
						Toast.makeText(getApplicationContext(), "Please set context value!", Toast.LENGTH_SHORT).show();
						break;
					} else{
						mContextValue=mContextValue.toLowerCase();
						if(mContextValue.matches("monday")){
							break;
						}
						if(mContextValue.matches("tuesday"))
						{
							break;
						}
						if(mContextValue.matches("wednesday")){
							break;
						}
						if(mContextValue.matches("thursday")){
							break;
						}
						if(mContextValue.matches("friday")){
							break;
						}
						if(mContextValue.matches("saturday")){
							break;
						}
						if(mContextValue.matches("sunday")){
							break;
						}
						valid=false;
						Toast.makeText(getApplicationContext(), "Invalid weekday!", Toast.LENGTH_SHORT).show();
					}
					break;
					
				default:
					valid=false;
					break;
				}
				
				/*
				 * If the created filter is valid, insert into database set the rule id to -1 (temp data)
				 */
				if(valid){
					if(mRuleRowId==null){
						if(mDbHelper.insertFilter(mChosenContextType, mChosenContextOp, mContextValue, -1)>0){
							Toast.makeText(getApplicationContext(), "Filter Saved!", Toast.LENGTH_SHORT).show();
							setResult(RESULT_OK);
							finish();
						} else{
							Toast.makeText(getApplicationContext(), "Error in saving!!", Toast.LENGTH_SHORT).show();
						}
					} else{
						if(mDbHelper.insertFilter(mChosenContextType, mChosenContextOp, mContextValue, mRuleRowId.intValue())>0){
							Toast.makeText(getApplicationContext(), "Filter Saved with rule id set!", Toast.LENGTH_SHORT).show();
							setResult(RESULT_OK);
							finish();
						} else{
							Toast.makeText(getApplicationContext(), "Error in saving!!", Toast.LENGTH_SHORT).show();
						}
					}
				} else{
					Toast.makeText(getApplicationContext(), "invalid data", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}
	
	/**
	 * Register listener for cancel button.
	 */
	private void registerListenerForCancelBtn(){
		mCancelBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				setResult(RESULT_CANCELED);
				finish();
			}
		});

	}
	
	/**
	 * Fetch all saved location names from database.
	 * @return an ArrayList of strings, each corresponding to a location name
	 */
	private ArrayList<String> fetchAllSavedLocationNames(){
		ArrayList<String> result=new ArrayList<String>();
		Cursor c=mDbHelper.fetchContextConstantByType(ContextType.GPS_LOCATION);
		startManagingCursor(c);
		if(c.getCount()>0){
			while(!c.isAfterLast()){
				result.add(c.getString(c.getColumnIndex(MyDbAdapter.KEY_CONTEXT_CONSTANT_NAME)));
				c.moveToNext();
			}
		}
		c.close();
		return result;
	}
	
	/**
	 * Fetch all saved location data from database.
	 * @return an ArrayList of location data, each in (latitude, longitude) format
	 */
	private ArrayList<String> fetchAllSavedLocationDatas(){
		ArrayList<String> result=new ArrayList<String>();
		Cursor c=mDbHelper.fetchContextConstantByType(ContextType.GPS_LOCATION);
		startManagingCursor(c);
		if(c.getCount()>0){
			while(!c.isAfterLast()){
				result.add(c.getString(c.getColumnIndex(MyDbAdapter.KEY_CONTEXT_CONSTANT_VALUE)));
				c.moveToNext();
			}
		}
		c.close();
		return result;
	}
	
	/**
	 * Fetch all saved device names.
	 * @return an ArrayList of Bluetooth device names
	 */
	private ArrayList<String> fetchAllSavedDeviceNames(){
		ArrayList<String> result=new ArrayList<String>();
		Cursor c=mDbHelper.fetchContextConstantByType(ContextType.BLUETOOTH);
		startManagingCursor(c);
		if(c.getCount()>0){
			while(!c.isAfterLast()){
				result.add(c.getString(c.getColumnIndex(MyDbAdapter.KEY_CONTEXT_CONSTANT_NAME)));
				c.moveToNext();
			}
		}
		c.close();
		return result;
	}
	
	/**
	 * Fetch the MAC address of all save Bluetooth devices.
	 * @return an ArrayList of MAC addresses
	 */
	private ArrayList<String> fetchAllSavedDeviceMacs(){
		ArrayList<String> result=new ArrayList<String>();
		Cursor c=mDbHelper.fetchContextConstantByType(ContextType.BLUETOOTH);
		startManagingCursor(c);
		if(c.getCount()>0){
			while(!c.isAfterLast()){
				result.add(c.getString(c.getColumnIndex(MyDbAdapter.KEY_CONTEXT_CONSTANT_VALUE)));
				c.moveToNext();
			}
		}
		c.close();
		return result;
	}
	
	@Override
	protected void onDestroy() {
		mDbHelper.close();
		super.onDestroy();
	}
}
