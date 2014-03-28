package com.cilinet.taskStack.launchMode.standard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.cilinet.taskStack.launchMode.R;

public class Activity_1 extends Activity {
	
	private static final String TAG = "Activity_1";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.launchmode_standard_activity_1);
		
		Log.i(TAG, String.valueOf(super.getTaskId()));
		
		Button btn_startActivity_2 = (Button)super.findViewById(R.id.btn_startActivity_2);
		btn_startActivity_2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(Activity_1.this,Activity_2.class);
				Activity_1.this.startActivity(intent);
			}
		});
	}

}
