package edu.hkust.cse.phoneAdapter.activity;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import edu.hkust.cse.phoneAdapter.R;
import edu.hkust.cse.phoneAdapter.database.MyDbAdapter;

/**
 * The Class EditRuleActivity.
 * @author andrew
 */
public class EditRuleActivity extends Activity {
	
	private MyDbAdapter mDbHelper;

	private EditText mRuleNameEditText;
	
	private Spinner mCurStateSpinner;
	private Spinner mNewStateSpinner;
	private Spinner mPrioritySpinner;
	
	private Button mAddFilterBtn;
	private Button mSaveRuleBtn;

	private ListView mFilterListView;

	private String mRuleName;
	
	private int mCurProfileRowId;
	private int mNewProfileRowId;
	private int mPriority;

	private Long mRuleRowId;
	
	private final String mConstString="Choose Profile";
	
	private ArrayList<String> mCurProfileNameList;
	
	private ArrayList<Integer> mCurProfileIdList;
	
	private ArrayList<String> mNewProfileNameList;
	
	private ArrayList<Integer> mNewProfileIdList;
	
	private static final int ACTIVITY_ADD_FILTER=1;
	
	private static final String[] mContextTypes=new String[] {"","GPS.IsVaid","GPS.Location","GPS.Speed","Bluetooth","Bluetooth.Count","Time","Weekday"};
	
	private static final String[] mContextOps=new String[] {"","=","!=",">",">=","<","<="};
	
	private ArrayList<Long> mFilterRowId;
	
	private final static int CONTEXT_MENU_POSITION=Menu.FIRST+1; 
	private final static int ACTIVITY_EDIT=0;
	
	private Cursor mCursor;
	private Cursor mFilterCursor;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/* Edit rule activity shares the same layout with create rule activity */
		setContentView(R.layout.create_rule);
		setTitle(R.string.edit_rule_activity_label);

		mFilterRowId=new ArrayList<Long>();
		/* open database */
		mDbHelper=new MyDbAdapter(this);
		mDbHelper.open();
		
		/* get widgets */
		mRuleNameEditText=(EditText) findViewById(R.id.rule_name_textbox);
		mCurStateSpinner=(Spinner) findViewById(R.id.choose_cur_state_spinner);
		mNewStateSpinner=(Spinner) findViewById(R.id.choose_new_state_spinner);
		mPrioritySpinner=(Spinner) findViewById(R.id.choose_priority_spinner);
		mAddFilterBtn=(Button) findViewById(R.id.add_filter_btn);
		mSaveRuleBtn=(Button) findViewById(R.id.save_rule_btn);
		mFilterListView=(ListView) findViewById(R.id.filter_list);

		/* set array adapter for current state spinner */
		mCurProfileNameList=fetchAllProfileNamesFromDb();
		mCurProfileIdList=fetchAllProfileIdsFromDb();
		mNewProfileNameList=(ArrayList<String>)mCurProfileNameList.clone();
		mNewProfileIdList=(ArrayList<Integer>)mCurProfileIdList.clone();
		
		/* users are allowed to ignore current state, add one more choice to profile name ("don't care") */
		mCurProfileNameList.add("Don't care");
		
		/* the id is the same with that of "choose profile", but we won't store choose profile in database, so no need to distinguish */
		mCurProfileIdList.add(-1);
		
