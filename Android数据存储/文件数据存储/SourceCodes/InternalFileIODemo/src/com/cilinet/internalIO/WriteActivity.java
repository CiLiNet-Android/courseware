package com.cilinet.internalIO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

/** 将数据写入内部文件系统 **/
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
					OutputStream outStream = WriteActivity.this.openFileOutput("info.txt", MODE_PRIVATE);
					IOUtil.write(_info, outStream);
					
					outStream.close();
					
					WriteActivity.this.finish();
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch(IOException e){
					e.printStackTrace();
				}
			}
		});
	}

}
