package com.zzz.mvpzzz.sample1.presenter;

import android.util.Log;
import android.widget.Toast;

import com.zzz.mvp.base.BasePresenter;
import com.zzz.mvp.inject.InjectModel;
import com.zzz.mvpzzz.sample1.contract.LoginContract;
import com.zzz.mvpzzz.sample1.model.UserModel;
import com.zzz.mvpzzz.sample1.pojo.User;

import io.reactivex.functions.Consumer;

/**
 * @author 请叫我张懂
 * @Date 2018/3/9 15:48
 * @Description
 */

public class LoginPresenter extends BasePresenter<LoginContract.ILoginView> implements LoginContract.ILoginPresenter {
    @InjectModel
    private UserModel userModel;

    @Override
    public void toLogin(User user) {
        if(getContext() == null){
            Log.i("zzzz", "toLogin: null null null");
        }
        Toast.makeText(getContext(),"测试",Toast.LENGTH_SHORT).show();
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
