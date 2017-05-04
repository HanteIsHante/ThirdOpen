package com.example.hante.thirdopen.mvp.adapter.douban;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 *  豆瓣 适配器
 */

public class DouBanAdapter extends RecyclerView.Adapter<DouBanAdapter.DouBanViewHolder>{

    private Context mContext;
    private onItemClickListener mOnItemClickListener;

    @Override
    public DouBanViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder (DouBanViewHolder holder, int position) {

    }

    @Override
    public int getItemCount () {
        return 0;
    }


    private interface onItemClickListener{
        void onItemClick (View view, int position);
    }

    public void setOnItemClickListener(onItemClickListener OnItemClickListener){
        this.mOnItemClickListener = OnItemClickListener;
    }

    class DouBanViewHolder extends RecyclerView.ViewHolder {

        public DouBanViewHolder (View itemView) {
            super(itemView);
        }
    }

}
