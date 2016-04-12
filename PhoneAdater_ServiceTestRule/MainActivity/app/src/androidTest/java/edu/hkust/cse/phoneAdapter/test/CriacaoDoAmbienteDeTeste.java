package edu.hkust.cse.phoneAdapter.test;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

import edu.hkust.cse.phoneAdapter.activity.MainActivity;


public class CriacaoDoAmbienteDeTeste extends ActivityInstrumentationTestCase2<MainActivity> {
  	private Solo solo;
  	
  	public CriacaoDoAmbienteDeTeste() {
		super(MainActivity.class);
  	}

  	public void setUp() throws Exception {
        super.setUp();
		solo = new Solo(getInstrumentation());
		getActivity();
  	}
  
   	@Override
   	public void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
  	}
  
	public void testRun() {

		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.MainActivity'
		solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.MainActivity.class, 2000);
		// Click on Create Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.main_btn_create_profiles));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateProfileActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateProfileActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateProfileActivity.class));
		// Enter the text: 'general'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.profile_name_textbox));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.profile_name_textbox), "general");
		// Set progress on SeekBar
		solo.setProgressBar((android.widget.ProgressBar) solo.getView(edu.hkust.cse.phoneAdapter.R.id.ring_volume_seekbar), 50);
		// Click on Confirm
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.create_profile_confirm_btn));
		// Click on Create Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.main_btn_create_profiles));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateProfileActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateProfileActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateProfileActivity.class));
		// Enter the text: 'Na rua'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.profile_name_textbox));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.profile_name_textbox), "Na rua");
		// Set progress on SeekBar
		solo.setProgressBar((android.widget.ProgressBar) solo.getView(edu.hkust.cse.phoneAdapter.R.id.ring_volume_seekbar), 100);
		// Click on Confirm
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.create_profile_confirm_btn));
		// Click on Create Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.main_btn_create_profiles));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateProfileActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateProfileActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateProfileActivity.class));
		// Enter the text: 'Corrida de rua'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.profile_name_textbox));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.profile_name_textbox), "Corrida de rua");
		// Set progress on SeekBar
		solo.setProgressBar((android.widget.ProgressBar) solo.getView(edu.hkust.cse.phoneAdapter.R.id.ring_volume_seekbar), 100);
		// Click on Confirm
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.create_profile_confirm_btn));
		// Click on Create Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.main_btn_create_profiles));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateProfileActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateProfileActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateProfileActivity.class));
		// Enter the text: 'Casa'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.profile_name_textbox));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.profile_name_textbox), "Casa");
		// Set progress on SeekBar
		solo.setProgressBar((android.widget.ProgressBar) solo.getView(edu.hkust.cse.phoneAdapter.R.id.ring_volume_seekbar), 100);
		// Click on Confirm
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.create_profile_confirm_btn));
		// Click on Create Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.main_btn_create_profiles));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateProfileActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateProfileActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateProfileActivity.class));
		// Enter the text: 'Dirigindo'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.profile_name_textbox));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.profile_name_textbox), "Dirigindo");
		// Set progress on SeekBar
		solo.setProgressBar((android.widget.ProgressBar) solo.getView(edu.hkust.cse.phoneAdapter.R.id.ring_volume_seekbar), 50);
		// Click on Confirm
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.create_profile_confirm_btn));
		// Click on Create Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.main_btn_create_profiles));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateProfileActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateProfileActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateProfileActivity.class));
		// Enter the text: 'DirigindoRapido'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.profile_name_textbox));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.profile_name_textbox), "DirigindoRapido");
		// Set progress on SeekBar
		solo.setProgressBar((android.widget.ProgressBar) solo.getView(edu.hkust.cse.phoneAdapter.R.id.ring_volume_seekbar), 10);
		// Click on Confirm
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.create_profile_confirm_btn));
		// Click on Create Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.main_btn_create_profiles));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateProfileActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateProfileActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateProfileActivity.class));
		// Enter the text: 'Escritorio'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.profile_name_textbox));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.profile_name_textbox), "Escritorio");
		// Click on OFF
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.vibration_toggle_button));
		// Click on Confirm
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.create_profile_confirm_btn));
		// Click on Create Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.main_btn_create_profiles));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateProfileActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateProfileActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateProfileActivity.class));
		// Enter the text: 'Reuniao'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.profile_name_textbox));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.profile_name_textbox), "Reuniao");
		// Click on OFF
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.airplane_mode_toggle_button));
		// Click on Confirm
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.create_profile_confirm_btn));
		// Click on Create Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.main_btn_create_profiles));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateProfileActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateProfileActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateProfileActivity.class));
		// Enter the text: 'Sincronizacao'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.profile_name_textbox));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.profile_name_textbox), "Sincronizacao");
		// Set progress on SeekBar
		solo.setProgressBar((android.widget.ProgressBar) solo.getView(edu.hkust.cse.phoneAdapter.R.id.ring_volume_seekbar), 50);
		// Click on Confirm
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.create_profile_confirm_btn));

		// Click on Record Constant
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.main_btn_record_constant));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateContextConstantActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateContextConstantActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateContextConstantActivity.class));
		// Click on Empty Text View
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.bt_name_textbox_in_record_constant));

		// Enter the text: 'bt_escritorio'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.bt_name_textbox_in_record_constant));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.bt_name_textbox_in_record_constant), "bt_escritorio");
		// Click on Empty Text View
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.bt_mac_textbox_in_record_constant));
		// Enter the text: 'DC:53:60:4F:02:AA'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.bt_mac_textbox_in_record_constant));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.bt_mac_textbox_in_record_constant), "DC:53:60:4F:02:AA");
		// Click on Save Device
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.save_device_btn_in_record_constant));

		// Click on Record Constant
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.main_btn_record_constant));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateContextConstantActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateContextConstantActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateContextConstantActivity.class));
		// Click on Empty Text View
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.bt_name_textbox_in_record_constant));
		// Enter the text: 'bt_casa'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.bt_name_textbox_in_record_constant));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.bt_name_textbox_in_record_constant), "bt_casa");
		// Click on Empty Text View
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.bt_mac_textbox_in_record_constant));
		// Enter the text: '1C:39:47:0D:4A:BC'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.bt_mac_textbox_in_record_constant));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.bt_mac_textbox_in_record_constant), "1C:39:47:0D:4A:BC");
		// Click on Save Device
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.save_device_btn_in_record_constant));
		// Click on Record Constant
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.main_btn_record_constant));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateContextConstantActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateContextConstantActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateContextConstantActivity.class));
		// Click on Empty Text View
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.bt_name_textbox_in_record_constant));
		// Enter the text: 'bt_carro'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.bt_name_textbox_in_record_constant));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.bt_name_textbox_in_record_constant), "bt_carro");
		// Click on Empty Text View
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.bt_mac_textbox_in_record_constant));
		// Enter the text: '00:FF:CD:6A:12:6B'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.bt_mac_textbox_in_record_constant));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.bt_mac_textbox_in_record_constant), "00:FF:CD:6A:12:6B");
		// Click on Save Device
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.save_device_btn_in_record_constant));
		
		// Click on Record Constant
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.main_btn_record_constant));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateContextConstantActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateContextConstantActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateContextConstantActivity.class));
		// Enter the text: 'Escritorio'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.location_name_textbox_in_record_constant));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.location_name_textbox_in_record_constant), "Escritorio");
		// Click on Empty Text View
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.latitude_textbox_in_record_constant));
		// Enter the text: '-21.979769'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.latitude_textbox_in_record_constant));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.latitude_textbox_in_record_constant), "-21.979769");
		// Click on Empty Text View
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.longitude_textbox_in_record_constant));
		// Enter the text: '-47.880300'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.longitude_textbox_in_record_constant));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.longitude_textbox_in_record_constant), "-47.880300");
		// Click on Save Location
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.save_location_btn_in_record_constant));
		// Click on Record Constant
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.main_btn_record_constant));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateContextConstantActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateContextConstantActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateContextConstantActivity.class));
		// Enter the text: 'Casa'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.location_name_textbox_in_record_constant));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.location_name_textbox_in_record_constant), "Casa");
		// Click on Empty Text View
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.latitude_textbox_in_record_constant));
		// Enter the text: '-20.999935'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.latitude_textbox_in_record_constant));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.latitude_textbox_in_record_constant), "-20.999935");
		// Click on Empty Text View
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.longitude_textbox_in_record_constant));
		// Enter the text: '-48.210638'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.longitude_textbox_in_record_constant));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.longitude_textbox_in_record_constant), "-48.210638");
		// Click on Save Location
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.save_location_btn_in_record_constant));

		//inserted 07/02   #1
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.MainActivity'
		solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.MainActivity.class, 2000);
		// Click on Create Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.main_btn_create_rules));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity.class));
		// Enter the text: 'AtivarRua'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox), "AtivarRua");
		// Click on Choose Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_cur_state_spinner));
		// Click on general
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on Choose Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_new_state_spinner));
		// Click on Na rua
		solo.clickOnView(solo.getView(android.R.id.text1, 2));
		// Click on edu.hkust.cse.phoneAdapter.R$id.choose_priority_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_priority_spinner));
		// Click on android.R$id.text1
		solo.clickOnView(solo.getView(android.R.id.text1, 4));
		// Click on Add Filter
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.add_filter_btn));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity.class));
		// Click on Choose From Stored Constants
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_from_db_radio));
		// Enter the text: 'true'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_edit_text));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_edit_text), "true");
		// Click on Confirm
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.confirm_btn));
		// Click on Add Filter
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.add_filter_btn));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity.class));
		// Click on GPS.IsValid
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_type_spinner));
		// Click on GPS.Location
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on Choose From Stored Constants
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_from_db_radio));
		// Click on edu.hkust.cse.phoneAdapter.R$id.context_op_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_op_spinner));
		// Click on !
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on Escritorio
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_spinner));
		// Click on Casa
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on Confirm
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.confirm_btn));
		// Click on Add Filter
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.add_filter_btn));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity.class));
		// Click on GPS.IsValid
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_type_spinner));
		// Click on GPS.Location
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on Choose From Stored Constants
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_from_db_radio));
		// Click on edu.hkust.cse.phoneAdapter.R$id.context_op_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_op_spinner));
		// Click on !
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on Escritorio
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_spinner));
		// Click on Casa
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on Casa
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_spinner));
		// Click on Escritorio
		solo.clickOnView(solo.getView(android.R.id.text1));
		// Click on Confirm
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.confirm_btn));
		// Click on Save Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.save_rule_btn));
		// Click on Create Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.main_btn_create_rules));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity.class));
		// Enter the text: 'DesativarRua_GPSNaoValido'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox), "DesativarRua_GPSNaoValido");
		// Click on Choose Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_cur_state_spinner));
		// Click on Na rua
		solo.clickOnView(solo.getView(android.R.id.text1, 2));
		// Click on Choose Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_new_state_spinner));
		// Click on general
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on edu.hkust.cse.phoneAdapter.R$id.choose_priority_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_priority_spinner));
		// Click on android.R$id.text1
		solo.clickOnView(solo.getView(android.R.id.text1, 4));
		// Click on Add Filter
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.add_filter_btn));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity.class));
		// Click on edu.hkust.cse.phoneAdapter.R$id.context_op_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_op_spinner));
		// Click on !
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on Choose From Stored Constants
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_from_db_radio));
		// Enter the text: 'true'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_edit_text));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_edit_text), "true");
		// Click on Confirm
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.confirm_btn));
		// Click on Save Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.save_rule_btn));
		// Click on Create Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.main_btn_create_rules));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity.class));
		// Enter the text: 'DesativarRua_LocalCasa'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox), "DesativarRua_LocalCasa");
		// Click on Choose Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_cur_state_spinner));
		// Click on Na rua
		solo.clickOnView(solo.getView(android.R.id.text1, 2));
		// Click on Choose Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_new_state_spinner));
		// Click on general
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on edu.hkust.cse.phoneAdapter.R$id.choose_priority_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_priority_spinner));;
		// Click on android.R$id.text1
		solo.clickOnView(solo.getView(android.R.id.text1, 4));
		// Click on Add Filter
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.add_filter_btn));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity.class));
		// Click on GPS.IsValid
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_type_spinner));
		// Click on GPS.Location
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on Choose From Stored Constants
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_from_db_radio));
		// Click on Escritorio
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_spinner));
		// Click on Casa
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on Confirm
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.confirm_btn));
		// Click on Save Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.save_rule_btn));
		// Click on Create Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.main_btn_create_rules));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity.class));
		// Enter the text: 'DesativarRua_LocalEscritorio'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox), "DesativarRua_LocalEscritorio");
		// Click on Choose Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_cur_state_spinner));
		// Click on Na rua
		solo.clickOnView(solo.getView(android.R.id.text1, 2));
		// Click on Choose Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_new_state_spinner));
		// Click on general
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on edu.hkust.cse.phoneAdapter.R$id.choose_priority_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_priority_spinner));
		// Click on android.R$id.text1
		solo.clickOnView(solo.getView(android.R.id.text1, 4));
		// Click on Add Filter
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.add_filter_btn));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity.class));
		// Click on GPS.IsValid
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_type_spinner));
		// Click on GPS.Location
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on Choose From Stored Constants
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_from_db_radio));
		// Click on Escritorio
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_spinner));
		// Click on Casa
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on Casa
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_spinner));
		// Click on Escritorio
		solo.clickOnView(solo.getView(android.R.id.text1));
		// Click on Confirm
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.confirm_btn));
		// Click on Save Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.save_rule_btn));
		// Click on Create Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.main_btn_create_rules));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity.class));
		// Enter the text: 'AtivarCorrida'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox), "AtivarCorrida");
		// Click on Choose Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_cur_state_spinner));
		// Click on Na rua
		solo.clickOnView(solo.getView(android.R.id.text1, 2));
		// Click on Choose Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_new_state_spinner));
		// Click on Corrida de rua
		solo.clickOnView(solo.getView(android.R.id.text1, 3));
		// Click on edu.hkust.cse.phoneAdapter.R$id.choose_priority_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_priority_spinner));
		// Click on android.R$id.text1
		solo.clickOnView(solo.getView(android.R.id.text1, 4));
		// Click on Add Filter
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.add_filter_btn));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity.class));
		// Click on GPS.IsValid
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_type_spinner));
		// Click on GPS.Location
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on GPS.Location
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_type_spinner));
		// Click on GPS.IsValid
		solo.clickOnView(solo.getView(android.R.id.text1));
		// Click on Choose From Stored Constants
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_from_db_radio));
		// Enter the text: 'true'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_edit_text));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_edit_text), "true");
		// Click on Confirm
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.confirm_btn));
		// Click on Add Filter
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.add_filter_btn));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity.class));
		// Click on GPS.IsValid
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_type_spinner));
		// Click on GPS.Speed
		solo.clickOnView(solo.getView(android.R.id.text1, 2));
		// Click on Choose From Stored Constants
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_from_db_radio));
		// Click on edu.hkust.cse.phoneAdapter.R$id.context_op_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_op_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(50);
		// Click on android.R$id.text1
		solo.clickOnView(solo.getView(android.R.id.text1, 2));
		// Click on Empty Text View
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_edit_text));
		// Enter the text: '5'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_edit_text));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_edit_text), "5");
		// Click on Confirm
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.confirm_btn));
		// Click on Save Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.save_rule_btn));
		// Click on Create Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.main_btn_create_rules));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity.class));
		// Enter the text: 'DesativarCorrida_GPSNaoValido'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox), "DesativarCorrida_GPSNaoValido");
		// Click on Choose Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_cur_state_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on Corrida de rua
		solo.clickOnView(solo.getView(android.R.id.text1, 3));
		// Click on Choose Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_new_state_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on Na rua
		solo.clickOnView(solo.getView(android.R.id.text1, 2));
		// Click on edu.hkust.cse.phoneAdapter.R$id.choose_priority_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_priority_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on android.R$id.text1
		solo.clickOnView(solo.getView(android.R.id.text1, 4));
		// Click on Add Filter
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.add_filter_btn));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity.class));
		// Click on edu.hkust.cse.phoneAdapter.R$id.context_op_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_op_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on !
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on Choose From Stored Constants
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_from_db_radio));
		// Click on Empty Text View
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_edit_text));
		// Enter the text: 'true'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_edit_text));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_edit_text), "true");
		// Click on Confirm
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.confirm_btn));
		// Click on Save Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.save_rule_btn));
		// Click on Create Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.main_btn_create_rules));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity.class));
		// Enter the text: 'DesativarCorrida_VelocidadeMenorIgual5'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox), "DesativarCorrida_VelocidadeMenorIgual5");
		// Click on Choose Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_cur_state_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on Corrida de rua
		solo.clickOnView(solo.getView(android.R.id.text1, 3));
		// Click on Choose Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_new_state_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on Na rua
		solo.clickOnView(solo.getView(android.R.id.text1, 2));
		// Click on edu.hkust.cse.phoneAdapter.R$id.choose_priority_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_priority_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on android.R$id.text1
		solo.clickOnView(solo.getView(android.R.id.text1, 4));
		// Click on Add Filter
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.add_filter_btn));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity.class));
		// Click on GPS.IsValid
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_type_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on GPS.Speed
		solo.clickOnView(solo.getView(android.R.id.text1, 2));
		// Click on edu.hkust.cse.phoneAdapter.R$id.context_op_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_op_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on
		solo.clickOnView(solo.getView(android.R.id.text1, 3));
		// Click on Choose From Stored Constants
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_from_db_radio));
		// Enter the text: '5'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_edit_text));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_edit_text), "5");
		// Click on Confirm
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.confirm_btn));
		// Click on GPS.Speed  5
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.filter_value));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.EditFilterActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.EditFilterActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.EditFilterActivity.class));
		// Click on
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_op_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on
		solo.clickOnView(solo.getView(android.R.id.text1, 5));
		// Click on Confirm
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.confirm_btn));
		// Click on Save Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.save_rule_btn));
		// Click on Add Filter
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.add_filter_btn));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity.class));
		// Click on GPS.IsValid
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_type_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on GPS.Speed
		solo.clickOnView(solo.getView(android.R.id.text1, 2));
		// Click on edu.hkust.cse.phoneAdapter.R$id.context_op_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_op_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on
		solo.clickOnView(solo.getView(android.R.id.text1, 5));
		// Click on Choose From Stored Constants
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_from_db_radio));
		// Click on Empty Text View
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_edit_text));
		// Enter the text: '5'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_edit_text));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_edit_text), "5");
		// Click on Confirm
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.confirm_btn));
		// Click on Save Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.save_rule_btn));
		// Click on Create Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.main_btn_create_rules));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity.class));
		// Enter the text: 'AtivarDirigindo_Geral'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox), "AtivarDirigindo_Geral");
		// Click on Choose Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_cur_state_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on general
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on Choose Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_new_state_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on Dirigindo
		solo.clickOnView(solo.getView(android.R.id.text1, 5));
		// Click on edu.hkust.cse.phoneAdapter.R$id.choose_priority_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_priority_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on android.R$id.text1
		solo.clickOnView(solo.getView(android.R.id.text1));
		// Click on Add Filter
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.add_filter_btn));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity.class));
		// Click on GPS.IsValid
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_type_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on Bluetooth
		solo.clickOnView(solo.getView(android.R.id.text1, 3));
		// Click on Choose From Stored Constants
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_from_db_radio));
		// Click on bt_escritorio
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on bt_carro
		solo.clickOnView(solo.getView(android.R.id.text1, 2));
		// Click on Confirm
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.confirm_btn));
		// Click on Save Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.save_rule_btn));
		// Click on Create Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.main_btn_create_rules));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity.class));
		// Enter the text: 'AtivarDirigindo_Casa'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox), "AtivarDirigindo_Casa");
		// Click on Choose Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_cur_state_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on Casa
		solo.clickOnView(solo.getView(android.R.id.text1, 4));
		// Click on Choose Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_new_state_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on Dirigindo
		solo.clickOnView(solo.getView(android.R.id.text1, 5));
		// Click on Add Filter
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.add_filter_btn));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity.class));
		// Click on GPS.IsValid
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_type_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on Bluetooth
		solo.clickOnView(solo.getView(android.R.id.text1, 3));
		// Click on Choose From Stored Constants
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_from_db_radio));
		// Click on bt_escritorio
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on bt_carro
		solo.clickOnView(solo.getView(android.R.id.text1, 2));
		// Click on Confirm
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.confirm_btn));
		// Click on Save Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.save_rule_btn));
		// Click on Create Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.main_btn_create_rules));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity.class));
		// Enter the text: 'AtivarDirigindo_Escritorio'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox), "AtivarDirigindo_Escritorio");
		// Click on Choose Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_cur_state_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on Escritorio
		solo.clickOnView(solo.getView(android.R.id.text1, 7));
		// Click on Choose Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_new_state_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on Dirigindo
		solo.clickOnView(solo.getView(android.R.id.text1, 5));
		// Click on Add Filter
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.add_filter_btn));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity.class));
		// Click on GPS.IsValid
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_type_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on Bluetooth
		solo.clickOnView(solo.getView(android.R.id.text1, 3));
		// Click on Choose From Stored Constants
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_from_db_radio));
		// Click on bt_escritorio
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on bt_carro
		solo.clickOnView(solo.getView(android.R.id.text1, 2));
		// Click on Confirm
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.confirm_btn));
		// Click on Save Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.save_rule_btn));
		// Click on Create Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.main_btn_create_rules));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity.class));
		// Click on Empty Text View
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox));
		// Enter the text: 'AtivarDirigindo_NaRua'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox), "AtivarDirigindo_NaRua");
		// Click on Choose Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_cur_state_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on Na rua
		solo.clickOnView(solo.getView(android.R.id.text1, 2));
		// Click on Choose Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_new_state_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on Dirigindo
		solo.clickOnView(solo.getView(android.R.id.text1, 5));
		// Click on Add Filter
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.add_filter_btn));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity.class));
		// Click on GPS.IsValid
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_type_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on Bluetooth
		solo.clickOnView(solo.getView(android.R.id.text1, 3));
		// Click on Choose From Stored Constants
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_from_db_radio));
		// Click on bt_escritorio
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on bt_carro
		solo.clickOnView(solo.getView(android.R.id.text1, 2));
		// Click on Confirm
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.confirm_btn));
		// Click on Save Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.save_rule_btn));
		// Click on Create Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.main_btn_create_rules));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity.class));
		// Enter the text: 'DesativarDirigindo'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox), "DesativarDirigindo");
		// Click on Choose Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_cur_state_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on Dirigindo
		solo.clickOnView(solo.getView(android.R.id.text1, 5));
		// Click on Choose Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_new_state_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on general
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on Add Filter
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.add_filter_btn));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity.class));
		// Click on GPS.IsValid
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_type_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on Bluetooth
		solo.clickOnView(solo.getView(android.R.id.text1, 3));
		// Click on edu.hkust.cse.phoneAdapter.R$id.context_op_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_op_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on !
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on Choose From Stored Constants
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_from_db_radio));
		// Click on bt_escritorio
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on bt_carro
		solo.clickOnView(solo.getView(android.R.id.text1, 2));
		// Click on Confirm
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.confirm_btn));
		// Click on Save Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.save_rule_btn));
		// Click on Create Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.main_btn_create_rules));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity.class));
		// Enter the text: 'AtivarDirigindoRapido'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox), "AtivarDirigindoRapido");
		// Click on Choose Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_cur_state_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on Dirigindo
		solo.clickOnView(solo.getView(android.R.id.text1, 5));
		// Click on Choose Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_new_state_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on DirigindoRapido
		solo.clickOnView(solo.getView(android.R.id.text1, 6));
		// Click on edu.hkust.cse.phoneAdapter.R$id.choose_priority_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_priority_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on android.R$id.text1
		solo.clickOnView(solo.getView(android.R.id.text1));
		// Click on edu.hkust.cse.phoneAdapter.R$id.choose_priority_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_priority_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on android.R$id.text1
		solo.clickOnView(solo.getView(android.R.id.text1));
		// Click on Add Filter
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.add_filter_btn));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity.class));
		// Click on Choose From Stored Constants
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_from_db_radio));
		// Click on Empty Text View
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_edit_text));
		// Enter the text: 'true'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_edit_text));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_edit_text), "true");
		// Click on Confirm
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.confirm_btn));
		// Click on Add Filter
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.add_filter_btn));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity.class));
		// Click on GPS.IsValid
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_type_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on GPS.Speed
		solo.clickOnView(solo.getView(android.R.id.text1, 2));
		// Click on edu.hkust.cse.phoneAdapter.R$id.context_op_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_op_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on android.R$id.text1
		solo.clickOnView(solo.getView(android.R.id.text1, 2));
		// Click on Choose From Stored Constants
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_from_db_radio));
		// Click on Empty Text View
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_edit_text));
		// Enter the text: '70'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_edit_text));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_edit_text), "70");
		// Click on Confirm
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.confirm_btn));
		// Click on Save Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.save_rule_btn));
		// Click on Create Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.main_btn_create_rules));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity.class));
		// Click on Empty Text View
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox));
		// Enter the text: 'DesativarDirigindoRapido_GPSNaoValido'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox), "DesativarDirigindoRapido_GPSNaoValido");
		// Click on Choose Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_cur_state_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on DirigindoRapido
		solo.clickOnView(solo.getView(android.R.id.text1, 6));
		// Click on Choose Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_new_state_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on Dirigindo
		solo.clickOnView(solo.getView(android.R.id.text1, 5));
		// Click on edu.hkust.cse.phoneAdapter.R$id.choose_priority_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_priority_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on android.R$id.text1
		solo.clickOnView(solo.getView(android.R.id.text1));
		// Click on Add Filter
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.add_filter_btn));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity.class));
		// Click on edu.hkust.cse.phoneAdapter.R$id.context_op_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_op_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on !
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on Choose From Stored Constants
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_from_db_radio));
		// Click on Empty Text View
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_edit_text));
		// Enter the text: 'true'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_edit_text));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_edit_text), "true");
		// Click on Confirm
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.confirm_btn));
		// Click on Save Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.save_rule_btn));
		// Click on Create Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.main_btn_create_rules));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity.class));
		// Click on Empty Text View
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox));
		// Enter the text: 'DesativarDirigindoRapido_VelocidadeMenorIgual70'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox), "DesativarDirigindoRapido_VelocidadeMenorIgual70");
		// Click on Choose Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_cur_state_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on DirigindoRapido
		solo.clickOnView(solo.getView(android.R.id.text1, 6));
		// Click on Choose Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_new_state_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on Dirigindo
		solo.clickOnView(solo.getView(android.R.id.text1, 5));
		// Click on edu.hkust.cse.phoneAdapter.R$id.choose_priority_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_priority_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on android.R$id.text1
		solo.clickOnView(solo.getView(android.R.id.text1));
		// Click on Add Filter
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.add_filter_btn));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity.class));
		// Click on GPS.IsValid
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_type_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on GPS.Speed
		solo.clickOnView(solo.getView(android.R.id.text1, 2));
		// Click on edu.hkust.cse.phoneAdapter.R$id.context_op_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_op_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on
		solo.clickOnView(solo.getView(android.R.id.text1, 5));
		// Click on Choose From Stored Constants
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_from_db_radio));
		// Click on Empty Text View
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_edit_text));
		// Enter the text: '70'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_edit_text));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_edit_text), "70");
		// Click on Confirm
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.confirm_btn));
		// Click on Save Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.save_rule_btn));
		// Click on Create Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.main_btn_create_rules));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity.class));
		// Click on Empty Text View
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox));
		// Enter the text: 'AtivarCasa_Bluetooth'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox), "AtivarCasa_Bluetooth");
		// Click on Choose Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_cur_state_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on general
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on Choose Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_new_state_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on Casa
		solo.clickOnView(solo.getView(android.R.id.text1, 4));
		// Click on edu.hkust.cse.phoneAdapter.R$id.choose_priority_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_priority_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on android.R$id.text1
		solo.clickOnView(solo.getView(android.R.id.text1, 4));
		// Click on Add Filter
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.add_filter_btn));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity.class));
		// Click on GPS.IsValid
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_type_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on Bluetooth
		solo.clickOnView(solo.getView(android.R.id.text1, 3));
		// Click on Choose From Stored Constants
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_from_db_radio));
		// Click on bt_escritorio
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on bt_casa
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on Confirm
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.confirm_btn));
		// Click on Save Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.save_rule_btn));
		// Click on Create Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.main_btn_create_rules));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity.class));
		// Enter the text: 'AtivarCasa_GPS'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox), "AtivarCasa_GPS");
		// Click on Choose Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_cur_state_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on general
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on Choose Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_new_state_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on Casa
		solo.clickOnView(solo.getView(android.R.id.text1, 4));
		// Click on edu.hkust.cse.phoneAdapter.R$id.choose_priority_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_priority_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on android.R$id.text1
		solo.clickOnView(solo.getView(android.R.id.text1, 4));
		// Assert that: 'View' is shown
		assertTrue("'View' is not shown!", solo.waitForView(solo.getView(android.view.View.class, 22)));
		// Click on Add Filter
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.add_filter_btn));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity.class));
		// Click on Choose From Stored Constants
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_from_db_radio));
		// Click on Empty Text View
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_edit_text));
		// Enter the text: 'true'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_edit_text));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_edit_text), "true");
		// Click on Confirm
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.confirm_btn));
		// Click on Add Filter
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.add_filter_btn));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity.class));
		// Click on GPS.IsValid
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_type_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on GPS.Location
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on edu.hkust.cse.phoneAdapter.R$id.context_op_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_op_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on android.R$id.text1
		solo.clickOnView(solo.getView(android.R.id.text1));
		// Click on Choose From Stored Constants
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_from_db_radio));
		// Click on Escritorio
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on Casa
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Press menu back key
		solo.goBack();
		// Click on Add Filter
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.add_filter_btn));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity.class));
		// Click on GPS.IsValid
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_type_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on GPS.Location
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on Choose From Stored Constants
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_from_db_radio));
		// Click on Escritorio
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on Casa
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on Confirm
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.confirm_btn));
		// Click on Save Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.save_rule_btn));
		// Click on Create Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.main_btn_create_rules));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity.class));
		// Enter the text: 'DesativarCasa_Bluetooth'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox), "DesativarCasa_Bluetooth");
		// Click on Choose Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_cur_state_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on Casa
		solo.clickOnView(solo.getView(android.R.id.text1, 4));
		// Click on Choose Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_new_state_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on general
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on edu.hkust.cse.phoneAdapter.R$id.choose_priority_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_priority_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on android.R$id.text1
		solo.clickOnView(solo.getView(android.R.id.text1, 4));
		// Click on Add Filter
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.add_filter_btn));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity.class));
		// Click on GPS.IsValid
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_type_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on Bluetooth
		solo.clickOnView(solo.getView(android.R.id.text1, 3));
		// Click on edu.hkust.cse.phoneAdapter.R$id.context_op_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_op_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on !
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on Choose From Stored Constants
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_from_db_radio));
		// Click on bt_escritorio
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on bt_casa
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on Confirm
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.confirm_btn));
		// Click on Save Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.save_rule_btn));
		// Click on Create Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.main_btn_create_rules));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity.class));
		// Enter the text: 'DesativarCasa_GPS'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox), "DesativarCasa_GPS");
		// Click on Choose Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_cur_state_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on Casa
		solo.clickOnView(solo.getView(android.R.id.text1, 4));
		// Click on Choose Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_new_state_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on general
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Assert that: 'View' is shown
		assertTrue("'View' is not shown!", solo.waitForView(solo.getView(android.view.View.class, 18)));
		// Click on edu.hkust.cse.phoneAdapter.R$id.choose_priority_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_priority_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on android.R$id.text1
		solo.clickOnView(solo.getView(android.R.id.text1, 4));
		// Click on Add Filter
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.add_filter_btn));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity.class));
		// Click on Choose From Stored Constants
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_from_db_radio));
		// Enter the text: 'true'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_edit_text));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_edit_text), "true");
		// Click on Confirm
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.confirm_btn));
		// Click on Add Filter
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.add_filter_btn));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity.class));
		// Click on GPS.IsValid
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_type_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on GPS.Location
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on Choose From Stored Constants
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_from_db_radio));
		// Click on Escritorio
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on Casa
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on Confirm
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.confirm_btn));
		// Click on GPS.Location -20.999935,-48.210638
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.filter_value, 1));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.EditFilterActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.EditFilterActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.EditFilterActivity.class));
		// Click on edu.hkust.cse.phoneAdapter.R$id.context_op_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_op_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on !
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on Confirm
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.confirm_btn));
		// Click on Add Filter
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.add_filter_btn));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity.class));
		// Click on GPS.IsValid
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_type_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on GPS.Location
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on edu.hkust.cse.phoneAdapter.R$id.context_op_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_op_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on !
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on Choose From Stored Constants
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_from_db_radio));
		// Click on Escritorio
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on Casa
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on Confirm
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.confirm_btn));
		// Click on Save Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.save_rule_btn));
		// Click on Create Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.main_btn_create_rules));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity.class));
		// Enter the text: 'AtivarEscritorio_Bluetooh'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox), "AtivarEscritorio_Bluetooh");
		// Click on Choose Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_cur_state_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on general
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on Choose Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_new_state_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on Escritorio
		solo.clickOnView(solo.getView(android.R.id.text1, 7));
		// Click on edu.hkust.cse.phoneAdapter.R$id.choose_priority_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_priority_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on android.R$id.text1
		solo.clickOnView(solo.getView(android.R.id.text1, 4));
		// Click on Add Filter
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.add_filter_btn));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity.class));
		// Click on GPS.IsValid
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_type_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on Bluetooth
		solo.clickOnView(solo.getView(android.R.id.text1, 3));
		// Click on Choose From Stored Constants
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_from_db_radio));
		// Click on bt_escritorio
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on bt_casa
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on bt_casa
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on bt_escritorio
		solo.clickOnView(solo.getView(android.R.id.text1));
		// Click on Confirm
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.confirm_btn));
		// Click on Save Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.save_rule_btn));
		// Click on Create Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.main_btn_create_rules));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity.class));
		// Enter the text: 'AtivarEscritorio_GPS'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox), "AtivarEscritorio_GPS");
		// Click on Choose Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_cur_state_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on general
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on Choose Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_new_state_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on Escritorio
		solo.clickOnView(solo.getView(android.R.id.text1, 7));
		// Click on edu.hkust.cse.phoneAdapter.R$id.choose_priority_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_priority_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on android.R$id.text1
		solo.clickOnView(solo.getView(android.R.id.text1, 4));
		// Click on Add Filter
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.add_filter_btn));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity.class));
		// Click on Choose From Stored Constants
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_from_db_radio));
		// Enter the text: 'true'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_edit_text));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_edit_text), "true");
		// Click on Confirm
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.confirm_btn));
		// Click on Add Filter
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.add_filter_btn));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity.class));
		// Click on GPS.IsValid
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_type_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on GPS.Location
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on Choose From Stored Constants
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_from_db_radio));
		// Click on Escritorio
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on Casa
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on Casa
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on Escritorio
		solo.clickOnView(solo.getView(android.R.id.text1));
		// Click on Confirm
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.confirm_btn));
		// Click on Save Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.save_rule_btn));
		// Click on Create Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.main_btn_create_rules));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity.class));
		// Press menu back key
		solo.goBack();
		// Click on View Rules
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.main_btn_view_rules));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.ViewRuleActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.ViewRuleActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.ViewRuleActivity.class));
		// Press menu back key
		solo.goBack();
		// Click on Create Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.main_btn_create_rules));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity.class));
		// Enter the text: 'DesativarEscritorio_Bluetooth'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox), "DesativarEscritorio_Bluetooth");
		// Click on Choose Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_cur_state_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on Escritorio
		solo.clickOnView(solo.getView(android.R.id.text1, 7));
		// Click on Choose Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_new_state_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on general
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on edu.hkust.cse.phoneAdapter.R$id.choose_priority_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_priority_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on android.R$id.text1
		solo.clickOnView(solo.getView(android.R.id.text1, 4));
		// Click on Add Filter
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.add_filter_btn));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity.class));
		// Click on GPS.IsValid
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_type_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on Bluetooth
		solo.clickOnView(solo.getView(android.R.id.text1, 3));
		// Click on edu.hkust.cse.phoneAdapter.R$id.context_op_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_op_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on !
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Take screenshot
		solo.takeScreenshot();
		// Click on Choose From Stored Constants
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_from_db_radio));
		// Click on bt_escritorio
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on bt_casa
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on bt_casa
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_spinner));
		// Take screenshot
		solo.takeScreenshot();
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on bt_escritorio
		solo.clickOnView(solo.getView(android.R.id.text1));
		// Click on Confirm
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.confirm_btn));
		// Click on Save Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.save_rule_btn));


		//inserted 07/02 - #2
		// Click on Create Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.main_btn_create_rules));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity.class));
		// Click on Empty Text View
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox));
		// Enter the text: 'DesativarEscritorio_GPS'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox), "DesativarEscritorio_GPS");
		// Click on Choose Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_cur_state_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on Escritorio
		solo.clickOnView(solo.getView(android.R.id.text1, 7));
		// Click on Choose Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_new_state_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on general
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on edu.hkust.cse.phoneAdapter.R$id.choose_priority_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_priority_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on android.R$id.text1
		solo.clickOnView(solo.getView(android.R.id.text1, 4));
		// Click on Add Filter
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.add_filter_btn));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity.class));
		// Click on GPS.IsValid
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_type_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on GPS.IsValid
		solo.clickOnView(solo.getView(android.R.id.text1));
		// Click on Choose From Stored Constants
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_from_db_radio));
		// Click on Empty Text View
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_edit_text));
		// Enter the text: 'true'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_edit_text));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_edit_text), "true");
		// Click on Confirm
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.confirm_btn));
		// Click on Add Filter
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.add_filter_btn));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity.class));
		// Click on GPS.IsValid
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_type_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on GPS.Location
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on edu.hkust.cse.phoneAdapter.R$id.context_op_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_op_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on !
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on Choose From Stored Constants
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_from_db_radio));
		// Click on Escritorio
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on Casa
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on Casa
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on Escritorio
		solo.clickOnView(solo.getView(android.R.id.text1));
		// Click on Confirm
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.confirm_btn));
		// Click on Save Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.save_rule_btn));
		// Click on Create Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.main_btn_create_rules));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity.class));
		// Enter the text: 'AtivarReuniao'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox), "AtivarReuniao");
		// Click on Choose Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_cur_state_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on Escritorio
		solo.clickOnView(solo.getView(android.R.id.text1, 7));
		// Click on Choose Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_new_state_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on Reuniao
		solo.clickOnView(solo.getView(android.R.id.text1, 8));
		// Click on edu.hkust.cse.phoneAdapter.R$id.choose_priority_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_priority_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on android.R$id.text1
		solo.clickOnView(solo.getView(android.R.id.text1, 3));
		// Click on Add Filter
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.add_filter_btn));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity.class));
		// Click on GPS.IsValid
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_type_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on Time
		solo.clickOnView(solo.getView(android.R.id.text1, 5));
		// Click on edu.hkust.cse.phoneAdapter.R$id.context_op_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_op_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on
		solo.clickOnView(solo.getView(android.R.id.text1, 3));
		// Click on Choose From Stored Constants
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_from_db_radio));
		// Enter the text: '14::00:00'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_edit_text));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_edit_text), "14::00:00");
		// Click on 14::00:00
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_edit_text));
		// Enter the text: '14:00:00'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_edit_text));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_edit_text), "14:00:00");
		// Click on 14:00:00
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_edit_text));
		// Click on Confirm
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.confirm_btn));
		// Click on Add Filter
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.add_filter_btn));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity.class));
		// Click on GPS.IsValid
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_type_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on Bluetooth.Count
		solo.clickOnView(solo.getView(android.R.id.text1, 4));
		// Click on edu.hkust.cse.phoneAdapter.R$id.context_op_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_op_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on
		solo.clickOnView(solo.getView(android.R.id.text1, 3));
		// Click on Choose From Stored Constants
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_from_db_radio));
		// Enter the text: '3'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_edit_text));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_edit_text), "3");
		// Click on Confirm
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.confirm_btn));
		// Click on Save Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.save_rule_btn));
		// Click on Create Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.main_btn_create_rules));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity.class));
		// Enter the text: 'DesativarReuniao'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox), "DesativarReuniao");
		// Click on Choose Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_cur_state_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on Reuniao
		solo.clickOnView(solo.getView(android.R.id.text1, 8));
		// Click on Choose Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_new_state_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on Escritorio
		solo.clickOnView(solo.getView(android.R.id.text1, 7));
		// Click on edu.hkust.cse.phoneAdapter.R$id.choose_priority_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_priority_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on android.R$id.text1
		solo.clickOnView(solo.getView(android.R.id.text1, 3));
		// Click on Add Filter
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.add_filter_btn));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity.class));
		// Click on GPS.IsValid
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_type_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on Time
		solo.clickOnView(solo.getView(android.R.id.text1, 5));
		// Click on edu.hkust.cse.phoneAdapter.R$id.context_op_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_op_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on
		solo.clickOnView(solo.getView(android.R.id.text1, 3));
		// Click on Choose From Stored Constants
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_from_db_radio));
		// Enter the text: '16:00:00'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_edit_text));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_edit_text), "16:00:00");
		// Click on Confirm
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.confirm_btn));
		// Click on Save Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.save_rule_btn));
		// Click on Create Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.main_btn_create_rules));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity.class));
		// Enter the text: 'AtivarSincroni'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox), "AtivarSincroni");
		// Click on AtivarSincroni
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox));
		// Enter the text: 'AtivarSincronizacao_BTCasa'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox), "AtivarSincronizacao_BTCasa");
		// Click on Choose Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_cur_state_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on general
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on Choose Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_new_state_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on Sincronizacao
		solo.clickOnView(solo.getView(android.R.id.text1, 9));
		// Click on edu.hkust.cse.phoneAdapter.R$id.choose_priority_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_priority_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on android.R$id.text1
		solo.clickOnView(solo.getView(android.R.id.text1, 8));
		// Click on Add Filter
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.add_filter_btn));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity.class));
		// Click on GPS.IsValid
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_type_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on Bluetooth
		solo.clickOnView(solo.getView(android.R.id.text1, 3));
		// Click on Choose From Stored Constants
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_from_db_radio));
		// Click on bt_escritorio
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on bt_casa
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on Confirm
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.confirm_btn));
		// Click on Save Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.save_rule_btn));
		// Click on Create Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.main_btn_create_rules));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity.class));
		// Enter the text: 'AtivarSincronizacao_BT_Escritorio'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox), "AtivarSincronizacao_BT_Escritorio");
		// Click on Choose Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_cur_state_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on general
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on Choose Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_new_state_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on Escritorio
		solo.clickOnView(solo.getView(android.R.id.text1, 7));
		// Click on edu.hkust.cse.phoneAdapter.R$id.choose_priority_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_priority_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on android.R$id.text1
		solo.clickOnView(solo.getView(android.R.id.text1, 8));
		// Click on Add Filter
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.add_filter_btn));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity.class));
		// Click on GPS.IsValid
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_type_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on Bluetooth
		solo.clickOnView(solo.getView(android.R.id.text1, 3));
		// Click on Choose From Stored Constants
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_from_db_radio));
		// Click on bt_escritorio
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on bt_casa
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on bt_casa
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on bt_escritorio
		solo.clickOnView(solo.getView(android.R.id.text1));
		// Click on Confirm
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.confirm_btn));
		// Click on Save Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.save_rule_btn));
		// Click on Create Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.main_btn_create_rules));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateRuleActivity.class));
		// Click on Empty Text View
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox));
		// Enter the text: 'DesativarSincronizacao'
		solo.clearEditText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox));
		solo.enterText((android.widget.EditText) solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_name_textbox), "DesativarSincronizacao");
		// Click on Choose Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_cur_state_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on Sincronizacao
		solo.clickOnView(solo.getView(android.R.id.text1, 9));
		// Click on Choose Profile
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_new_state_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on general
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on edu.hkust.cse.phoneAdapter.R$id.choose_priority_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_priority_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on android.R$id.text1
		solo.clickOnView(solo.getView(android.R.id.text1, 8));
		// Click on Add Filter
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.add_filter_btn));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity.class));
		// Click on GPS.IsValid
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_type_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on Bluetooth
		solo.clickOnView(solo.getView(android.R.id.text1, 3));
		// Click on edu.hkust.cse.phoneAdapter.R$id.context_op_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_op_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on !
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on Choose From Stored Constants
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_from_db_radio));
		// Click on bt_escritorio
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on bt_casa
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on Confirm
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.confirm_btn));
		// Click on Add Filter
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.add_filter_btn));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.CreateFilterActivity.class));
		// Click on GPS.IsValid
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_type_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on Bluetooth
		solo.clickOnView(solo.getView(android.R.id.text1, 3));
		// Click on edu.hkust.cse.phoneAdapter.R$id.context_op_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_op_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on !
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on Choose From Stored Constants
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_from_db_radio));
		// Click on bt_escritorio
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on bt_casa
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on bt_casa
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.context_value_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on bt_escritorio
		solo.clickOnView(solo.getView(android.R.id.text1));
		// Click on Confirm
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.confirm_btn));
		// Click on Save Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.save_rule_btn));
		// Click on View Rules
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.main_btn_view_rules));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.ViewRuleActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.ViewRuleActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.ViewRuleActivity.class));
		// Click on AtivarDirigindo_Geral
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_item_text_view, 7));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.EditRuleActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.EditRuleActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.EditRuleActivity.class));
		// Click on edu.hkust.cse.phoneAdapter.R$id.choose_priority_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_priority_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on android.R$id.text1
		solo.clickOnView(solo.getView(android.R.id.text1, 5));
		// Click on edu.hkust.cse.phoneAdapter.R$id.choose_priority_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_priority_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on android.R$id.text1
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on Save Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.save_rule_btn));
		// Click on AtivarDirigindo_Casa
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_item_text_view, 8));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.EditRuleActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.EditRuleActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.EditRuleActivity.class));
		// Click on edu.hkust.cse.phoneAdapter.R$id.choose_priority_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_priority_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on android.R$id.text1
		solo.clickOnView(solo.getView(android.R.id.text1, 5));
		// Click on edu.hkust.cse.phoneAdapter.R$id.choose_priority_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_priority_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on android.R$id.text1
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on Save Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.save_rule_btn));
		// Click on AtivarDirigindo_Escritorio
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_item_text_view, 9));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.EditRuleActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.EditRuleActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.EditRuleActivity.class));
		// Click on edu.hkust.cse.phoneAdapter.R$id.choose_priority_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_priority_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on android.R$id.text1
		solo.clickOnView(solo.getView(android.R.id.text1, 6));
		// Click on edu.hkust.cse.phoneAdapter.R$id.choose_priority_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_priority_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on android.R$id.text1
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on Save Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.save_rule_btn));
		// Click on AtivarDirigindo_NaRua
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_item_text_view, 10));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.EditRuleActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.EditRuleActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.EditRuleActivity.class));
		// Click on edu.hkust.cse.phoneAdapter.R$id.choose_priority_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_priority_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on android.R$id.text1
		solo.clickOnView(solo.getView(android.R.id.text1, 6));
		// Click on edu.hkust.cse.phoneAdapter.R$id.choose_priority_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_priority_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on android.R$id.text1
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on Save Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.save_rule_btn));
		// Click on DesativarDirigindo
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_item_text_view, 11));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.EditRuleActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.EditRuleActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.EditRuleActivity.class));
		// Click on edu.hkust.cse.phoneAdapter.R$id.choose_priority_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_priority_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on android.R$id.text1
		solo.clickOnView(solo.getView(android.R.id.text1, 7));
		// Click on edu.hkust.cse.phoneAdapter.R$id.choose_priority_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_priority_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on android.R$id.text1
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
		// Click on Save Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.save_rule_btn));
		// Click on AtivarDirigindoRapido
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_item_text_view, 12));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.EditRuleActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.EditRuleActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.EditRuleActivity.class));
		// Click on edu.hkust.cse.phoneAdapter.R$id.choose_priority_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_priority_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on android.R$id.text1
		solo.clickOnView(solo.getView(android.R.id.text1, 6));
		// Click on edu.hkust.cse.phoneAdapter.R$id.choose_priority_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_priority_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on android.R$id.text1
		solo.clickOnView(solo.getView(android.R.id.text1));
		// Click on Save Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.save_rule_btn));
		// Click on DesativarDirigindoRapido_GPSNaoValido
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_item_text_view, 13));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.EditRuleActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.EditRuleActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.EditRuleActivity.class));
		// Click on edu.hkust.cse.phoneAdapter.R$id.choose_priority_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_priority_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on android.R$id.text1
		solo.clickOnView(solo.getView(android.R.id.text1, 6));
		// Click on edu.hkust.cse.phoneAdapter.R$id.choose_priority_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_priority_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on android.R$id.text1
		solo.clickOnView(solo.getView(android.R.id.text1));
		// Click on Save Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.save_rule_btn));
		// Click on DesativarDirigindoRapido_VelocidadeMenorIgual70
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.rule_item_text_view, 14));
		// Wait for activity: 'edu.hkust.cse.phoneAdapter.activity.EditRuleActivity'
		assertTrue("edu.hkust.cse.phoneAdapter.activity.EditRuleActivity is not found!", solo.waitForActivity(edu.hkust.cse.phoneAdapter.activity.EditRuleActivity.class));
		// Click on edu.hkust.cse.phoneAdapter.R$id.choose_priority_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_priority_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on android.R$id.text1
		solo.clickOnView(solo.getView(android.R.id.text1, 6));
		// Click on edu.hkust.cse.phoneAdapter.R$id.choose_priority_spinner
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.choose_priority_spinner));
		// Wait for spinner to open
		solo.waitForDialogToOpen(5000);
		// Click on android.R$id.text1
		solo.clickOnView(solo.getView(android.R.id.text1));
		// Click on Save Rule
		solo.clickOnView(solo.getView(edu.hkust.cse.phoneAdapter.R.id.save_rule_btn));
		// Press menu back key
		solo.goBack();


	}
}
