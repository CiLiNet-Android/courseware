package com.cilinet.settings;

import android.os.Environment;

/** 应用全局的常量配置 **/
public class Settings {
	
	/** SD卡项目根路径,加.为android系统的隐藏文件 **/
	public static final String SDCARD_BASE_DIR = Environment.getExternalStorageDirectory() + "/.JxcApp/";
	
}
