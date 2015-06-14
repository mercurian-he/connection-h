package sxh.connection.adapter;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;

import java.util.ArrayList;

/**
 * Created by Eleanor on 2015/6/14.
 */
public class ViewPagerAdapter extends PagerAdapter {
    private ArrayList<View> views;

    public void setViews(ArrayList<View> views) {
        this.views = views;
    }
    @Override
    public int getCount() {
        return views.size();
    }
    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }
    @Override
    public void destroyItem(View container, int position, Object object) {

        ((ViewPager)container).removeView(views.get(position));
    }
    @Override
    public Object instantiateItem(View container, int position) {
        ((ViewPager)container).addView(views.get(position));
        return views.get(position);
    }
}
