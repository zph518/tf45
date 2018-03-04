package com.hzyc.zph.demo_08;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    private EditText editText2;
    private Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        editText2 = (EditText) findViewById(R.id.editText2);
        button2 = (Button) findViewById(R.id.button2);
        //接值（只接一遍）

        Intent intent = getIntent();
        /*String value = intent.getStringExtra("name");
        editText2.setText(value);*/

        Bundle bundle = intent.getExtras();
        String name = bundle.getString("name");
        int age = bundle.getInt("age");
        String sex = bundle.getString("sex");
        editText2.setText(name+"--"+age+"--"+sex);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String backValue = editText2.getText().toString();
                //反向意图
                Intent intent1 = new Intent(Main2Activity.this,MainActivity.class);
                intent1.putExtra("back",backValue);
                setResult(200,intent1);
                Main2Activity.this.finish();//关闭
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
