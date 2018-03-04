package com.hzyc.zph.demo_10;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private Button AleatDialog,AleatDialogKz,datePickerDialog,timePickerDialog,progressDialog;
    private String [] data = {"喜欢","不喜欢","一般般"};
    //公共的事件处理
    private DialogInterface.OnClickListener dc = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which){
                case -2:
                    Toast.makeText(MainActivity.this, "喜欢"+which, Toast.LENGTH_SHORT).show();
                    break;
                case -1:
                    Toast.makeText(MainActivity.this, "不喜欢"+which, Toast.LENGTH_SHORT).show();
                    break;
                case -3:
                    Toast.makeText(MainActivity.this, "一般般"+which, Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AleatDialog = (Button) findViewById(R.id.AleatDialog);
        AleatDialogKz = (Button) findViewById(R.id.AleatDialogKz);
        datePickerDialog = (Button) findViewById(R.id.datePickerDialog);
        timePickerDialog = (Button) findViewById(R.id.timePickerDialog);
        progressDialog = (Button) findViewById(R.id.progressDialog);

        AleatDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setIcon(R.drawable.image1)
                        .setTitle("问卷调查")
                        .setMessage("你喜欢好莱坞电影吗？")
                        .setNegativeButton("喜欢", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "喜欢"+which, Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setPositiveButton("不喜欢", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "不喜欢"+which, Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNeutralButton("一般般", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "一般般"+which, Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();*/
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setIcon(R.drawable.image1)
                        .setTitle("问卷调查")
                        .setMessage("你喜欢好莱坞电影吗？")
                        .setNegativeButton("喜欢",dc)
                        .setPositiveButton("不喜欢",dc)
                        .setNeutralButton("一般般",dc);

                //得到当前弹出窗口的主题
                AlertDialog dialog = builder.create();
                dialog.show();

                //写代码修改控件的主题
                Window dialogwindow = dialog.getWindow();
                WindowManager m = dialogwindow.getWindowManager();
                Display d=  m.getDefaultDisplay();
                WindowManager.LayoutParams layout =  dialogwindow.getAttributes();
                layout.width = (int) (d.getWidth() * 0.6);
                layout.height = (int)(d.getHeight() * 0.4);
                layout.alpha = 0.5f;
                layout.gravity = Gravity.BOTTOM;
                dialogwindow.setAttributes(layout);
            }
        });

        AleatDialogKz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setIcon(R.drawable.image1)
                        .setTitle("问卷调查")
                        //多选控件
                        .setMultiChoiceItems(data, new boolean[]{true,false,true}, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                Toast.makeText(MainActivity.this, ""+which, Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();*/
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setIcon(R.drawable.image1)
                        .setTitle("问卷调查")      //标题
                        .setView(R.layout.layout) //引入控件
                        .show();
            }
        });
        datePickerDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //获取当前的系统时间   远比date要强大（日历类能计算时间  10，30天后是哪天）
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);             //获取当前的年份
                int month = calendar.get(Calendar.MONTH);           //获取当前的月份
                int day = calendar.get(Calendar.DAY_OF_MONTH);     //获取当前的月份的某天

                DatePickerDialog dp = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        String sj = year +"-"+ (monthOfYear+1) +"-"+ dayOfMonth;
                        Toast.makeText(MainActivity.this, sj, Toast.LENGTH_SHORT).show();
                    }
                },year,month,day);
                dp.show();
            }
        });

        timePickerDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);         //获取当前的小时
                int minute = calendar.get(Calendar.MINUTE);           //获取当前的分钟

                TimePickerDialog tp = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        String sj = hourOfDay+":"+minute;
                        Toast.makeText(MainActivity.this, ""+sj, Toast.LENGTH_SHORT).show();
                    }
                },hourOfDay+8,minute,false);
                tp.show();
            }
        });

        progressDialog.setOnClickListener(new View.OnClickListener() {
            @Override                                                               //进度条
            public void onClick(View v) {
                final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setIcon(R.drawable.image1);
                progressDialog.setTitle("请等待");
                progressDialog.setMessage("正在加载...");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.show();

                progressDialog.setMax(100);
                progressDialog.setProgress(50);

                //进度条改成水平的
                //大小   max  总大小
                //当前的进度是多少
                //让他会自己动  (自己动  程序操作它  android 中开辟一个线程)
                //Android  默认只有主线程

                /*int i = 1;
                while(i<=100){
                    progressDialog.setProgress(i);
                    i++;
                }*/

                //学习Java的线程
                //线程各种方法
                //调度任务
                //文章线程池
                class MyThread extends Thread{
                    int i = 0;
                    @Override
                    public void run() {
                        while (true){
                            try {
                                sleep(1000);        //休眠   睡一会再走
                                progressDialog.setProgress(i+=10);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            if(i==100){
                                break;
                            }
                        }
                    }
                }
                new MyThread().start();   //开始工作
            }
        });
    }
}
