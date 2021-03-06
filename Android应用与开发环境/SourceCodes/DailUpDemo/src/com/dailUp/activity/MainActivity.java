package com.dailUp.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.dailUp.R;

public class MainActivity extends Activity {

	private EditText phoneNoEditText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
		
		phoneNoEditText = (EditText)super.findViewById(R.id.editText_phoneNo);
		
		
		Button callButton = (Button)super.findViewById(R.id.callButton);
		callButton.setOnClickListener(new View.OnClickListener() {
			
			//当用户点击时调用
			@Override
			public void onClick(View view) {
				String phoneNo = phoneNoEditText.getText().toString();
				if(null != phoneNo && !"".equals(phoneNo)){
					//拨号程序
					Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:" + phoneNo));
					MainActivity.this.startActivity(intent);
				}
			}
		});
		
	}
	
}
