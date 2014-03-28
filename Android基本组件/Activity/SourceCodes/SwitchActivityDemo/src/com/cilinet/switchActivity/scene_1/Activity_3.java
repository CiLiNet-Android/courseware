package com.cilinet.switchActivity.scene_1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cilinet.switchActivity.R;

public class Activity_3 extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.scene_1_activity_3);
		
		Button btn_finish_activity_3 = (Button)super.findViewById(R.id.btn_scene_1_finish_activity_3);
		btn_finish_activity_3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Activity_3.this.finish();
			}
		});
	}

}
