package com.cilinet.asyncTask;

import android.os.AsyncTask;
import android.util.Log;

public class MyAsyncTask extends AsyncTask<Void, Integer, Void> {
	private static final String TAG = "MyAsyncTask";
	
	/** 宿主线程中执行,在异步任务开始前调用 **/
	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		
		Log.i(TAG, "onPreExecute()..");
	}
	
	/** 新创建一个线程执行，异步任务执行的主方法 **/
	@Override
	protected Void doInBackground(Void... arg0) {
		Log.i(TAG, "doInBackground()..");
		
		return null;
	}
	
	/** 宿主线程中执行，当在异步任务中调用 publishProgress()后，调用该方法**/
	@Override
	protected void onProgressUpdate(Integer... values) {
		super.onProgressUpdate(values);
		
		Log.i(TAG, "onProgressUpdate()..");
	}
	
	/** 在宿主线程中执行，异步任务执行结束后调用 **/
	@Override
	protected void onPostExecute(Void result) {
		super.onPostExecute(result);
		
		Log.i(TAG, "onPostExecute()..");
	}
	
	/** 在异步任务被取消时调用 **/
	@Override
	protected void onCancelled() {
		super.onCancelled();
		
		Log.i(TAG, "onCancelled()..");
	}
	

}
