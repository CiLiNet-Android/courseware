package com.cilinet.dynamicUpdateUI;

import java.lang.reflect.Field;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

/**
 * 主界面，由startService和broadcastreceiver配合动态更新UI
 * **/
public class MainActivity extends Activity {
	
	private static final String TAG = "MainActivity";
	
	public static final String BROADCAST_ACTION_UPDATEUI = "com.cilinet.action.UPDATEUI";
	
	private static final String SERVICE_ACTION = "com.cilinet.action.STARTSERVICE";
	
	private ImageView imgV_number;
	
	private Button btn_start;
	private Button btn_stop;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		super.setContentView(R.layout.activity_main);
		
		//初始化imageV
		imgV_number = (ImageView)findViewById(R.id.imgV_number);
		//imgV_number.setImageBitmap(getBitmapByNumber(3));
		//imgV_number.setImageDrawable(new BitmapDrawable(_numberBitmap));
		
		//初始化Button
		btn_start = (Button)findViewById(R.id.btn_start);
		btn_start.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent _intent = new Intent(SERVICE_ACTION);
				startService(_intent);
			}
		});
		
		btn_stop = (Button)findViewById(R.id.btn_stop);
		btn_stop.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent _intent = new Intent(DynamicUpdateUIService.BROADCAST_ACTION_OPERATION);
				LocalBroadcastManager.getInstance(MainActivity.this).sendBroadcast(_intent);
			}
		});
		
		//动态注册BroadcastReceiver
		IntentFilter _intentFilter = new IntentFilter(BROADCAST_ACTION_UPDATEUI);
		DynamicUpdateUIBroadcastReceiver _receiver = new DynamicUpdateUIBroadcastReceiver();
		//super.registerReceiver(_receiver, _intentFilter);
		//以下实现更安全,但只限于当前应用内部(只接收内部广播)
		LocalBroadcastManager.getInstance(this).registerReceiver(_receiver, _intentFilter);
	}
	
	
	/** 根据整型参数，反射获取其所代表的的图片资源ID **/
	private int getDrawableResIdByNunber(int number){
		int _drawableResId = -1;
		
		try {
			Class<?> _classObject = Class.forName("com.cilinet.dynamicUpdateUI.R$drawable");
			
			Field _fieldObject = _classObject.getField("number_" + number);
			_drawableResId = _fieldObject.getInt(null);//静态方法，传入null即可
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return _drawableResId;
	}
	
	/** 根据整型数字获取其对应的图片的Bitmap对象 **/
	private Bitmap getBitmapByNumber(int number){
		int _drawableResId = getDrawableResIdByNunber(number);
		Bitmap _bitmap = BitmapFactory.decodeResource(getResources(), _drawableResId);
		
		return _bitmap;
	}
	
	/** 收到广播后动态更新界面  比较好的Broadcast实现，是将其定义成内部类，然后动态注册 **/
	class DynamicUpdateUIBroadcastReceiver extends BroadcastReceiver {
		
		private static final String TAG = "DynamicUpdateUIBroadcastReceiver";
		
		@Override
		public void onReceive(Context context, Intent intent) {
			int _number = intent.getIntExtra("number", 9);
			if(_number < 0){
				LocalBroadcastManager.getInstance(MainActivity.this).sendBroadcast(new Intent(DynamicUpdateUIService.BROADCAST_ACTION_OPERATION));
			}else {
				//接收到service发来的广播，并且更新UI
				imgV_number.setImageBitmap(getBitmapByNumber(_number));
			}
		}

	}

}
