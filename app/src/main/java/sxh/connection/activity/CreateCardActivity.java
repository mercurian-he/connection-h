package sxh.connection.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import sxh.connection.R;
import sxh.connection.function.FunctionAccessor;
import sxh.connection.function.FunctionImpl;

public class CreateCardActivity extends Activity {

    FunctionAccessor fa = new FunctionImpl();
    private List<String> items = new ArrayList<String>();
    private SimpleAdapter adapter;
    private List<Map<String,Object>>list = new ArrayList<Map<String,Object>>();
    ListView conListview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        items.add("姓名");
        items.add("移动电话");
        items.add("E-mail");
        items.add("职业");
        items.add("公司");
        items.add("家庭住址");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_card);
        getData();


            adapter = new SimpleAdapter(this,list,R.layout.create_card_item,
                new String[]{"item","value"},
                new int[] {R.id.create_item_name,R.id.create_item_value});

        conListview = (ListView) findViewById(R.id.edit_info);
        conListview.setAdapter(adapter);

        conListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                @SuppressWarnings("unchecked")
                //获取被点击的item所对应的数据
                        HashMap<String,Object> map = (HashMap<String, Object>) parent.getItemAtPosition(position);

            }
        });

    }

    private List<Map<String,Object>> getData() {

       //add names to adapter
        Map<String,Object>map = new HashMap<String,Object>();
        for (Iterator<String> i = items.iterator(); i.hasNext();){
            String str = (String)i.next();
            map.put("item",str);
            list.add(map);
            //refresh map
            map = new HashMap<String,Object>();
        }

        return list;
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_card, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //add new kind of information
    public void add(View view) {

            final EditText et=new EditText(this);
            //设置用户密码的方法
            new AlertDialog.Builder(this).setTitle("新项目").setView(
                    et).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // 点击确定按钮后得到输入的值，保存
                    String str = et.getText().toString();
                    items.add(str);
                    Map map = new HashMap<String,Object>();
                    map.put("item", str);
                    list.add(map);
                    //refresh map

                    adapter.notifyDataSetChanged();

                }
            })

                    .setNegativeButton("取消", null).show();


    }

    public void delete(View view) {

    }

    //submit edit
    public void submit(View view) {
        //
        FunctionAccessor fa = new FunctionImpl();

        //read data from textview
        List<String>result = new ArrayList<String>();
        int size = conListview.getChildCount();
        for(int i = 0; i < size;i++)
        {
            LinearLayout layout = (LinearLayout)conListview.getChildAt(i);
            EditText et = (EditText)layout.findViewById(R.id.create_item_value);
            result.add(et.getText().toString());
        }

        fa.create_card();
        fa.set_card_name(result.get(0));
        fa.add_card_phone_number("移动电话", result.get(1));
        fa.set_card_email(result.get(2));
        fa.set_card_address((result.get(5)));
        fa.modify_edited_card();

        //jump
        Intent intent = new Intent(this, CardHolderActivity.class);
        startActivity((intent));

    }



}
