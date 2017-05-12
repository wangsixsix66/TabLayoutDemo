package com.sixsix.tablayout;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 创建者:   Sixsix
 * 创建时间:  2017/01/09 21:52
 * 描述：    BaseFragment基类
 */
public abstract class BaseFragment extends Fragment {

    protected Activity mActivity;
    protected boolean isHidden;
    private View rootView;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mActivity = (Activity) context;
        prepare();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        prepareData(); //首页创建 view前准备数据
        rootView = inflater.inflate(inflateLayoutId(), container, false);
        initView(rootView);
        init();
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @LayoutRes
    protected abstract int inflateLayoutId();

    protected void prepareData(){}

    protected void init() {}
    protected void initView(View rootView) {}

    protected void prepare(){}


    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);

        if (hidden) {
            // 友盟统计
        }
    }




}
