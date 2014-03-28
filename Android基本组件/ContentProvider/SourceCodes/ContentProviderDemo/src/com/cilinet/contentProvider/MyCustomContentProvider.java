package com.cilinet.contentProvider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

/** ContentProvider 服务器端 **/
public class MyCustomContentProvider extends ContentProvider {
	
	private static final String TAG = "MyCustomContentProvider";
	
	private static UriMatcher mUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
	static {
		mUriMatcher.addURI("com.cilinet.provider.MYCUSTOMCONTENTPROVIDER", "words", 20);
		//#号为通配符,表示至少有一个字符
		mUriMatcher.addURI("com.cilinet.provider.MYCUSTOMCONTENTPROVIDER", "word/#", 10);
	}

	@Override
	public boolean onCreate() {
		Log.i(TAG, "onCreate()..");
		
		return true;
	}
	
	@Override
	public Uri insert(Uri uri, ContentValues values) {
		Log.i(TAG, "insert()..uri: " + uri);
		Log.i(TAG, "insert()..uriCode: " + mUriMatcher.match(uri));
		Log.i(TAG, "insert()..id: " + ContentUris.parseId(uri));
		
		return null;
	}
	
	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		Log.i(TAG, "delete()..uri: " + uri);
		Log.i(TAG, "delete()..uriCode: " + mUriMatcher.match(uri));
		Log.i(TAG, "delete()..id: " + ContentUris.parseId(uri));
		
		return 0;
	}
	
	@Override
	public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
		Log.i(TAG, "update()..uri: " + uri);
		Log.i(TAG, "update()..uriCode: " + mUriMatcher.match(uri));
		Log.i(TAG, "update()..id: " + ContentUris.parseId(uri));
		
		return 0;
	}
	
	@Override
	public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
		Log.i(TAG, "query()..uri: " + uri);
		Log.i(TAG, "query()..uriCode: " + mUriMatcher.match(uri));
		//Log.i(TAG, "query()..id: " + ContentUris.parseId(uri));
		
		return null;
	}


	@Override
	public String getType(Uri arg0) {
		return null;
	}

}
