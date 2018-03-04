package lcb.hzyc.com.contacts;

import android.database.Cursor;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017-11-04.
 */
public class CursorUtils {


    public List<Map<String,String>> cursorToList(Cursor cursor){
        List<Map<String,String>> list = new ArrayList<Map<String,String>>();
        //表的总列数
        int count = cursor.getColumnCount();
        while (cursor.moveToNext()){
            Map<String,String> map = new HashMap<String,String>();
            for(int i = 0; i<count; i++){
                String columnName = cursor.getColumnName(i);
                String columnValue = cursor.getString(cursor.getColumnIndex(columnName));
                map.put(columnName,columnValue);
            }
            list.add(map);
        }
        return list;
    }

    public List<Map<String,Object>> cursorToListForObject(Cursor cursor){
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        //表的总列数
        int count = cursor.getColumnCount();
        while (cursor.moveToNext()){
            Map<String,Object> map = new HashMap<String,Object>();
            for(int i = 0; i<count; i++){
                String columnName = cursor.getColumnName(i);
                Object columnValue = null;
                if(cursor.getType(i) == Types.VARCHAR){
                    columnValue = cursor.getString(i);
                }else if(cursor.getType(i) == Types.INTEGER){
                    columnValue = cursor.getInt(i);
                }
                map.put(columnName,columnValue);
            }
            list.add(map);
        }
        return list;
    }
}
