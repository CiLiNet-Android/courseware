package com.cilinet.progressBar.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.cilinet.R;

public class MainActivity extends Activity {
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.setContentView(R.layout.activity_main);
		
		
	}

}
