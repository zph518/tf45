package lcb.hzyc.com.contacts;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class ShowDetail extends AppCompatActivity {
    private ImageView detailphoto;
    private TextView detailphone;
    private TextView detailname;
    private Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);
        detailphoto= (ImageView) findViewById(R.id.detailphoto);
        detailphone= (TextView) findViewById(R.id.detailphone);
        detailname= (TextView) findViewById(R.id.detailname);

        Intent intent=getIntent();
        bundle= intent.getExtras();
        detailname.setText(bundle.getString("name"));
        detailphone.setText(bundle.getString("phone"));
        if(!"no".equals(bundle.getString("image"))){
            Bitmap bitmap = BitmapFactory.decodeFile(bundle.getString("image"));
            detailphoto.setImageBitmap(bitmap);
        }



        detailphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+detailphone.getText().toString().trim()));
                if (ActivityCompat.checkSelfPermission(ShowDetail.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        detailphoto= (ImageView) findViewById(R.id.detailphoto);
        detailphone= (TextView) findViewById(R.id.detailphone);
        detailname= (TextView) findViewById(R.id.detailname);

        detailname.setText(bundle.getString("name"));
        detailphone.setText(bundle.getString("phone"));
        if(!"no".equals(bundle.getString("image"))){
            Bitmap bitmap = BitmapFactory.decodeFile(bundle.getString("image"));
            detailphoto.setImageBitmap(bitmap);
        }



        detailphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+detailphone.getText().toString().trim()));
                if (ActivityCompat.checkSelfPermission(ShowDetail.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1 && resultCode == 2){
            //new GameThread().run();
            bundle=data.getExtras();
            Toast.makeText(ShowDetail.this, "修改成功", Toast.LENGTH_SHORT).show();
        }

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        //指明菜单使用的文件
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.one,menu);
        return super.onCreateOptionsMenu(menu);
    }

    //2.实现菜单的选择和跳转
    //可以在菜单被点击的时候调用
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id){
            case R.id.update :
                Intent intent1=new Intent(ShowDetail.this,UpdateDetail.class);
                intent1.putExtras(bundle);
                startActivityForResult(intent1,1);
                break;
            case R.id.delete :
                DbUtils dbUtils = new DbUtils(ShowDetail.this);
                SQLiteDatabase sqLiteDatabase=dbUtils.getWritableDatabase();
                sqLiteDatabase.execSQL("delete from person where id="+bundle.getString("id"));
                sqLiteDatabase.close();
                Intent intent = new Intent(ShowDetail.this,PersonList.class);
                setResult(400,intent);
                ShowDetail.this.finish();
                break;

        }

        return super.onOptionsItemSelected(item);
    }

}
