package com.cilinet.settings;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/** 保存值得时候，是以默认方式（方式三）来创建XML文件 **/
public class SettingsPreferenceActivity extends PreferenceActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		/** 配置方式一：显示自己定制的配置功能界面 **/
		super.addPreferencesFromResource(R.xml.settings);
		
		/** 配置方式二：通过Intent调用已有的配置功能界面 **/
//		Intent _intent = new Intent();
//		_intent.setAction(action);
//		_intent.addCategory(category);
//		super.addPreferencesFromIntent();
		
		//可以通过此方法，通过Key获得XML文件中的组件
//		Preference _preference = (Preference)super.findPreference("lstPref");
//		ListPreference _listPreference = (ListPreference)_preference;
//		_preference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
//			@Override
//			public boolean onPreferenceChange(Preference arg0, Object arg1) {
//				// TODO Auto-generated method stub
//				return false;
//			}
//		});
	}

}
