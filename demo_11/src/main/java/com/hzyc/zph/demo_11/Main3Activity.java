package com.hzyc.zph.demo_11;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main3Activity extends AppCompatActivity {

    private ImageView addperson;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        addperson = (ImageView) findViewById(R.id.addperson);
        listView = (ListView) findViewById(R.id.listView);

        addperson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main3Activity.this, Main5Activity.class);
                startActivity(intent);
            }
        });
        listView.setAdapter(new MyAdapter());
    }

    class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return null;
        }
    }
    public List<Map<String,String>> cursorToList(Cursor cursor){
        List<Map<String,String>> list = new ArrayList<Map<String,String>>();
        //表的总列数
        int count = cursor.getColumnCount();
        while (cursor.moveToNext()){
            Map<String,String> map = new HashMap<String,String>();
            for(int i = 0; i<count; i++){
                String columnName = cursor.getColumnName(i);
                String columnValue = cursor.getString(cursor.getColumnIndex(columnName));
                map.put(columnName,columnValue);
            }
            list.add(map);
        }
        return list;
    }
}
