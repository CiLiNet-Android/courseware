package com.cilinet.switchActivity.scene_2;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cilinet.switchActivity.R;

public class Activity_1 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.scene_2_activity_1);
		
		Button btn_scene_2_start_activity_2 = (Button)super.findViewById(R.id.btn_scene_2_start_activity_2);
		btn_scene_2_start_activity_2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Activity_1.this,Activity_2.class);
				intent.putExtra("message", "Hello Activity_2,I am Activity_1");
				
//				Bundle datas = new Bundle();
//				datas.putInt("arg1", 20);
//				datas.putBoolean("arg2", true);
//				intent.putExtra("datas", datas);
				
				Activity_1.this.startActivity(intent);
			}
		});
	}

}
