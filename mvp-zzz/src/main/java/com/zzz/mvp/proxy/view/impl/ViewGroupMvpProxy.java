package com.zzz.mvp.proxy.view.impl;

import com.zzz.mvp.base.IBaseView;
import com.zzz.mvp.proxy.view.IActivityMvpProxy;
import com.zzz.mvp.proxy.view.IViewGroupMvpProxy;

/**
 * @author 请叫我张懂
 * @Date 2018/3/9 14:30
 * @Description
 */

public class ViewGroupMvpProxy extends BaseViewMvpProxy implements IViewGroupMvpProxy {

    public ViewGroupMvpProxy(IBaseView View) {
        super(View);
    }
}
