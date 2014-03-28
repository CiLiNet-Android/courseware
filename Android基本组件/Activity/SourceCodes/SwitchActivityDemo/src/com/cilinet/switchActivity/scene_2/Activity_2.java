package com.cilinet.switchActivity.scene_2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cilinet.switchActivity.R;

public class Activity_2 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.scene_2_activity_2);
		
		Intent intent = super.getIntent();
		
//		Bundle datas = intent.getBundleExtra("datas");
//		datas.getInt("arg1");
//		datas.getBoolean("arg2");
		
		String message = intent.getStringExtra("message");
		
		TextView txtView_scene_2_message = (TextView)super.findViewById(R.id.txtView_scene_2_message);
		txtView_scene_2_message.setVisibility(View.VISIBLE);
		txtView_scene_2_message.setText(message);
		
		Button btn_scene_2_finish_activity_2 = (Button)super.findViewById(R.id.btn_scene_2_finish_activity_2);
		btn_scene_2_finish_activity_2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Activity_2.this.finish();
			}
		});
	}
}
