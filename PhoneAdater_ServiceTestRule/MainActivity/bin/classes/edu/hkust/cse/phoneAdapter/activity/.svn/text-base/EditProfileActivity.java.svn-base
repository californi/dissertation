package edu.hkust.cse.phoneAdapter.activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.ToggleButton;
import edu.hkust.cse.phoneAdapter.R;
import edu.hkust.cse.phoneAdapter.database.MyDbAdapter;

/**
 * The Class EditProfileActivity.
 * @author andrew
 */
public class EditProfileActivity extends Activity {
	
	private EditText mProfileName;
	
	private SeekBar mRingVolume;
	
	private ToggleButton mVibration;
	private ToggleButton mAirplaneMode;
	
	private Button mConfirmation;
	private Button mCancel;
	
	private MyDbAdapter mDbHelper;
	
	private Long mRowId;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_profile);
		
		/* get the reference of widgets */
		mProfileName=(EditText) findViewById(R.id.profile_name_textbox_in_edit_profile);
		mRingVolume=(SeekBar) findViewById(R.id.ring_volume_seekbar_in_edit_profile);
		mVibration=(ToggleButton) findViewById(R.id.vibration_toggle_button_in_edit_profile);
		mAirplaneMode=(ToggleButton) findViewById(R.id.airplane_mode_toggle_button_in_edit_profile);
		mConfirmation=(Button) findViewById(R.id.confirm_btn_in_edit_profile);
		mCancel=(Button) findViewById(R.id.cancel_btn_in_edit_profile);
		
		/* open database */
		mDbHelper=new MyDbAdapter(this);
		mDbHelper.open();
		
		/* fill the widgets by calling populateFields() */
		mRowId = (savedInstanceState == null) ? null :
            (Long) savedInstanceState.getSerializable(MyDbAdapter.KEY_ROW_ID);
        if (mRowId == null) {
            Bundle extras = getIntent().getExtras();
            mRowId = extras != null ? extras.getLong(MyDbAdapter.KEY_ROW_ID)
                                    : null;
        }
        populateFields();
        
		/* register listeners for buttons */
		registerListenerForConfirmButton();
		registerListenerForCancelButton();
	}
	
	/**
	 * Register listener for confirm button. After press this button, the recorded profile will be updated.
	 */
	public void registerListenerForConfirmButton(){
		mConfirmation.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				/* get the data of widgets */
				String profileName=mProfileName.getText().toString();
				int ringVolume=mRingVolume.getProgress();
				int airplaneMode=mAirplaneMode.getText().equals("ON")?1:0;
				int vibration=mVibration.getText().equals("ON")?1:0;
				
				if(mRowId!=null){
					/* update the profile */
					if(mDbHelper.updateProfile(mRowId, profileName, ringVolume, airplaneMode, vibration)){
						Toast.makeText(getApplicationContext(), "update successful!",Toast.LENGTH_SHORT).show();
						if(mDbHelper.ruleHasProfileId(mRowId)){
							Intent i=new Intent("edu.hkust.cse.phoneAdapter.ruleChange");
							sendBroadcast(i);
						}
						setResult(RESULT_OK);
						finish();
					} else{
						Toast.makeText(getApplicationContext(), "nothing is updated!",Toast.LENGTH_SHORT).show();
					}
				} else{
					Toast.makeText(getApplicationContext(), "row id is null, activity is forced to finish!",Toast.LENGTH_SHORT).show();
					setResult(RESULT_CANCELED);
					finish();
				}
			}
		});
		
	}
	
	/**
	 * Register listener for cancel button.
	 */
	public void registerListenerForCancelButton(){
		mCancel.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				setResult(RESULT_CANCELED);
				finish();
			}
		});
	}
	
	/**
	 * Populate fields.
	 */
	public void populateFields(){
		if(mRowId!=null){
			Cursor c=mDbHelper.fetchProfile(mRowId);
			startManagingCursor(c);
			if(c.getCount()>0){
				c.moveToFirst();
				String profileName=c.getString(c.getColumnIndex(MyDbAdapter.KEY_PROFILE_NAME));
				int ringVolume=c.getInt(c.getColumnIndex(MyDbAdapter.KEY_RING_VOLUME));
				int vibration=c.getInt(c.getColumnIndex(MyDbAdapter.KEY_VIBRATION));
				int airplaneMode=c.getInt(c.getColumnIndex(MyDbAdapter.KEY_AIRPLANE_MODE));
				mProfileName.setText(profileName);
				mRingVolume.setProgress(ringVolume);
				if(vibration==1){
					mVibration.setChecked(true);
				} else{
					mVibration.setChecked(false);
				}
				if(airplaneMode==1){
					mAirplaneMode.setChecked(true);
				} else{
					mAirplaneMode.setChecked(false);
				}
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
