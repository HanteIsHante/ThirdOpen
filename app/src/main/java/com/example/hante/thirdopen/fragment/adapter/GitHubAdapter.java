package com.example.hante.thirdopen.fragment.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created By HanTe
 */

public class GitHubAdapter extends RecyclerView.Adapter<GitHubAdapter.GitHubViewHolder> {

    private onItemClickListener mOnItemClickListener;

    @Override
    public GitHubViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder (GitHubViewHolder holder, int position) {

    }

    @Override
    public int getItemCount () {
        return 0;
    }

    private interface  onItemClickListener{
        void onItemClick (View view, int position);
    }
    public void setOnItemClickListener(onItemClickListener onItemClickListener){
         this.mOnItemClickListener = onItemClickListener;
    }

    class GitHubViewHolder extends RecyclerView.ViewHolder{

        public GitHubViewHolder (View itemView) {
            super(itemView);
        }
    }
}
