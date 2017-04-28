package com.example.hante.thirdopen.mvp.adapter.freebook;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hante.thirdopen.R;
import com.example.hante.thirdopen.mvp.entry.freebook.FreeBook;

import java.util.ArrayList;
import java.util.List;


/**
 * Created By HanTe
 */

public class FreeBookAdapter extends RecyclerView.Adapter<FreeBookAdapter.FreeBookViewHolder> {

    private onItemClickListener mOnItemClickListener;
    private Context mContext;
    private List<FreeBook.DataBean.HotBookBean> mHotBookBeen;
    public FreeBookAdapter (Context context, List<FreeBook.DataBean.HotBookBean> hotBookBeen) {
        mContext = context;
        if(hotBookBeen == null) {
            hotBookBeen = new ArrayList<>();
        }
        mHotBookBeen = hotBookBeen;
    }

    @Override
    public FreeBookAdapter.FreeBookViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
       View inflate = LayoutInflater.from(mContext).inflate(R.layout.freebook_item_layout,
               parent, false);
       return new FreeBookViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder (final FreeBookAdapter.FreeBookViewHolder holder, int position) {
        final FreeBook.DataBean.HotBookBean hotBookBean = mHotBookBeen.get(position);
        if(hotBookBean.getImageUrl() != null && !"".equalsIgnoreCase(hotBookBean.getImageUrl())) {
            String imageUrl = hotBookBean.getImageUrl();
            Glide.with(mContext).load(imageUrl)
                    .placeholder(R.mipmap.nocover)
                    .error(R.mipmap.nocover)
                    .into(holder.mIcon);
        }
        holder.mDesc.setText(hotBookBean.getIntroduction());
        holder.mBooker.setText(hotBookBean.getAuthor());
        holder.mName.setText(hotBookBean.getBookName());
        holder.mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                if(mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(view, hotBookBean.getId());
                }
            }
        });
    }

    @Override
    public int getItemCount () {
        return mHotBookBeen.size();
    }

    public interface onItemClickListener{
        void onItemClick (View view, int position);
    }
    public void setOnItemClickListener(onItemClickListener onItemClickListener){
        this.mOnItemClickListener = onItemClickListener;
    }
    class FreeBookViewHolder extends RecyclerView.ViewHolder{
        private ImageView mIcon;
        private TextView mName, mBooker, mDesc;
        private LinearLayout mLayout;
        FreeBookViewHolder (View itemView) {
            super(itemView);
            mLayout = (LinearLayout)itemView.findViewById(R.id.item_linearLayout);
            mIcon = (ImageView)itemView.findViewById(R.id.book_icon);
            mName = (TextView)itemView.findViewById(R.id.book_name);
            mBooker = (TextView)itemView.findViewById(R.id.book_auther);
            mDesc = (TextView)itemView.findViewById(R.id.book_desc);
        }
    }
}
