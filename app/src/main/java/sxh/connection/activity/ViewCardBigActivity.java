package sxh.connection.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import sxh.connection.R;
import sxh.connection.adapter.ViewPagerAdapter;
import sxh.connection.data.CardInfo;
import sxh.connection.function.FunctionAccessor;
import sxh.connection.function.FunctionImpl;

/**
 * Created by Eleanor on 2015/6/14.
 */



public class ViewCardBigActivity extends Activity {

    FunctionAccessor fa = new FunctionImpl();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initViewPager();


    }

    private void initViewPager(){
        setContentView(R.layout.view_card_big_pager);

        ViewPager viewPager = (ViewPager)findViewById(R.id.viewPager);

        View view1 = LayoutInflater.from(this).inflate(R.layout.view_card_big, null);
        View view2 = LayoutInflater.from(this).inflate(R.layout.view_card_list, null);

        getInfoPage1(view1);
        getInfoPage2(view2);


        ArrayList<View> views = new ArrayList<View>();
        views.add(view1);
        views.add(view2);

        ViewPagerAdapter adapter = new ViewPagerAdapter();
        adapter.setViews(views);
        viewPager.setAdapter(adapter);
    }

    private void getInfoPage1(View view){
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        CardInfo card = fa.get_card_info(id);

        /**
         * test

        fa.create_card();
        fa.set_card_name("testName");
        fa.set_card_address("testAddress");
        CardInfo card = fa.get_current_card_info();
         */
        TextView textView = (TextView)view.findViewById(R.id.big_card_name);
        textView.setText(card.get_name());

        String description = card.get_address();
        textView = (TextView)view.findViewById(R.id.big_card_description);
        textView.setText(description);


    }

    private void getInfoPage2(View view){

    }
}





