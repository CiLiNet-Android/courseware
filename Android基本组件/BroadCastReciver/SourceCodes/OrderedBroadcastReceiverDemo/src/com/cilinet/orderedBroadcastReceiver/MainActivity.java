package com.cilinet.orderedBroadcastReceiver;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends Activity {
	
	private static final String BROADCAST_ACTION = "com.cilinet.action.MY_ORDEREDBROADCAST";
	
	private Button btn_sendOrderedBroadcast;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		super.setContentView(R.layout.activity_main);
		
		btn_sendOrderedBroadcast = (Button)findViewById(R.id.btn_sendOrderedBroadcast);
		btn_sendOrderedBroadcast.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent _intent = new Intent();
				_intent.setAction(BROADCAST_ACTION);
				_intent.putExtra("OrderedBroadcastExtra", "发送给 Ordered BroadcastReceiver的数据信息");
				
				sendOrderedBroadcast(_intent, null);
			}
		});
	}

}
