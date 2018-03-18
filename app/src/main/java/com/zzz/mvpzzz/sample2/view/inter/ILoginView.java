package com.zzz.mvpzzz.sample2.view.inter;

import com.zzz.mvp.base.IBaseView;

/**
 * @author 请叫我张懂
 * @Date 2018/3/18 14:16
 * @Description
 */

public interface ILoginView extends IBaseView {
    /**
     * 正在登陆
     */
    void showLoginLoading();

    /**
     * 结束登陆
     */
    void hideLoginLoading();

    /**
     * 正在登录成功
     */
    void loginSuccess();

    /**
     * 正在登录失败
     */
    void loginFail(String msg);
}
