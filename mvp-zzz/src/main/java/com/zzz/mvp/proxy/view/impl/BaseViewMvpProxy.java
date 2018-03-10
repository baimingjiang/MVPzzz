package com.zzz.mvp.proxy.view.impl;

import android.view.View;

import com.zzz.mvp.base.BasePresenter;
import com.zzz.mvp.base.IBaseView;
import com.zzz.mvp.inject.InjectPresenter;
import com.zzz.mvp.proxy.view.IBaseViewMvpProxy;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 请叫我张懂
 * @Date 2018/3/9 14:10
 * @Description
 */
class BaseViewMvpProxy implements IBaseViewMvpProxy {
    private List<BasePresenter> mPresenters;
    private IBaseView mView;

    BaseViewMvpProxy(IBaseView View) {
        this.mView = View;
        this.mPresenters = new ArrayList<>();
    }

    @Override
    @SuppressWarnings("unchecked")
    public void injectPresenters() {
        Field[] declaredFields = mView.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            InjectPresenter annotation = declaredField.getAnnotation(InjectPresenter.class);
            if (null != annotation) {
                Class<? extends BasePresenter> type = (Class<? extends BasePresenter>) declaredField.getType();
                try {
                    BasePresenter basePresenter = type.newInstance();
                    declaredField.setAccessible(true);
                    declaredField.set(mView, basePresenter);
                    basePresenter.attach(mView);
                    mPresenters.add(basePresenter);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void detachPresenters() {
        for (BasePresenter presenter : mPresenters) {
            presenter.detach();
        }
        //
        mView = null;
        //
        mPresenters.clear();
        mPresenters = null;
    }
}
