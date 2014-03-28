package com.cilinet.switchActivity.scene_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cilinet.switchActivity.R;

public class Activity_2 extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.scene_1_activity_2);
		
		Button btn_start_activity_3 = (Button)super.findViewById(R.id.btn_scene_1_start_activity_3);
		btn_start_activity_3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(Activity_2.this,Activity_3.class);
				Activity_2.this.startActivity(intent);//发送给Android系统ActivityManager
			}
		});
	}

}
