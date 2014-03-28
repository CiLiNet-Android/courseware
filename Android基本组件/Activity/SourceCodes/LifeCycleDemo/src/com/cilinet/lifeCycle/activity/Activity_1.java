package com.cilinet.lifeCycle.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cilinet.lifeCycle.R;

/** Demo: 验证Activity处于某种状态时所调用的生命周期方法**/
public class Activity_1 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_1);
		
		System.out.println("Activity_1 ==> onCreate()");
		
		Button btn_startActivity_2 = (Button)super.findViewById(R.id.btn_startActivity_2);
		btn_startActivity_2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Activity_1.this,Activity_2.class);
				Activity_1.this.startActivity(intent);
			}
		});
	}

	@Override
	protected void onStart() {
		super.onStart();
		
		System.out.println("Activity_1 ==> onStart()");
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		
		System.out.println("Activity_1 ==> onResume()");
	}

	@Override
	protected void onPause() {
		super.onPause();
		
		System.out.println("Activity_1 ==> onPause()");
	}


	@Override
	protected void onStop() {
		super.onStop();
		
		System.out.println("Activity_1 ==> onStop()");
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		
		System.out.println("Activity_1 ==> onDestroy()");
	}
	
	@Override
	protected void onRestart() {
		super.onRestart();
		
		System.out.println("Activity_1 ==> onRestart()");
	}
	
}
