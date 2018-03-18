package com.zzz.mvpzzz.sample1.contract;

import com.zzz.mvp.base.IBaseView;
import com.zzz.mvpzzz.sample1.pojo.User;

/**
 * @author 请叫我张懂
 * @Date 2018/3/9 15:33
 * @Description
 */

public class LoginContract {
    public interface ILoginView extends IBaseView {
        void LoginSuccess();

        void loginFail(String msg);
    }

    public interface ILoginPresenter {
        void toLogin(User user);
    }
}
