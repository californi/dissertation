package edu.hkust.cse.phoneAdapter.activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;
import edu.hkust.cse.phoneAdapter.R;
import edu.hkust.cse.phoneAdapter.database.MyDbAdapter;

/**
 * The Class ViewRuleActivity.
 * @author andrew
 */
public class ViewRuleActivity extends Activity {
	
	private MyDbAdapter mDbHelper;
	
	private static final int DELETE_RULE=Menu.FIRST+1;
	private static final int ENABLE=Menu.FIRST+2;
	private static final int DISABLE=Menu.FIRST+3;
	private static final int NEW_RULE=Menu.FIRST;
	private static final int ACTIVITY_EDIT=1;
	private static final int ACTIVITY_CREATE=1;

	private ListView mEnabledRuleList;
	private ListView mDisabledRuleList;

	private Cursor mCursor_enabled;
	private Cursor mCursor_disabled;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rule_list);
		/* fetch rules and display them according to whether they are enabled */
		mDbHelper=new MyDbAdapter(this);
		mDbHelper.open();
		mEnabledRuleList=(ListView) findViewById(R.id.enabled_rule_list);
		mDisabledRuleList=(ListView) findViewById(R.id.disabled_rule_list);
		fillData();

		/* set up context menu and list item click listeners */
		registerForContextMenu(mEnabledRuleList);
		registerForContextMenu(mDisabledRuleList);
		registerOnListItemClickListenerForListView(mEnabledRuleList);
		registerOnListItemClickListenerForListView(mDisabledRuleList);
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		menu.add(0, NEW_RULE, 0, R.string.create_rule_menu_item);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		super.onOptionsItemSelected(item);
		switch(item.getItemId()){
		case NEW_RULE:
			Intent i=new Intent(this,CreateRuleActivity.class);
			startActivityForResult(i, ACTIVITY_CREATE);
			break;
		default:
			break;
		}
		return true;
	}


	/**
	 * Register on list item click listener for list view.
	 * @param lv the lv
	 */
	private void registerOnListItemClickListenerForListView(ListView lv){
		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
				if(view.isEnabled()){
					Intent i=new Intent(ViewRuleActivity.this,EditRuleActivity.class);
					i.putExtra(MyDbAdapter.KEY_ROW_ID,id);
					startActivityForResult(i, ACTIVITY_EDIT);
				} else{
					Toast.makeText(getApplicationContext(), "Cannot edit a disabled rule! Long press to enable it!", Toast.LENGTH_SHORT).show();
				}
			}
			
		});
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		super.onContextItemSelected(item);
		AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
		
		/*
		 * Context menu (long press an item) allows users to delete, enable, or disable a rule 
		 */
		switch(item.getItemId()){
		case DELETE_RULE:
			if(!mDbHelper.deleteRule(info.id)){
				Toast.makeText(getApplicationContext(), "No rules deleted!", Toast.LENGTH_SHORT).show();
			}
			if(!mDbHelper.deleteFilterByRuleRowId(info.id)){
				Toast.makeText(getApplicationContext(), "No filters deleted!", Toast.LENGTH_SHORT).show();
			}
			fillData();
			break;
			
		case ENABLE:
			if(!mDbHelper.enableRule(info.id)){
				Toast.makeText(getApplicationContext(), "No rule is enabled!", Toast.LENGTH_SHORT).show();
			} 
			fillData();
			break;
			
		case DISABLE:
			if(!mDbHelper.disableRule(info.id)){
				Toast.makeText(getApplicationContext(), "No rule is enabled!", Toast.LENGTH_SHORT).show();
			} 
			fillData();
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
		menu.add(0, DELETE_RULE, 0, R.string.delete);
		menu.add(0,ENABLE,0,R.string.enable_rule);
		menu.add(0,DISABLE,0,R.string.disable_rule);
	}
	
	/**
	 * Fill data. Fetch all rules from database and display them.
	 */
	private void fillData(){
		/* fetch all rules from database */
		mCursor_enabled=mDbHelper.fetchAllEnabledRules();
		startManagingCursor(mCursor_enabled);
		
		/* specify the fields we want to display in the list view, in this case, we only display rule names */
		String[] from=new String[] {MyDbAdapter.KEY_RULE_NAME};
		
		/* specify the layout of each item, display enabled rules */
		int[] to_enabled=new int[] {R.id.rule_item_text_view};
		SimpleCursorAdapter adapter_enabled=new SimpleCursorAdapter(this, R.layout.rule_item, mCursor_enabled, from, to_enabled);
		mEnabledRuleList.setAdapter(adapter_enabled);
		
		mCursor_disabled=mDbHelper.fetchAllDisabledRules();
		startManagingCursor(mCursor_disabled);
		
		/* display disabled rules */
		int[] to_disabled=new int[]{R.id.disabled_rule_item_text_view};
		SimpleCursorAdapter adapter_disabled=new SimpleCursorAdapter(this, R.layout.disable_rule_item, mCursor_disabled, from, to_disabled);
		mDisabledRuleList.setAdapter(adapter_disabled);
		
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		fillData();
	}
	
	@Override
	protected void onDestroy() {
		if(mCursor_enabled!=null){
			mCursor_enabled.close();
		}
		if(mCursor_disabled!=null){
			mCursor_disabled.close();
		}
		mDbHelper.close();
		super.onDestroy();
	}
}
