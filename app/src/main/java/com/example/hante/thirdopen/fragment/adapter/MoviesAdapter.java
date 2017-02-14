package com.example.hante.thirdopen.fragment.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created By HanTe
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder> {


    @Override
    public MoviesViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder (MoviesViewHolder holder, int position) {

    }

    @Override
    public int getItemCount () {
        return 0;
    }

    class MoviesViewHolder extends RecyclerView.ViewHolder{

        public MoviesViewHolder (View itemView) {
            super(itemView);
        }
    }
}
