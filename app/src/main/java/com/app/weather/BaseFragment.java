package com.app.weather;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by wangshuo on 16/12/8.
 */

public abstract class BaseFragment extends Fragment {
    protected ViewGroup mRootView;
    protected LayoutInflater mLayoutInflater;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mLayoutInflater = inflater;
        mRootView = (ViewGroup) inflater.inflate(layoutId(), container, false);
        return mRootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        setEvents();
        initDatas();

    }

    protected abstract int layoutId();

    protected abstract void initViews(View view);

    protected abstract void initDatas();

    protected abstract void setEvents();

    protected <T extends View> T findViewById(int id) {
        return (T) mRootView.findViewById(id);
    }
}