		/* set up the current profile spinner */
		ArrayAdapter<String> adapterForCurStateSpinner=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mCurProfileNameList);
		adapterForCurStateSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mCurStateSpinner.setAdapter(adapterForCurStateSpinner);
		registerListenerForCurStateSpinner();
		
		/* set up the new profile spinner */
		ArrayAdapter<String> adapterForNewStateSpinner=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mNewProfileNameList);
		adapterForNewStateSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mNewStateSpinner.setAdapter(adapterForNewStateSpinner);
		registerListenerForNewStateSpinner();
		
		/* set up the priority spinner */
		ArrayAdapter<CharSequence> adapterForPrioritySpinner=ArrayAdapter.createFromResource(this, R.array.priority_array, android.R.layout.simple_spinner_item);
		adapterForPrioritySpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mPrioritySpinner.setAdapter(adapterForPrioritySpinner);
		registerListenerForPrioritySpinner();
		
		/* set up buttons */
		registerListenerForAddFilterBtn();
		registerListenerForSaveRuleBtn();
		
		/* register context menu for list view items, clicking each item will pop up a context menu for users to choose operations (delete a filter in this case) */
		registerForContextMenu(mFilterListView);
		registerOnItemClickListenerForFilterListView();
		
		/* get the row id of the rule and populate fields */ 
		mRuleRowId = (savedInstanceState == null) ? null :
            (Long) savedInstanceState.getSerializable(MyDbAdapter.KEY_ROW_ID);
        if (mRuleRowId == null) {
            Bundle extras = getIntent().getExtras();
            mRuleRowId = extras != null ? extras.getLong(MyDbAdapter.KEY_ROW_ID) : null;
        }
        populateFields();
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		super.onContextItemSelected(item);
		switch(item.getItemId()){
		case CONTEXT_MENU_POSITION:
			try{
				AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
				if(mFilterRowId.size()>=2){
					if(mDbHelper.deleteFilter(mFilterRowId.get(info.position))){
						Toast.makeText(getApplicationContext(), "Deleted!", Toast.LENGTH_SHORT).show();
						fillData();
					} else{
						Toast.makeText(getApplicationContext(), "Failed to delete filters!", Toast.LENGTH_SHORT).show();
					}
				} else{
					Toast.makeText(getApplicationContext(), "You cannot delete the last filter, try to delete rule instead!", Toast.LENGTH_SHORT).show();
				}
			} catch(Exception e){
				Toast.makeText(getApplicationContext(), "Exceptions in deleting filters!", Toast.LENGTH_SHORT).show();
			}
			break;
		default:
			break;
		}
		return true;
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		menu.add(0, CONTEXT_MENU_POSITION, 0, R.string.delete);
	}

	/**
	 * Fetch all profile names from database.
	 * @return an ArrayList of profile names
	 */
	private ArrayList<String> fetchAllProfileNamesFromDb(){
		ArrayList<String> result=new ArrayList<String>();
		result.add(mConstString);
		Cursor c=mDbHelper.fetAllProfiles();
		startManagingCursor(c);
		if(c.getCount()>0){
			c.moveToFirst();
			while(!c.isAfterLast()){
				result.add(c.getString(c.getColumnIndex(MyDbAdapter.KEY_PROFILE_NAME)));
				c.moveToNext();
			}
		}
		c.close();
		return result;
	}
	
	/**
	 * Fetch all profile ids from database.
	 * @return An ArrayList of profile ids
	 */
	private ArrayList<Integer> fetchAllProfileIdsFromDb(){
		ArrayList<Integer> result=new ArrayList<Integer>();
		result.add(-1);
		Cursor c=mDbHelper.fetAllProfiles();
		startManagingCursor(c);
		if(c.getCount()>0){
			c.moveToFirst();
			while(!c.isAfterLast()){
				result.add(c.getInt(c.getColumnIndex(MyDbAdapter.KEY_ROW_ID)));
				c.moveToNext();
			}
		}
		c.close();
		return result;
	}
	
	/**
	 * Register listener for current state spinner.
	 */
	private void registerListenerForCurStateSpinner(){
		mCurStateSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int pos, long id) {
				if(!parent.getItemAtPosition(pos).toString().equals(mConstString)){
					mCurProfileRowId=mCurProfileIdList.get(pos);
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
	}
	
	/**
	 * Register listener for new state spinner.
	 */
	private void registerListenerForNewStateSpinner(){
		mNewStateSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int pos, long id) {
				if(!parent.getItemAtPosition(pos).toString().equals(mConstString)){
					mNewProfileRowId=mNewProfileIdList.get(pos);
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
	}
	
	/**
	 * Register listener for priority spinner.
	 */
	private void registerListenerForPrioritySpinner(){
		mPrioritySpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int pos, long id) {
				try{
					mPriority=Integer.parseInt(parent.getItemAtPosition(pos).toString());
				} catch(Exception e){
					Toast.makeText(getApplicationContext(), "invalid priority format!", Toast.LENGTH_SHORT).show();
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
	}
	
	/**
	 * Register listener for add filter button. When the button is clicked, the create filter activity will be started.
	 */
	private void registerListenerForAddFilterBtn(){
		mAddFilterBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent i=new Intent(EditRuleActivity.this, CreateFilterActivity.class);
				i.putExtra(MyDbAdapter.KEY_ROW_ID, mRuleRowId);
				startActivityForResult(i,ACTIVITY_ADD_FILTER);
			}
		});
	}
	
	/**
	 * Register listener for save rule button.
	 */
	private void registerListenerForSaveRuleBtn(){
		mSaveRuleBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				//need to become an update instead of creating new
				/*
				 *  first delete the rows whose ruleId is -1, that's temp data for adding filters
				 *  then validation
				 *  (1) rule name is not null or empty
				 *  (2) priority is within 1 and 9
				 *  (3) current profile row id == -1 or in database
				 *  (4) new profile row row id in database
				 */
				mRuleName=mRuleNameEditText.getText().toString();
				boolean valid=true;
				if(mRuleName==null || mRuleName.length()==0){
					valid=false;
					Toast.makeText(EditRuleActivity.this, "Rule name cannot be empty!", Toast.LENGTH_SHORT).show();
					return;
				}
				
				if(mPriority<=0 || mPriority>9){
					valid=false;
					Toast.makeText(EditRuleActivity.this, "Priority must be within [1,9].", Toast.LENGTH_SHORT).show();
					return;
				}
				
				mCursor=mDbHelper.fetchProfile(mCurProfileRowId);
				startManagingCursor(mCursor);
				if(mCurProfileRowId!=-1 && mCursor.getCount()==0){
					valid=false;
					Toast.makeText(EditRuleActivity.this, "Invalid current profile!", Toast.LENGTH_SHORT).show();
					return;
				}
				mCursor=mDbHelper.fetchProfile(mNewProfileRowId);
				startManagingCursor(mCursor);
				if(mCursor.getCount()==0){
					valid=false;
					Toast.makeText(EditRuleActivity.this, "Invalid new profile!", Toast.LENGTH_SHORT).show();
					return;
				}

				if(valid && mFilterRowId.size()>0 && mRuleRowId!=null){
					if(mDbHelper.updateRule(mRuleRowId, mRuleName, mCurProfileRowId, mNewProfileRowId, mPriority, mNewProfileRowId,1)){
						boolean succ=true;
						for(int i=0;i<mFilterRowId.size();i++){
							succ=succ && mDbHelper.updateFilterRuleRowId(mFilterRowId.get(i), mRuleRowId);
						}
						if(!succ){
							Toast.makeText(EditRuleActivity.this, "Filters are not updated!", Toast.LENGTH_SHORT).show();
						} else{
							Toast.makeText(EditRuleActivity.this, "Update successful!", Toast.LENGTH_SHORT).show();
							Intent i=new Intent();
							i.setAction("edu.hkust.cse.phoneAdapter.ruleChange");
							sendBroadcast(i);
							setResult(RESULT_OK);
							finish();
						}
					} else{
						Toast.makeText(EditRuleActivity.this, "Rule is not updated!", Toast.LENGTH_SHORT).show();
					}
				} else{
					Toast.makeText(EditRuleActivity.this, "Rule cannot be saved because of valid data format, lack of filters or missing rule id!", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}
	
	/**
	 * Register on item click listener for filter list view. When a listed filter is clicked, the edit filter activity will be started to allow users edit the filter
	 */
	private void registerOnItemClickListenerForFilterListView(){
		mFilterListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int pos,
					long id) {
				Intent i=new Intent(EditRuleActivity.this,EditFilterActivity.class);
				i.putExtra(MyDbAdapter.KEY_ROW_ID, mFilterRowId.get(pos));
				i.putExtra("Rule_Row_ID",mRuleRowId);
				startActivityForResult(i, ACTIVITY_EDIT);
			}
		});
	}
	
	
	/**
	 * Use the recorded filters to fill the list view (for displaying added filter)
	 */
	private void fillData(){
		/* fill the list view, search filters table for rows where ruleId=mRuleRowId  */
		if(mRuleRowId!=null){
			Cursor mFilterCursor=mDbHelper.fetchFilterByRuleId(mRuleRowId);
			ArrayList<String> filterListMsg=new ArrayList<String>();
			mFilterRowId=new ArrayList<Long>();
			startManagingCursor(mFilterCursor);
			if(mFilterCursor.getCount()>0){
				mFilterCursor.moveToFirst();
				while(!mFilterCursor.isAfterLast()){
					mFilterRowId.add(mFilterCursor.getLong(mFilterCursor.getColumnIndex(MyDbAdapter.KEY_ROW_ID)));
					StringBuffer sb=new StringBuffer();
					sb.append(mContextTypes[mFilterCursor.getInt(mFilterCursor.getColumnIndex(MyDbAdapter.KEY_CV_TYPE))]);
					sb.append(mContextOps[mFilterCursor.getInt(mFilterCursor.getColumnIndex(MyDbAdapter.KEY_CV_OPERATOR))]);
					sb.append(mFilterCursor.getString(mFilterCursor.getColumnIndex(MyDbAdapter.KEY_VALUE)));
					filterListMsg.add(sb.toString());
					mFilterCursor.moveToNext();
				}
			}
			ArrayAdapter<String> adapter=new ArrayAdapter<String>(EditRuleActivity.this, R.layout.filter_item, filterListMsg);
			mFilterListView.setAdapter(adapter);
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		fillData();
	}
	
	/**
	 * Populate fields. The rule data was previously specified by users.
	 */
	private void populateFields(){
		if(mRuleRowId!=null){
			Cursor c=mDbHelper.fetchRule(mRuleRowId);
			startManagingCursor(c);
			if(c.getCount()>0){
				c.moveToFirst();
				String name=c.getString(c.getColumnIndex(MyDbAdapter.KEY_RULE_NAME));
				Long curStateProfileId=c.getLong(c.getColumnIndex(MyDbAdapter.KEY_CURRENT_STATE_ID));
				Long newStateProfileId=c.getLong(c.getColumnIndex(MyDbAdapter.KEY_NEW_STATE_ID));
				int priority=c.getInt(c.getColumnIndex(MyDbAdapter.KEY_PRIORITY));
				Cursor c1;
				String curStateProfileName;
				String newStateProfileName;
				if(curStateProfileId>0){
					c1=mDbHelper.fetchProfile(curStateProfileId);
					startManagingCursor(c1);
					c1.moveToFirst();
					curStateProfileName=c1.getString(c1.getColumnIndex(MyDbAdapter.KEY_PROFILE_NAME));
				} else{
					curStateProfileName="Don't care";
				}
				c1=mDbHelper.fetchProfile(newStateProfileId);
				startManagingCursor(c1);
				c1.moveToFirst();
				newStateProfileName=c1.getString(c1.getColumnIndex(MyDbAdapter.KEY_PROFILE_NAME));
				mRuleNameEditText.setText(name);
				int curIndex=mCurProfileNameList.indexOf(curStateProfileName);
				int newIndex=mNewProfileNameList.indexOf(newStateProfileName);
				if(curIndex>=0){
					mCurStateSpinner.setSelection(curIndex);
				}
				if(newIndex>=0){
					mNewStateSpinner.setSelection(newIndex);
				}
				mPrioritySpinner.setSelection(priority-1);
				fillData();
				c1.close();
			} else{
				Toast.makeText(getApplicationContext(), "Failed to populate fields!", Toast.LENGTH_SHORT).show();
			}
		}
	}
	
	@Override
	protected void onDestroy() {
		if(mCursor!=null){
			mCursor.close();
		}
		if(mFilterCursor!=null){
			mFilterCursor.close();
		}
		mDbHelper.close();
		super.onDestroy();
	}
	

	/*
	 * may need to override onResume() method, when users switch to other activities to add more profiles, then we need to fetch fresh data from database
	 */
}
