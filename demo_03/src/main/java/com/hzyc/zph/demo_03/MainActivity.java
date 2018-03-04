package com.hzyc.zph.demo_03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private GridView gridView; //棋盘
    private int[] data = {R.drawable.buythg,R.drawable.buythg,R.drawable.buythg,R.drawable.buythg,R.drawable.buythg,
            R.drawable.buythg,R.drawable.buythg,R.drawable.buythg,R.drawable.buythg,R.drawable.buythg,R.drawable.buythg,
            R.drawable.buythg,R.drawable.buythg,R.drawable.buythg,R.drawable.buythg,R.drawable.buythg,R.drawable.buythg,
            R.drawable.buythg,R.drawable.buythg,R.drawable.buythg,R.drawable.buythg,R.drawable.buythg};
            //创造数据
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView) findViewById(R.id.gridView);
        //具体如何放东西
        //需要使用适配器
        //gridView 布局使用是适配器  条用getView方法把得到的控件放到   网格布局中

        gridView.setAdapter(new MyAdapter());

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //组件跳转
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                //跳转
                startActivity(intent);
            }
        });

    }

    //要有数据   自己虚拟数据   data
    //要有适配器
    //写成内部类
    class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return data.length;  //返回数据长度 （总数）
        }

        @Override
        public Object getItem(int position) {
            return data[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ImageView imageView;
            if(convertView == null){
                imageView = new ImageView(MainActivity.this);
                imageView.setPadding(6,6,6,6);

            }else{
                imageView = (ImageView) convertView;
            }
            imageView.setImageResource(data[position]);

            return imageView;
        }
    }
}
