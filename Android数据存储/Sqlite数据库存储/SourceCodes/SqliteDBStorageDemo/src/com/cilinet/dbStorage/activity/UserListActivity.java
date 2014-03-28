package com.cilinet.dbStorage.activity;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.Menu;
import android.widget.EditText;

import com.cilinet.dbStorage.R;
import com.cilinet.dbStorage.db.DBOperation;

public class UserListActivity extends ListActivity {
	
	private final int USER_DIALOG_ID = 1234;
	
	private DBOperation mDbOperation;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		mDbOperation = new DBOperation(this);
		mDbOperation.openOrCreateDatabase();
		
		displayUsers();
	}

	private void displayUsers() {
		Cursor _cursor = mDbOperation.queryAllUser();
		if(null != _cursor){
			SimpleCursorAdapter _simpleCursorAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, _cursor, new String[]{"userName","userAddress"}, new int[]{android.R.id.text1,android.R.id.text2});
			super.setListAdapter(_simpleCursorAdapter);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(1,1,1,"添加用户");
		menu.add(1,1,1,"查询用户");
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	protected Dialog onCreateDialog(int id, Bundle args) {
		return super.onCreateDialog(id, args);
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		if(id == USER_DIALOG_ID){
			AlertDialog alertDialog = new AlertDialog.Builder(this)
				.setTitle("添加用户")
				.setIcon(R.drawable.ic_launcher)
				.setView(LayoutInflater.from(this).inflate(R.layout.dialog_userlist, null))
				.setPositiveButton("确定", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						AlertDialog alertDialog = (AlertDialog)dialog;
						EditText nameEditText = (EditText)alertDialog.findViewById(R.id.userNameEditText);
						EditText addressEditText = (EditText)alertDialog.findViewById(R.id.userAddressEditText);
					}
				})
				.setNegativeButton("取消",  new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
					}
				})
				.create();
		}
		return super.onCreateDialog(id);
	}
	
	
	
	

}
