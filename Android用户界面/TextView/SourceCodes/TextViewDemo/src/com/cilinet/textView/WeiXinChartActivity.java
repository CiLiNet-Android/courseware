package com.cilinet.textView;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class WeiXinChartActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		super.setContentView(R.layout.activity_weixinchart);
	}

}
