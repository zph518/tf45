package lcb.hzyc.com.contacts;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Administrator on 2017-10-29.
 * 使用sqlite方法 数据 微型数据  适合存储20M一下的数据
 * 使用SQL语句 SQL语法 做程序 （语法类似于mysql）
 * data.db 库文件 （包含一个系统的table  自己建立的tbale） < mysql 中的一个table
 * 每一个应用都会内置一个.db文件 == sqlite数据
 * android 数据是与APP内部应用 不会对外开放的   每个APP 都会有自己的SQLite  （私有的默认不对外开放）
 */
public class DbUtils extends SQLiteOpenHelper {


    private static final String DB_NAME = "data.db";
    private static final int VERSION = 2;

    public DbUtils(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    //建立数据库
    //第一执行工具类的时候调用  只调用一次 用来建立自己的table表
    //SQLiteDatabase db  书写和发送sql的对象  直接执行sql语句
    @Override
    public void onCreate(SQLiteDatabase db) {

        boolean bol = false;
        Log.i("数据库信息","开始执行onCreate");
        db.execSQL("create table person (id integer primary key autoincrement,name varchar(10),phone varchar(10),image varchar(500))");
        bol = true;
        Log.i("数据库信息","是否成功="+bol);
    }

    //更新数据库
    //当我们需要变动表的结构的时候  调用这个方法  oldVERSION < VERSION
    //VERSION 更新的 oldVERSION < newVERSION
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       /* boolean bol = false;
        Log.i("数据库信息","开始执行onUpgrade");
        db.execSQL("alter table person add age int(10)");
        bol = true;
        Log.i("数据库信息","是否成功="+bol);*/
    }
}
