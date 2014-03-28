package com.cilinet.lifeCycle.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cilinet.lifeCycle.R;

public class Activity_2 extends Activity {
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_2);
		
		System.out.println("Activity_2 ==> onCreate()");
		
		Button btn_startActivity_3 = (Button)super.findViewById(R.id.btn_startActivity_3);
		btn_startActivity_3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Activity_2.this,Activity_3.class);
				Activity_2.this.startActivity(intent);
			}
		});
		
		Button btn_finish_Activity_2 = (Button)super.findViewById(R.id.btn_finish_Activity_2);
		btn_finish_Activity_2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Activity_2.this.finish();
			}
		});
	}

	@Override
	protected void onStart() {
		super.onStart();
		
		System.out.println("Activity_2 ==> onStart()");
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		
		System.out.println("Activity_2 ==> onResume()");
	}

	@Override
	protected void onPause() {
		super.onPause();
		
		System.out.println("Activity_2 ==> onPause()");
	}


	@Override
	protected void onStop() {
		super.onStop();
		
		System.out.println("Activity_2 ==> onStop()");
	}
	
	@Override
	protected void onRestart() {
		super.onRestart();
		
		System.out.println("Activity_2 ==> onRestart()");
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		
		System.out.println("Activity_2 ==> onDestroy()");
	}

}
