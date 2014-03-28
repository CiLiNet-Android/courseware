package com.cilinet.sharedpreference.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.cilinet.sharedpreference.R;

/** 主界面 **/
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		super.setContentView(R.layout.activity_main);
		
		//设置SharedPreference
		Button btn_setSharedPreference = (Button)findViewById(R.id.btn_setSharedPreference);
		btn_setSharedPreference.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				Intent _intent = new Intent(MainActivity.this,SetSharedPreferencesActivity.class);
				startActivity(_intent);
			}
		});
		
		//获取SharedPreference
		Button btn_getSharedPreference = (Button)findViewById(R.id.btn_getSharedPreference);
		btn_getSharedPreference.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent _intent = new Intent(MainActivity.this,GetSharedPreferencesActivity.class);
				startActivity(_intent);
			}
		});
	}

}
