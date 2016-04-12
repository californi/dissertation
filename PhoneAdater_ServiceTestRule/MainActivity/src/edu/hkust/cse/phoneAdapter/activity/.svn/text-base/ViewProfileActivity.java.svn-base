package edu.hkust.cse.phoneAdapter.activity;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;
import android.widget.AdapterView.AdapterContextMenuInfo;
import edu.hkust.cse.phoneAdapter.R;
import edu.hkust.cse.phoneAdapter.database.MyDbAdapter;

/**
 * The Class ViewProfileActivity.
 * @author andrew
 */
public class ViewProfileActivity extends ListActivity {
	
	/* naming convention to call it mDbHelper */
	private MyDbAdapter mDbHelper;
	
	private Cursor mCursor;
	
	private static final int CREATE_PROFILE=Menu.FIRST;
	private static final int DELETE_PROFILE=Menu.FIRST+1;
	
	/* users click menu and then will be able to create a new profile */
	private static final int ACTIVITY_CREATE=0;
	
	/* users click a profile item and then will be able to edit it */
	private static final int ACTIVITY_EDIT=1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.profiles_list);
		mDbHelper=new MyDbAdapter(this);
		mDbHelper.open();
		fillData();
		
		/* register context menu listener for each list item */
		registerForContextMenu(getListView());
	}
	
	/**
	 * Fill data. Fetch all recorded profiles in database and display them.
	 */
	private void fillData(){
		/* fetch all profiles from database */
		mCursor=mDbHelper.fetAllProfiles();
		startManagingCursor(mCursor);
		
		/* specify the fields we want to display in the list view, in this case, we only display the profile names */
		String[] from=new String[] {MyDbAdapter.KEY_PROFILE_NAME};
		
		/* specify the layout of each item */
		int[] to=new int[] {R.id.profile_item_text_view};
		SimpleCursorAdapter adapter=new SimpleCursorAdapter(this, R.layout.profile_item, mCursor, from, to);
		setListAdapter(adapter);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		/* let users edit the profile, start the profile edit activity, the interface will be similar to the create profile activity */
		super.onListItemClick(l, v, position, id);
		Intent i=new Intent(this,EditProfileActivity.class);
		i.putExtra(MyDbAdapter.KEY_ROW_ID,id);
		startActivityForResult(i, ACTIVITY_EDIT);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		super.onContextItemSelected(item);
		/* no need to check item id, only one option */
		AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
		if(mDbHelper.checkRulesByProfileRowId(info.id)){
			Toast.makeText(getApplicationContext(), "There are rules referencing it, cannot delete!", Toast.LENGTH_SHORT).show();
		} else{
			if(!mDbHelper.deleteProfile(info.id)){
				Toast.makeText(getApplicationContext(), "No profile is deleted!", Toast.LENGTH_SHORT).show();
			} else{
				fillData();
			}
		}
		return true;
	}

	/*
	 * users long press a list item and then will be able to delete the profile
	 * but this may result in the deletion of some rules, warnings should be presented
	 */
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		menu.add(0, DELETE_PROFILE, 0, R.string.delete);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		menu.add(0, CREATE_PROFILE, 0, R.string.create_profile_menu_item);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
		case CREATE_PROFILE:
			createProfile();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	/**
	 * start the creates profile activity.
	 * @see CreateProfileActivity
	 */
	public void createProfile(){
		Intent i=new Intent(this, CreateProfileActivity.class);
		startActivityForResult(i, ACTIVITY_CREATE);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		fillData();
	}
	
	@Override
	protected void onDestroy() {
		if(mCursor!=null){
			mCursor.close();
		}
		mDbHelper.close();
		super.onDestroy();
	}
}
