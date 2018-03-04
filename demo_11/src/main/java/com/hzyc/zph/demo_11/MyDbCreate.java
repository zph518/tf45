package com.hzyc.zph.demo_11;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Administrator on 2018/2/23.
 */
public class MyDbCreate extends SQLiteOpenHelper{

    private static final String DB_NAME = "data.db";
    private static final int VERSION = 2;

    public MyDbCreate(Context context) {
        super(context, DB_NAME, null, VERSION);
        Log.i("数据库消息","构造方法");
    }

    //建表建库
    //sqlite  不需要建库的  data.db
    //只需要建表了

    @Override
    public void onCreate(SQLiteDatabase db) {
        boolean bol = false;
        db.execSQL("create table person(id integer primary_key auto increment,name varchar(10))");
        bol =  true;
        Log.i("数据库消息","创建状态="+bol);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        boolean bol = false;
        db.execSQL("alter table person add age int(10)");
        bol =  true;
        Log.i("数据库消息","更新状态="+bol);
    }
}
