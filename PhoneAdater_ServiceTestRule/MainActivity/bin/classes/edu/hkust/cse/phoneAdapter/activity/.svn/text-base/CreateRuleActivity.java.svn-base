package edu.hkust.cse.phoneAdapter.activity;

import java.util.ArrayList;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
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
 * The Class CreateRuleActivity.
 * Users are allowed to set rules in conjunction normal form
 * If they wish to set rules in disjunction normal form, they can set rules with the same name and with the same priority (optional) 
 * @author andrew
 */
public class CreateRuleActivity extends Activity {
	
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

	private long mRuleRowId=-1;
	
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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.create_rule);
		
		/* the triggering condition of a rule (profile switching) is the conjunction of several filters */
		mFilterRowId=new ArrayList<Long>();
		
		/* open database */
		mDbHelper=new MyDbAdapter(this);
		mDbHelper.open();
		
		/* get widget references */
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
		mNewProfileNameList=(ArrayList<String>) mCurProfileNameList.clone();
		mNewProfileIdList=(ArrayList<Integer>) mCurProfileIdList.clone();
		
		/* users are allowed to ignore current state, add one more choice to profile name ("don't care") */
		mCurProfileNameList.add("Don't care");
		/* the id is the same with that of "choose profile", but we won't store choose profile in database, so no need to distinguish */
		mCurProfileIdList.add(-1);
		
		/*set up the current profile spinner */
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
		
		/*set up buttons */
		registerListenerForAddFilterBtn();
		registerListenerForSaveRuleBtn();
		
		/* 
		 * register context menu for list view items, clicking each item will pop up a context menu for users to choose operations (delete a filter in this case)
		 */
		registerForContextMenu(mFilterListView);
		registerOnItemClickListenerForFilterListView();
		
		/* delete all temporary filters in database with id marked as "-1" */
		mDbHelper.deleteFilterByRuleRowId(-1);
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		super.onContextItemSelected(item);
		switch(item.getItemId()){
		case CONTEXT_MENU_POSITION:
			try{
				AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
				if(mDbHelper.deleteFilter(mFilterRowId.get(info.position))){
					Toast.makeText(getApplicationContext(), "Deleted!", Toast.LENGTH_SHORT).show();
					fillData();
				} else{
					Toast.makeText(getApplicationContext(), "Failed to delete filters!", Toast.LENGTH_SHORT).show();
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
	 * @return an ArrayList of profile ids
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
	 * Register listener for add filter button. When the button is clicked, the add filter activity will be started.
	 * @see CreateFilterActivity
	 */
	private void registerListenerForAddFilterBtn(){
		mAddFilterBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent i=new Intent(CreateRuleActivity.this, CreateFilterActivity.class);
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
				/*
				 *  first delete the rows whose ruleId is -1, that's temp data for adding filters
				 *  then, validation
				 *  (1) rule name is not null or empty
				 *  (2) priority is within 1 and 9
				 *  (3) current profile row id == -1 or in database
				 *  (4) new profile row row id in database
				 */
				mRuleName=mRuleNameEditText.getText().toString();
				boolean valid=true;
				if(mRuleName==null || mRuleName.length()==0){
					valid=false;
					Toast.makeText(CreateRuleActivity.this, "Rule name cannot be empty!", Toast.LENGTH_SHORT).show();
					return;
				}
				
				if(mPriority<=0 || mPriority>9){
					valid=false;
					Toast.makeText(CreateRuleActivity.this, "Priority must be within [1,9].", Toast.LENGTH_SHORT).show();
					return;
				}
				
				mCursor=mDbHelper.fetchProfile(mCurProfileRowId);
				startManagingCursor(mCursor);
				if(mCurProfileRowId!=-1 && mCursor.getCount()==0){
					valid=false;
					Toast.makeText(CreateRuleActivity.this, "Invalid current profile!", Toast.LENGTH_SHORT).show();
					return;
				}
				
				mCursor=mDbHelper.fetchProfile(mNewProfileRowId);
				startManagingCursor(mCursor);
				if(mCursor.getCount()==0){
					valid=false;
					Toast.makeText(CreateRuleActivity.this, "Invalid new profile!", Toast.LENGTH_SHORT).show();
					return;
				}
				
				if(valid && mFilterRowId.size()>0){
					mCursor=mDbHelper.fetchRuleByName(mRuleName);
					startManagingCursor(mCursor);
					
					/*
					 * If-case: no rule with the same name exists in database, free to insert
					 * Else-case: a rule with the same name exists in database, ask user whether to update.
					 */
					if(mCursor.getCount()==0){
						boolean succ=false;
						mRuleRowId=mDbHelper.insertRule(mRuleName, mCurProfileRowId, mNewProfileRowId, mPriority, mNewProfileRowId,1);
						if(mRuleRowId>0){
							succ=true;
							for(int i=0;i<mFilterRowId.size();i++){
								succ=succ && mDbHelper.updateFilterRuleRowId(mFilterRowId.get(i), mRuleRowId);
							}
							if(succ){
								Toast.makeText(CreateRuleActivity.this, "New rule inserted!", Toast.LENGTH_SHORT).show();
								Intent i=new Intent();
								i.setAction("edu.hkust.cse.phoneAdapter.ruleChange");
								sendBroadcast(i);
								setResult(RESULT_OK);
								finish();
							} else{
								Toast.makeText(CreateRuleActivity.this, "Errors in inserting the rule!", Toast.LENGTH_SHORT).show();
							}
						}
					} else{
						mCursor.moveToFirst();
						AlertDialog.Builder builder=new AlertDialog.Builder(CreateRuleActivity.this);
						builder.setMessage("A rule with the same name exists in database!")
						.setCancelable(false)
						.setPositiveButton("Update", new DialogInterface.OnClickListener() {						
							@Override
							public void onClick(DialogInterface arg0, int arg1) {
								/* get the rowID of the exising rule and then update it */
								mCursor.moveToFirst();
								mRuleRowId=mCursor.getLong(mCursor.getColumnIndex(MyDbAdapter.KEY_ROW_ID));
								if(mDbHelper.updateRule(mRuleRowId,mRuleName,mCurProfileRowId,mNewProfileRowId,mPriority,mNewProfileRowId,1)){
									boolean succ=true;
									for(int i=0;i<mFilterRowId.size();i++){
										succ=succ && mDbHelper.updateFilterRuleRowId(mFilterRowId.get(i), mRuleRowId);
									}
									if(succ){
										Toast.makeText(getApplicationContext(), "update successful!", Toast.LENGTH_SHORT).show();
										Intent i=new Intent();
										i.setAction("edu.hkust.cse.phoneAdapter.ruleChange");
										sendBroadcast(i);
										setResult(RESULT_OK);
										finish();
									} else{
										Toast.makeText(getApplicationContext(), "Filters are not updated!", Toast.LENGTH_SHORT).show();
									}
								} else{
									Toast.makeText(getApplicationContext(), "Rule is not updated!", Toast.LENGTH_SHORT).show();
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
				} else{
					Toast.makeText(getApplicationContext(), "Rule cannot be created without any filter!", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}
	
	/**
	 * Register on item click listener for filter list view. When a listed filter is clicked, edit filter activity will be started, and users are allowed to edit the filter
	 * @see EditFilterActivity
	 */
	private void registerOnItemClickListenerForFilterListView(){
		mFilterListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int pos,
					long id) {
				Intent i=new Intent(CreateRuleActivity.this,EditFilterActivity.class);
				i.putExtra(MyDbAdapter.KEY_ROW_ID, mFilterRowId.get(pos));
				startActivityForResult(i, ACTIVITY_EDIT);
			}
		});
	}
	
	/**
	 * Use the temporary filters to fill the list view (for displaying added filter)
	 */
	private void fillData(){
		/* fill the list view, search filters table for rows where ruleId=-1 */
		Cursor c=mDbHelper.fetchFilterByRuleId(mRuleRowId);
		ArrayList<String> filterListMsg=new ArrayList<String>();
		mFilterRowId=new ArrayList<Long>();
		startManagingCursor(c);
		if(c.getCount()>0){
			c.moveToFirst();
			while(!c.isAfterLast()){
				mFilterRowId.add(c.getLong(c.getColumnIndex(MyDbAdapter.KEY_ROW_ID)));
				StringBuffer sb=new StringBuffer();
				sb.append(mContextTypes[c.getInt(c.getColumnIndex(MyDbAdapter.KEY_CV_TYPE))]);
				sb.append(mContextOps[c.getInt(c.getColumnIndex(MyDbAdapter.KEY_CV_OPERATOR))]);
				sb.append(c.getString(c.getColumnIndex(MyDbAdapter.KEY_VALUE)));
				filterListMsg.add(sb.toString());
				c.moveToNext();
			}			
		}
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(CreateRuleActivity.this, R.layout.filter_item, filterListMsg);
		mFilterListView.setAdapter(adapter);
		c.close();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		fillData();
	}

	@Override
	protected void onDestroy() {
		mDbHelper.close();
		super.onDestroy();
	}
	
	/*
	 * may need to override onResume() method, when users switch to other activities to add more profiles, then we need to fetch fresh data from database
	 */
}
