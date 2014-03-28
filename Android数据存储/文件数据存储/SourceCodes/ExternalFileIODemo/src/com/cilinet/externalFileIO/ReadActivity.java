package com.cilinet.externalFileIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/** 从内部文件系统中读取数据 **/
public class ReadActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_read);
		
		TextView txtV_info = (TextView)findViewById(R.id.txtV_info);
		
		try {
			if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
				File _file = new File(Environment.getExternalStorageDirectory(),"info.txt");
				FileInputStream _inStream = new FileInputStream(_file);
				byte[] datas = IOUtil.read(_inStream);
				String _info = new String(datas,"UTF-8");
				
				txtV_info.setText(_info);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Button btn_back = (Button)findViewById(R.id.btn_back);
		btn_back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				finish();
			}
		});
		
	}

}
