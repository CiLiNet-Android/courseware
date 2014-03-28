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

import com.cilinet.service.R;

public class OtherBoundServiceActivity extends Activity {
	
	private MyOtherServiceConnection mMyOtherServiceConnection;
	
	private class MyOtherServiceConnection implements ServiceConnection{
		
		private static final String TAG = "MyOtherServiceConnection";

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			Log.i(TAG, "onServiceConnected()...");
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			Log.i(TAG, "onServiceDisconnected()...");
		}
		
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_otherboundservice);
		
		Button btn_otherStart_boundService = (Button)super.findViewById(R.id.btn_otherStart_boundService);
		btn_otherStart_boundService.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent _intent = new Intent(OtherBoundServiceActivity.this,BoundService.class);
				
				mMyOtherServiceConnection = new MyOtherServiceConnection();
				
				OtherBoundServiceActivity.this.bindService(_intent, mMyOtherServiceConnection, Service.BIND_AUTO_CREATE);
			}
		});
		
		Button otherFinish_boundService = (Button)super.findViewById(R.id.otherFinish_boundService);
		otherFinish_boundService.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				OtherBoundServiceActivity.this.unbindService(mMyOtherServiceConnection);
			}
		});
		
		Button btn_finish_OtherBoundServiceActivity = (Button)super.findViewById(R.id.btn_finish_OtherBoundServiceActivity);
		btn_finish_OtherBoundServiceActivity.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				OtherBoundServiceActivity.this.finish();
			}
		});
	}

}
