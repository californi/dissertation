package edu.hkust.cse.phoneAdapter.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * The Class MyDbAdapter.
 * @author andrew
 */
public class MyDbAdapter {
	
	private static final String TABLE_RULE="rule";
	private static final String TABLE_FILTER="filter";
	private static final String TABLE_PROFILE="profile";
	private static final String TABLE_CONSTANT="context_constant";

	/* all tables have the same name for the id row */
	public static final String KEY_ROW_ID="_id";
	public static final String KEY_RULE_NAME="rule_name";
	public static final String KEY_CURRENT_STATE_ID="current_state_id";
	public static final String KEY_NEW_STATE_ID="new_state_id";
	public static final String KEY_PRIORITY="priority";
	public static final String KEY_ACTION_ID="action_id";
	public static final String KEY_ENABLED="enabled";
	
	public static final String KEY_CV_TYPE="cv_type";
	public static final String KEY_CV_OPERATOR="cv_operator";
	public static final String KEY_VALUE="value";
	
	public static final String KEY_RULE_ROW_ID="rule_row_id";
	public static final String KEY_PROFILE_NAME="profile_name";
	public static final String KEY_RING_VOLUME="ring_volume";
	public static final String KEY_AIRPLANE_MODE="airplane_mode";
	public static final String KEY_VIBRATION="vibration";
	
	public static final String KEY_CONTEXT_CONSTANT_NAME="constant_name";
	public static final String KEY_CONTEXT_CONSTANT_TYPE="constant_type";
	public static final String KEY_CONTEXT_CONSTANT_VALUE="constant_value";
	
	private SQLiteDatabase mDb;
	private Context mContext;
	private MyDbHelper mDbHelper;
	
	/**
	 * Instantiates a new my db adapter.
	 * @param c context
	 */
	public MyDbAdapter(Context c){
		this.mContext=c;
	}
	
	/**
	 * Open database connection.
	 * @throws SQLException the sQL exception
	 */
	public void open() throws SQLException{
		mDbHelper=new MyDbHelper(mContext);
		mDb=mDbHelper.getWritableDatabase();
	}
	
	/**
	 * Close database connection.
	 */
	public void close(){
		mDbHelper.close();
	}
	
	//insert a new row into table and return its _id
	/**
	 * Insert a new rule into database.
	 * @param ruleName the rule name
	 * @param currentStateId the current state id
	 * @param newStateId the new state id
	 * @param priority the priority
	 * @param actionId the action id
	 * @param enabled the enabled
	 * @return the _id the inserted rule
	 */
	public long insertRule(String ruleName,int currentStateId,int newStateId,int priority,int actionId, int enabled){
		ContentValues values=new ContentValues();
		values.put(KEY_RULE_NAME, ruleName);
		values.put(KEY_CURRENT_STATE_ID, currentStateId);
		values.put(KEY_NEW_STATE_ID,newStateId);
		values.put(KEY_PRIORITY, priority);
		values.put(KEY_ACTION_ID, actionId);
		values.put(KEY_ENABLED, enabled);
		return mDb.insert(TABLE_RULE, null, values);
	}
	
	/**
	 * Insert a filter into database.
	 * @param cvType the context type
	 * @param cvOp the context operator
	 * @param value the target value
	 * @param ruleRowId the rule row id
	 * @return the _id of the inserted filter
	 */
	public long insertFilter(int cvType, int cvOp,String value,int ruleRowId){
		ContentValues values=new ContentValues();
		values.put(KEY_CV_TYPE, cvType);
		values.put(KEY_CV_OPERATOR, cvOp);
		values.put(KEY_VALUE, value);
		values.put(KEY_RULE_ROW_ID, ruleRowId);
		return mDb.insert(TABLE_FILTER, null, values);
	}
	
	/**
	 * Insert a profile into database.
	 *
	 * @param profileName the profile name
	 * @param ringVolume the ring volume
	 * @param airplaneMode airplane mode is enabled or not
	 * @param vibration vibration is enabled or not
	 * @return the _id of the inserted profile
	 */
	public long insertProfile(String profileName,int ringVolume,int airplaneMode, int vibration){
		ContentValues values=new ContentValues();
		values.put(KEY_PROFILE_NAME, profileName);
		values.put(KEY_RING_VOLUME, ringVolume);
		values.put(KEY_AIRPLANE_MODE, airplaneMode);
		values.put(KEY_VIBRATION, vibration);
		return mDb.insert(TABLE_PROFILE, null, values);
	}
	
