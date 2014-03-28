package com.cilinet.weixinChat.bean;

import java.util.Date;

public class ChatMessageBean {
	
	public static final int REC_MESSAGE_TYPE = 0;
	public static final int SEND_MESSAGE_TYPE = 1;
	
	/** 信息ID **/
	public long id;
	
	/** 昵称 **/
	public String chatterName;
	
	/** 信息内容 **/
	public String content;
	
	/** 信息类型 **/
	public int type;
	
	/** 信息传递的时间 **/
	public Date chatTime;
	
	/** 传递者头像 **/
	public int chatterPhotoResId;

}
