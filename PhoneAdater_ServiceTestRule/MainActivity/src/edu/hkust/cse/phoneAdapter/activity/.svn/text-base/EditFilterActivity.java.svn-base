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
 * The Class EditFilterActivity.
 * @author andrew
 */
public class EditFilterActivity extends Activity{
	
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
	
	private Long mFilterRowId;
	
	private Long mRuleRowId;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/* Create filter activity and edit filter activity share the same layout */
		setContentView(R.layout.create_filter);
		
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
		
		/* set up the buttons */
		registerListenerForConfirmBtn();
		registerListenerForCancelBtn();
		
		/* populate fields */
		mFilterRowId = (savedInstanceState == null) ? null : (Long) savedInstanceState.getSerializable(MyDbAdapter.KEY_ROW_ID);
        if (mFilterRowId == null) {
            Bundle extras = getIntent().getExtras();
            mFilterRowId = extras != null ? extras.getLong(MyDbAdapter.KEY_ROW_ID)
                                    : null;
        }
        mRuleRowId = (savedInstanceState == null) ? null :
            (Long) savedInstanceState.getSerializable("Rule_Row_ID");
        if (mRuleRowId == null) {
            Bundle extras = getIntent().getExtras();
            mRuleRowId = extras != null ? extras.getLong("Rule_Row_ID")
                                    : null;
        }
        populateField();
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
	 * Register listener for self define radio button. When the radio button is selected, application will give hint about context data format.
	 */
	private void registerListenerForSelfDefineRadioBtn(){
		mSelfDefineRadioBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				mSelfDefine=true;
				mChooseFromDb=false;
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
	 * Register listener for choose from data base radio button. When the radio button is selected, application will try to load recorded context constants from data base and let user choose.
	 */
	private void registerListenerForChooseFromDbRadioBtn(){
		mChooseFromDbRadioBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				mChooseFromDb=true;
				mSelfDefine=false;
				switch(mChosenContextType){
				case ContextType.GPS_ISVALID:
					/* GPS_ISVALID is simple to specify (either true or false), simply let user manually input */
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
					/* fetch data from database and reset the spinner */
					mLocationNameList=fetchAllSavedLocationNames();
					mLocationDataList=fetchAllSavedLocationDatas();
					if(mLocationNameList.size()==0){
						Toast.makeText(getApplicationContext(), "No stored location data, please input manually!", Toast.LENGTH_SHORT).show();
					} else{
						ArrayAdapter<String> adapter=new ArrayAdapter<String>(EditFilterActivity.this, android.R.layout.simple_spinner_item, mLocationNameList);
						adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
						mChoicesSpinner.setAdapter(adapter);
					}
					break;
					
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
					/* fetch data from database and reset the spinner */
					mDeviceNameList=fetchAllSavedDeviceNames();
					mDeviceMacList=fetchAllSavedDeviceMacs();
					if(mDeviceNameList.size()==0){
						Toast.makeText(getApplicationContext(), "No stored device data, please input manually!", Toast.LENGTH_SHORT).show();
					} else{
						ArrayAdapter<String> adapter=new ArrayAdapter<String>(EditFilterActivity.this, android.R.layout.simple_spinner_item, mDeviceNameList);
						adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
						mChoicesSpinner.setAdapter(adapter);
					}
					break;
					
				case ContextType.BLUETOOTH_COUNT:
					mSelfDefineRadioBtn.setChecked(true);
					mSelfDefine=true;
					mChooseFromDb=false;
					mChoicesSpinner.setEnabled(false);
					mSelfDefinedValue.setEnabled(true);
					mSelfDefinedValue.setHint("integer");
					break;
					
				case ContextType.TIME:
					mSelfDefineRadioBtn.setChecked(true);
					mSelfDefine=true;
					mChooseFromDb=false;
					mChoicesSpinner.setEnabled(false);
					mSelfDefinedValue.setEnabled(true);
					mSelfDefinedValue.setHint("hh:mm:ss");
					break;
					
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
	 * Register listener for choice spinner. Users choose from the loaded context constants.
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
							if(!mContextValue.matches("true") && !mContextValue.matches("false"))
							{
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
						//split the context value at the position of ","
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
				if(valid){
					/* update the filter record in database */
					if(mFilterRowId!=null){
						if(mRuleRowId==null){
							if(mDbHelper.updateFilter(mFilterRowId,mChosenContextType, mChosenContextOp, mContextValue, -1)){
								Toast.makeText(getApplicationContext(), "Filter updated!", Toast.LENGTH_SHORT);
								setResult(RESULT_OK);
								finish();
							} else{
								Toast.makeText(getApplicationContext(), "Error in saving!!", Toast.LENGTH_SHORT);
							}
						} else{
							if(mDbHelper.updateFilter(mFilterRowId,mChosenContextType, mChosenContextOp, mContextValue, mRuleRowId.intValue())){
								Toast.makeText(getApplicationContext(), "Filter updated with rule id set!", Toast.LENGTH_SHORT);
								setResult(RESULT_OK);
								finish();
							} else{
								Toast.makeText(getApplicationContext(), "Error in saving!!", Toast.LENGTH_SHORT);
							}
						}
					} else{
						Toast.makeText(getApplicationContext(), "Filter id is missing!", Toast.LENGTH_SHORT);
					}
				} else{
					Toast.makeText(getApplicationContext(), "Invalid data format!", Toast.LENGTH_SHORT);
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
	 * Fetch all saved location names.
	 * @return an ArrayList of location names
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
	 * Fetch all saved location datas.
	 * @return an ArrayList of location data
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
	 * @return an ArrayList of bluetooth device names
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
	 * Fetch the MAC address of all saved Bluetooth devices.
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
	
	/**
	 * Populate field. The populated data were previously specified by users.
	 */
	private void populateField(){
		if(mFilterRowId!=null){
			Cursor c=mDbHelper.fetchFilter(mFilterRowId);
			startManagingCursor(c);
			if(c.getCount()>0){
				mChosenContextType=c.getInt(c.getColumnIndex(MyDbAdapter.KEY_CV_TYPE))-1;
				mChosenContextOp=c.getInt(c.getColumnIndex(MyDbAdapter.KEY_CV_OPERATOR))-1;
				mContextValue=c.getString(c.getColumnIndex(MyDbAdapter.KEY_VALUE));
				if(mChosenContextType>=0){
					mContextTypeSpinner.setSelection(mChosenContextType);
				}
				if(mChosenContextOp>=0){
					mContextOpSpinner.setSelection(mChosenContextOp);
				}
				mSelfDefineRadioBtn.setChecked(true);
				mSelfDefine=true;
				mChooseFromDb=false;
				mSelfDefinedValue.setText(mContextValue);
			}
			c.close();
		}
	}
	
	@Override
	protected void onDestroy() {
		mDbHelper.close();
		super.onDestroy();
	}
}
