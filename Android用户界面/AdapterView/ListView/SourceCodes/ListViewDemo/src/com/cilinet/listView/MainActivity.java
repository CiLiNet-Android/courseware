package com.cilinet.listView;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ListView listV_myListV;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.setContentView(R.layout.activity_main);
		
		listV_myListV = (ListView)findViewById(R.id.listV_myListV);
		
		ArrayList<String> datas = new ArrayList<String>();
		datas.add("张三");
		datas.add("李四");
		datas.add("王五");
		datas.add("赵六");
		datas.add("朱七");
		
		
		listV_myListV.setAdapter(new ArrayAdapter(this, R.layout.listview_item, R.id.txtV_myTextV, datas));
		
	}

}
