package com.example.hante.thirdopen.fragment.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created By HanTe
 */

public class FreeBookAdapter extends RecyclerView.Adapter<FreeBookAdapter.FreeBookViewHolder> {

    private onItemClickListener mOnItemClickListener;
    @Override
    public FreeBookViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder (FreeBookViewHolder holder, int position) {

    }

    @Override
    public int getItemCount () {
        return 0;
    }

    private interface onItemClickListener{
        void onItemClick (View view, int position);
    }
    public void setOnItemClickListener(onItemClickListener onItemClickListener){
        this.mOnItemClickListener = onItemClickListener;
    }
    class FreeBookViewHolder extends RecyclerView.ViewHolder{

        public FreeBookViewHolder (View itemView) {
            super(itemView);
        }
    }
}
