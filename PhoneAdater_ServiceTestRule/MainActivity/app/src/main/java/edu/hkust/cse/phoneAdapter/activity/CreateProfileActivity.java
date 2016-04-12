package edu.hkust.cse.phoneAdapter.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
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
 * The Class CreateProfileActivity.
 * There are two ways this activity will be started
 * (1) from the main activity interface, click the "create profile" button
 * (2) from the view profile activity interface, click menu and choose "create profile"
 * @author andrew
 */

public class CreateProfileActivity extends Activity {
	
	private EditText mProfileName;
	
	private SeekBar mRingVolume;
	
	private ToggleButton mVibration;
	private ToggleButton mAirplaneMode;
	
	private Button mConfirmation;
	private Button mCancel;
	
	private MyDbAdapter mDbHelper;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.create_profile);
		
		mDbHelper=new MyDbAdapter(this);
		mDbHelper.open();
		
		/*
		 * get the reference of widgets
		 */
		mProfileName=(EditText) findViewById(R.id.profile_name_textbox);
		mRingVolume=(SeekBar) findViewById(R.id.ring_volume_seekbar);
		mVibration=(ToggleButton) findViewById(R.id.vibration_toggle_button);
		mAirplaneMode=(ToggleButton) findViewById(R.id.airplane_mode_toggle_button);
		mConfirmation=(Button) findViewById(R.id.create_profile_confirm_btn);
		mCancel=(Button) findViewById(R.id.create_profile_cancel_btn);
		
		/*
		 * register listener for confirm and cancel buttons
		 */
		registerListenerForConfirmButton();
		registerListenerForCancelButton();
	}
	
	/**
	 * Register listener for confirm button.
	 */
	public void registerListenerForConfirmButton(){
		mConfirmation.setOnClickListener(new OnClickListener() {
			private int ringVolume;
			private String profileName;
			private int airplaneMode;
			private int vibration;
			private Cursor c;
			
			@Override
			public void onClick(View v) {
				/*get the data from widgets and insert into database and then finish the activity and respond ok */
				profileName=mProfileName.getText().toString();
				ringVolume=mRingVolume.getProgress();
				airplaneMode=mAirplaneMode.getText().equals("ON")?1:0;
				vibration=mVibration.getText().equals("ON")?1:0;
				
				/* make sure a profile with the same name does not exist in database */
				c=mDbHelper.fetchProfileByName(profileName);
				if(c.getCount()==0){
					mDbHelper.insertProfile(profileName, ringVolume, airplaneMode, vibration);
					String msg=profileName+"(ring volume="+ringVolume+", vibration="+mVibration.getText()+", airplane mode="+mAirplaneMode.getText()+") is saved!";
					Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
					setResult(RESULT_OK);
					finish();
				} else{
					/*A profile with the same name exists in database, ask user whether to update*/
					AlertDialog.Builder builder=new AlertDialog.Builder(CreateProfileActivity.this);
					builder.setMessage("A profile with the same name exists in database!")
					.setCancelable(false)
					.setPositiveButton("Update", new DialogInterface.OnClickListener() {						
						@Override
						public void onClick(DialogInterface arg0, int arg1) {
							/* get the _id the old profile entry */
							startManagingCursor(c);
							
							/* c cannot be empty */
							c.moveToFirst();
							
							Long rowId=c.getLong(c.getColumnIndex(MyDbAdapter.KEY_ROW_ID));
							if(mDbHelper.updateProfile(rowId, profileName, ringVolume, airplaneMode, vibration)){
								Toast.makeText(getApplicationContext(), "update successful!", Toast.LENGTH_SHORT).show();
							} else{
								Toast.makeText(getApplicationContext(), "Nothing is updated", Toast.LENGTH_SHORT).show();
							}
							setResult(RESULT_OK);
							finish();
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
	
	@Override
	protected void onDestroy() {
		mDbHelper.close();
		super.onDestroy();
	}
}
