package com.hzyc.zph.demo_11;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    private Button createDataBase,upDateBase,editor,call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        createDataBase = (Button) findViewById(R.id.createDataBase);
        upDateBase = (Button) findViewById(R.id.upDateBase);
        editor = (Button) findViewById(R.id.editor);
        call = (Button) findViewById(R.id.call);

        createDataBase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDbCreate myDbCreate = new MyDbCreate(Main2Activity.this);//数据库建库工具类对象
                //激活数据库 （会调用onCreate 方法   只会调用一次  一个版本的范围内  只能激活一次）
                //data/data/应用包/database/ db 拿出来无法正常查看（数据库文件）
                //GUI（sqlite  图形化界面）


                //激活数据库  如果20480都装满了   允许继续查询数据库  （不能更新）
                SQLiteDatabase sqLiteDatabase = myDbCreate.getReadableDatabase();

                //sqLiteDatabase.execSQL("insert into person (name) values ('张三')");
                //sqLiteDatabase.execSQL("insert into person (name) values (?)",new Object[]{"李四"});
                //如果20480装满了  就不能在使用数据库了
                //SQLiteDatabase sqLiteDatabase = myDbCreate.getWritableDatabase();
            }
        });
        upDateBase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDbCreate myDbCreate = new MyDbCreate(Main2Activity.this);
                SQLiteDatabase sqLiteDatabase = myDbCreate.getReadableDatabase();

                sqLiteDatabase.execSQL("update person set age = 23 where id = 1");
                sqLiteDatabase.execSQL("update person set age = 22 where id = 2");
            }
        });

        editor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDbCreate myDbCreate = new MyDbCreate(Main2Activity.this);
                SQLiteDatabase sqLiteDatabase = myDbCreate.getReadableDatabase();

                //实现增删改
                //select不好使的
                //sqLiteDatabase.execSQL("insert delete update ? = 22");
/*
                sqLiteDatabase.execSQL("insert into person (name,age) values ('王五',20)");
                sqLiteDatabase.execSQL("insert into person (name,age) values ('薛六',20)");
                sqLiteDatabase.execSQL("insert into person (name,age) values ('郑琦',20)");*/

                //查询
                //cuesor  取出一列的值   向下一行一行滚动
                Cursor cursor = sqLiteDatabase.rawQuery("select * from person ",null);
                //Cursor cursor1 = sqLiteDatabase.rawQuery("select from person where name = ?",new String[]{"张三"});

                while(cursor.moveToNext()){
                    String name = cursor.getString(1);
                    String age = cursor.getString(2);
                    Log.i("数据库信息",name+"@@"+age);

                }
            }
        });
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:10010"));
                if (ActivityCompat.checkSelfPermission(Main2Activity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(intent);
            }
        });
    }
}
