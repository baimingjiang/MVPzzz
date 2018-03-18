package com.zzz.mvp.proxy.view.impl;


import com.zzz.mvp.base.IBaseView;
import com.zzz.mvp.proxy.view.IActivityMvpProxy;

/**
 * @author 请叫我张懂
 * @Date 2018/3/9 14:30
 * @Description
 */

public class ActivityMvpProxy extends BaseViewMvpProxy implements IActivityMvpProxy {
    public ActivityMvpProxy(IBaseView View) {
        super(View);
    }
}
