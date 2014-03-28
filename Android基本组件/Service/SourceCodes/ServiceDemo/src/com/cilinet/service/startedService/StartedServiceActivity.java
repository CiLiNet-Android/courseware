package com.cilinet.service.startedService;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cilinet.service.R;

public class StartedServiceActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_startedservice);
		
		Button btn_start_startedService = (Button)super.findViewById(R.id.btn_start_startedService);
		btn_start_startedService.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent _intent = new Intent(StartedServiceActivity.this,StartedService.class);
				StartedServiceActivity.this.startService(_intent);
			}
		});
		
		Button btn_finish_startedService = (Button)super.findViewById(R.id.btn_finish_startedService);
		btn_finish_startedService.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				//创建新的意图，用来表示要关闭的服务
				Intent _intent = new Intent(StartedServiceActivity.this,StartedService.class);
				//当服务已经被关闭时，不会再调用Service的onDestroy()方法
				StartedServiceActivity.this.stopService(_intent);
			}
		});
		
		Button btn_start_otherStartedServiceActivity = (Button)super.findViewById(R.id.btn_start_otherStartedServiceActivity);
		btn_start_otherStartedServiceActivity.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent _intent = new Intent(StartedServiceActivity.this,OtherStartedServiceActivity.class);
				StartedServiceActivity.this.startActivity(_intent);
			}
		});
	}

}
