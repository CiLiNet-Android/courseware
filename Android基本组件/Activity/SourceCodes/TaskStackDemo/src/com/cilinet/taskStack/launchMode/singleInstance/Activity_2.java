package com.cilinet.taskStack.launchMode.singleInstance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.cilinet.taskStack.launchMode.R;

public class Activity_2 extends Activity {
	
	private static final String TAG = "Activity_2";
	
	private static int activity_2Count;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.launchmode_singleinstance_activity_2);
		
		Log.i(TAG, "StackTaskId: " + String.valueOf(super.getTaskId()));
		
		activity_2Count ++;
		Log.i(TAG, "activity_2Count: " + activity_2Count);
		
		Button btn_launchMode_singleInstance_start_activity_1 = (Button)super.findViewById(R.id.btn_launchMode_singleInstance_start_activity_1);
		btn_launchMode_singleInstance_start_activity_1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(Activity_2.this,Activity_1.class);
				Activity_2.this.startActivity(intent);
			}
		});
	}

}
