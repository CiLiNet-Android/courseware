package com.cilinet.contentProvider;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

/**
 * 只要Uri的authorities匹配，就可以将请求发到对应
 * 
 * **/
public class MainActivity extends Activity {
	
	private Button btn_insert;
	private Button btn_delete;
	private Button btn_update;
	private Button btn_query;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		super.setContentView(R.layout.activity_main);
		
		btn_insert = (Button)findViewById(R.id.btn_insert);
		btn_insert.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				//第一步，获得ContentResolver
				ContentResolver _contentResolver = MainActivity.this.getContentResolver();
				
				//第二步，准备Uri和参数
				Uri _uri = Uri.parse("content://com.cilinet.provider.MYCUSTOMCONTENTPROVIDER/word");
				//调用后content://com.cilinet.provider.MYCUSTOMCONTENTPROVIDER/word/3
				_uri = ContentUris.withAppendedId(_uri, 3L);
				
				//第三步，发送请求
				_contentResolver.insert(_uri, null);
			}
		});
		
		btn_delete = (Button)findViewById(R.id.btn_delete);
		btn_delete.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				ContentResolver _contentResolver = MainActivity.this.getContentResolver();
				
				Uri _uri = Uri.parse("content://com.cilinet.provider.MYCUSTOMCONTENTPROVIDER/word");
				//调用后content://com.cilinet.provider.MYCUSTOMCONTENTPROVIDER/word/3
				_uri = ContentUris.withAppendedId(_uri, 3L);
				
				_contentResolver.delete(_uri, null, null);
			}
		});
		
		btn_update = (Button)findViewById(R.id.btn_update);
		btn_update.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				ContentResolver _contentResolver = MainActivity.this.getContentResolver();
				
				Uri _uri = Uri.parse("content://com.cilinet.provider.MYCUSTOMCONTENTPROVIDER/word");
				//调用后content://com.cilinet.provider.MYCUSTOMCONTENTPROVIDER/word/3
				_uri = ContentUris.withAppendedId(_uri, 3L);
				
				_contentResolver.update(_uri, null, null, null);
			}
		});
		
		btn_query = (Button)findViewById(R.id.btn_query);
		btn_query.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				ContentResolver _contentResolver = MainActivity.this.getContentResolver();
				
				Uri _uri = Uri.parse("content://com.cilinet.provider.MYCUSTOMCONTENTPROVIDER/words");
				
				_contentResolver.query(_uri, null, null, null, null);
			}
		});
	}

	
}
