package com.hzyc.zph.demo_02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkbox;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void check(View view){
        int id = view.getId();

        switch (id){
            case R.id.lq:
                Toast.makeText(MainActivity.this, "篮球", Toast.LENGTH_SHORT).show();
                break;
            case R.id.zq:
                Toast.makeText(MainActivity.this, "足球", Toast.LENGTH_SHORT).show();
                break;
            case R.id.pq:
                Toast.makeText(MainActivity.this, "排球", Toast.LENGTH_SHORT).show();
                break;
            case R.id.yyq:
                Toast.makeText(MainActivity.this, "羽毛球", Toast.LENGTH_SHORT).show();
                break;

        }
    }
}
