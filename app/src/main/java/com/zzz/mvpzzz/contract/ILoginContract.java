package com.zzz.mvpzzz.contract;

import com.zzz.mvp.base.IBaseView;
import com.zzz.mvpzzz.pojo.User;

/**
 * @author 请叫我张懂
 * @Date 2018/3/9 15:33
 * @Description
 */

public interface ILoginContract {
    interface ILoginView extends IBaseView {
        void LoginSuccess();

        void loginFail(String msg);
    }

    interface ILoginPresenter {
        void toLogin(User user);
    }
}
