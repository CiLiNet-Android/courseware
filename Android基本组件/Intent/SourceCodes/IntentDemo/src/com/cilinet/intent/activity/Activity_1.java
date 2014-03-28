package com.cilinet.intent.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cilinet.intent.R;

public class Activity_1 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_1);
		
		Button btn_start_activity_2_by_explicit = (Button)super.findViewById(R.id.btn_start_activity_2_by_explicit);
		btn_start_activity_2_by_explicit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				//通过显式意图的方式启动Activity_2
				Intent intent = new Intent(Activity_1.this,Activity_2.class);
				Activity_1.this.startActivity(intent);
			}
		});
		
		Button btn_start_activity_2_by_implicit = (Button)super.findViewById(R.id.btn_start_activity_2_by_implicit);
		btn_start_activity_2_by_implicit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//如果在功能清单文件中要注册自己的Category，那么必须要先注册默认的Category
				//通过隐式意图的方式启动Activity_2,指定的多个条件都是同时要满足的
				//在功能清单文件中，只要注册的条件范围大于或者等于程序中指定的条件范围，那么该组件就会被启动
				//当程序中指定的条件被多个组件满足时，系统会提示用户选择一个组件来启动
				
				Intent intent = new Intent();
				intent.setAction("dfdf");
				intent.addCategory("com.cilinet.mycategory");
				intent.addCategory("com.cilinet.a");
				
				Activity_1.this.startActivity(intent);
			}
		});
		
		Button btn_start_contactActivity = (Button)super.findViewById(R.id.btn_start_contactActivity);
		btn_start_contactActivity.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setAction(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("content://contacts/people/"));
				
				Activity_1.this.startActivity(intent);
			}
		});
	}

}
