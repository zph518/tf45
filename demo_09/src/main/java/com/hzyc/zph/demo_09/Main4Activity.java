package com.hzyc.zph.demo_09;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;


public class Main4Activity extends AppCompatActivity {


        private ImageView imageView;
        private Button btnAlpha,btnScale,btnTranslate,btnRotate,button5;
        private Animation myAnimation;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main4);
            imageView = (ImageView) findViewById(R.id.imageView);
            btnAlpha = (Button) findViewById(R.id.btnAlpha);
            btnScale = (Button) findViewById(R.id.btnScale);
            btnTranslate = (Button) findViewById(R.id.btnTranslate);
            btnRotate = (Button) findViewById(R.id.btnRotate);
            button5 = (Button) findViewById(R.id.button5);

            btnAlpha.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    myAnimation = AnimationUtils.loadAnimation(Main4Activity.this,R.anim.my_alpha);
                    imageView.startAnimation(myAnimation);
                }
            });
            btnScale.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    myAnimation = AnimationUtils.loadAnimation(Main4Activity.this,R.anim.my_scale);
                    imageView.startAnimation(myAnimation);
                }
            });
            btnTranslate.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    myAnimation = AnimationUtils.loadAnimation(Main4Activity.this,R.anim.my_translate);
                    imageView.startAnimation(myAnimation);
                }
            });
            btnRotate.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    myAnimation = AnimationUtils.loadAnimation(Main4Activity.this,R.anim.my_rotate);
                    imageView.startAnimation(myAnimation);
                }
            });
            button5.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Main4Activity.this,MainActivity.class);
                    startActivity(intent);
                }
            });


        }

        /*
        *  初始化组件
        */


        /*
        *   初始化数据
        */

        /*private void initData(){
            btnAlpha.setOnClickListener(this);
            btnScale.setOnClickListener(this);
            btnTranslate.setOnClickListener(this);
            btnRotate.setOnClickListener(this);
        }*/

        /*@Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btnAlpha:
                    myAnimation = AnimationUtils.loadAnimation(this,R.anim.my_alpha);
                    imageView.startAnimation(myAnimation);
                    break;
                case R.id.btnScale:
                    myAnimation = AnimationUtils.loadAnimation(this,R.anim.my_scale);
                    imageView.startAnimation(myAnimation);
                    break;
                case R.id.btnTranslate:
                    myAnimation = AnimationUtils.loadAnimation(this,R.anim.my_translate);
                    imageView.startAnimation(myAnimation);
                    break;
                case R.id.btnRotate:
                    myAnimation = AnimationUtils.loadAnimation(this,R.anim.my_rotate);
                    imageView.startAnimation(myAnimation);
                    break;
            }
        }*/


}
