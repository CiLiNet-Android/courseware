package com.cilinet.switchActivity.scene_3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cilinet.switchActivity.R;

public class Activity_1 extends Activity {
	
	private static final String TAG = "Activity_1";
	
	private TextView txtV_scene_3_contactInfo_label;
	private TextView txtV_scene_3_contactInfo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.scene_3_activity_1);
		
		Button scene_3_add_contact = (Button)super.findViewById(R.id.btn_scene_3_add_contact);
		scene_3_add_contact.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(Activity_1.this,Activity_2.class);
				Activity_1.this.startActivityForResult(intent, 23);
			}
		});
		
//		Button scene_3_add_contact = (Button)super.findViewById(R.id.btn_scene_3_add_contact);
//		scene_3_add_contact.setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View arg0) {
//				Intent intent = new Intent(Activity_1.this,Activity_3.class);
//				Activity_1.this.startActivityForResult(intent, 24);
//			}
//		});
		
//		Button scene_3_add_contact = (Button)super.findViewById(R.id.btn_scene_3_add_contact);
//		scene_3_add_contact.setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View arg0) {
//				Intent intent = new Intent(Activity_1.this,Activity_4.class);
//				Activity_1.this.startActivityForResult(intent, 25);
//			}
//		});
		
		txtV_scene_3_contactInfo_label = (TextView)super.findViewById(R.id.txtV_scene_3_contactInfo_label);
		txtV_scene_3_contactInfo = (TextView)super.findViewById(R.id.txtV_scene_3_contactInfo);
	}

	/** Activity_2返回结果的时候，系统会调用该方法 **/
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//		Log.i(TAG, "onActivityResult()被系统调用了..");
		
		if(requestCode == 23 && resultCode == 33){
			Bundle datas = data.getBundleExtra("datas");
			String contactName = datas.getString("contactName");
			String contactNumber = datas.getString("contactNumber");
			
			String contactInfo = "联系人姓名: " + contactName + " == " + "联系人电话：" + contactNumber;
			
			txtV_scene_3_contactInfo.setText(contactInfo);
			txtV_scene_3_contactInfo_label.setVisibility(View.VISIBLE);
			txtV_scene_3_contactInfo.setVisibility(View.VISIBLE);
		}
		
	}
	
}
