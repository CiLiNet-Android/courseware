package com.cilinet.weixin.activity;

import com.cilinet.weixin.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/** 微信聊天界面 **/
public class ChatUIActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		super.setContentView(R.layout.activity_chatui);
		
	}
	
	

}