	/**
	 * Insert a context constant into database.
	 * @param type context type
	 * @param constantName the constant name
	 * @param constantValue the constant value
	 * @return the _id of the inserted context constant
	 */
	public long insertContextConstant(int type,String constantName,String constantValue){
		ContentValues values=new ContentValues();
		values.put(KEY_CONTEXT_CONSTANT_TYPE, type);
		values.put(KEY_CONTEXT_CONSTANT_NAME, constantName);
		values.put(KEY_CONTEXT_CONSTANT_VALUE, constantValue);
		return mDb.insert(TABLE_CONSTANT, null, values);
	}
	
	/**
	 * Delete a rule from database.
	 * @param rowId the row id
	 * @return true, if successful
	 */
	public boolean deleteRule(long rowId){
		return mDb.delete(TABLE_RULE, KEY_ROW_ID+"="+rowId, null)>0;
	}
	
	/**
	 * Delete a filter from database.
	 * @param rowId the row id
	 * @return true, if successful
	 */
	public boolean deleteFilter(long rowId){
		return mDb.delete(TABLE_FILTER, KEY_ROW_ID+"="+rowId, null)>0;
	}
	
	/**
	 * Delete filters by rule row id.
	 * @param rowId the row id
	 * @return true, if successful
	 */
	public boolean deleteFilterByRuleRowId(long rowId){
		return mDb.delete(TABLE_FILTER, KEY_RULE_ROW_ID+"="+rowId, null)>0;
	}
	
	/**
	 * Delete a profile from database.
	 * @param rowId the row id
	 * @return true, if successful
	 */
	public boolean deleteProfile(long rowId){
		return mDb.delete(TABLE_PROFILE, KEY_ROW_ID+"="+rowId, null)>0;
	}
	
	/**
	 * Delete context constant from database.
	 * @param rowId the row id
	 * @return true, if successful
	 */
	public boolean deleteContextConstant(long rowId){
		return mDb.delete(TABLE_CONSTANT, KEY_ROW_ID+"="+rowId, null)>0;
	}
	
	/**
	 * Enable a rule rule.
	 * @param rowId the row id
	 * @return true, if successful
	 */
	public boolean enableRule(long rowId){
		ContentValues values=new ContentValues();
		values.put(KEY_ENABLED, 1);
		return mDb.update(TABLE_RULE, values, KEY_ROW_ID+"="+rowId, null)>0;
	}
	
	/**
	 * Disable a rule.
	 * @param rowId the row id
	 * @return true, if successful
	 */
	public boolean disableRule(long rowId){
		ContentValues values=new ContentValues();
		values.put(KEY_ENABLED, 0);
		return mDb.update(TABLE_RULE, values, KEY_ROW_ID+"="+rowId, null)>0;
	}
	
	/**
	 * Update a rule.
	 * @param rowId the row id
	 * @param ruleName the rule name
	 * @param currentStateId the current state id
	 * @param newStateId the new state id
	 * @param priority the priority
	 * @param actionId the action id
	 * @param enabled the enabled
	 * @return true, if successful
	 */
	public boolean updateRule(long rowId,String ruleName,int currentStateId,int newStateId,int priority,int actionId, int enabled){
		ContentValues values=new ContentValues();
		values.put(KEY_RULE_NAME, ruleName);
		values.put(KEY_CURRENT_STATE_ID, currentStateId);
		values.put(KEY_NEW_STATE_ID,newStateId);
		values.put(KEY_PRIORITY, priority);
		values.put(KEY_ACTION_ID, actionId);
		values.put(KEY_ENABLED, enabled);
		return mDb.update(TABLE_RULE, values,KEY_ROW_ID+"="+rowId, null )>0;
	}
	
	/**
	 * Update a filter.
	 * @param rowId the row id
	 * @param cvType the cv type
	 * @param cvOp the cv op
	 * @param value the value
	 * @param ruleRowId the rule row id
	 * @return true, if successful
	 */
	public boolean updateFilter(long rowId,int cvType, int cvOp,String value,int ruleRowId){
		ContentValues values=new ContentValues();
		values.put(KEY_CV_TYPE, cvType);
		values.put(KEY_CV_OPERATOR, cvOp);
		values.put(KEY_VALUE, value);
		values.put(KEY_RULE_ROW_ID, ruleRowId);
		return mDb.update(TABLE_FILTER, values,KEY_ROW_ID+"="+rowId, null )>0;
	}
	
