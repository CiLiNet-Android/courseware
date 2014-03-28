package com.cilinet.weixin.activity;

import com.cilinet.weixin.R;
import com.cilinet.weixin.UI.HorizontalScrollLayout;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;

/** 微信案例：开始界面的横向滚动 **/
public class HorizontalScrollUIActivity extends Activity implements HorizontalScrollLayout.OnViewChangeListener{
	
	private static final String TAG = "HorizontalScrollUIActivity";
	
	/** 自定义界面 **/
	private HorizontalScrollLayout lyot_horizontalScroll;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		super.setContentView(R.layout.activity_horizontalscrollui);
		
		init();
	}

	private void init() {
		initView();
		
	}

	private void initView() {
		lyot_horizontalScroll = (HorizontalScrollLayout)findViewById(R.id.lyot_horizontalScroll);
		lyot_horizontalScroll.setOnViewChangeListener(this);
		
	}

	/** Layout被拖动后，通知其委托 **/
	@Override
	public void OnViewChange(int viewIndex) {
		Log.i(TAG, "OnViewChange()...");
	}

}
