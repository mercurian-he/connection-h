package sxh.connection.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import sxh.connection.R;

/**
 * Created by Eleanor on 2015/6/14.
 */
public class ApplicationActivity extends Activity implements AdapterView.OnItemClickListener{
    private GridView gridView;
    private String IMAGE_ITEM = "imgage_item";
    private String TEXT_ITEM = "text_item";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.application);

        gridView = (GridView) findViewById(R.id.gridView);

        SimpleAdapter simpleAdapter = new SimpleAdapter(this,
                getGridViewData(),
                R.layout.application_item,
                new String[] {IMAGE_ITEM, TEXT_ITEM},
                new int[] {R.id.itemImage, R.id.itemText});

        gridView.setAdapter(simpleAdapter);
        gridView.setOnItemClickListener(this);

    }

    private List<HashMap<String, Object>> getGridViewData(){
        List<HashMap<String, Object>> list = new ArrayList<>();
        int num = 0;
        for (int i = 0; i < num; i++){
            HashMap<String, Object> map = new HashMap<>();
            //map.put(IMAGE_ITEM, img);
            //map.put(TEXT_ITEM, txt);
            list.add(map);
        }

        return list;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long orwid){
        HashMap<String, Object> item = (HashMap<String, Object>) adapterView.getItemAtPosition(position);

        String itemText = (String) item.get(TEXT_ITEM);
        Object object = item.get(IMAGE_ITEM);


    }


}
