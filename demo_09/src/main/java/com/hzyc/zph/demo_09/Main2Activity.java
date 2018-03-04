package com.hzyc.zph.demo_09;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> arrayAdapter;
    private Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listView = (ListView) findViewById(R.id.listView);
        button2 = (Button) findViewById(R.id.button2);
        arrayAdapter = new ArrayAdapter<String>(Main2Activity.this,R.layout.support_simple_spinner_dropdown_item,
                new String[]{"数据1","数据2","数据3","数据4","数据5"});
        listView.setAdapter(arrayAdapter);

        registerForContextMenu(listView);  //注册上下文菜单   这种菜单通过空间触发  长点击事件

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this,Main3Activity.class);
                startActivity(intent);
            }
        });
    }

    //实现创建上下文菜单的方法
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.one,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    //实现菜单选择的方法
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.save:
                Toast.makeText(Main2Activity.this, "保存", Toast.LENGTH_SHORT).show();
                break;
            case R.id.update:
                Toast.makeText(Main2Activity.this, "编辑", Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete:
                Toast.makeText(Main2Activity.this, "删除", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onContextItemSelected(item);
    }
}
