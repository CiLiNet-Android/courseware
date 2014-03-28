package com.cilinet.seekBar;

import com.cilinet.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

/**
 * 因为SeekBar是ProgressBar的子类，所以它基本继承了ProgressBar的相关方法
 * **/
public class MainActivity extends Activity {
	private static final String TAG = "MainActivity";
	
	private SeekBar seekBar_mySeekBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.setContentView(R.layout.activity_main);
		
		seekBar_mySeekBar = (SeekBar)findViewById(R.id.seekBar_mySeekBar);
		seekBar_mySeekBar.setMax(100);
		seekBar_mySeekBar.setProgress(50);
		seekBar_mySeekBar.setSecondaryProgress(80);
		
		seekBar_mySeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListenerImpl());
	}
	
	/** SeekBar变动监听器 **/
	private class OnSeekBarChangeListenerImpl implements OnSeekBarChangeListener {
		
		/** 当SeekBar进度条被拖动时调用 
		 * @param seekBar 被拖动的SeekBar
		 * @param progress 拖动以后的进度
		 * @param fromUser 是否是用户在屏幕滑动导致的进度变化
		 * **/
		@Override
		public void onProgressChanged(SeekBar seekBar, int progress,
				boolean fromUser) {
			Log.i(TAG, "onProgressChanged()..." + "progress: " + progress);
		}

		/** 当SeekBar进度条被拖动开始时调用 **/
		@Override
		public void onStartTrackingTouch(SeekBar seekBar) {
			Log.i(TAG, "onStartTrackingTouch()...");
		}

		/** 当SeekBar进度条被拖动结束时调用 **/
		@Override
		public void onStopTrackingTouch(SeekBar seekBar) {
			Log.i(TAG, "onStopTrackingTouch()..." + seekBar.getProgress());
		}
		
	} 

}
