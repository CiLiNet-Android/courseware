package com.cilinet.switchActivity.scene_3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.cilinet.switchActivity.R;

public class Activity_2 extends Activity {
	
	EditText edTxt_contactName;
	EditText edTxt_contactNumber;
	
	Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.scene_3_activity_2);
		
		intent = this.getIntent();
		
		edTxt_contactName = (EditText)super.findViewById(R.id.edTxt_contactName);
		edTxt_contactNumber = (EditText)super.findViewById(R.id.edTxt_contactNumber);
		
		Button button = (Button)super.findViewById(R.id.btn_scene_3_config_finish);
		button.setOnClickListener(new View.OnClickListener() {		
			@Override
			public void onClick(View v) {
				String contactName = edTxt_contactName.getText().toString();
				String contactNumber = edTxt_contactNumber.getText().toString();
				
				Bundle datas = new Bundle();
				datas.putString("contactName", contactName);
				datas.putString("contactNumber", contactNumber);
				intent.putExtra("datas", datas);
				
				Activity_2.this.setResult(33, Activity_2.this.intent);
				
				Activity_2.this.finish();
			}
		});
	}

}
