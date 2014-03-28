package com.cilinet.ratingBar;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;

import com.cilinet.R;

public class MainActivity extends Activity {
	private static final String TAG = "MainActivity";
	
	private RatingBar ratingBar_myRatingBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.setContentView(R.layout.activity_main);
		
		ratingBar_myRatingBar = (RatingBar)findViewById(R.id.ratingBar_myRatingBar);
		
		//设置5颗星 注：RatingBar必须指定宽度为包裹内容，不然星星的数量不受控制
		ratingBar_myRatingBar.setNumStars(5);
		
		//设置最小偏移量
		ratingBar_myRatingBar.setStepSize(0.5f);//一次最少必须偏移0.5(半颗星)
		
		//注册监听器
		ratingBar_myRatingBar.setOnRatingBarChangeListener(new OnRatingBarChangeListenerImpl());
	}
	
	/** RatingBar监听器 **/
	private class OnRatingBarChangeListenerImpl implements OnRatingBarChangeListener {
		
		/** 当OnRatingBar被拖动结束以后调用，参数的作用与SeekBar相同 **/
		@Override
		public void onRatingChanged(RatingBar ratingBar, float rating,
				boolean fromUser) {
			Log.i(TAG, "onRatingChanged()...rating: " + rating);
		}
		
	}

}
