package com.cilinet.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

public class NewView extends View {
	
	private int mColor;
	
	private String mText;

	public NewView(Context context) {
		super(context);
	}
	
	public NewView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		TypedArray _typeArray = context.getTheme().obtainStyledAttributes(attrs,
				R.styleable.MyButton, 0, 0);
		mColor = _typeArray.getColor(R.styleable.MyButton_myColor, 0xFFFFFFFF);
	}

	


	public int getmColor() {
		return mColor;
	}

	public void setmColor(int mColor) {
		this.mColor = mColor;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		Paint _paint = new Paint();
		//_paint.setAlpha(100);
		_paint.setColor(mColor);
		_paint.setStrokeWidth(0);
		
		canvas.drawRect(new Rect(80, 80, 200, 150), _paint);
		
		_paint.setColor(Color.RED);
		canvas.drawText("确定", 125,125 ,_paint);
		
		
		
		super.onDraw(canvas);
	}
	
	

}
;