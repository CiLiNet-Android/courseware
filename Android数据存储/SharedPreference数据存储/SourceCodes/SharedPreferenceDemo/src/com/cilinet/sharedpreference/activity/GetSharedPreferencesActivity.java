package com.cilinet.sharedpreference.activity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Window;
import android.widget.TextView;

import com.cilinet.sharedpreference.R;

/** 获取 SharedPreferenceActivity **/
public class GetSharedPreferencesActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		super.setContentView(R.layout.activity_getsharedpreferences);
		/**** Get SharedPreferences 方式一 :自定义XML文件名 ****/
		SharedPreferences _sharedPreferences = this.getSharedPreferences("com.cilinet.sharedPreference", MODE_WORLD_READABLE);
		
		/**** Get SharedPreferences 方式二:以Activity名称命名的XML文件 *****/
		//SharedPreferences _sharedPreferences = this.getPreferences(MODE_PRIVATE);
		
		/**** Get SharedPreferences 方式三:默认文件名:上下文包名 *****/
		//SharedPreferences _sharedPreferences = PreferenceManager.getDefaultSharedPreferences(GetSharedPreferencesActivity.this);
		
		String _userName = _sharedPreferences.getString("userName", "还未赋值");
		
		TextView txtV_userName = (TextView)findViewById(R.id.txtV_userName);
		txtV_userName.setText(_userName);
		
	}

}
