package com.cilinet.service.boundService;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
/**
 * 
 * **/
public class BoundService extends Service {
	
	private static final String TAG = "BoundService";
	
	private int mCount;
	
	private MyBinder mMyBinder;
	
	public class MyBinder extends Binder{
		public int getCount(){
			return mCount;
		}
		
	}

	@Override
	public void onCreate() {
		super.onCreate();
		
		Log.i(TAG, "onCreate()..");
		
		new Thread(){
			public void run(){
				for(int i = 0; i < 50; i ++){
					mCount ++;
					try {
						Log.i(TAG, "onStartCommand(): " + i);
						Thread.sleep(1 * 1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		Log.i(TAG, "onBind()..");
		
		mMyBinder = new MyBinder();
		
		return mMyBinder;
	}
	
	@Override
	public boolean onUnbind(Intent intent) {
		Log.i(TAG, "onUnbind()..");
		
		return super.onUnbind(intent);
	}

	@Override
	public void onDestroy() {
		Log.i(TAG, "onDestroy()..");
		
		super.onDestroy();
	}

}
