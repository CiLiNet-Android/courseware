package com.cilinet.httpRequest;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

/** Http请求工具 **/
public class HttpRequestUtil {
	
	/** 默认HTTP响应等待时间 ： 5s**/
	private static final int DEFAULT_CONNECTION_TIMEOUT = 5 * 1000;
	
	/** 请求头相关字段 **/
	private static final class HTTPREQUEST_HEADER_PARAMNAME {
		//以下两个必填
		public static final String PARAM_CONTENT_TYPE = "Content-Type";
		/** 请求体的二进制数据长度（字节） **/
		public static final String PARAM_CONTENT_LENGTH = "Content-Length";
	}
	

	public static void main(String[] args) {
//		try {
//			System.out.println(HttpRequestUtil.sendPostRequest("http://woofm.cn:8080/jxc-appservice/service/purOrder/create", null, "UTF-8"));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
	
	
	public static boolean sendPostRequest(String urlPath,Map<String,String> requestHeaderParams,Map<String,String> requetBodyParams,String encode) throws Exception{
		//POST请求体
		StringBuilder _postRequestBody = new StringBuilder();
		if(null != requetBodyParams && requetBodyParams.size() > 0){
			for(Map.Entry<String, String> _entry : requetBodyParams.entrySet()){
				_postRequestBody.append(_entry.getKey())
							   .append("=")
							   .append(URLEncoder.encode(_entry.getValue(), encode))
							   .append("&");
			}
			_postRequestBody.deleteCharAt(_postRequestBody.lastIndexOf("&"));
		}
		
		byte[] _postRequestDatas = _postRequestBody.toString().getBytes(encode);
		
		URL _url = new URL(urlPath);
		HttpURLConnection _httpURLConnection = (HttpURLConnection)_url.openConnection();
		_httpURLConnection.setRequestMethod("POST");
		_httpURLConnection.setConnectTimeout(DEFAULT_CONNECTION_TIMEOUT);
		
		//如果是POST方式，以下两个参数必须设为true
		_httpURLConnection.setDoOutput(true);
		_httpURLConnection.setDoInput(true);
		
		//以下设置头字段
		_httpURLConnection.setRequestProperty(HTTPREQUEST_HEADER_PARAMNAME.PARAM_CONTENT_TYPE, "application/x-www-form-urlencoded");
		_httpURLConnection.setRequestProperty(HTTPREQUEST_HEADER_PARAMNAME.PARAM_CONTENT_LENGTH,String.valueOf(_postRequestDatas.length));
		
		//设置自定义的请求头
		if(null != requestHeaderParams && requestHeaderParams.size() > 0){
			for(Map.Entry<String, String> _entry : requestHeaderParams.entrySet()){
				_httpURLConnection.setRequestProperty(_entry.getKey(), _entry.getValue());
			}	
		}
		
		//发送请求数据
		OutputStream _outStream = _httpURLConnection.getOutputStream();
		_outStream.write(_postRequestDatas);
		_outStream.flush();
		
		_outStream.close();
		
		return _httpURLConnection.getResponseCode() == 200;
	}

}
