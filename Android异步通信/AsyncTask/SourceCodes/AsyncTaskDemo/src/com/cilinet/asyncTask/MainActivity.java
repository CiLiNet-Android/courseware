package com.cilinet.asyncTask;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class MainActivity extends Activity {
	
	private MyAsyncTask mMyAsyncTask;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.setContentView(R.layout.activity_main);
		
		//创建并执行一个异步任务
		mMyAsyncTask = new MyAsyncTask();
		mMyAsyncTask.execute();
	}

}
