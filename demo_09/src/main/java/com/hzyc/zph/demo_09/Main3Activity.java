package com.hzyc.zph.demo_09;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    private ActionMode actionMode;
    private ListView listView2;
    private ArrayAdapter<String> arrayAdapter;
    private Button button3;

    //实现内部类
    private ActionMode.Callback callback = new ActionMode.Callback(){

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.one,menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            int id = item.getItemId();
            switch (id){
                case R.id.save:
                    Toast.makeText(Main3Activity.this, "保存", Toast.LENGTH_SHORT).show();
                    mode.finish();
                    return true;
                case R.id.update:
                    Toast.makeText(Main3Activity.this, "编辑", Toast.LENGTH_SHORT).show();
                    mode.finish();
                    return true;
                case R.id.delete:
                    Toast.makeText(Main3Activity.this, "删除", Toast.LENGTH_SHORT).show();
                    mode.finish();
                    return true;
            }
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            actionMode = null;  //释放了
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        listView2 = (ListView) findViewById(R.id.listView2);
        button3 = (Button) findViewById(R.id.button3);
        arrayAdapter = new ArrayAdapter<String>(Main3Activity.this,R.layout.support_simple_spinner_dropdown_item,
                new String[]{"数据1","数据2","数据3","数据4"});

        listView2.setAdapter(arrayAdapter);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main3Activity.this,Main3_5Activity.class);
                startActivity(intent);
            }
        });

        //注册 actionMode

        listView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                if(actionMode != null){
                    return false;
                }

                actionMode = Main3Activity.this.startActionMode(callback);
                return true;
            }
        });

    }
}
