package com.example.hante.thirdopen.mvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hante.thirdopen.R;
import com.example.hante.thirdopen.mvp.entry.freebook.FreeBook;

import java.util.ArrayList;
import java.util.List;


/**
 * Created By HanTe
 */

public class FreeBookAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private onItemClickListener mOnItemClickListener;
    private Context mContext;
    private List<FreeBook.DataBean.HotBookBean> mHotBookBeen;

    public static final int VIEW_TYPE_NORMAL = 0;
    public static final int VIEW_TYPE_FOOTER = -1;

    public static final int STATE_HIDE = 1;
    public static final int STATE_LOADING = 2;
    public static final int STATE_No_MORE = 3;
    public static final int STATE_LOAD_ERROR = 4;

    private int mSTATE;

    public FreeBookAdapter (Context context, List<FreeBook.DataBean.HotBookBean> hotBookBeen) {
        mContext = context;
        if(hotBookBeen == null) {
            hotBookBeen = new ArrayList<>();
        }
        mHotBookBeen = hotBookBeen;
        mSTATE = STATE_HIDE;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_FOOTER){
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.bottom_view, parent, false);
            return new FooterViewHolder(inflate);
        } else {
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.freebook_item_layout,
                    parent, false);
            return new FreeBookViewHolder(inflate);
        }
    }

    @Override
    public void onBindViewHolder (final RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == VIEW_TYPE_FOOTER){
             FooterViewHolder footerViewHolder = (FooterViewHolder)holder;
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
            final FreeBookViewHolder freeBookViewHolder = (FreeBookViewHolder) holder;
            FreeBook.DataBean.HotBookBean hotBookBean = mHotBookBeen.get(position);
            if(hotBookBean.getImageUrl() != null) {
                String imageUrl = hotBookBean.getImageUrl();
                Glide.with(mContext).load(imageUrl)
                        .placeholder(R.mipmap.nocover)
                        .error(R.mipmap.nocover)
                        .into(freeBookViewHolder.mIcon);
            }
            freeBookViewHolder.mDesc.setText(hotBookBean.getIntroduction());
            freeBookViewHolder.mBooker.setText(hotBookBean.getAuthor());
            freeBookViewHolder.mName.setText(hotBookBean.getBookName());
            freeBookViewHolder.mLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick (View view) {
                    if(mOnItemClickListener != null) {
                        mOnItemClickListener.onItemClick(view, holder.getLayoutPosition());
                    }
                }
            });
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
        return mHotBookBeen.size() + 1;
    }

    @Override
    public int getItemViewType (int position) {
        if (position + 1 == getItemCount()){
            return  VIEW_TYPE_FOOTER;
        } else {
            return VIEW_TYPE_NORMAL;
        }
    }

    public interface onItemClickListener{
        void onItemClick (View view, int position);
    }
    public void setOnItemClickListener(onItemClickListener onItemClickListener){
        this.mOnItemClickListener = onItemClickListener;
    }
    private class FreeBookViewHolder extends RecyclerView.ViewHolder{
        private ImageView mIcon;
        private TextView mName, mBooker, mDesc;
        private LinearLayout mLayout;
        public FreeBookViewHolder (View itemView) {
            super(itemView);
            mLayout = (LinearLayout)itemView.findViewById(R.id.item_linearLayout);
            mIcon = (ImageView)itemView.findViewById(R.id.book_icon);
            mName = (TextView)itemView.findViewById(R.id.book_name);
            mBooker = (TextView)itemView.findViewById(R.id.book_auther);
            mDesc = (TextView)itemView.findViewById(R.id.book_desc);
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
