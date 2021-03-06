package edu.hkust.cse.phoneAdapter.context;

import java.util.ArrayList;
import java.util.Random;

import android.app.IntentService;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;
import edu.hkust.cse.phoneAdapter.R;
import edu.hkust.cse.phoneAdapter.activity.MainActivity;
import edu.hkust.cse.phoneAdapter.database.MyDbAdapter;

/**
 * The Class AdaptationManager.
 * @author andrew
 */
//[SERVICE-EA-BEGIN-AdaptationManager]
public class AdaptationManager extends IntentService {
	
	private MyDbAdapter mDbHelper;
	
	private Handler mHandler;
	
	private MyBroadcastReceiver mReceiver;
	
	private ArrayList<Rule> mRuleList;
	
	private Profile mCurProfile;
	
	private ArrayList<Rule> mCurRuleList;
	
	//[RG-EA-Sound/Vibracall]
	private AudioManager mAudioManager;
	
	private int mMaxVolume;
	
	private boolean mStop;
	
	private static boolean running;
	
	/**
	 * Instantiates a new adaptation manager.
	 */
	public AdaptationManager(){
		super("AdaptationManager");
	}
	
	//[THREAD-EA-BEGIN-onCreate]
	@Override
	public void onCreate() {
		super.onCreate();
		/*
		 * (1) get a handler in the main thread for UI notification purpose in onHandleIntent
		 * (2) open database
		 * (3) register broadcast receiver
		 */
		mHandler=new Handler();
		
		mDbHelper=new MyDbAdapter(this);
		mDbHelper.open();
		
		mReceiver=new MyBroadcastReceiver();
		IntentFilter iFilter=new IntentFilter("edu.hkust.cse.phoneAdapter.newContext");
		iFilter.addAction("edu.hkust.cse.phoneAdapter.ruleChange");
		iFilter.addAction("edu.hkust.cse.phoneAdapter.stopService");
		registerReceiver(mReceiver, iFilter);
		
		mAudioManager=(AudioManager) this.getSystemService(Context.AUDIO_SERVICE);
		mMaxVolume=mAudioManager.getStreamMaxVolume(AudioManager.STREAM_RING);
		
		//get enabled rules from database
		
		fetchRulesFromDb();
		mCurProfile=new Profile();
		mCurProfile.profileName="general";
		int volume=mAudioManager.getStreamVolume(AudioManager.STREAM_RING);
		mCurProfile.ringVolume=(int)((volume*1.0/mMaxVolume)*100);
		mCurProfile.airplaneMode=Settings.System.getInt(getContentResolver(),Settings.System.AIRPLANE_MODE_ON, 0);
		
		if(mAudioManager.getRingerMode()==AudioManager.RINGER_MODE_NORMAL || mAudioManager.getRingerMode()==AudioManager.RINGER_MODE_VIBRATE){
			mCurProfile.vibration=1;
		} else{
			mCurProfile.vibration=0;
		}
		//[GA-ANALISADOR-REQUERIDO-BEGIN-obtêm as regras definidas pelo usuário]
		mRuleList=fetchRulesFromDb();
		//[GA-ANALISADOR-REQUERIDO-END-obtêm as regras definidas pelo usuário]
		mCurRuleList=new ArrayList<Rule>();
		for(int j=0;j<mRuleList.size();j++){
			if(mRuleList.get(j).currentProfile.profileName.equals(mCurProfile.profileName)){
				mCurRuleList.add(mRuleList.get(j));
			}
		}
		mStop=false;
		
		/**start foreground service**/
		// step 1: instantiate the notification
		int icon = R.drawable.icon;
		CharSequence tickerText = "hello";
		long when = System.currentTimeMillis();
		Notification noti = new Notification(icon, tickerText, when);
		
		//step 2: define the notification's message and PendingIntent
		Context context = getApplicationContext();
		CharSequence contentTitle = "PhoneAdapter";
		CharSequence contentText = "Adaptation manager is running";
		Intent notiIntent = new Intent(this, MainActivity.class);
		PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notiIntent, 0);
		noti.setLatestEventInfo(context, contentTitle, contentText, contentIntent);
		
		startForeground(1347, noti);
		
