package com.example.asus.carmania_v1.modelClass;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.asus.carmania_v1.R;

import java.util.List;

public class shop_list_adapter extends BaseAdapter {


    private Context mContext;
    private List<shops> mShopsList;

    public shop_list_adapter(Context context, List<shops> shopsList) {
        mContext = context;
        mShopsList = shopsList;
    }

    @Override
    public int getCount() {
        return mShopsList.size();
    }

    @Override
    public Object getItem(int position) {
        return mShopsList.get(position) ;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       View v = View.inflate(mContext, R.layout.activity_shop_list,null);
        TextView name = (TextView)v.findViewById(R.id.shopname);
        TextView location = (TextView)v.findViewById(R.id.location);
        TextView contact = (TextView)v.findViewById(R.id.shopcontact);

        name.setText(mShopsList.get(position).getName());
        location.setText(mShopsList.get(position).getLocation());
        contact.setText(mShopsList.get(position).getContact());


        return v;
    }
}
