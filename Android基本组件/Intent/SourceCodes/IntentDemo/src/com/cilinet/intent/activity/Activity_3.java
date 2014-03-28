package com.cilinet.intent.activity;

import com.cilinet.intent.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
	}

}