		AdaptationManager.running = true;
	}
	//[THREAD-EA-END-onCreate]
	
	@Override
	protected void onHandleIntent(Intent arg0) {
		while(!mStop){
		}
	}

	@Override
	public void onDestroy() {
		/* unregister broadcast receiver and close database */
		try{
			unregisterReceiver(mReceiver);
		} catch(Exception e){
			mHandler.post(new Runnable() {
				@Override
				public void run() {
					//[IMPREVISIBILIDADE-TRACE]
					Toast.makeText(getApplicationContext(), "failed to unregister broadcast receiver", Toast.LENGTH_SHORT).show();
				}
			});
		}
		mDbHelper.close();
		/**stop foreground service**/
		stopForeground(true);
		
		AdaptationManager.running = false;
		
		super.onDestroy();
	}
	
	/**
	 * Fetch all enabled rules from database.
	 * @return An ArrayList of enabled rules
	 */
	private ArrayList<Rule> fetchRulesFromDb(){
		ArrayList<Rule> list=new ArrayList<Rule>();
		Cursor c=mDbHelper.fetchAllEnabledRules();
		if(c.getCount()>0){
			c.moveToFirst();
			while(!c.isAfterLast()){
				Rule r=new Rule();
				Profile curP=new Profile();
				Profile newP=new Profile();
				ArrayList<Filter> fList=new ArrayList<Filter>();
				r.ruleName=c.getString(c.getColumnIndex(MyDbAdapter.KEY_RULE_NAME));
				r.priority=c.getInt(c.getColumnIndex(MyDbAdapter.KEY_PRIORITY));
				
				/*retrieve profiles, current state might be do not care */
				Cursor tempC;
				if(c.getLong(c.getColumnIndex(MyDbAdapter.KEY_CURRENT_STATE_ID))==-1){
					curP.profileName="general";
					/* ring volume should be the percentage of the max, not the absolute value */
					int volume=mAudioManager.getStreamVolume(AudioManager.STREAM_RING);
					curP.ringVolume=(int)((volume*1.0/mMaxVolume)*100);
					
					curP.airplaneMode=Settings.System.getInt(getContentResolver(),Settings.System.AIRPLANE_MODE_ON, 0);
					
					if(mAudioManager.getRingerMode()==AudioManager.RINGER_MODE_NORMAL || mAudioManager.getRingerMode()==AudioManager.RINGER_MODE_VIBRATE){
						curP.vibration=1;
					} else{
						curP.vibration=0;
					}
				} else{
					tempC=mDbHelper.fetchProfile(c.getLong(c.getColumnIndex(MyDbAdapter.KEY_CURRENT_STATE_ID)));
					if(tempC.getCount()<=0){
						c.moveToNext();
						continue;
					} else{
						tempC.moveToFirst();
						curP.profileName=tempC.getString(tempC.getColumnIndex(MyDbAdapter.KEY_PROFILE_NAME));
						curP.ringVolume=tempC.getInt(tempC.getColumnIndex(MyDbAdapter.KEY_RING_VOLUME));
						curP.airplaneMode=tempC.getInt(tempC.getColumnIndex(MyDbAdapter.KEY_AIRPLANE_MODE));
						curP.vibration=tempC.getInt(tempC.getColumnIndex(MyDbAdapter.KEY_VIBRATION));
						tempC.close();
					}
				}
				
				r.currentProfile=curP;
				tempC=mDbHelper.fetchProfile(c.getLong(c.getColumnIndex(MyDbAdapter.KEY_NEW_STATE_ID)));
				if(tempC.getCount()<=0){
					c.moveToNext();
					continue;
				} else{
					tempC.moveToFirst();
					newP.profileName=tempC.getString(tempC.getColumnIndex(MyDbAdapter.KEY_PROFILE_NAME));
					newP.ringVolume=tempC.getInt(tempC.getColumnIndex(MyDbAdapter.KEY_RING_VOLUME));
					newP.airplaneMode=tempC.getInt(tempC.getColumnIndex(MyDbAdapter.KEY_AIRPLANE_MODE));
					newP.vibration=tempC.getInt(tempC.getColumnIndex(MyDbAdapter.KEY_VIBRATION));
					r.newProfile=newP;
					tempC.close();
				}
				
				/* set filter list */
				tempC=mDbHelper.fetchFilterByRuleId(c.getLong(c.getColumnIndex(MyDbAdapter.KEY_ROW_ID)));
				if(tempC.getCount()<=0){
					c.moveToNext();
					continue;
				} else{
					tempC.moveToFirst();
					while(!tempC.isAfterLast()){
						Filter f=new Filter();
						f.contextType=tempC.getInt(tempC.getColumnIndex(MyDbAdapter.KEY_CV_TYPE));
						f.contextOp=tempC.getInt(tempC.getColumnIndex(MyDbAdapter.KEY_CV_OPERATOR));
						f.contextValue=tempC.getString(tempC.getColumnIndex(MyDbAdapter.KEY_VALUE));
						fList.add(f);
						tempC.moveToNext();
					}
					tempC.close();
				}
				r.filterList=fList;
				list.add(r);
				c.moveToNext();
			}
			c.close();
		}
		return list;
	}
	
