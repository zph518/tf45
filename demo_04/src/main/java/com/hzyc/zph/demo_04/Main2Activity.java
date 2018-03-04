package com.hzyc.zph.demo_04;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main2Activity extends AppCompatActivity {

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listView = (ListView) findViewById(R.id.listView);

        listView.setAdapter(new MyAdapter());
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Main2Activity.this, ""+position, Toast.LENGTH_SHORT).show();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //组件跳转
                Intent intent = new Intent(Main2Activity.this,Main3Activity.class);
                //跳转
                startActivity(intent);
            }
        });

    }
    public List<Map<String,Object>> getList(){
        //虚拟数据
        List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
        for(int i = 1;i<20;i++){
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("photo",R.drawable.buythg);
            map.put("name","商品"+i);
            map.put("price",0.1);
            map.put("bz","小米手机");
            map.put("rating",5);
            list.add(map);
        }
        return list;

    }

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return getList().size();
        }

        @Override
        public Object getItem(int position) {
            return getList().get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            //选择控件了
            //获取一个设计好的布局（适配器 效果砸门就可以控制了）
            //获取这个布局中的空间（位置已经设计好了）
            //list里面的数据装的空间中
            //view 代表所有控件的根类 （表示所有的显示效果  布局xml）
            //activiry.001.xml = view
            View view;  //xml文件
            if(convertView == null){
                //LayoutInflater布局填充器
                //通过activity类获取一个外部的布局文件
                view = LayoutInflater.from(Main2Activity.this).inflate(R.layout.image_text,null);
            }else{
                view = convertView;
            }

            //取出xml中的控件
            //

            ImageView photo = (ImageView) view.findViewById(R.id.photo);
            TextView name = (TextView) view.findViewById(R.id.name);
            TextView price = (TextView) view.findViewById(R.id.price);
            TextView bz = (TextView) view.findViewById(R.id.bz);
            RatingBar rating = (RatingBar) view.findViewById(R.id.ratingBar);

            photo.setImageResource(Integer.parseInt(getList().get(position).get("photo").toString()));
            name.setText(getList().get(position).get("name").toString());
            price.setText(getList().get(position).get("price").toString());
            bz.setText(getList().get(position).get("bz").toString());
            rating.setRating(Float.parseFloat(getList().get(position).get("rating").toString()));


            return view;
        }
    }
}
