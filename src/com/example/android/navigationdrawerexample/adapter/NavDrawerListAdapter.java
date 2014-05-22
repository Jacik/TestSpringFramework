package com.example.android.navigationdrawerexample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.navigationdrawerexample.R;
import com.example.android.navigationdrawerexample.model.NavDrawerItem;

import java.util.ArrayList;

public class NavDrawerListAdapter extends BaseAdapter{

    private Context mContext;
    private ArrayList<NavDrawerItem> mNavDrawerList;
    
    
    public NavDrawerListAdapter(Context context, ArrayList<NavDrawerItem> navDrawerList) {
        mContext = context;
        mNavDrawerList = navDrawerList;
    }

    public void setNavDrawerList(ArrayList<NavDrawerItem> navDrawerList) {
        this.mNavDrawerList = navDrawerList;
    }

    public int getCount() {
        
        if (mNavDrawerList != null){
            return mNavDrawerList.size();
        } else {
            return 0;
        }
    }

    public NavDrawerItem getItem(int position) {
        if (mNavDrawerList != null){
            return mNavDrawerList.get(position);
        }else
            return null;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            LayoutInflater li = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = li.inflate(R.layout.drawer_list_item, null);
        }
        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.icon);
        TextView txtTitle = (TextView) convertView.findViewById(R.id.title);
        TextView txtCount = (TextView) convertView.findViewById(R.id.counter);
        
        final NavDrawerItem item = getItem(position);
        if (item != null){
            imgIcon.setImageResource(item.getIcon());
            txtTitle.setText(item.getTitle());
            
            if (item.getCounterVisibility()){
                txtCount.setText(item.getCount());
                txtCount.setVisibility(View.VISIBLE);
            }else{
                txtCount.setVisibility(View.GONE);
            }
        }else{
            imgIcon.setImageDrawable(null);
            txtTitle.setText("Error - Empty list");
            txtCount.setVisibility(View.GONE);
        }
        return convertView;
    }
}
