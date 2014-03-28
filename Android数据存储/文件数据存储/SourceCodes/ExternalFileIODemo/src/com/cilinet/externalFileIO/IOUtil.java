package com.cilinet.externalFileIO;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/** IO工具类 **/
public class IOUtil {
	
	/** 将数据写入输出流 **/
	public static void write(String info,OutputStream outStream){
		try {
			byte[] _buffer = info.getBytes("UTF-8");
			outStream.write(_buffer);
			
			outStream.flush();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/** 从输入流中读取数据 **/
	public static byte[] read(InputStream instream){
		ByteArrayOutputStream _byteArrayOutputStream = new ByteArrayOutputStream();
		try {
			byte[] _buffer = new byte[1024];//1K的缓存
			int _length = 0;
			while((_length = instream.read(_buffer)) > 0){
				_byteArrayOutputStream.write(_buffer, 0, _length);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return _byteArrayOutputStream.toByteArray();
	} 

}