/** indicate whether the service is running or not*/
	
	public static boolean isRunning(){
		return AdaptationManager.running;
	}
	
	/**
	 * The Class MyBroadcastReceiver.
	 */
	//[THREAD-EA-BEGIN-Verificar regras e realizar adaptações]
	private class MyBroadcastReceiver extends BroadcastReceiver{

		@Override
		//[INTERATION-EA-EVENT-BEGIN-devido ao listener com filtro para newContext,ruleChange,stopService]
		public void onReceive(Context c, Intent i) {
			String action=i.getAction();
			if(action.equals("edu.hkust.cse.phoneAdapter.newContext")){
				/* handle new context, perform adaptation (on such context changes) */
				//[GA-ANALISADOR-REINICIA-BEGIN- Executa até que alguém pare o serviço]
				//GA-EXECUTOR-REINICIA-BEGIN]
				while(true){
					/*
					 * check the satisfied rules, pick one with the highest priority, if more than one (randomly pick and let users know)
					 * if an adaptation is performed, update the current active rule list, continue to check...
					 * if no rule is satisfied, break
					 */
					
					
					if(mCurRuleList.size()>0){
						//[GA-ANALISADOR-REQUERIDO-BEGIN-obtêm as regras definidas pelo usuário]
						ArrayList<Rule> satisfiedRuleList=checkRules(mCurRuleList, i);
						//[GA-ANALISADOR-REQUERIDO-END-obtêm as regras definidas pelo usuário]
						//[GA-ANALISADOR-COMBINA-BEGIN-Undersatisfied]
						if(satisfiedRuleList.size()==0){
							//[GA-EXECUTOR-GETFLAG-BEGIN-registra uma mensagem de nenhuma regra satisfeita]
							mHandler.post(new Runnable() {
								@Override
								public void run() {
									//[IMPREVISIBILIDADE-TRACE]
									Toast.makeText(getApplicationContext(), "no rule satisfied", Toast.LENGTH_SHORT).show();
								}
							});
							break;
							//[GA-EXECUTOR-GETFLAG-END-registra uma mensagem de nenhuma regra satisfeita]
						}
						//[GA-ANALISADOR-COMBINA-END-Undersatisfied] 
						//[GA-ANALISADOR-COMBINA-BEGIN-Satisfied] 
						else if(satisfiedRuleList.size()==1){
							//perform adaptation and update current profile and current rule list
							//[GA-EXECUTOR-GETFLAG-BEGIN-dispara ações quando uma única regra é satisfeita]
							double volumeLevel=(satisfiedRuleList.get(0).newProfile.ringVolume)*1.0/100;
							int volume=(int)(volumeLevel*mMaxVolume);
							int airplaneModeOn=satisfiedRuleList.get(0).newProfile.airplaneMode;
							int vibration=satisfiedRuleList.get(0).newProfile.vibration;
							
							//perform actions and notify users
							mHandler.post(new Runnable() {
								
								@Override
								public void run() {
									//[IMPREVISIBILIDADE-TRACE]
									Toast.makeText(getApplicationContext(), "only one rule satisfied,perform adaptation", Toast.LENGTH_SHORT).show();
								}
							});
							
							
							//[RG-ATUADOR-SET-BEGIN-sound]
							//[GA-EXECUTOR-PRONTO-BEGIN-Volume maior que zero]
							//[GA-EXECUTOR-INVOQUE-BEGIN-solicita ao atuador para realizar adaptações]
							//[GA-KNOWLEDGE-ESTATICO-BEGIN-verifica se volume maior que zero]
							if(volume>0){	
								//[GA-EXECUTOR-PREPARA-BEGIN-Muda para modo de toque antes de mudar volume]
								mAudioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
								//[GA-EXECUTOR-PREPARA-END-Muda para modo de toque antes de mudar volume]
								mAudioManager.setStreamVolume(AudioManager.STREAM_RING, volume, AudioManager.FLAG_SHOW_UI);
							//[GA-EXECUTOR-PRONTO-END-Volume maior que zero]
							//[GA-EXECUTOR-PRONTO-BEGIN-Volume menor/igual a zero]
							} else{
								mAudioManager.setStreamVolume(AudioManager.STREAM_RING, 0, AudioManager.FLAG_SHOW_UI);
							}
							//[GA-KNOWLEDGE-ESTATICO-END-verifica se volume maior que zero]
							//[GA-EXECUTOR-INVOQUE-END-solicita ao atuador para realizar adaptações]
							//[GA-EXECUTOR-PRONTO-END-Volume menor/igual a zero]
							//[RG-ATUADOR-SET-END-sound]

							//[RG-ATUADOR-SET-BEGIN-vibracall]
							//[GA-EXECUTOR-PRONTO-BEGIN-vibrador ligado]
							//[GA-EXECUTOR-INVOQUE-BEGIN-solicita ao atuador para realizar adaptações]
							//[GA-KNOWLEDGE-ESTATICO-BEGIN-verifica se vibração esta ativa]
							if(vibration==1){
								mAudioManager.setVibrateSetting(AudioManager.VIBRATE_TYPE_RINGER, AudioManager.VIBRATE_SETTING_ON);
							} else{
								mAudioManager.setVibrateSetting(AudioManager.VIBRATE_TYPE_RINGER, AudioManager.VIBRATE_SETTING_OFF);
							}
							//[GA-KNOWLEDGE-ESTATICO-END-verifica se vibração esta ativa]
							//[GA-EXECUTOR-INVOQUE-END-solicita ao atuador para realizar adaptações]
							//[GA-EXECUTOR-PRONTO-END-vibrador ligado]
							//[RG-ATUADOR-SET-END-vibracall]

							//[RG-ATUADOR-SET-BEGIN-airplane]
							//[GA-EXECUTOR-PRONTO-BEGIN-Modo avião ligado]
							//[GA-KNOWLEDGE-ESTATICO-BEGIN-verifica se modo avião igual ativo]
							if(airplaneModeOn==1){
								//[GA-EXECUTOR-INVOQUE-BEGIN-solicita ao atuador para realizar adaptações]
								 if(Settings.System.getInt(getContentResolver(), Settings.System.AIRPLANE_MODE_ON, 0) == 0){
									 Settings.System.putInt(getContentResolver(),Settings.System.AIRPLANE_MODE_ON, 1);
									 //[RG-EA-Airplane]
									 Intent intent=new Intent(Intent.ACTION_AIRPLANE_MODE_CHANGED);
								     intent.putExtra("state", true);
								     sendBroadcast(intent);
								 }
							        
							} else{
								if(Settings.System.getInt(getContentResolver(), Settings.System.AIRPLANE_MODE_ON, 0) == 1){
									Settings.System.putInt(getContentResolver(),Settings.System.AIRPLANE_MODE_ON, 0);
								    Intent intent=new Intent(Intent.ACTION_AIRPLANE_MODE_CHANGED);
								    intent.putExtra("state", false);
								    sendBroadcast(intent);
								}
								//[GA-EXECUTOR-INVOQUE-END-solicita ao atuador para realizar adaptações]
							}
							//[GA-KNOWLEDGE-ESTATICO-END-verifica se modo avião igual ativo]
							//[GA-EXECUTOR-PRONTO-END-Modo avião ligado]
							//[RG-ATUADOR-SET-END-airplane]
							
							
							mCurProfile=satisfiedRuleList.get(0).newProfile;
							mCurRuleList=new ArrayList<Rule>();
							for(int j=0;j<mRuleList.size();j++){
								if(mRuleList.get(j).currentProfile.profileName.equals(mCurProfile.profileName)){
									mCurRuleList.add(mRuleList.get(j));
								}
							}
							
							/* Log de contexto para an�lise  */
							StringBuffer sb = new StringBuffer();
							sb.append(satisfiedRuleList.get(0).currentProfile.profileName);
							sb.append('@');
							sb.append(satisfiedRuleList.get(0).ruleName);
							sb.append('@');
							sb.append(satisfiedRuleList.get(0).newProfile.profileName);
							sb.append('@');
							sb.append("Volume:" + satisfiedRuleList.get(0).newProfile.ringVolume);
							sb.append(",Vibracall:" + satisfiedRuleList.get(0).newProfile.vibration);
							sb.append(",ModoAviao:" + satisfiedRuleList.get(0).newProfile.airplaneMode);
							
							/* Log de contexto para an�lise  */
							Log.i("Testing-SA-Saida", sb.toString());
							
							mHandler.post(new Runnable() {
								
								@Override
								public void run() {
									//[IMPREVISIBILIDADE-TRACE]
									Toast.makeText(getApplicationContext(), mCurProfile.profileName+" is enabled.", Toast.LENGTH_SHORT).show();
								}
							});
							//[GA-EXECUTOR-GETFLAG-END-dispara ações quando uma única regra é satisfeita]
						}//[GA-ANALISADOR-COMBINA-END-Satisfied]  
						else{
							//[GA-EXECUTOR-GETFLAG-BEGIN-dispara ações quando mais que uma regra é satisfeita]
							//pick up the rule with highest priority
							ArrayList<Rule> candidate=new ArrayList<Rule>();
							int min=Integer.MAX_VALUE;

							for(int j=0;j<satisfiedRuleList.size();j++){
								if(satisfiedRuleList.get(j).priority<min){
									min=satisfiedRuleList.get(j).priority;
								}
							}
							for(int j=0;j<satisfiedRuleList.size();j++){
								if(satisfiedRuleList.get(j).priority==min){
									candidate.add(satisfiedRuleList.get(j));
								}
							}

							
							// size cannot be zero, at least one
							if(candidate.size()==1){
								//perform adaptation and update current profile and current rule list
								double volumeLevel=(candidate.get(0).newProfile.ringVolume)*1.0/100;
								int volume=(int)(volumeLevel*mMaxVolume);
								int airplaneModeOn=candidate.get(0).newProfile.airplaneMode;
								int vibration=candidate.get(0).newProfile.vibration;
								//perform actions and notify users
								mHandler.post(new Runnable() {
									
									@Override
									public void run() {
										//[IMPREVISIBILIDADE-TRACE]
										Toast.makeText(getApplicationContext(), "only one rule with highest priority, perform actions", Toast.LENGTH_SHORT).show();
									}
								});
								
								//[RG-ATUADOR-SET-BEGIN-sound]
								//[GA-EXECUTOR-PRONTO-BEGIN-Volume maior que zero]
								//[GA-EXECUTOR-INVOQUE-BEGIN-solicita ao atuador para realizar adaptações]
								//[GA-KNOWLEDGE-ESTATICO-BEGIN-verifica se volume maior que zero]
								if(volume>0){
									//[GA-EXECUTOR-PREPARA-BEGIN-Muda para modo de toque antes de mudar volume]
									mAudioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
									//[GA-EXECUTOR-PREPARA-END-Muda para modo de toque antes de mudar volume]
									mAudioManager.setStreamVolume(AudioManager.STREAM_RING, volume, AudioManager.FLAG_SHOW_UI);
								//[GA-EXECUTOR-PRONTO-END-Volume maior que zero]
								//[GA-EXECUTOR-PRONTO-BEGIN-Volume menor ou igual a zero]
								} else{
									mAudioManager.setStreamVolume(AudioManager.STREAM_RING, 0, AudioManager.FLAG_SHOW_UI);
								}
								//[GA-KNOWLEDGE-ESTATICO-END-verifica se volume maior que zero]
								//[GA-EXECUTOR-INVOQUE-END-solicita ao atuador para realizar adaptações]
								//[GA-EXECUTOR-PRONTO-END-Volume menor ou igual a zero]
								//[RG-ATUADOR-SET-END-sound]

								
								//[RG-ATUADOR-SET-BEGIN-vibracall]
								//[GA-EXECUTOR-PRONTO-BEGIN-vibrador ligado]
								//[GA-EXECUTOR-INVOQUE-BEGIN-solicita ao atuador para realizar adaptações]
								//[GA-KNOWLEDGE-ESTATICO-BEGIN-verifica se vibração esta ativa]
								if(vibration==1){
									mAudioManager.setVibrateSetting(AudioManager.VIBRATE_TYPE_RINGER, AudioManager.VIBRATE_SETTING_ON);
								} else{
									mAudioManager.setVibrateSetting(AudioManager.VIBRATE_TYPE_RINGER, AudioManager.VIBRATE_SETTING_OFF);
								}
								//[GA-KNOWLEDGE-ESTATICO-END-verifica se vibração esta ativa]
								//[GA-EXECUTOR-INVOQUE-END-solicita ao atuador para realizar adaptações]
								//[GA-EXECUTOR-PRONTO-END-vibrador ligado]
								//[RG-ATUADOR-SET-END-vibracall]

								//[RG-ATUADOR-SET-BEGIN-airplane]
								//[GA-EXECUTOR-PRONTO-BEGIN-Modo avião ligado]
								//[GA-EXECUTOR-INVOQUE-BEGIN-solicita ao atuador para realizar adaptações]
								//[GA-KNOWLEDGE-ESTATICO-BEGIN-verifica se modo avião igual ativo]
								if(airplaneModeOn==1){
									 if(Settings.System.getInt(getContentResolver(), Settings.System.AIRPLANE_MODE_ON, 0) == 0){
										 Settings.System.putInt(getContentResolver(),Settings.System.AIRPLANE_MODE_ON, 1);
									     Intent intent=new Intent(Intent.ACTION_AIRPLANE_MODE_CHANGED);
									     intent.putExtra("state", true);
									     sendBroadcast(intent);
									 }
								        
								} else{
									if(Settings.System.getInt(getContentResolver(), Settings.System.AIRPLANE_MODE_ON, 0) == 1){
										Settings.System.putInt(getContentResolver(),Settings.System.AIRPLANE_MODE_ON, 0);
									    Intent intent=new Intent(Intent.ACTION_AIRPLANE_MODE_CHANGED);
									    intent.putExtra("state", false);
									    sendBroadcast(intent);
									}
								}
								//[GA-KNOWLEDGE-ESTATICO-END-verifica se modo avião igual ativo]
								//[GA-EXECUTOR-INVOQUE-END-solicita ao atuador para realizar adaptações]
								//[GA-EXECUTOR-PRONTO-END-Modo avião ligado]
								//[RG-ATUADOR-SET-END-airplane]
								
								mCurProfile=candidate.get(0).newProfile;
								mCurRuleList=new ArrayList<Rule>();
								for(int j=0;j<mRuleList.size();j++){
									if(mRuleList.get(j).currentProfile.profileName.equals(mCurProfile.profileName)){
										mCurRuleList.add(mRuleList.get(j));
									}
								}
								mHandler.post(new Runnable() {
									
									@Override
									public void run() {
										//[IMPREVISIBILIDADE-TRACE]
										Toast.makeText(getApplicationContext(), mCurProfile.profileName+" is enabled.", Toast.LENGTH_SHORT).show();
									}
								});
								
							} else{
								//randomly pick one 
								Random rand=new Random();
								int choice=rand.nextInt(candidate.size());
								//perform adaptation and update current profile and current rule list
								double volumeLevel=(candidate.get(choice).newProfile.ringVolume)*1.0/100;
								int volume=(int)(volumeLevel*mMaxVolume);
								int airplaneModeOn=candidate.get(choice).newProfile.airplaneMode;
								int vibration=candidate.get(choice).newProfile.vibration;
								//perform actions and notify users
								mHandler.post(new Runnable() {
									
									@Override
									public void run() {
										//[IMPREVISIBILIDADE-TRACE]
										Toast.makeText(getApplicationContext(), "randomly pick one", Toast.LENGTH_SHORT).show();
									}
								});
								
								//[RG-ATUADOR-SET-BEGIN-sound]
								//[GA-EXECUTOR-INVOQUE-BEGIN-solicita ao atuador para realizar adaptações]
								//[GA-KNOWLEDGE-ESTATICO-BEGIN-verifica se volume maior que zero]
								if(volume>0){
									//[GA-EXECUTOR-PREPARA-BEGIN-Muda para modo de toque antes de mudar volume]
									mAudioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
									//[GA-EXECUTOR-PREPARA-END-Muda para modo de toque antes de mudar volume]
									mAudioManager.setStreamVolume(AudioManager.STREAM_RING, volume, AudioManager.FLAG_SHOW_UI);
								} else{
									mAudioManager.setStreamVolume(AudioManager.STREAM_RING, 0, AudioManager.FLAG_SHOW_UI);
								}
								//[GA-KNOWLEDGE-ESTATICO-END-verifica se volume maior que zero]
								//[GA-EXECUTOR-INVOQUE-END-solicita ao atuador para realizar adaptações]
								//[RG-ATUADOR-SET-END-sound]

								//[RG-ATUADOR-SET-BEGIN-vibracall]
								//[GA-EXECUTOR-PRONTO-BEGIN-vibrador ligado]
								//[GA-EXECUTOR-INVOQUE-BEGIN-solicita ao atuador para realizar adaptações]
								//[GA-KNOWLEDGE-ESTATICO-BEGIN-verifica se vibração esta ativa]
								if(vibration==1){
									mAudioManager.setVibrateSetting(AudioManager.VIBRATE_TYPE_RINGER, AudioManager.VIBRATE_SETTING_ON);
								} else{
									mAudioManager.setVibrateSetting(AudioManager.VIBRATE_TYPE_RINGER, AudioManager.VIBRATE_SETTING_OFF);
								}
								//[GA-KNOWLEDGE-ESTATICO-END-verifica se vibração esta ativa]
								//[GA-EXECUTOR-INVOQUE-END-solicita ao atuador para realizar adaptações]
								//[GA-EXECUTOR-PRONTO-END-vibrador ligado]
								//[RG-ATUADOR-SET-END-vibracall]

								//[RG-ATUADOR-SET-BEGIN-airplane]
								//[GA-EXECUTOR-PRONTO-BEGIN-Modo avião ligado]
								//[GA-EXECUTOR-INVOQUE-BEGIN-solicita ao atuador para realizar adaptações]
								//[GA-KNOWLEDGE-ESTATICO-BEGIN-verifica se modo avião igual ativo]
								if(airplaneModeOn==1){
									//[GA-EXECUTOR-PREPARA-BEGIN-Atualiza contexto com modo avião]
									 if(Settings.System.getInt(getContentResolver(), Settings.System.AIRPLANE_MODE_ON, 0) == 0){
										 Settings.System.putInt(getContentResolver(),Settings.System.AIRPLANE_MODE_ON, 1);
									     Intent intent=new Intent(Intent.ACTION_AIRPLANE_MODE_CHANGED);
									     intent.putExtra("state", true);
									     sendBroadcast(intent);
									 }
									//[GA-EXECUTOR-PREPARA-END-Atualiza contexto com modo avião]
								} else{
									//[GA-EXECUTOR-PREPARA-BEGIN-Atualiza contexto com modo avião]
									if(Settings.System.getInt(getContentResolver(), Settings.System.AIRPLANE_MODE_ON, 0) == 1){
										Settings.System.putInt(getContentResolver(),Settings.System.AIRPLANE_MODE_ON, 0);
									    Intent intent=new Intent(Intent.ACTION_AIRPLANE_MODE_CHANGED);
									    intent.putExtra("state", false);
									    sendBroadcast(intent);
									}
									//[GA-EXECUTOR-PREPARA-END-Atualiza contexto com modo avião]
								}
								//[GA-KNOWLEDGE-ESTATICO-END-verifica se modo avião igual ativo]
								//[GA-EXECUTOR-INVOQUE-END-solicita ao atuador para realizar adaptações]
								//[GA-EXECUTOR-PRONTO-END-Modo avião ligado]
								//[RG-ATUADOR-SET-END-airplane]
								
								mCurProfile=candidate.get(choice).newProfile;
								mCurRuleList=new ArrayList<Rule>();
								for(int j=0;j<mRuleList.size();j++){
									if(mRuleList.get(j).currentProfile.profileName.equals(mCurProfile.profileName)){
										mCurRuleList.add(mRuleList.get(j));
									}
								}
								mHandler.post(new Runnable() {
									
									@Override
									public void run() {
										//[IMPREVISIBILIDADE-TRACE]
										Toast.makeText(getApplicationContext(), "undeterminism!"+mCurProfile.profileName+" is enabled at random.", Toast.LENGTH_SHORT).show();
									}
								});
								
							}
							//
							//[GA-EXECUTOR-GETFLAG-END-dispara ações quando mais que uma regra é satisfeita]
						}
				
						
					} else{
						break;
					}
				}
				//[GA-ANALISADOR-REINICIA-END - Executa até que alguém pare o serviço]
				
				
			} else if(action.equals("edu.hkust.cse.phoneAdapter.ruleChange")){
//				mHandler.post(new Runnable() {
//					
//					@Override
//					public void run() {
//						Toast.makeText(getApplicationContext(), "rule change broadcast received.", Toast.LENGTH_SHORT).show();
//					}
//				});
				//update rule list, current rule list based on current profile name(unique)
				mCurProfile=new Profile();
				mCurProfile.profileName="general";
				int volume=mAudioManager.getStreamVolume(AudioManager.STREAM_RING);
				mCurProfile.ringVolume=(int)((volume*1.0/mMaxVolume)*100);
				mCurProfile.airplaneMode=Settings.System.getInt(getContentResolver(),Settings.System.AIRPLANE_MODE_ON, 0);
				if(mAudioManager.getRingerMode()==AudioManager.RINGER_MODE_NORMAL || mAudioManager.getRingerMode()==AudioManager.RINGER_MODE_VIBRATE){
					mCurProfile.vibration=1;
				} else{
					mCurProfile.vibration=0;
				}
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						//[IMPREVISIBILIDADE-TRACE]
						Toast.makeText(getApplicationContext(), "rule changed. Back to general state.", Toast.LENGTH_SHORT).show();
					}
				});
				mRuleList=fetchRulesFromDb();
				mCurRuleList=new ArrayList<Rule>();
				for(int j=0;j<mRuleList.size();j++){
					if(mRuleList.get(j).currentProfile.profileName.equals(mCurProfile.profileName)){
						mCurRuleList.add(mRuleList.get(j));
					}
				}
				
				
			} else if(action.equals("edu.hkust.cse.phoneAdapter.stopService")){
				mStop=true;
			} else{
				//nothing
			}	
		}	
		//[INTERATION-EA-EVENT-END-devido ao listener com filtro para newContext,ruleChange,stopService]
	}
	//[THREAD-EA-END-Verificar regras e realizar adaptações]
	
	/**
	 * Check whether rules are satisfied by context changes.
	 * @param ruleList the currently active rules
	 * @param i the intent i is used to pass context data
	 * @return An ArrayList of satisfied rules
	 */
	private static ArrayList<Rule> checkRules(ArrayList<Rule> ruleList, Intent i){
		ArrayList<Rule> result=new ArrayList<Rule>();
		
		/* get context data from intent */
		//[GA-ANALISADOR-GETCONTEXT-BEGIN]
		boolean gpsAvailable=i.getBooleanExtra(ContextName.GPS_AVAILABLE, false);
		String gpsLocation=i.getStringExtra(ContextName.GPS_LOCATION);
		double gpsSpeed=i.getDoubleExtra(ContextName.GPS_SPEED, 0.0);
		String[] deviceMacList=i.getStringArrayExtra(ContextName.BT_DEVICE_LIST);
		int count=deviceMacList.length;
		String time=i.getStringExtra(ContextName.TIME);
		String weekday=i.getStringExtra(ContextName.WEEKDAY);
		//[GA-ANALISADOR-GETCONTEXT-END]
		
		/* go through each active rule and evaluate whether its predicate (a conjunction of filters) is satisfied */
		for(int j=0;j<ruleList.size();j++){
			ArrayList<Filter> fList=ruleList.get(j).filterList;
			boolean f=true;
			for(int k=0;k<fList.size();k++){
				/* if any filter is not satisfied,break and set f to false */
				Filter filter=fList.get(k);
				switch(filter.contextType){
				case ContextType.GPS_ISVALID:
					int value = 0; //false por padrao
					//int value=Integer.parseInt(filter.contextValue);
					if(filter.contextValue.toLowerCase() == "true")
						value = 1;
					else
						value = 0;
					
					boolean bool=(value==1)?true:false;
					if(filter.contextOp==ContextOperator.EQUAL){
						if(gpsAvailable!=bool){
							f=false;
							break;
						}
					}
					if(filter.contextOp==ContextOperator.NOTEQUAL){
						if(gpsAvailable==bool){
							f=false;
							break;
						}
					}
					break;
					
				case ContextType.GPS_LOCATION:
					if(gpsLocation==null || !gpsLocation.contains(","))
					{
						f=false;
						break;
					} else{
						if(filter.contextOp==ContextOperator.EQUAL){
							if(calculateDist(filter.contextValue, gpsLocation)>0.05){
								f=false;
								break;
							}
						}
						if(filter.contextOp==ContextOperator.NOTEQUAL){
							if(calculateDist(filter.contextValue, gpsLocation)<=0.05){
								f=false;
								break;
							}
						}
					}
					break;
					
				case ContextType.GPS_SPEED:
					switch(filter.contextOp){
					case ContextOperator.EQUAL:
						if(gpsSpeed!=Double.parseDouble(filter.contextValue)){
							f=false;
						}
						break;
					case ContextOperator.GREATER:
						if(gpsSpeed<=Double.parseDouble(filter.contextValue)){
							f=false;
						}
						break;
					case ContextOperator.GREATER_EQUAL:
						if(gpsSpeed<Double.parseDouble(filter.contextValue)){
							f=false;
						}
						break;
					case ContextOperator.NOTEQUAL:
						if(gpsSpeed==Double.parseDouble(filter.contextValue)){
							f=false;
						}
						break;
					case ContextOperator.SMALLER:
						if(gpsSpeed>=Double.parseDouble(filter.contextValue)){
							f=false;
						}
						break;
					case ContextOperator.SMALLER_EQUAL:
						if(gpsSpeed>Double.parseDouble(filter.contextValue)){
							f=false;
						}
						break;
					default:
						break;
						
					}
					break;
					
				case ContextType.BLUETOOTH:
					if(filter.contextOp==ContextOperator.EQUAL){
						/* if mac list does not contain the context value, f=false */
						if(!macListContainsMac(deviceMacList, filter.contextValue)){
							f=false;
							break;
						}
					}
					if(filter.contextOp==ContextOperator.NOTEQUAL){
						/* if mac list contains the context value, f=false */
						if(macListContainsMac(deviceMacList, filter.contextValue)){
							f=false;
							break;
						}
					}
					break;
					
				case ContextType.BLUETOOTH_COUNT:
					switch(filter.contextOp){
					case ContextOperator.EQUAL:
						if(count!=Integer.parseInt(filter.contextValue)){
							f=false;
						}
						break;
					case ContextOperator.GREATER:
						if(count<=Integer.parseInt(filter.contextValue)){
							f=false;
						}
						break;
					case ContextOperator.GREATER_EQUAL:
						if(count<Integer.parseInt(filter.contextValue)){
							f=false;
						}
						break;
					case ContextOperator.NOTEQUAL:
						if(count==Integer.parseInt(filter.contextValue)){
							f=false;
						}
						break;
					case ContextOperator.SMALLER:
						if(count>=Integer.parseInt(filter.contextValue)){
							f=false;
						}
						break;
					case ContextOperator.SMALLER_EQUAL:
						if(count>Integer.parseInt(filter.contextValue)){
							f=false;
						}
						break;
					}
					break;
					
				case ContextType.TIME:
					int compResult=compareTime(time, filter.contextValue);
					switch(filter.contextOp){
					case ContextOperator.EQUAL:
						if(compResult!=0){
							f=false;
						}
						break;
					case ContextOperator.GREATER:
						if(compResult!=1){
							f=false;
						}
						break;
					case ContextOperator.GREATER_EQUAL:
						if(compResult<0){
							f=false;
						}
						break;
					case ContextOperator.NOTEQUAL:
						if(compResult==0){
							f=false;
						}
						break;
					case ContextOperator.SMALLER:
						if(compResult!=-1){
							f=false;
						}
						break;
					case ContextOperator.SMALLER_EQUAL:
						if(compResult==1 || compResult==-2){
							f=false;
						}
						break;
					}
					break;
					
				case ContextType.WEEKDAY:
					int comp=compareWeekday(weekday, filter.contextValue);
					switch(filter.contextOp){
					case ContextOperator.EQUAL:
						if(comp!=0){
							f=false;
						}
						break;
					case ContextOperator.GREATER:
						if(comp!=1){
							f=false;
						}
						break;
					case ContextOperator.GREATER_EQUAL:
						if(comp<0){
							f=false;
						}
						break;
					case ContextOperator.NOTEQUAL:
						if(comp==0){
							f=false;
						}
						break;
					case ContextOperator.SMALLER:
						if(comp!=-1){
							f=false;
						}
						break;
					case ContextOperator.SMALLER_EQUAL:
						if(comp==1 || comp==-2){
							f=false;
						}
						break;
					default:
						break;
					}
					break;
					
				default:
					break;
				}
			}
			if(f){
				result.add(ruleList.get(j));
			}
		}
		return result;
	}
	
	/**
	 * Calculate distance between two GPS coordinates.
	 *
	 * @param lastLoc the coordinate (lat, lon) of the previously sensed location
	 * @param curLoc the coordinate of the current location
	 * @return the distance between two GPS coordinates
	 */
	public static double calculateDist(String lastLoc, String curLoc){
		double lat1=0.0;
		double lat2=0.0;
		double long1=0.0;
		double long2=0.0;
		String[] temp=lastLoc.split(",");
		if(temp.length==2){
			lat1=Double.parseDouble(temp[0]);
			long1=Double.parseDouble(temp[1]);
		}
		
		temp=curLoc.split(",");
		if(temp.length==2){
			lat2=Double.parseDouble(temp[0]);
			long2=Double.parseDouble(temp[1]);
		}
		
		/*transform to radians */
		lat1=(lat1*Math.PI)/180.0;
		lat2=(lat2*Math.PI)/180.0;
		long1=(long1*Math.PI)/180.0;
		long2=(long2*Math.PI)/180.0;
		
		double dlat=lat2-lat1;
		double dlong=long2-long1;
		double a= Math.sin(dlat/2)*Math.sin(dlat/2)+Math.sin(dlong/2)*Math.sin(dlong/2)*Math.cos(lat1)*Math.cos(lat2);
		double c=2*Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		double d=6371*c;
		return d;
	}
	
	/**
	 * Check whether a list of MAC addresses contains a specific MAC address.
	 * @param list the list of MAC addresses
	 * @param mac the specific MAC
	 * @return true if the MAC list contains the specific MAC, and false otherwise
	 */
	public static boolean macListContainsMac(String[] list, String mac){
		for(int i=0;i<list.length;i++){
			if(list[i].equals(mac)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Compare time.
	 * @param t1 time1
	 * @param t2 time2
	 * @return 1 if time1 > time2 (> means after), 0 if time1 = time2, -1 if time1 < time2
	 */
	private static int compareTime(String t1,String t2){
		String[] s1=t1.split(":");
		String[] s2=t2.split(":");
		if(s1.length!=3 || s2.length!=3){
			return -2;
		} else{
			int h1=Integer.parseInt(s1[0]);
			int h2=Integer.parseInt(s2[0]);
			if(h1<h2){
				return -1;
			} else if(h1>h2){
				return 1;
			} else{
				int m1=Integer.parseInt(s1[1]);
				int m2=Integer.parseInt(s2[1]);
				if(m1<m2){
					return -1;
				} else if(m1>m2){
					return 1;
				} else{
					int sec1=Integer.parseInt(s1[2]);
					int sec2=Integer.parseInt(s2[2]);
					if(sec1<sec2){
						return -1;
					} else if(sec1>sec2){
						return 1;
					} else{
						return 0;
					}
				}
			}
		}
	}
	
	/**
	 * Compare weekday.
	 *
	 * @param wd1 weekday1
	 * @param wd2 weekday2
	 * @return 1 if weekday1 > weekday2, 0 if weekday1 = weekday2, -1 if weekday1 < weekday2, -2 if weekday1 or weekday2 is invalid
	 */
	private static int compareWeekday(String wd1,String wd2){
		String[] list =new String[]{"sunday","monday","tuesday","wednesday","thursday","friday","saturday"};
		int d1=-1,d2=-1;
		for(int i=0;i<list.length;i++){
			if(list[i].equals(wd1)){
				d1=i;
			}
			if(list[i].equals(wd2)){
				d2=i;
			}
		}
		if(d1<0 || d2<0){
			return -2;
		}
		if(d1<d2){
			return -1;
		} else if(d1>d2){
			return 1;
		} else{
			return 0;
		}
	}
	
	/**
	 * The Class Rule.
	 */
	private class Rule{
		
		private String ruleName;
		private Profile currentProfile;
		private ArrayList<Filter> filterList;
		private Profile newProfile;
		private int priority;
	}
	
	/**
	 * The Class Profile.
	 */
	private class Profile{
		private String profileName;
		private int ringVolume;
		private int airplaneMode;
		private int vibration;
	}
	
	/**
	 * The Class Filter.
	 */
	private class Filter{
		private int contextType;
		private int contextOp;
		private String contextValue;
	}
}
//[SERVICE-EA-END-AdaptationManager]