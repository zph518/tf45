package com.hzyc.zph.demo_08;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = editText.getText().toString().trim();
                //直接使用意图
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                /*intent.putExtra("name",value);
                startActivity(intent);*/

                //javaBean
                Bundle bundle = new Bundle();
                bundle.putString("name",value);
                bundle.putInt("age",20);
                bundle.putString("sex","男");
                intent.putExtras(bundle);
                //startActivity(intent);  不期待结果的
                startActivityForResult(intent,0);//如果结果回来了就会激活另一个函数
                overridePendingTransition(R.anim.tip_right,R.anim.tip_left);//页面跳转
            }
        });
        SharedPreferences spf = getSharedPreferences("data",0);
        String name = spf.getString("name","nothing");
        if(!"nothing".equals(name)){
            editText.setText(name);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 0 && resultCode == 200){
            Toast.makeText(MainActivity.this, ""+data.getStringExtra("back"), Toast.LENGTH_SHORT).show();
        }
    }

    //保护输入现场
    //开启杀死应用保护模式（保护了数据就永不丢失）
    //1.xml  2.io文档   3.数据库sqlite  4.web文档


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //判断保护的值是否存在
        String value = editText.getText().toString().trim();

        if("".equals(value)){
            Toast.makeText(MainActivity.this, "buxuyaobaohu", Toast.LENGTH_SHORT).show();
        }else{
            //在手机中检索有没有data文件  如果没有就新建  有就获取
            SharedPreferences spf = getSharedPreferences("data",0);
            //存储   编辑
            SharedPreferences.Editor editor = spf.edit();
            editor.putString("name",value);
            boolean bol = editor.commit();
            Toast.makeText(MainActivity.this, "保护成功"+true, Toast.LENGTH_SHORT).show();

            //存到哪了

        }


    }
}
