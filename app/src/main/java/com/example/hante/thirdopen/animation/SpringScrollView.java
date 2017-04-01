package com.example.hante.thirdopen.animation;

import android.content.Context;
import android.support.animation.SpringAnimation;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 在刚推出的 Support Library 25.3.0
 * 里面新增了一个叫 SpringAnimation 的动画，也就是弹簧动画。
 * 用它来做一个滑动控件下拉回弹的效果
 * 回弹 动画
 */

public class SpringScrollView extends NestedScrollView {

    private float startDragY;
    private SpringAnimation mSpringAnimation;

    public SpringScrollView (Context context) {
        super(context);
    }

    public SpringScrollView (Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public SpringScrollView (Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mSpringAnimation = new SpringAnimation(this, SpringAnimation.TRANSLATION_Y, 0);
        //  刚度 默认1200 值越大回弹的速度越快
        mSpringAnimation.getSpring().setStiffness(800.0f);
        // 阻尼 默认0.5 值越小，回弹之后来回的次数越多
        mSpringAnimation.getSpring().setDampingRatio(0.50f);
    }

    @Override
    public boolean onTouchEvent (MotionEvent ev) {
        switch(ev.getAction()){
            case MotionEvent.ACTION_MOVE:
                if(getScrollY() <= 0) {
                    // 顶部下拉
                    if (startDragY == 0){
                        startDragY = ev.getRawY();
                    }
                    if (ev.getRawX() - startDragY > 0){
                        setTranslationY((ev.getRawY() - startDragY) / 3);
                        return true;
                    } else {
                        startDragY = 0;
                        mSpringAnimation.cancel();
                        setTranslationY(0);
                    }
                } else if ((getScrollY() + getHeight()) >= getChildAt(0).getMeasuredHeight()) {
                    //底部上拉
                    if (startDragY == 0) {
                        startDragY = ev.getRawY();
                    }
                    if (ev.getRawY() - startDragY < 0) {
                        setTranslationY((ev.getRawY() - startDragY) / 3);
                        return true;
                    } else {
                        startDragY = 0;
                        mSpringAnimation.cancel();
                        setTranslationY(0);
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                if (getTranslationY() != 0) {
                    mSpringAnimation.start();
                }
                startDragY = 0;
                break;
        }
        return super.onTouchEvent(ev);
    }
}
