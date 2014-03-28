package com.cilinet.button;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener{
	
	private Button btn_clickButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_main);
		
		btn_clickButton = (Button)findViewById(R.id.btn_clickButton);
		btn_clickButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		
	}
	
	

}
