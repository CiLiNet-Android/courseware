package com.cilinet.orderedBroadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class OrderedBroadcastReceiverA extends BroadcastReceiver {
	
	private static final String TAG = "OrderedBroadcastReceiverA";

	@Override
	public void onReceive(Context context, Intent intent) {
		String _extra = intent.getExtras().getString("OrderedBroadcastExtra");
		Log.i(TAG, "OrderedBroadcastReceiverA: " + _extra);
		
		//将数据传递给下一个receiver
		Bundle _datas = new Bundle();
		_datas.putString("OrderedBroadcastReceiverA", "传递给OrderedBroadcastReceiverB的数据");
		
		//比该receiver优先级低的receiver不会被触发，但比该receiver优先级高的receiver就会被触发
		//super.abortBroadcast();
		
		super.setResultExtras(_datas);
		
	}

}
