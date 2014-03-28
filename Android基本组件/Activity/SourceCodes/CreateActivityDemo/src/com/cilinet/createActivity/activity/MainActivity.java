package com.cilinet.createActivity.activity;

import android.app.Activity;
import android.os.Bundle;

import com.cilinet.createActivity.R;

public class MainActivity extends Activity {
	
	//private static final String TAG = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_main);
		
		//Log.e(TAG, "MainActivity has been created!");
		
		System.out.println("**************************");
	}

}
