package com.zzz.mvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zzz.mvp.proxy.view.IFragmentMvpProxy;
import com.zzz.mvp.proxy.view.impl.FragmentMvpProxy;

/**
 * @author 请叫我张懂
 * @Date 2018/3/10 9:40
 * @Description
 */

public abstract class BaseMvpFragment extends Fragment implements IBaseView {
    private View baseView;
    private Boolean isFragmentVisible;
    private Boolean hasCreateView;
    private IFragmentMvpProxy mvpProxy;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initValue();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (baseView == null) {
            baseView = inflater.inflate(createView(), container, false);
            injectPresenter();
            initView(baseView);
        } else {
            ViewGroup viewGroup = (ViewGroup) container.getParent();
            viewGroup.removeView(baseView);
        }
        return baseView;
    }

    private void injectPresenter() {
        if (null == mvpProxy) {
            mvpProxy = new FragmentMvpProxy(this);
            mvpProxy.injectPresenters();
        }
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (!hasCreateView && getUserVisibleHint()) {
            onFragmentVisibleChange(true);
            isFragmentVisible = true;
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (baseView == null) {
            return;
        }
        hasCreateView = true;
        if (isVisibleToUser) {
            onFragmentVisibleChange(true);
            isFragmentVisible = true;
            return;
        }
        if (isFragmentVisible) {
            onFragmentVisibleChange(false);
            isFragmentVisible = false;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (null != mvpProxy) {
            mvpProxy.detachPresenters();
            mvpProxy = null;
        }
    }

    private void initValue() {
        hasCreateView = false;
        isFragmentVisible = false;
    }

    /**
     * 当前fragment可见状态发生变化时会回调该方法
     * 如果当前fragment是第一次加载，等待onCreateView后才会回调该方法，其它情况回调时机跟 {@link #setUserVisibleHint(boolean)}一致
     * 在该回调方法中你可以做一些加载数据操作，甚至是控件的操作，因为配合fragment的view复用机制，你不用担心在对控件操作中会报 null 异常
     *
     * @param isVisible true  不可见 -> 可见
     *                  false 可见  -> 不可见
     */
    private void onFragmentVisibleChange(boolean isVisible) {
        if (isVisible) {
            loadData();
        }
    }


    protected abstract int createView();

    protected abstract void initView(View view);

    /**
     * 懒加载
     */
    protected abstract void loadData();
}
