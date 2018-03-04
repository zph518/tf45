package lcb.hzyc.com.contacts;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Message;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Map;

public class PersonList extends AppCompatActivity {
    private FloatingActionButton add;
    Cursor cursor;
    List<Map<String,String>> list;
    RelativeLayout rel;
    TextView textView;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        add= (FloatingActionButton) findViewById(R.id.add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersonList.this,AddPerson.class);
                startActivity(intent);
                PersonList.this.finish();
            }
        });

        DbUtils dbUtils = new DbUtils(PersonList.this);
        SQLiteDatabase sqLiteDatabase=dbUtils.getWritableDatabase();
        cursor=sqLiteDatabase.rawQuery("select * from person",null);
        rel= (RelativeLayout) findViewById(R.id.addlayout);
        Log.i("123", String.valueOf(cursor.getColumnCount()));
        if(cursor.getCount()==0){
            textView=new TextView(PersonList.this);
            textView.setText("无联系人");
            textView.setTextSize(30);
            textView.setId(R.id.text_view);
            textView.setTextColor(this.getResources().getColor(R.color.colottv));
            rel.addView(textView);

       }else{
            CursorUtils cursorUtils=new CursorUtils();
            list=cursorUtils.cursorToList(cursor);
            listView=new ListView(PersonList.this);
            listView.setId(R.id.list_view);
            rel.addView(listView);
            listView.setAdapter(new MyAdapter());
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent it=new Intent(PersonList.this,ShowDetail.class);
                    Bundle bundle=new Bundle();
                    bundle.putString("id",list.get(position).get("id"));
                    bundle.putString("name",list.get(position).get("name"));
                    bundle.putString("phone",list.get(position).get("phone"));
                    bundle.putString("image",list.get(position).get("image"));
                    it.putExtras(bundle);
                    startActivityForResult(it,200);

                }
            });
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        rel.removeView(listView);
        rel.removeView(textView);
        DbUtils dbUtils = new DbUtils(PersonList.this);
        SQLiteDatabase sqLiteDatabase=dbUtils.getWritableDatabase();
        cursor=sqLiteDatabase.rawQuery("select * from person",null);
        rel= (RelativeLayout) findViewById(R.id.addlayout);
        if(cursor.getCount()==0){
            textView=new TextView(PersonList.this);
            textView.setText("无联系人");
            textView.setTextSize(30);
            textView.setTextColor(this.getResources().getColor(R.color.colottv));
            textView.setGravity(Gravity.CENTER);
            rel.addView(textView);

        }else{
            CursorUtils cursorUtils=new CursorUtils();
            list=cursorUtils.cursorToList(cursor);
            listView=new ListView(PersonList.this);
            rel.addView(listView);
            listView.setAdapter(new MyAdapter());
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent it=new Intent(PersonList.this,ShowDetail.class);
                    Bundle bundle=new Bundle();
                    bundle.putString("id",list.get(position).get("id"));
                    bundle.putString("name",list.get(position).get("name"));
                    bundle.putString("phone",list.get(position).get("phone"));
                    bundle.putString("image",list.get(position).get("image"));
                    it.putExtras(bundle);
                    startActivityForResult(it,200);

                }
            });
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 200 && resultCode == 400){
            //new GameThread().run();
            Toast.makeText(PersonList.this, "删除成功", Toast.LENGTH_SHORT).show();
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_person_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view;
            if(convertView==null){
                view= LayoutInflater.from(PersonList.this).inflate(R.layout.image_text,null);
            }else{
                view=convertView;
            }
            TextView name = (TextView) view.findViewById(R.id.imgname);
            name.setText(list.get(position).get("name").toString());
            return view;
        }
    }



}