	/**
	 * Update a filter rule row id.
	 * @param rowId the row id
	 * @param ruleRowId the rule row id
	 * @return true, if successful
	 */
	public boolean updateFilterRuleRowId(long rowId,long ruleRowId){
		ContentValues values=new ContentValues();
		values.put(KEY_RULE_ROW_ID, ruleRowId);
		return mDb.update(TABLE_FILTER, values,KEY_ROW_ID+"="+rowId, null )>0;
	}
	
	/**
	 * Update a profile.
	 * @param rowId the row id
	 * @param profileName the profile name
	 * @param ringVolume the ring volume
	 * @param airplaneMode the airplane mode
	 * @param vibration the vibration
	 * @return true, if successful
	 */
	public boolean updateProfile(long rowId,String profileName,int ringVolume,int airplaneMode, int vibration){
		ContentValues values=new ContentValues();
		values.put(KEY_PROFILE_NAME, profileName);
		values.put(KEY_RING_VOLUME, ringVolume);
		values.put(KEY_AIRPLANE_MODE, airplaneMode);
		values.put(KEY_VIBRATION, vibration);
		return mDb.update(TABLE_PROFILE, values,KEY_ROW_ID+"="+rowId, null )>0;
	}
	
	/**
	 * Update a context constant.
	 * @param rowId the row id
	 * @param type the type
	 * @param constantName the constant name
	 * @param constantValue the constant value
	 * @return true, if successful
	 */
	public boolean updateContextConstant(long rowId,int type,String constantName,String constantValue){
		ContentValues values=new ContentValues();
		values.put(KEY_CONTEXT_CONSTANT_TYPE,type);
		values.put(KEY_CONTEXT_CONSTANT_NAME, constantName);
		values.put(KEY_CONTEXT_CONSTANT_VALUE, constantValue);
		return mDb.update(TABLE_CONSTANT, values,KEY_ROW_ID+"="+rowId, null )>0;
	}
	
	/**
	 * Fetch all rules from database.
	 * @return database cursor
	 */
	public Cursor fetchAllRules(){
		return mDb.query(TABLE_RULE, null, null, null, null, null, null);
	}
	
	/**
	 * Fetch all enabled rules from database.
	 * @return database cursor
	 */
	public Cursor fetchAllEnabledRules(){
		return mDb.query(TABLE_RULE, null, KEY_ENABLED+"=1", null, null, null, null);
	}
	
	/**
	 * Fetch all disabled rules from database.
	 * @return database cursor
	 */
	public Cursor fetchAllDisabledRules(){
		return mDb.query(TABLE_RULE, null, KEY_ENABLED+"=0", null, null, null, null);
	}

	/**
	 * Fetch all filters from database.
	 * @return database cursor
	 */
	public Cursor fetAllFilters(){
		return mDb.query(TABLE_FILTER, null, null, null, null, null, null);
	}
	
	/**
	 * Fetch all profiles from database.
	 * @return database cursor
	 */
	public Cursor fetAllProfiles(){
		return mDb.query(TABLE_PROFILE, null, null, null, null, null, null);
	}
	
	/**
	 * Fetch all context constants from database.
	 * @return database cursor
	 */
	public Cursor fetchAllContextConstant(){
		return mDb.query(TABLE_CONSTANT, null, null, null, null, null, null);
	}
	
