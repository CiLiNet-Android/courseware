package com.cilinet.service.boundService;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.cilinet.service.R;

public class BoundServiceActivity extends Activity {
	
	private MyServiceConnection mMyServiceConnection;
	
	private BoundService.MyBinder mMyBinder;
	
	private class MyServiceConnection implements ServiceConnection{
		private static final String TAG = "MyServiceConnection";

		/** 当代理跟BoundService建立连接之后，就会调用 **/
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			Log.i(TAG, "onServiceConnected()...");
			
			mMyBinder = (BoundService.MyBinder)service;
			
		}

		/** 当代理跟BoundService解除连接之后，就会调用 **/
		@Override
		public void onServiceDisconnected(ComponentName name) {
			Log.i(TAG, "onServiceDisconnected()...");
		}
		
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_boundservice);
		
		Button btn_start_boundService = (Button)super.findViewById(R.id.btn_start_boundService);
		btn_start_boundService.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent _intent = new Intent();
				_intent.setAction("com.cilinet.MyBoundService");
				
				mMyServiceConnection = new MyServiceConnection();
				
				BoundServiceActivity.this.bindService(_intent,mMyServiceConnection,Service.BIND_AUTO_CREATE);
			}
		});
		
		Button btn_finish_boundService = (Button)super.findViewById(R.id.btn_finish_boundService);
		btn_finish_boundService.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {	
				BoundServiceActivity.this.unbindService(mMyServiceConnection);
			}
		});
		
		Button btn_start_otherBoundServiceActivity = (Button)super.findViewById(R.id.btn_start_otherBoundServiceActivity);
		btn_start_otherBoundServiceActivity.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent _intent = new Intent(BoundServiceActivity.this,OtherBoundServiceActivity.class);
				BoundServiceActivity.this.startActivity(_intent);
			}
		});
		
		Button btn_getBoundServiceDatas = (Button)super.findViewById(R.id.btn_getBoundServiceDatas);
		btn_getBoundServiceDatas.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				int boundServiceDatas = mMyBinder.getCount();
				Toast.makeText(BoundServiceActivity.this, "BoundServiceDatas--count: " + boundServiceDatas, Toast.LENGTH_SHORT).show();
			}
		});
	}
	
}
