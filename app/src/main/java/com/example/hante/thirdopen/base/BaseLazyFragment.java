package com.example.hante.thirdopen.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Field;

/**
 * Created By HanTe
 * 懒加载Fragment
 */

public class BaseLazyFragment extends Fragment {

    protected LayoutInflater mLayoutInflater;
    private View mView;
    private Context mContext;
    private ViewGroup mViewGroup;

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity().getApplicationContext();
    }
    //子类通过重写onCreateView，
    // 调用setOnContentView进行布局设置，否则 mView == null，返回null
    @Nullable
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.mLayoutInflater = inflater;
        mViewGroup = container;
        onCreateView(savedInstanceState);
        if (mView == null){
            return super.onCreateView(inflater, container, savedInstanceState);
        }
        return mView;
    }

    private void onCreateView (Bundle savedInstanceState) {

    }

    @Override
    public void onDestroyView () {
        super.onDestroyView();
        mLayoutInflater = null;
        mView = null;
        mViewGroup = null;
    }

    public Context getApplicationContext (){
        return mContext;
    }

    public void setContentView (int layoutId){
        setContentView((ViewGroup) mLayoutInflater.inflate(layoutId, mViewGroup, false));
    }

    public void setContentView (View inflate) {
        mView = inflate;
    }

    public View getContentView (){
        return mViewGroup;
    }

    public View findViewById (int id){
        if (mViewGroup != null){
            return mViewGroup.findViewById(id);
        }
        return null;
    }
// http://stackoverflow.com/questions/15207305/getting-the-error-java-lang-illegalstateexception-activity-has-been-destroyed
    @Override
    public void onDetach () {
        super.onDetach();
        try {
            Field declaredField = Fragment.class.getDeclaredField("mChildFragmentManager");
            declaredField.setAccessible(true);
            declaredField.set(this, null);
        } catch(NoSuchFieldException e) {
            e.printStackTrace();
        } catch(IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroy () {
        super.onDestroy();
    }
}
