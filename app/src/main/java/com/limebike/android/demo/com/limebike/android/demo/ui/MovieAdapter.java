package com.limebike.android.demo.com.limebike.android.demo.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.limebike.android.demo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Don on 8/29/2019.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.VH> {

        //② 创建ViewHolder
        public static class VH extends RecyclerView.ViewHolder{
            public final TextView title;
            public VH(View v) {
                super(v);
                title = (TextView) v.findViewById(R.id.id_num);
            }
        }

        private List<String> mDatas;
        public MovieAdapter(Context c , List<String> data) {
            this.mDatas = data;
        }

        //③ 在Adapter中实现3个方法
        @Override
        public void onBindViewHolder(VH holder, int position) {
            holder.title.setText(mDatas.get(position));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //item 点击事件
                }
            });
        }

        @Override
        public int getItemCount() {
            return mDatas.size();
        }

        @Override
        public VH onCreateViewHolder(ViewGroup parent, int viewType) {
            //LayoutInflater.from指定写法
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
            return new VH(v);
        }
    }

