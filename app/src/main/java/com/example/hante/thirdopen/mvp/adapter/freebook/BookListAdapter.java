package com.example.hante.thirdopen.mvp.adapter.freebook;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.hante.thirdopen.R;

import java.util.List;

/**
 * Created By HanTe
 */

public class BookListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<String> list;
    private Context mContext;
    public static final int VIEW_TYPE_NORMAL = 0;
    public static final int VIEW_TYPE_FOOTER = -1;

    public static final int STATE_HIDE = 1;
    public static final int STATE_LOADING = 2;
    public static final int STATE_No_MORE = 3;
    public static final int STATE_LOAD_ERROR = 4;
    private int mSTATE;

    public BookListAdapter (int STATE) {
        mSTATE = STATE_HIDE;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_FOOTER){
            return null;
        } else {
            return null;
        }
    }

    @Override
    public void onBindViewHolder (RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == VIEW_TYPE_FOOTER){
            BookListAdapter.FooterViewHolder footerViewHolder = (BookListAdapter.FooterViewHolder)holder;
            footerViewHolder.itemView.setVisibility(View.VISIBLE);
            switch(mSTATE){
                case STATE_LOADING:
                    footerViewHolder.mTextView.setText(mContext.getResources().getString(R.string
                            .is_loading));
                    footerViewHolder.mProgressBar.setVisibility(View.VISIBLE);
                    break;
                case STATE_No_MORE:
                    footerViewHolder.mTextView.setText(mContext.getResources().getString(R.string
                            .is_noMore));
                    footerViewHolder.mProgressBar.setVisibility(View.GONE);
                    break;
                case STATE_HIDE:
                    footerViewHolder.itemView.setVisibility(View.GONE);
                    break;
                case STATE_LOAD_ERROR:
                    footerViewHolder.mTextView.setText(mContext.getResources().getString(R.string
                            .is_error));
                    footerViewHolder.mProgressBar.setVisibility(View.GONE);
                    break;
            }
        } else {

        }

    }
    public void setState (int state){
        if (this.mSTATE != state){
            this.mSTATE = state;
            updateItem(getItemCount() - 1);
        }
    }
    public void updateItem(int position){
        if (getItemCount() > position){
            notifyItemChanged(position);
        }
    }
    @Override
    public int getItemCount () {
        return list.size() + 1;
    }

    @Override
    public int getItemViewType (int position) {
        if (position + 1 == getItemCount()){
            return  VIEW_TYPE_FOOTER;
        } else {
            return VIEW_TYPE_NORMAL;
        }
    }

    private class FooterViewHolder extends RecyclerView.ViewHolder{
        private ProgressBar mProgressBar;
        private TextView mTextView;
        public FooterViewHolder (View itemView) {
            super(itemView);
            mProgressBar = (ProgressBar)itemView.findViewById(R.id.pb_footer);
            mTextView = (TextView)itemView.findViewById(R.id.tv_footer);
        }
    }
}
