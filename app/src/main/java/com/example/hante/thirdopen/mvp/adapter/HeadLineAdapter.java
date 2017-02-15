package com.example.hante.thirdopen.mvp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created By HanTe
 */

public class HeadLineAdapter extends RecyclerView.Adapter<HeadLineAdapter.HeadLineViewHolder>{

    @Override
    public HeadLineViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder (HeadLineViewHolder holder, int position) {

    }

    @Override
    public int getItemCount () {
        return 0;
    }

    class HeadLineViewHolder extends RecyclerView.ViewHolder{

        public HeadLineViewHolder (View itemView) {
            super(itemView);
        }
    }
}
