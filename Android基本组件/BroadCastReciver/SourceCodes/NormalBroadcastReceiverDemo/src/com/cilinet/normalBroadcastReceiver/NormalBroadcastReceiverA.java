package com.cilinet.normalBroadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class NormalBroadcastReceiverA extends BroadcastReceiver {
	
	private static final String TAG = "NormalBroadcastReceiverA";

	@Override
	public void onReceive(Context context, Intent intent) {
		String _extra = intent.getExtras().getString("NormalBroadcastExtra");
		
		Log.i(TAG,_extra);
	}

}
