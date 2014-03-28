package com.cilinet.dynamicUpdateUI;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

/** 计算时间，然后发送广播通知，这样就完成了Activity和startService的交互 **/
public class DynamicUpdateUIService extends Service {
	
	private static final String TAG = "DynamicUpdateUIService";
	
	public static final String BROADCAST_ACTION_OPERATION = "com.cilinet.action.OPERATION";
	
	private int mNumber;
	
	private boolean mIsRunning;
	
	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}
	
	private Timer mTimer;

	@Override
	public void onCreate() {
		super.onCreate();
		Log.i(TAG, "onCreate()..");
		
		mIsRunning = false;
		
		mNumber = 9;
		
		//注册receiver
		IntentFilter _intentFilter = new IntentFilter(BROADCAST_ACTION_OPERATION);
		DynamicUpdateUIBroadcastReceiver _receiver = new DynamicUpdateUIBroadcastReceiver();
		LocalBroadcastManager.getInstance(this).registerReceiver(_receiver, _intentFilter);
		
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.i(TAG, "onStartCommand()..");
		
		if(!mIsRunning){
			//这个方法会使timer直接启动
			mTimer = new Timer();
			mTimer.schedule(new TimerTask() {
				@Override
				public void run() {
					Intent _intent = new Intent();
					_intent.setAction(MainActivity.BROADCAST_ACTION_UPDATEUI);
					_intent.putExtra("number", mNumber);
					//DynamicUpdateUIService.this.sendBroadcast(intent);
					LocalBroadcastManager.getInstance(DynamicUpdateUIService.this).sendBroadcast(_intent);
					
					mNumber --;
				}
			},1000,1000);//延迟1秒，执行1秒
		}
		
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		Log.i(TAG, "onDestroy()..");
		
		super.onDestroy();
	}
	
	class DynamicUpdateUIBroadcastReceiver extends BroadcastReceiver {
		
		private static final String TAG = "DynamicUpdateUIBroadcastReceiver";
		
		@Override
		public void onReceive(Context context, Intent intent) {
			Log.i(TAG, "DynamicUpdateUIBroadcastReceiver: " + "暂停消息");
			
				mTimer.cancel();
				mNumber = 9;
		}
		
	}
	

}
