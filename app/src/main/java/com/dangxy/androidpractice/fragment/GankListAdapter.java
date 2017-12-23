package com.dangxy.androidpractice.fragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.dangxy.androidpractice.R;
import com.dangxy.androidpractice.entity.CommonEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dangxueyi
 * @description
 * @date 2017/12/14
 */

public class GankListAdapter extends RecyclerView.Adapter<GankListAdapter.ViewHolder> {

    private List<CommonEntity.ResultsBean> listEntities = new ArrayList<>();
    private Context context;

    public GankListAdapter(Context context, List<CommonEntity.ResultsBean> listEntities) {
        this.listEntities = listEntities;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gank_item_layout, null);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(context).load(listEntities.get(position).getUrl()).into(holder.imageView);
    }


    @Override
    public int getItemCount() {
        return listEntities.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;


        public ViewHolder(View convertView) {
            super(convertView);
            imageView = (ImageView) convertView.findViewById(R.id.iv);
        }
    }

}
