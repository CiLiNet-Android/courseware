package com.cilinet.externalFileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class WriteActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.setContentView(R.layout.activity_write);
		
		Button btn_save = (Button)findViewById(R.id.btn_save);
		btn_save.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				EditText edtTxt_info = (EditText)findViewById(R.id.edtTxt_info);
				String _info = edtTxt_info.getText().toString();
				
				try {
					//获取输出流的核心代码
					//如果SDCard存在，并且可以读写
					if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
						File _file = new File(Environment.getExternalStorageDirectory(),"info.txt");//获得SDCard的目录
						FileOutputStream _outStream = new FileOutputStream(_file);
						IOUtil.write(_info, _outStream);
						_outStream.close();
						
						WriteActivity.this.finish();
					}
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch(IOException e){
					e.printStackTrace();
				}
			}
		});
	}
}
