package com.cilinet.application;

import android.app.Application;
import android.content.Context;
import android.util.Log;

public class BaseApplication extends Application {
	
	private static final String TAG = "BaseApplication";
	
	public static Context sAppContext;

	@Override
	public void onCreate() {
		super.onCreate();
		
		sAppContext = super.getBaseContext();
		
		Context _context6 = super.getApplicationContext();
		Log.i(TAG, "_context6: " + _context6);
		
		//Thread.setDefaultUncaughtExceptionHandler(new DefaultExceptionHandler(super.getBaseContext()));
	}

	
}
