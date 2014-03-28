package com.cilinet.weixinChat.adapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cilinet.weixinChat.R;
import com.cilinet.weixinChat.bean.ChatMessageBean;

public class ChatViewAdapter extends BaseAdapter{
	
	private Context mContext;
	private LayoutInflater mLayoutInflater;
	
	private ArrayList<ChatMessageBean> mChatMessageBeans;
	
	private static final int MESSAGE_TYPE_RECIVE = 0;
	private static final int MESSAGE_TYPE_SEND = 1;
	
	
	public ChatViewAdapter(Context context,ArrayList<ChatMessageBean> chatMessageBeans){
		mContext = context;
		mLayoutInflater = LayoutInflater.from(context);
		mChatMessageBeans = chatMessageBeans;
	}

	@Override
	public int getCount() {
		return mChatMessageBeans.size();
	}

	@Override
	public Object getItem(int position) {
		return mChatMessageBeans.get(position);
	}

	@Override
	public long getItemId(int position) {
		return mChatMessageBeans.get(position).id;
	}
	
	@Override
	public int getItemViewType(int position) {
		ChatMessageBean _chatMessageBean = mChatMessageBeans.get(position);
		int _itemViewType = 0;
		if(_chatMessageBean.type == ChatMessageBean.REC_MESSAGE_TYPE){
			_itemViewType = MESSAGE_TYPE_RECIVE;
		}else if(_chatMessageBean.type == ChatMessageBean.SEND_MESSAGE_TYPE){
			_itemViewType = MESSAGE_TYPE_SEND;
		}
		
		return _itemViewType;
	}

	@Override
	public int getViewTypeCount() {
		return 2;
	}

	private class ViewHolder {
		public TextView txtV_chatMsgTime;
		public ImageView imgV_chatterPhoto;
		public TextView txtV_chatMsg;
		public TextView txtV_chatterName;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder _viewHolder = null;
		if(convertView == null){
			_viewHolder = new ViewHolder();
			
			int _viewType = getItemViewType(position);
			if(_viewType == MESSAGE_TYPE_RECIVE){
				convertView = mLayoutInflater.inflate(R.layout.chatview_listitem_left, null);
				
				_viewHolder.txtV_chatMsgTime = (TextView)convertView.findViewById(R.id.txtV_recChatMsgTime);
				_viewHolder.imgV_chatterPhoto = (ImageView)convertView.findViewById(R.id.imgV_recChatterPhoto);
				_viewHolder.txtV_chatMsg = (TextView)convertView.findViewById(R.id.txtV_recChatMsg);
				_viewHolder.txtV_chatterName = (TextView)convertView.findViewById(R.id.txtV_recChatterName);
				
			}else if(_viewType == MESSAGE_TYPE_SEND){
				convertView = mLayoutInflater.inflate(R.layout.chatview_listitem_right, null);
				
				_viewHolder.txtV_chatMsgTime = (TextView)convertView.findViewById(R.id.txtV_sendChatMsgTime);
				_viewHolder.imgV_chatterPhoto = (ImageView)convertView.findViewById(R.id.imgV_sendChatterPhoto);
				_viewHolder.txtV_chatMsg = (TextView)convertView.findViewById(R.id.txtV_sendChatMsg);
				_viewHolder.txtV_chatterName = (TextView)convertView.findViewById(R.id.txtV_sendChatterName);
				
			}
			
			convertView.setTag(_viewHolder);
		}else {
			_viewHolder = (ViewHolder)convertView.getTag();
		}
		
		ChatMessageBean _chatMessageBean = (ChatMessageBean)getItem(position);
		
		//设置信息时间
		_viewHolder.txtV_chatMsgTime.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(_chatMessageBean.chatTime));
		
		//设置头像
		_viewHolder.imgV_chatterPhoto.setImageResource(_chatMessageBean.chatterPhotoResId);
		
		//设置聊天内容
		_viewHolder.txtV_chatMsg.setText(_chatMessageBean.content);
		
		//设置昵称
		_viewHolder.txtV_chatterName.setText(_chatMessageBean.chatterName);
		
		return convertView;
	}

}
