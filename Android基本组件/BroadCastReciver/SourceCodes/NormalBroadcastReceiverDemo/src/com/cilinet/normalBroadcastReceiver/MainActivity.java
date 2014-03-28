package com.cilinet.normalBroadcastReceiver;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends Activity {
	
	private static final String BROADCAST_ACTION = "com.cilinet.action.MY_NORMALBROADCAST";
	
	private Button btn_sendNormalBroadcast;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		super.setContentView(R.layout.activity_main);
		
		btn_sendNormalBroadcast = (Button)findViewById(R.id.btn_sendNormalBroadcast);
		btn_sendNormalBroadcast.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				//第一步，构造发送给BroadcastReceiver的Intent
				Intent _intent = new Intent();
				_intent.setAction(BROADCAST_ACTION);
				_intent.putExtra("NormalBroadcastExtra", "发送给 Normal BroadcastReceiver的数据信息");
				
				//第二步，发送
				sendBroadcast(_intent);
			}
		});
	}
	
	

}
