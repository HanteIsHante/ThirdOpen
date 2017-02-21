package com.example.hante.thirdopen.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.hante.thirdopen.R;

/**
 * Created By HanTe
 */

public class LazyFragment  extends BaseLazyFragment{

    private boolean isInit = false; // 真正要显示的View 是否已经初始化
    private Bundle savedInstance;
    public static final String INTENT_BOOLEAN_LAZYLOAD = "intent_boolean_lazyLoad";
    private boolean isLazyLoad = true;
    private FrameLayout mFrameLayout;
    private boolean isStart = false ; // 是否处于可见状态

    @Override
    public void onStart () {
        super.onStart();
        if (isInit && !isStart && getUserVisibleHint()){
            isStart = true;
            onFragmentStartLazy();
        }
    }

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null){
            isLazyLoad = bundle.getBoolean(INTENT_BOOLEAN_LAZYLOAD, isLazyLoad);
        }
        // 判断是否是懒加载
        if(isLazyLoad) {
            //一旦isVisibleToUser==true即可对真正需要的显示内容进行加载
            if(getUserVisibleHint() && !isInit) {
                this.savedInstance = savedInstanceState;
                isInit = true;
            } else {
                // 进行懒加载
                mFrameLayout = new FrameLayout(getApplicationContext());
                mFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams
                        .MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                View inflate = LayoutInflater.from(getApplicationContext()).inflate(R.layout.fragment_lazy_loading, null);
                mFrameLayout.addView(inflate);
                super.setContentView(mFrameLayout);
            }
        }  else {
            // 不需要懒加载
            onCreateViwLazy (savedInstanceState);
            isInit = true;
        }


    }

    @Override
    public void onResume () {
        super.onResume();
        if (isInit){
            onResumeLazy();
        }
    }

    @Override
    public void onPause () {
        super.onPause();
        if (isInit){
            onPauseLazy();
        }
    }

    private void onPauseLazy () {

    }


    @Override
    public void onStop () {
        super.onStop();
        if (isInit && isStart && getUserVisibleHint()){
            isStart = true;
            onFragmentStopLazy();
        }
    }

    public void onCreateViwLazy (Bundle savedInstanceState) {

    }

    @Override
    public void setUserVisibleHint (boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        //一旦isVisibleToUser==true即可进行对真正需要的显示内容的加载
        // 可见，但还没初始化
        if (isVisibleToUser && !isInit && getContentView() != null){
            onCreateViwLazy(savedInstance);
            isInit = true;
            onResumeLazy();
        }
        // 已经正常加载过了
        if ( isInit && getContentView() != null){
            if (isVisibleToUser){
                isStart = true;
                onFragmentStartLazy();
            } else {
                isStart = false;
                onFragmentStopLazy();
            }
        }


    }

    @Override
    public void setContentView (View inflate) {
        super.setContentView(inflate);
        //判断若isLazyLoad==true,移除所有lazy view，加载真正要显示的view
        if (isLazyLoad && getContentView() != null && getContentView().getParent() != null) {
            mFrameLayout.removeAllViews();
            mFrameLayout.addView(inflate);
        }
        //否则，开门见山，直接加载
        else {
            super.setContentView(inflate);
        }
    }

    private void onFragmentStopLazy () {

    }

    private void onFragmentStartLazy () {

    }

    private void onResumeLazy () {

    }

    @Override
    public void setContentView (int layoutId) {
        super.setContentView(layoutId);
        // 判断 islazyload == true ,移除所有lazy view 加载真正view
        if (isLazyLoad && getContentView() != null && getContentView().getParent() != null){
            mFrameLayout.removeAllViews();
            View inflate = mLayoutInflater.inflate(layoutId, mFrameLayout, false);
            mFrameLayout.addView(inflate);
        }
        else {
            super.setContentView(layoutId);
        }
    }

    @Override
    public void onDestroy () {
        super.onDestroy();
        if (isInit){
            onDestroyViewLazy();
        }
        isInit = false;
    }

    private void onDestroyViewLazy () {

    }
}
