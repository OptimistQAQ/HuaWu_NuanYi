package com.example.lbstest.CardView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lbstest.R;

public class PageAdapter extends BaseAdapter {
    private Context mContext;
    private int[] imgIds;

    public PageAdapter(Context context, int[] imgIds) {
        mContext = context;
        this.imgIds = imgIds;
    }

    @Override
    public int getCount() {
        return imgIds.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.card, null);
        }
        mViewHolder = getHolder(convertView);
        mViewHolder.ivNormal.setImageResource(imgIds[position]);
        return convertView;
    }

    private ViewHolder getHolder(View convertView) {
        ViewHolder holder = (ViewHolder) convertView.getTag();
        if (holder == null) {
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }
        return holder;
    }

    private ViewHolder mViewHolder;

    static class ViewHolder {
        TextView tvCaption;
        ImageView ivNormal;

        public ViewHolder(View convertView) {
            ivNormal = (ImageView) convertView.findViewById(R.id.iv_normal);
        }
    }
}