	/**
	 * Fetch a rule by id.
	 * @param rowId the row id
	 * @return database cursor
	 * @throws SQLException the sQL exception
	 */
	public Cursor fetchRule(long rowId) throws SQLException {

        Cursor mCursor = mDb.query(TABLE_RULE, null, KEY_ROW_ID + "=" + rowId, null,
                    null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }
	
	/**
	 * Fetch a rule by name.
	 * @param name the name
	 * @return database cursor
	 * @throws SQLException the sQL exception
	 */
	public Cursor fetchRuleByName(String name) throws SQLException {

        Cursor mCursor = mDb.query(TABLE_RULE, null, KEY_RULE_NAME + "='" + name+"'", null,
                    null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }
	
	/**
	 * check whether a profile is referred to by some rules.
	 * @param profileId the profile id
	 * @return true, if the profile is being used
	 * @throws SQLException the sQL exception
	 */
	public boolean ruleHasProfileId(long profileId) throws SQLException{
		Cursor mCursor=mDb.query(TABLE_RULE, null, KEY_CURRENT_STATE_ID+"="+profileId, null, null, null, null);
		if(mCursor==null){
			mCursor=mDb.query(TABLE_RULE, null, KEY_NEW_STATE_ID+"="+profileId, null, null, null, null);
			if(mCursor==null){
				return false;
			} else{
				return true;
			}
			
		} else{
			return true;
		}
	}
	
	/**
	 * Fetch a profile by id.
	 * @param rowId the row id
	 * @return database cursor
	 * @throws SQLException the sQL exception
	 */
	public Cursor fetchProfile(long rowId) throws SQLException {
        Cursor mCursor = mDb.query(TABLE_PROFILE, null, KEY_ROW_ID + "=" + rowId, null,
                    null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }
	
	/**
	 * Fetch a filter by id.
	 * @param rowId the row id
	 * @return database cursor
	 * @throws SQLException the sQL exception
	 */
	public Cursor fetchFilter(long rowId) throws SQLException {
        Cursor mCursor = mDb.query(TABLE_FILTER, null, KEY_ROW_ID + "=" + rowId, null,
                    null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }
	
	/**
	 * Fetch a profile by name.
	 * @param profileName the profile name
	 * @return database cursor
	 * @throws SQLException the sQL exception
	 */
	public Cursor fetchProfileByName(String profileName) throws SQLException{
		Cursor mCursor=mDb.query(TABLE_PROFILE, null, KEY_PROFILE_NAME+"="+"'"+profileName+"'", null, null, null, null, null);
		if(mCursor !=null){
			mCursor.moveToFirst();
		}
		return mCursor;
	}
	
	/**
	 * Fetch a context constant by id.
	 * @param rowId the row id
	 * @return database cursor
	 * @throws SQLException the sQL exception
	 */
	public Cursor fetchContextConstant(long rowId) throws SQLException{
		Cursor mCursor = mDb.query(TABLE_CONSTANT, null, KEY_ROW_ID + "=" + rowId, null,
                null, null, null, null);
	    if (mCursor != null) {
	        mCursor.moveToFirst();
	    }
	    return mCursor;
		}
	
	/**
	 * Fetch a context constant by name and type.
	 * @param name the name
	 * @param type the type
	 * @return database cursor
	 * @throws SQLException the sQL exception
	 */
	public Cursor fetchContextConstantByNameAndType(String name,int type) throws SQLException{
		Cursor c=mDb.query(TABLE_CONSTANT, null, KEY_CONTEXT_CONSTANT_NAME+"="+"'"+name+"' and "+KEY_CONTEXT_CONSTANT_TYPE+"="+type, null, null, null, null);
		if(c!=null){
			c.moveToFirst();
		}
		return c;
	}
	
	/**
	 * Fetch context constant by type.
	 * @param type the type
	 * @return database cursor
	 * @throws SQLException the sQL exception
	 */
	public Cursor fetchContextConstantByType(int type) throws SQLException{
		Cursor c=mDb.query(TABLE_CONSTANT, null, KEY_CONTEXT_CONSTANT_TYPE+"="+type, null, null, null, null);
		if(c!=null){
			c.moveToFirst();
		}
		return c;
	}
	
	/**
	 * Fetch a filter by rule id.
	 * @param ruleRowId the rule row id
	 * @return database cursor
	 * @throws SQLException the sQL exception
	 */
	public Cursor fetchFilterByRuleId(long ruleRowId) throws SQLException{
		Cursor mCursor = mDb.query(TABLE_FILTER, null, KEY_RULE_ROW_ID +"="+ ruleRowId, null,
	                null, null, null, null);
	    if (mCursor != null) {
	        mCursor.moveToFirst();
	    }
	    return mCursor;
	}
	
	/**
	 * Check rules by profile row id.
	 * @param rowId the row id
	 * @return true, if there are rules whose current state corresponds to the profile with rowId
	 * @throws SQLException the sQL exception
	 */
	public boolean checkRulesByProfileRowId(long rowId) throws SQLException{
		Cursor mCursor = mDb.query(TABLE_RULE, null, KEY_CURRENT_STATE_ID +"="+ rowId, null,
                null, null, null, null);
		if(mCursor!=null){
			if(mCursor.getCount()>0){
				mCursor.close();
				return true;
			}
		}
		mCursor = mDb.query(TABLE_RULE, null, KEY_NEW_STATE_ID +"="+ rowId, null,
                null, null, null, null);
		if(mCursor!=null){
			if(mCursor.getCount()>0){
				mCursor.close();
				return true;
			}
		}
		mCursor = mDb.query(TABLE_RULE, null, KEY_ACTION_ID +"="+ rowId, null,
                null, null, null, null);
		if(mCursor!=null){
			if(mCursor.getCount()>0){
				mCursor.close();
				return true;
			}
		}
		return false;
		}
}
