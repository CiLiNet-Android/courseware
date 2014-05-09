package com.cilinet.expandableListView;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ExpandableListViewAdapter extends BaseExpandableListAdapter {
	
	/** 国家 **/
	private String[] countries = {"魏","蜀","吴"};
	
	/** 将军的名称 **/
	private String[][] generals = {
			{"貂蝉","夏侯惇","张辽"},
			{"关羽","刘备","张飞","赵云","诸葛亮"},
			{"孙权","甘宁","大乔","黄盖","周瑜"}
	};
	/** 将军的头像 **/
	private int[][] general_photos = {
			{R.drawable.diaochan,R.drawable.xiahoudun,R.drawable.zhangliao},
			{R.drawable.guanyu,R.drawable.liubei,R.drawable.zhangfei,R.drawable.zhaoyun,R.drawable.zhugeliang},
			{R.drawable.sunquan,R.drawable.gannin,R.drawable.daqiao,R.drawable.huanggai,R.drawable.zhouyu}}; 

	
	private Context mContext;
	
	public ExpandableListViewAdapter(Context context){
		mContext = context;
	}
	
	
	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return generals[groupPosition][childPosition];
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}
	
	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		 LinearLayout ll = new LinearLayout(mContext);
         ll.setOrientation(LinearLayout.HORIZONTAL);
         
         AbsListView.LayoutParams _abslayoutParams = new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT,100);
         ll.setLayoutParams(_abslayoutParams);
         
         TextView textView = getTextView();
         textView.setTextColor(Color.BLACK);
         textView.setTextSize(30f);
         textView.setText(getGroup(groupPosition).toString());
         
         LinearLayout.LayoutParams _linLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
         _linLayoutParams.gravity = Gravity.CENTER_VERTICAL;
         _linLayoutParams.leftMargin = 50;
        
         textView.setLayoutParams(_linLayoutParams);
         
         ll.addView(textView);
         
         return ll;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		LinearLayout ll = new LinearLayout(mContext);
        ll.setOrientation(LinearLayout.HORIZONTAL);
        
        AbsListView.LayoutParams _abslayoutParams = new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT,AbsListView.LayoutParams.WRAP_CONTENT);
        ll.setLayoutParams(_abslayoutParams);
        
        ll.setPadding(80, 0, 0, 0);
        
        ImageView generallogo = new ImageView(mContext);
        
        LinearLayout.LayoutParams _linImgLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        _linImgLayoutParams.width = 100;
        _linImgLayoutParams.height = 100;
        generallogo.setLayoutParams(_linImgLayoutParams);
        
        generallogo.setImageResource(general_photos[groupPosition][childPosition]);
        ll.addView(generallogo);
        
        
        TextView textView = getTextView();
        
        LinearLayout.LayoutParams _linTxtLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        _linTxtLayoutParams.gravity = Gravity.CENTER_VERTICAL;
        textView.setLayoutParams(_linTxtLayoutParams);
        
        textView.setText(getChild(groupPosition, childPosition).toString());
        ll.addView(textView);
        
        return ll;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		return generals[groupPosition].length;
	}

	@Override
	public Object getGroup(int groupPosition) {
		return countries[groupPosition];
	}

	@Override
	public int getGroupCount() {
		return countries.length;
	}

	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}
	
	private TextView getTextView() {
         AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
                 ViewGroup.LayoutParams.FILL_PARENT, 64);
         TextView textView = new TextView(mContext);
         textView.setLayoutParams(lp);
         textView.setGravity(Gravity.CENTER_VERTICAL);
         textView.setPadding(36, 0, 0, 0);
         textView.setTextSize(20);
         textView.setTextColor(Color.BLACK);
         return textView;
     }
	

	@Override
	public boolean hasStableIds() {
		return false;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return false;
	}

}
