package com.zzz.mvp.proxy.presenter.impl;

import com.zzz.mvp.base.BasePresenter;
import com.zzz.mvp.base.BaseModel;
import com.zzz.mvp.inject.InjectModel;
import com.zzz.mvp.proxy.presenter.IPresenterMvpProxy;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 请叫我张懂
 * @Date 2018/3/9 14:58
 * @Description
 */

public class PresenterMvpProxy implements IPresenterMvpProxy {
    private List<BaseModel> mModels;
    private BasePresenter mPresenter;

    public PresenterMvpProxy(BasePresenter presenter) {
        this.mPresenter = presenter;
        mModels = new ArrayList<>();
    }

    @Override
    @SuppressWarnings("unchecked")
    public void injectModels() {
        Field[] declaredFields = mPresenter.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            InjectModel annotation = declaredField.getAnnotation(InjectModel.class);
            if (null != annotation) {
                Class<? extends BaseModel> type = (Class<? extends BaseModel>) declaredField.getType();
                try {
                    BaseModel baseModel = type.newInstance();
                    declaredField.setAccessible(true);
                    declaredField.set(mPresenter, baseModel);
                    mModels.add(baseModel);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void detachModels() {
        for (BaseModel model : mModels) {
            model = null;
        }
        mModels.clear();
        mModels = null;
    }
}
