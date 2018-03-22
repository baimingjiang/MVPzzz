package com.zzz.mvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.zzz.mvp.proxy.view.IActivityMvpProxy;
import com.zzz.mvp.proxy.view.impl.ActivityMvpProxy;

/**
 * @author 请叫我张懂
 * @Date 2018/3/9 12:59
 * @Description
 */

public abstract class BaseMvpActivity extends KeyboardActivity implements IBaseView {
    private IActivityMvpProxy mvpProxy;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setContentView());
        //
        injectPresenter();
        //
        initView();
        initData();
    }

    private void injectPresenter() {
        if (null == mvpProxy) {
            mvpProxy = new ActivityMvpProxy(this);
        }
        mvpProxy.injectPresenters();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != mvpProxy) {
            mvpProxy.detachPresenters();
            mvpProxy = null;
        }
    }

    protected abstract int setContentView();

    protected abstract void initView();

    protected abstract void initData();


}
