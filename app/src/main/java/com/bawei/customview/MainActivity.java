package com.bawei.customview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FormtLayout.setSearch {

    private FormtLayout formtLayout;
    public MyView flow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        formtLayout = findViewById(R.id.form_layout);

        flow = findViewById(R.id.fl);
        formtLayout.setCallback(this);
    }

    @Override
    public void onSearch(String result) {
        Toast.makeText(this,result,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAisearch(String result) {
        Toast.makeText(this,result,Toast.LENGTH_SHORT).show();

        Button inflate = (Button) View.inflate(this, R.layout.flow, null);
            inflate.setText(result);
            inflate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this,((Button)v).getText().toString(),Toast.LENGTH_SHORT).show();
                }
            });
            flow.addView(inflate);
    }



}
