package com.cilinet.service.startedService;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class StartedService extends Service {
	
	private static final String TAG = "StartedService";
	
	/** 初始化工作 **/
	@Override
	public void onCreate() {
		super.onCreate();
		
		Log.i(TAG, "onCreate()...");
	}

	/** startService() **/
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.i(TAG, "onStartCommand()...");
		
		new Thread(){
			public void run(){
				for(int i = 0; i < 50; i ++){
					try {
						Log.i(TAG, "onStartCommand(): " + i);
						Thread.sleep(1 * 1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	
		return super.onStartCommand(intent, flags, startId);
	}
	
	@Override
	public void onDestroy() {
		Log.i(TAG, "onDestroy()...");
		
		super.onDestroy();
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

}
