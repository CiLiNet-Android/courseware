package com.cilinet.sharedpreference.activity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.cilinet.sharedpreference.R;

/** 设置 SharedPreferencesActivity 
 * 
 * 三种创建SharedPreferences的方式：生成的XML文件名不同
 * 
 * MODE只在创建的时候有效
 * **/
public class SetSharedPreferencesActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		super.setContentView(R.layout.activity_setsharedpreferences);

		//提交按钮
		Button btn_submit = (Button)findViewById(R.id.btn_submit);
		btn_submit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				CheckBox chkBox_isSaved = (CheckBox)findViewById(R.id.chkBox_isSaved);
				if(chkBox_isSaved.isChecked()){//如果选中，则存入SharedPreference
					EditText edTxt_userName = (EditText)findViewById(R.id.edTxt_userName);
					String _userName = edTxt_userName.getText().toString();
					
					/**** Set SharedPreferences 方式一 :自定义XML文件名 ****/
					SharedPreferences _sharedPreferences = SetSharedPreferencesActivity.this.getSharedPreferences("com.cilinet.sharedPreference", MODE_PRIVATE);
					
					/**** Set SharedPreferences 方式二:以Activity名称命名的XML文件 *****/
					//SharedPreferences _sharedPreferences = SetSharedPreferencesActivity.this.getPreferences(MODE_PRIVATE);
					
					/**** Set SharedPreferences 方式三:默认文件名:上下文包名 *****/
					//SharedPreferences _sharedPreferences = PreferenceManager.getDefaultSharedPreferences(SetSharedPreferencesActivity.this);
					
					//设置值得方式都一样
					Editor _editor = _sharedPreferences.edit();
					_editor.putString("userName", _userName);
					_editor.commit();//提交修改（文件的修改）
					
				}
				
				SetSharedPreferencesActivity.this.finish();
			}

		});
		
	}

}
