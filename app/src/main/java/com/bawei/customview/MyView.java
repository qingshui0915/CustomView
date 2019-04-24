package com.bawei.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Project_Name: CustomView
 * Time: 2019/4/24
 * Data: 晚么
 * Description:
 */
public class MyView extends ViewGroup {


    public MyView(Context context) {
        this(context,null);
    }

    public MyView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int mode = MeasureSpec.getMode(widthMeasureSpec);
        int size = MeasureSpec.getSize(widthMeasureSpec);

        int mode1 = MeasureSpec.getMode(heightMeasureSpec);
        int size1 = MeasureSpec.getSize(heightMeasureSpec);

        int wMeasure=0;
        int hMeasure=0;
        if (mode==MeasureSpec.EXACTLY&&mode1==MeasureSpec.EXACTLY){
            wMeasure=size;
            hMeasure=size1;
        }else{
            wMeasure=size;
            int ChildCount=getChildCount();
            int childWidth;
            int childHeight;
            int childLineWidth=0;
            int row=1;
            for (int i = 0; i <ChildCount; i++) {
                View childAt = getChildAt(i);
                childAt.measure(MeasureSpec.UNSPECIFIED,MeasureSpec.UNSPECIFIED);
                childWidth=childAt.getMeasuredWidth();
                childHeight=childAt.getMeasuredHeight();
                childLineWidth+=childWidth;
                if (childLineWidth>size){
                    childLineWidth=childWidth;
                    row++;
                }
                hMeasure=row*childHeight;
            }
        }
        setMeasuredDimension(wMeasure,hMeasure);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int width=r-l;
        int count=getChildCount();
        int x=0;
        int y;
        int row=1;
        for (int i = 0; i < count; i++) {
            View childAt = getChildAt(i);
            int childWidth = childAt.getMeasuredWidth();
            int childHeight = childAt.getMeasuredHeight();
            x+=childWidth;
            if (x>width){
                x=childWidth;
                row++;
            }
            y=childHeight*row;
            childAt.layout(x-childWidth,y-childHeight,x,y);
        }
    }
}
