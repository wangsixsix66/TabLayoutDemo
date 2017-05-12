package com.sixsix.tablayout;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by wangxin on 2017/5/12.
 */

public class NoScrollViewPager extends ViewPager {

    public void setNeedScroll(boolean needScroll) {
        isNeedScroll = needScroll;
    }

    private boolean isNeedScroll=true;

    public NoScrollViewPager(Context context) {
        super(context);
    }

    public NoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if(isNeedScroll){
            return super.onTouchEvent(ev);
        }else {
            return false;
        }
    }

//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        return super.onInterceptTouchEvent(ev);
//        return false;
//    }

}
