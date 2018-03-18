package com.zzz.mvpzzz.sample2.presenter;

import com.zzz.mvp.base.BasePresenter;
import com.zzz.mvp.inject.InjectModel;
import com.zzz.mvpzzz.sample2.model.UserModel;
import com.zzz.mvpzzz.sample2.pojo.User;
import com.zzz.mvpzzz.sample2.presenter.inter.ILoginPresenter;
import com.zzz.mvpzzz.sample2.view.inter.ILoginView;

import io.reactivex.functions.Consumer;

/**
 * @author 请叫我张懂
 * @Date 2018/3/9 15:48
 * @Description
 */

public class LoginPresenter extends BasePresenter<ILoginView> implements ILoginPresenter {
    @InjectModel
    private UserModel userModel;

    @Override
    public void toLogin(User user) {
        userModel.toLogin(user)
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String result) throws Exception {
                        if ("success".equals(result)) {
                            getView().LoginSuccess();
                        } else {
                            getView().loginFail(result);
                        }
                    }
                });
    }
}
