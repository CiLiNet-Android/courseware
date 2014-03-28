package com.cilinet.application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Debug;
import android.text.format.Time;
import android.util.Log;

import com.cilinet.settings.Settings;

/** 全局异常处理类，可以用于记录日志 **/
public class DefaultExceptionHandler implements UncaughtExceptionHandler {
	private static final String TAG = "DefaultExceptionHandler";

	/** 日志过期时间长度 **/
	private static final  long LOG_OVERDUE_TIME = 1000 * 60 * 60 *24 * 14; //14天
	
	public static final String LOG_BASE_DIR = Settings.SDCARD_BASE_DIR;
	
	/** 日志文件最大尺寸 **/
	private static final int MAX_LOG_MESSAGE_LENGTH = 200000;
	
	private static final String LINE_SEPARATOR = System.getProperty("line.separator");
	
	/** 错误日志路径 **/
	public static final String LOG_CRASH_FILE = LOG_BASE_DIR + "error.log";
	
	/** 应用的版本名称 **/
	private String mVersionName;
	/** 应用的版本号 **/
	private int mVersionCode;
	/** 手机型号 **/
	private String mPhoneModel;
	/** 手机sdk **/
	private int mPhoneSDK;
	
	private static final UncaughtExceptionHandler mDefaultExceptionHandler = Thread
			.getDefaultUncaughtExceptionHandler();

	public DefaultExceptionHandler(Context context) {
		Log.i(TAG, "LOG_BASE_DIR: " + LOG_BASE_DIR);
		
		PackageManager _packageManager = context.getPackageManager();
		try{
			PackageInfo _packageInfo = _packageManager.getPackageInfo(context.getPackageName(), 0);
			mVersionName = _packageInfo.versionName;
			mVersionCode = _packageInfo.versionCode;
			
			mPhoneModel = android.os.Build.MODEL;
			mPhoneSDK = android.os.Build.VERSION.SDK_INT;
			
			new File(LOG_BASE_DIR).mkdirs();
			//删除过期的日志
			new Thread(){
				public void run(){
					deleteOverDueLogs();
				}
			}.start();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/** 删除过期的日志 **/
	private void deleteOverDueLogs(){
		File _dir = new File(LOG_BASE_DIR);
		
		Log.i(TAG, "_dir: " + _dir);
		Log.i(TAG, "absolutePath: " + _dir.getAbsolutePath());
		
		try{
			final long _currentTime = System.currentTimeMillis();
			
			//过滤出已经过期的文件
			File[] _files = _dir.listFiles(new FilenameFilter() {
				@Override
				public boolean accept(File dir, String filename) {
					File _file = new File(dir.getAbsolutePath() + "/" + filename);
					
					long _lastModifyTime = _file.lastModified();
					if(_currentTime - _lastModifyTime > LOG_OVERDUE_TIME){
						return true;
					}
					return false;
				}
			});
			
			//如果没有过期的日志文件，则返回
			if(null == _files || _files.length == 0){
				return;
			}
			
			//如果有过期的文件，则删除
			for(File _file : _files){
				_file.delete();
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void uncaughtException(Thread thread, Throwable throwable) {
		final Writer _stackResult = new StringWriter();
		final PrintWriter _printWriter = new PrintWriter(_stackResult);
		throwable.printStackTrace(_printWriter);
		try{
			File _dir = new File(LOG_BASE_DIR);
			if(!_dir.isDirectory() && !_dir.exists()){//不是目录，也不是文件
				_dir.mkdirs();
			}
			Time _tmtxt = new android.text.format.Time();
			_tmtxt.setToNow();
			String _sTime = _tmtxt.format("%Y-%m-%d %H:%M:%S");
			
			File _logFile = new File(LOG_BASE_DIR + System.currentTimeMillis() + ".log");
			_logFile.createNewFile();
			
			//日志的内容
			BufferedWriter _bos = new BufferedWriter(new FileWriter(_logFile));
			_bos.write("\t\n==================LOG=================\t\n");
			_bos.write("APP_VERSION:" + mVersionName + "|" + mVersionCode + "\t\n");
			_bos.write("PHONE_MODEL:" + mPhoneModel + "\t\n");
			_bos.write("ANDROID_SDK:" + mPhoneSDK + "\t\n");
			_bos.write(_sTime + "\t\n");
			_bos.write(_stackResult.toString());
			_bos.write("\t\n--------------------------------------\t\n");
			_bos.flush();

			StringBuilder _log = getLog();
			int _keepOffSet = Math.max(_log.length() - MAX_LOG_MESSAGE_LENGTH, 0);
			if(_keepOffSet > 0){
				_log.delete(0, _keepOffSet);
			}
			_bos.write(getLog().toString());//logcat输出的信息
			_bos.flush();
			_bos.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		mDefaultExceptionHandler.uncaughtException(thread, throwable);
	}
	
	public StringBuilder getLog() {

		final StringBuilder log = new StringBuilder();
		try {
			ArrayList<String> commandLine = new ArrayList<String>();
			commandLine.add("logcat");//$NON-NLS-1$
			commandLine.add("-d");//$NON-NLS-1$

			Process process = Runtime.getRuntime().exec(commandLine.toArray(new String[0]));
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

			String line;
			while ((line = bufferedReader.readLine()) != null) {
				log.append(line);
				log.append(LINE_SEPARATOR);
			}
		} catch (IOException e) {
			Log.e("TAG", "getLog failed", e);//$NON-NLS-1$
		}
		return log;
	}
	
	/**
	 * 保存内存堆栈信息
	 */
	public static void saveHprofData() {
		try {
			Debug.dumpHprofData(LOG_BASE_DIR + System.currentTimeMillis() + ".hprof");
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}



}
