package com.example.hante.thirdopen.mvp.douban.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hante.thirdopen.R;
import com.example.hante.thirdopen.mvp.douban.bean.DouBanInTheaters;

import java.util.ArrayList;
import java.util.List;

/**
 * 豆瓣 适配器
 */

public class DouBanAdapter extends RecyclerView.Adapter<DouBanAdapter.DouBanViewHolder> {

    private Context mContext;
    private onItemClickListener mOnItemClickListener;
    private List<DouBanInTheaters.SubjectsBean> mSubList;

    public DouBanAdapter(Context Context, List<DouBanInTheaters.SubjectsBean> SubList) {
        mContext = Context;
        if (SubList == null) {
            SubList = new ArrayList<>();
        }
        mSubList = SubList;
    }

    @Override
    public DouBanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.douban_movies_item, parent, false);
        return new DouBanViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(DouBanViewHolder holder, int position) {
        DouBanInTheaters.SubjectsBean subjectsBean = mSubList.get(position);
        holder.mTitle.setText(subjectsBean.getTitle());
        holder.mContent.setText(subjectsBean.getGenres().toString());
        holder.mAverage.setText(String.valueOf(subjectsBean.getRating().getAverage()));
        holder.mPhotoItem.setAdapter(new DouBanPhotoItemAdapter(mContext, subjectsBean.getCasts()));
    }

    @Override
    public int getItemCount() {
        return mSubList.size();
    }


    public interface onItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(onItemClickListener OnItemClickListener) {
        this.mOnItemClickListener = OnItemClickListener;
    }

    class DouBanViewHolder extends RecyclerView.ViewHolder {

        private TextView mTitle;
        private TextView mContent;
        private RecyclerView mPhotoItem;
        private TextView mAverage;

        DouBanViewHolder(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.movie_name);
            mContent = (TextView) itemView.findViewById(R.id.movie_content);
            mAverage = (TextView) itemView.findViewById(R.id.average);
            mPhotoItem = (RecyclerView) itemView.findViewById(R.id.start_name_list);
            LinearLayoutManager lm = new LinearLayoutManager(mContext);
            lm.setOrientation(LinearLayoutManager.HORIZONTAL);
            mPhotoItem.setLayoutManager(lm);
        }
    }

}
