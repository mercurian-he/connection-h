package sxh.connection.activity;

import android.app.Activity;
import android.app.ListActivity;
import android.content.ContentResolver;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import sxh.connection.R;
import sxh.connection.data.CardInfo;
import sxh.connection.data.Phone;
import sxh.connection.function.FunctionAccessor;
import sxh.connection.function.FunctionImpl;
import sxh.connection.R;

public class CardListActivity extends Activity {

    FunctionAccessor fa = new FunctionImpl();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_list);

               SimpleAdapter adapter = new SimpleAdapter(this,getData(),R.layout.card_list_item,
                new String[]{"img","name"},
                new int[] {R.id.card_li_img,R.id.card_li_name});

        ListView conListview = (ListView) findViewById(R.id.list_card_list);
        conListview.setAdapter(adapter);


    }
/*
    private List<String> getData(List<CardInfo> cards){
        List<String> data = new ArrayList<String>();
        for (Iterator<CardInfo> i = cards.iterator(); i.hasNext();){
            CardInfo card = i.next();
            Phone phone = card.get_phone_numbers().get(0);
            data.add(card.get_name() + phone.number);
        }
        return data;
    }
*/

    private List<Map<String,Object>>getData() {
        List<Map<String,Object>>list = new ArrayList<Map<String,Object>>();
        ContentResolver resolver = this.getContentResolver();
        List<CardInfo> cards = fa.get_phone_contact(resolver);

        //should load img and name from fa
        Map<String,Object>map = new HashMap<String,Object>();
        for (Iterator<CardInfo> i = cards.iterator(); i.hasNext();){
            CardInfo card = i.next();
            String name = card.get_name();
            map.put("img",R.drawable.stub);
            map.put("name", name);
            list.add(map);
            map = new HashMap<String,Object>();
        }

        return list;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_card_list, menu);
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
}
