package com.zzz.mvpzzz.sample2.presenter;

import com.zzz.mvp.base.BasePresenter;
import com.zzz.mvp.inject.InjectModel;
import com.zzz.mvpzzz.sample2.model.DataModel;
import com.zzz.mvpzzz.sample2.pojo.User;
import com.zzz.mvpzzz.sample2.presenter.inter.IUserDataPresenter;
import com.zzz.mvpzzz.sample2.view.inter.IUserDataView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @author 请叫我张懂
 * @Date 2018/3/18 15:00
 * @Description
 */

public class UserDataPresenter extends BasePresenter<IUserDataView> implements IUserDataPresenter {
    @InjectModel
    private DataModel dataModel;

    @Override
    public void saveData(User user) {
        dataModel.saveUserData(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String result) throws Exception {
                        if ("success".equals(result)) {
                            getView().saveDataSuccess();
                        } else {
                            getView().saveDataFail("保存失败");
                        }
                    }
                });
    }

    @Override
    public void loadLastData() {
        dataModel.readUserData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<User>() {
                    @Override
                    public void accept(User user) throws Exception {
                        getView().readDataSuccess(user);
                    }
                });
    }
}
