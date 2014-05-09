package com.cilinet.expandableListView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.ExpandableListView;
import android.widget.Toast;

public class MainActivity extends Activity implements ExpandableListView.OnChildClickListener,ExpandableListView.OnGroupClickListener{
	
	private ExpandableListView expListV_generals;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.setContentView(R.layout.activity_main);
		
		expListV_generals = (ExpandableListView)findViewById(R.id.expListV_generals);
		
		ExpandableListViewAdapter _adapter = new ExpandableListViewAdapter(this);
		
		expListV_generals.setAdapter(_adapter);
		
		expListV_generals.setOnChildClickListener(this);
		
		expListV_generals.setOnGroupClickListener(this);
	}

	@Override
	public boolean onChildClick(ExpandableListView parent, View v,
			int groupPosition, int childPosition, long id) {
		Toast.makeText(this, "onChildClick()...", Toast.LENGTH_SHORT).show();
		
		return false;
	}

	@Override
	public boolean onGroupClick(ExpandableListView parent, View v,
			int groupPosition, long id) {
		Toast.makeText(this, "onGroupClick()...", Toast.LENGTH_SHORT).show();
		
		return false;
	}

}
