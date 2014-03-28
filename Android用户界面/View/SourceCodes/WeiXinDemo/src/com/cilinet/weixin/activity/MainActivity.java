package com.cilinet.weixin.activity;

import com.cilinet.weixin.R;
import com.cilinet.weixin.UI.HorizontalScrollLayout;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;

public class MainActivity extends Activity implements HorizontalScrollLayout.OnViewChangeListener{
	
	private static final String TAG = "MainActivity";

	/** 自定义界面 **/
	private HorizontalScrollLayout lyot_horizontalScroll;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		super.setContentView(R.layout.activity_main);
		
		init();
	}

	
	private void init() {
		initView();
		
	}


	private void initView() {
		lyot_horizontalScroll = (HorizontalScrollLayout)findViewById(R.id.lyot_horizontalScroll);
		lyot_horizontalScroll.setOnViewChangeListener(this);
		
	}


	@Override
	public void OnViewChange(int viewIndex) {
		Log.i(TAG, "OnViewChange()...");
	}

}
