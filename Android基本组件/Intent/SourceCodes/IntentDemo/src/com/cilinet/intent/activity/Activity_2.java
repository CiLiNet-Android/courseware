package com.cilinet.intent.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cilinet.intent.R;

public class Activity_2 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_2);
		
		Button btn_finish_activity_2 = (Button)super.findViewById(R.id.btn_finish_activity_2);
		btn_finish_activity_2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Activity_2.this.finish();
			}
		});
	}

}
