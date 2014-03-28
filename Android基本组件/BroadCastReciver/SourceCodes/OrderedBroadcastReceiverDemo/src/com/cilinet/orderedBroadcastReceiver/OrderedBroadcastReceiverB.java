package com.cilinet.orderedBroadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class OrderedBroadcastReceiverB extends BroadcastReceiver {
	
	private static final String TAG = "OrderedBroadcastReceiverB";

	@Override
	public void onReceive(Context context, Intent intent) {
		Bundle _datas = super.getResultExtras(true);
		String _data = _datas.getString("OrderedBroadcastReceiverA");
		
		Log.i(TAG, "OrderedBroadcastReceiverB: " + _data);
	}

}
