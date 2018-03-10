package com.zzz.mvpzzz.presenter;

import com.zzz.mvp.base.BasePresenter;
import com.zzz.mvp.inject.InjectModel;
import com.zzz.mvpzzz.contract.ILoginContract;
import com.zzz.mvpzzz.model.UserModel;
import com.zzz.mvpzzz.pojo.User;

import io.reactivex.functions.Consumer;

/**
 * @author 请叫我张懂
 * @Date 2018/3/9 15:48
 * @Description
 */

public class LoginPresenter extends BasePresenter<ILoginContract.ILoginView> implements ILoginContract.ILoginPresenter {
    private static final String TAG = "zzz";
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
