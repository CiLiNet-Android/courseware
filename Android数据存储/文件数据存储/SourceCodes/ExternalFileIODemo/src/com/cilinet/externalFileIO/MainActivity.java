package com.cilinet.externalFileIO;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		super.setContentView(R.layout.activity_main);
		
		Button btn_write = (Button)findViewById(R.id.btn_write);
		btn_write.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent _intent = new Intent(MainActivity.this,WriteActivity.class);
				startActivity(_intent);
			}
		});
		
		Button btn_read = (Button)findViewById(R.id.btn_read);
		btn_read.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent _intent = new Intent(MainActivity.this,ReadActivity.class);
				startActivity(_intent);
			}
		});
	}

}
