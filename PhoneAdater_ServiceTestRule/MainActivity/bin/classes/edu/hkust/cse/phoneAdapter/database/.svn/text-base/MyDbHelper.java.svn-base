package edu.hkust.cse.phoneAdapter.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * The Class MyDbHelper.
 * @author andrew
 */
public class MyDbHelper extends SQLiteOpenHelper {

	private static final String DB_NAME = "phoneAdapterData";
	
	private static final int DB_VERSION = 2;
	
	/* we don't take care of foreign key here */
	private static final String CREATE_RULE_TABLE = "create table rule (_id integer primary key autoincrement,"
			+ "rule_name text not null,"
			+ "current_state_id integer,"
			+ "new_state_id integer,"
			+ "priority integer," + "action_id integer," + "enabled integer);";
	
	private static final String CREATE_FILTER_TABLE = "create table filter (_id integer primary key autoincrement,"
			+ "cv_type integer,"
			+ "cv_operator integer,"
			+ "value text not null," + "rule_row_id integer);";
	
	private static final String CREATE_PROFILE_TABLE = "create table profile (_id integer primary key autoincrement,"
			+ "profile_name text not null,"
			+ "ring_volume integer,"
			+ "airplane_mode integer," + "vibration integer);";
	
	private static final String CREATE_CONTEXT_CONSTANT_TABLE="create table context_constant (_id integer primary key autoincrement,"
		+"constant_type integer,"
		+"constant_name text not null,"
		+"constant_value text not null);";
	
	/**
	 * Instantiates a new database helper.
	 * @param c context
	 */
	public MyDbHelper(Context c) {
		super(c, DB_NAME, null, DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(CREATE_RULE_TABLE);
		database.execSQL(CREATE_FILTER_TABLE);
		database.execSQL(CREATE_PROFILE_TABLE);
		database.execSQL(CREATE_CONTEXT_CONSTANT_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
		Log.w(MyDbHelper.class.getName(),
				"Upgrading database from version " + oldVersion + " to "
						+ newVersion + ", which will destroy all old data");
		database.execSQL("DROP TABLE IF EXISTS rule");
		database.execSQL("DROP TABLE IF EXISTS profile");
		database.execSQL("DROP TABLE IF EXISTS filter");
		database.execSQL("DROP TABLE IF EXISTS context");
		onCreate(database);
	}
}
