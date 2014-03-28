package com.cilinet.lifeCycle.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cilinet.lifeCycle.R;

public class Activity_3 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_3);
		
		Button btn_finish_activity_3 = (Button)super.findViewById(R.id.btn_finish_activity_3);
		btn_finish_activity_3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Activity_3.this.finish();
			}
		});
		
		System.out.println("Activity_3 ==> onCreate()");
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		
		System.out.println("Activity_3 ==> onStart()");
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		
		System.out.println("Activity_3 ==> onResume()");
	}

	@Override
	protected void onPause() {
		super.onPause();
		
		System.out.println("Activity_3 ==> onPause()");
	}


	@Override
	protected void onStop() {
		super.onStop();
		
		System.out.println("Activity_3 ==> onStop()");
	}
	
	@Override
	protected void onRestart() {
		super.onRestart();
		
		System.out.println("Activity_3 ==> onRestart()");
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		
		System.out.println("Activity_3 ==> onDestroy()");
	}

	
}
