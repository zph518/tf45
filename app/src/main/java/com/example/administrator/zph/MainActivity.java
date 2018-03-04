package com.example.administrator.zph;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化  找到加载到xml中的具体控件  通过ID属性
        button = (Button) findViewById(R.id.one);

        //添加单击事件
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //输出一句话
                Toast.makeText(MainActivity.this, "我爱你中国", Toast.LENGTH_SHORT).show();
            }
        });

        };


    }

