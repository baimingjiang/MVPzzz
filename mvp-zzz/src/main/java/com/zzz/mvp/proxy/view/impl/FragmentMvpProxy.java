package com.zzz.mvp.proxy.view.impl;

import com.zzz.mvp.base.IBaseView;
import com.zzz.mvp.proxy.view.IActivityMvpProxy;
import com.zzz.mvp.proxy.view.IFragmentMvpProxy;

/**
 * @author 请叫我张懂
 * @Date 2018/3/9 14:30
 * @Description
 */

public class FragmentMvpProxy extends BaseViewMvpProxy implements IFragmentMvpProxy {

    public FragmentMvpProxy(IBaseView View) {
        super(View);
    }
}
