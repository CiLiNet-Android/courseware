package com.cilinet.progressBar.activity;

import com.cilinet.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class HorizProgresBarActivity extends Activity {
	
	private ProgressBar progresBar_progressBarStyleHorizontal;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_horizprogresbar);
		
		progresBar_progressBarStyleHorizontal = (ProgressBar)findViewById(R.id.progresBar_progressBarStyleHorizontal);
		
		//进度条最大值
		progresBar_progressBarStyleHorizontal.setMax(200);
		//当前进度值
		progresBar_progressBarStyleHorizontal.setProgress(100);
		//第二进度值
		progresBar_progressBarStyleHorizontal.setSecondaryProgress(150);
		
		
		//判断进度条的样式(是否是转圈的样式)
		boolean flag = progresBar_progressBarStyleHorizontal.isIndeterminate();
		//通过偏移量改变进度值
		progresBar_progressBarStyleHorizontal.incrementProgressBy(10);//增加10个偏移量
		progresBar_progressBarStyleHorizontal.incrementSecondaryProgressBy(10);
		
		//获得当前进度
		progresBar_progressBarStyleHorizontal.getProgress();
	}

}
