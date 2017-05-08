package com.example.hante.thirdopen.mvp.douban.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hante.thirdopen.R;
import com.example.hante.thirdopen.mvp.douban.bean.DouBanInTheaters;

import java.util.List;

/**
 * Created By HanTe
 */

public class DouBanPhotoItemAdapter extends RecyclerView.Adapter<DouBanPhotoItemAdapter.DouBanPhotoViewHolder> {

    private Context mContext;
    private List<DouBanInTheaters.SubjectsBean.CastsBean> castsBeanList;

    public DouBanPhotoItemAdapter(Context mContext,
                                  List<DouBanInTheaters.SubjectsBean.CastsBean> castsBeanList) {
        this.mContext = mContext;
        this.castsBeanList = castsBeanList;
    }

    @Override
    public DouBanPhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.douban_name_list_item, parent, false);
        return new DouBanPhotoViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(DouBanPhotoViewHolder holder, int position) {
        DouBanInTheaters.SubjectsBean.CastsBean castsBean = castsBeanList.get(position);
        holder.mName.setText(castsBean.getName());
        if (castsBean.getAvatars() != null) {
            String medium = castsBean.getAvatars().getMedium();
            if ( medium != null && !"".equalsIgnoreCase(medium)) {
                Glide.with(mContext)
                        .load(castsBean.getAvatars().getMedium())
                        .error(mContext.getResources().getDrawable(R.mipmap.nocover))
                        .into(holder.mPhoto);
            }
        }
    }

    @Override
    public int getItemCount() {
        return castsBeanList.size();
    }

    class DouBanPhotoViewHolder extends RecyclerView.ViewHolder {
        private TextView mName;
        private ImageView mPhoto;

        DouBanPhotoViewHolder(View itemView) {
            super(itemView);
            mName = (TextView) itemView.findViewById(R.id.name_title);
            mPhoto = (ImageView) itemView.findViewById(R.id.name_photo);
        }
    }
}
