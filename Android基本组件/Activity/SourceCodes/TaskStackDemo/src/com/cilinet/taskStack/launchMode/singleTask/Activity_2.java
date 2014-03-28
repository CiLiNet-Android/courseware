package com.cilinet.taskStack.launchMode.singleTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.cilinet.taskStack.launchMode.R;

public class Activity_2 extends Activity {
	
	private static final String TAG = "Activity_2";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.launchmode_singletask_activity_2);
		
		Log.i(TAG, String.valueOf(super.getTaskId()));
		
		Button btn_launchMode_singleTask_start_activity_1 = (Button)super.findViewById(R.id.btn_launchMode_singleTask_start_activity_1);
		btn_launchMode_singleTask_start_activity_1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(Activity_2.this,Activity_1.class);
				Activity_2.this.startActivity(intent);
			}
		});
	}

}
