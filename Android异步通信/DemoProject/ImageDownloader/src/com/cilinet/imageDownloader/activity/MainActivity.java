package com.cilinet.imageDownloader.activity;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import com.cilient.imageDownloader.R;

public class MainActivity extends Activity {
	
	private static final String TAG = "MainActivity";
	
	private Button btn_downloader;
	
	private ImageView imgView_image;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_main);
		
		imgView_image = (ImageView)findViewById(R.id.imgView_image);
		
		btn_downloader = (Button)findViewById(R.id.btn_downloader);
		btn_downloader.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				try {
					ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
					progressDialog.setCancelable(false);
					progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
					//progressDialog.setButton(ProgressDialog.)
					
					progressDialog.setTitle("下载图片");
					progressDialog.setMessage("正在连接服务器...");
					progressDialog.show();
					
					//第一步，从网络加载图片数据
					URL url = new URL("http://b.hiphotos.baidu.com/image/w%3D2048/sign=fe395f9fdb33c895a67e9f7be52b73f0/377adab44aed2e737ac9ae248501a18b87d6fa92.jpg");
					HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
					
					//获取图片的字节尺寸
					int datasLength = httpURLConnection.getContentLength();
//					Log.i(TAG,String.valueOf(datasLength));
//					progressDialog.setMax(datasLength);
					
					InputStream inStream = httpURLConnection.getInputStream();
					
					ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
					byte[] buffer = new byte[1024];
					int length = 0;
					
					int number = 0;
					if(datasLength % buffer.length == 0){
						number = datasLength / buffer.length;
					}else {
						number = datasLength / buffer.length + 1;
					}
					
					progressDialog.setMax(number);
					progressDialog.setMessage("正在玩命下载，请稍后...");
					
					while((length = inStream.read(buffer)) != -1){
						byteArrayOutputStream.write(buffer, 0, length);
						progressDialog.incrementProgressBy(1);
					}
					
					//progressDialog.dismiss();
					
					//图片数据
					byte[] datas = byteArrayOutputStream.toByteArray();
					
					//创建位图
					Bitmap bitmap = BitmapFactory.decodeByteArray(datas, 0, datas.length);
					
					//第二步，将图片数据与ImageView绑定
					imgView_image.setImageBitmap(bitmap);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			}
		});
	}
	
	

}
