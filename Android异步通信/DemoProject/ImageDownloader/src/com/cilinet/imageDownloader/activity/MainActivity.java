package com.cilinet.imageDownloader.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import com.cilient.imageDownloader.R;

public class MainActivity extends Activity {

	private static final String TAG = "MainActivity";

	private Button btn_downloader;

	private ImageView imgView_image;
	
	private ProgressDialog progressDialog;
	
	public static final int MESSAGE_TYPE_UPDATE_IMAGEVIEW = 0;
	public static final int MESSAGE_TYPE_SET_PROGRESS_MAX = 1;
	public static final int MESSAGE_TYPE_INCREASE_PROGRESS = 2;
	
	public final Handler mHandler = new Handler(){
		
		//当Looper轮询到一个Message实例，就调用handler的handleMessage方法，并把轮到的Message实例发送过来
		@Override
		public void handleMessage(Message msg) {
			switch(msg.what){
			case MESSAGE_TYPE_UPDATE_IMAGEVIEW: {
				Bitmap bitmap = (Bitmap)msg.obj;
				imgView_image.setImageBitmap(bitmap);
				progressDialog.dismiss();
				break;
			}
			case MESSAGE_TYPE_SET_PROGRESS_MAX: {
				int max = msg.arg1;
				progressDialog.setMax(max);
				progressDialog.setMessage("玩命下载中...");
				break;
			}
			case MESSAGE_TYPE_INCREASE_PROGRESS: {
				progressDialog.incrementProgressBy(1);
			}
			default: 
				break;
			}
		}
		
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_main);

		imgView_image = (ImageView) findViewById(R.id.imgView_image);

		btn_downloader = (Button) findViewById(R.id.btn_downloader);
		btn_downloader.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				progressDialog = new ProgressDialog(MainActivity.this);
				progressDialog.setCancelable(false);
				progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
				// progressDialog.setButton(ProgressDialog.)
				progressDialog.setTitle("下载图片");
				progressDialog.setMessage("正在连接服务器...");
				progressDialog.show();
				
				//启动子线程
				new Thread(new ImageDownloadRunnable(mHandler)).start();
	
			}
		});
	}

}
