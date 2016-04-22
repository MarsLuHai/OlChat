package com.bedidi.fawzi.olchat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

    class ImageAdapter extends BaseAdapter {
    private final Context mContext;

    // Keep all Images in array
    private final Integer[] mThumbIds = {
            R.drawable.ic_account_circle_black_24dp, R.drawable.ic_account_circle_black_24dp,
            R.drawable.ic_account_circle_black_24dp, R.drawable.ic_account_circle_black_24dp,
            R.drawable.ic_account_circle_black_24dp, R.drawable.ic_account_circle_black_24dp,
            R.drawable.ic_account_circle_black_24dp, R.drawable.ic_account_circle_black_24dp
    };

    // Constructor
    public ImageAdapter(Context c){
        mContext = c;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return mThumbIds[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View gridView;

        gridView = new View(mContext);
        gridView = inflater.inflate(R.layout.contact_view, null);
        return gridView.findViewById(R.id.contact);
    }
}
