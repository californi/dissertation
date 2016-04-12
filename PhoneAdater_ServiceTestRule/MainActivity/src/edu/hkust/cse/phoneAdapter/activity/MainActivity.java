
package edu.hkust.cse.phoneAdapter.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import edu.hkust.cse.phoneAdapter.R;
import edu.hkust.cse.phoneAdapter.context.AdaptationManager;
import edu.hkust.cse.phoneAdapter.context.ContextManager;

/**
 * The main activity of PhoneAdapter.
 * @author andrew
 */
public class MainActivity extends Activity {
	
	/** The create profile button. */
	private Button createProfileBtn;
    
    /** The create rule button. */
    private Button createRuleBtn;
    
    /** The view profile button. */
    private Button viewProfileBtn;
    
    /** The view rule button. */
    private Button viewRuleBtn; 
    
    /** The record context button. */
    private Button recordContextBtn;
    
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        /* set GUI layout */
        setContentView(R.layout.main);
        
        /* the buttons have already been created by VM, retrieve their references and register listeners */
        createProfileBtn=(Button) findViewById(R.id.main_btn_create_profiles);
        createRuleBtn=(Button) findViewById(R.id.main_btn_create_rules);
        viewProfileBtn=(Button) findViewById(R.id.main_btn_view_profiles);
        viewRuleBtn=(Button) findViewById(R.id.main_btn_view_rules); 
        recordContextBtn=(Button) findViewById(R.id.main_btn_record_constant);
        
        /* register listeners for buttons */
        registerListenerForCreateProfileBtn();
        registerListenerForViewProfileBtn();
        registerListenerForCreateRuleBtn();
        registerListenerForViewRuleBtn();
        registerListenerForRecordConstantBtn();
        
        /*
         * start intent service
         * (1) ContextManager intentService retrieves sensing data from both logical (e.g., clock) and physical (e.g., GPS) sensors
         * (2) AdaptationManager evaluates active rules upon context change, and triggers the actions specified in the satisfied rule
         */
        Intent contextManagerIntent=new Intent(this, ContextManager.class);
        startService(contextManagerIntent);
        Intent adaptationManagerIntent=new Intent(this, AdaptationManager.class);
        startService(adaptationManagerIntent);
        
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
    	menu.add(Menu.NONE, Menu.FIRST+1, Menu.NONE, "start sensing and adaptation");
    	menu.add(Menu.NONE, Menu.FIRST+2, Menu.NONE, "stop sensing and adaptation");
    	return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
    	switch(item.getItemId()){
    	case Menu.FIRST+1:
    		startService();
    		break;
    	case Menu.FIRST+2:
    		stopService();
    		break;
    	default: break;
    	}
    	return true;
    }
    
    @Override
	protected void onDestroy() {
    	/* stop the ContextManager and Adaptation Manager service before destroying the main activity */
    	Intent i=new Intent("edu.hkust.cse.phoneAdapter.stopService");
    	sendBroadcast(i);
    	super.onDestroy();
	}

	/**
	 * Register listener for "Create Profile" button. When the button is clicked, create profile activity will be started.
	 * @see CreateProfileActivity
	 */
	public void registerListenerForCreateProfileBtn(){
    	createProfileBtn.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View arg0) {
				/* when the "Create Profile" button is clicked, the create profile activity will be started */
				Intent i=new Intent(MainActivity.this, CreateProfileActivity.class);
				startActivity(i);
			}
		});
    }
    
    /**
     * Register listener for "View Profile" button. When the button is clicked, view profile activity will be started.
     * @see ViewProfileActivity
     */
    public void registerListenerForViewProfileBtn(){
    	viewProfileBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				/* when the "View Profile" button is clicked, the view profile activity will be started */
				Intent i=new Intent(MainActivity.this, ViewProfileActivity.class);
				startActivity(i);
			}
		});
    }
    
    /**
     * Register listener for "Create Rule" button. When the button is clicked, create rule activity will be started.
     * @see CreateRuleActivity
     */
    public void registerListenerForCreateRuleBtn(){
    	createRuleBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent i=new Intent(MainActivity.this, CreateRuleActivity.class);
				startActivity(i);
			}
		});
    }
    
    /**
     * Register listener for "View Rule" button. When the button is clicked, view rule activity will be started.
     * @see ViewRuleActivity
     */
    public void registerListenerForViewRuleBtn(){
    	 viewRuleBtn.setOnClickListener(new OnClickListener() {
 			@Override
 			public void onClick(View arg0) {
 				Intent i=new Intent(MainActivity.this, ViewRuleActivity.class);
				startActivity(i);
 			}
 		});
    }
    
    /**
     * Register listener for "Record Constant" button. When the button is clicked, create context constant activity will be started.
     * @see CreateContextConstantActivity
     */
    public void registerListenerForRecordConstantBtn(){
    	recordContextBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent i=new Intent(MainActivity.this, CreateContextConstantActivity.class);
				startActivity(i);
			}
		});
   }  
    
   private void startService(){
	   if(!ContextManager.isRunning()){
		   Intent contextManagerIntent=new Intent(this, ContextManager.class);
	       startService(contextManagerIntent);
	   }
	   if(!AdaptationManager.isRunning()){
		   Intent adaptationManagerIntent=new Intent(this, AdaptationManager.class);
	       startService(adaptationManagerIntent);
	   }
   }
   
   private void stopService(){
	   if(ContextManager.isRunning() || AdaptationManager.isRunning()){
		   /* stop the ContextManager and Adaptation Manager service before destroying the main activity */
	    	Intent i=new Intent("edu.hkust.cse.phoneAdapter.stopService");
	    	sendBroadcast(i);
	   }
   }
}