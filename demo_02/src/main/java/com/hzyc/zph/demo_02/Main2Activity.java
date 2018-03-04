package com.hzyc.zph.demo_02;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imageView = (ImageView) findViewById(R.id.imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //imageView.setImageBitmap(Bitmap);
                imageView.setImageResource(R.drawable.image2);

                //调试程序 （输出一些信息）
                //显示信息  不适合调试
                //
                /*for(int i = 1;i<10; i++){
                    Toast.makeText(Main2Activity.this, "asdsad", Toast.LENGTH_SHORT).show();//排序输出
                }*/

                //日志猫  logcat

            }
        });

    }
}
