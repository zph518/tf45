package com.hzyc.zph.demo_12;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button createDataBase,updateData;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createDataBase = (Button) findViewById(R.id.createDataBase);
        updateData = (Button) findViewById(R.id.updateData);

        createDataBase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDbCreate myDbCreate = new MyDbCreate(MainActivity.this);
                //激活数据库   获取操作对象
                SQLiteDatabase sqLiteDatabase = myDbCreate.getReadableDatabase();
                //sqLiteDatabase.execSQL("静态语句");
                //sqLiteDatabase.execSQL("静态语句 ？"，new Object[]{"a"});

                //查询
                /*Cursor cursor = sqLiteDatabase.rawQuery("静态语句",new String[]{});

                while(cursor.moveToNext()){
                    int id = cursor.getInt(cursor.getColumnIndex("name"));

                }*/
            }
        });
        updateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDbCreate myDbCreate = new MyDbCreate(MainActivity.this);
                //激活数据库   获取操作对象
                SQLiteDatabase sqLiteDatabase = myDbCreate.getReadableDatabase();

                /*ContentValues contentValues = new ContentValues();
                contentValues.put("name","李四");
                contentValues.put("age",22);*/

                //i是我们添加成功之后   那行数据的ID
                /*long i = sqLiteDatabase.insert("person1",null,contentValues);
                Log.i("数据库信息","@@@"+i);*/

                //修改
                /*ContentValues contentValues = new ContentValues();
                contentValues.put("name","王五");
                contentValues.put("age",21);

                long i = sqLiteDatabase.update("person1",contentValues,"where id =?",new String[]{"1"});*/

                //sqLiteDatabase.delete("person1","where id = ?",new String[]{"1"});

                //Cursor cursor = sqLiteDatabase.query("person",new String[]{"name","age"},"name = ?",new String[]{"张三"},"name",null,"id desc","0,3");
                Cursor cursor = sqLiteDatabase.query("person1",new String[]{"name","age"},null,null,null,null,null,null);
                while(cursor.moveToNext()){
                    String name = cursor.getString(cursor.getColumnIndex("name"));
                    int age = cursor.getInt(cursor.getColumnIndex("age"));
                    Log.i("数据库信息",name+"@@@"+age);
                }
            }
        });
    }
}
