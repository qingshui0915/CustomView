package com.bawei.customview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Project_Name: CustomView
 * Time: 2019/4/24
 * Data: 晚么
 * Description:
 */
public class FormtLayout extends LinearLayout {

    public ImageView im_search;
    public ImageView im_send;
    public EditText et_tv;

    public FormtLayout(Context context) {
        this(context,null);
    }

    public FormtLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public FormtLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        inflate(context,R.layout.item,this);

        im_search = findViewById(R.id.im_search);
        im_send = findViewById(R.id.im_send);
        et_tv = findViewById(R.id.et_tv);

        im_search.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onSearch(et_tv.getText().toString());
            }
        });

        im_send.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onAisearch(et_tv.getText().toString());
            }
        });
    }
    private setSearch callback;

    public void setCallback(setSearch callback) {
        this.callback = callback;
    }

    interface setSearch{
        void onSearch(String result);

        void onAisearch(String result);
    }
}
