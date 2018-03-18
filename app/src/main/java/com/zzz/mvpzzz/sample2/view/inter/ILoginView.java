package com.zzz.mvpzzz.sample2.view.inter;

import com.zzz.mvp.base.IBaseView;

/**
 * @author 请叫我张懂
 * @Date 2018/3/18 14:16
 * @Description
 */

public interface ILoginView extends IBaseView {
    void LoginSuccess();

    void loginFail(String msg);
}
