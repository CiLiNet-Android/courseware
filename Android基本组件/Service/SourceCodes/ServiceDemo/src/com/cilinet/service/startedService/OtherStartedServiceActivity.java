package com.cilinet.service.startedService;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cilinet.service.R;

public class OtherStartedServiceActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_otherstartedservice);
		
		Button btn_otherStart_startedService = (Button)super.findViewById(R.id.btn_otherStart_startedService);
		btn_otherStart_startedService.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent _intent = new Intent(OtherStartedServiceActivity.this,StartedService.class);
				OtherStartedServiceActivity.this.startService(_intent);
			}
		});
		
		Button btn_otherFinish_startedService = (Button)super.findViewById(R.id.btn_otherFinish_startedService);
		btn_otherFinish_startedService.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent _intent = new Intent(OtherStartedServiceActivity.this,StartedService.class);
				OtherStartedServiceActivity.this.stopService(_intent);
			}
		});
		
		Button btn_finish_otherStartedServiceActivity = (Button)super.findViewById(R.id.btn_finish_otherStartedServiceActivity);
		btn_finish_otherStartedServiceActivity.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				OtherStartedServiceActivity.this.finish();
			}
		});
	}

	
}
