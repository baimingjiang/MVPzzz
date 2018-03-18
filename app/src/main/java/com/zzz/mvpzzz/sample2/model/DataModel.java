package com.zzz.mvpzzz.sample2.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.zzz.mvp.base.BaseModel;
import com.zzz.mvpzzz.AppContext;
import com.zzz.mvpzzz.sample2.pojo.User;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/**
 * @author 请叫我张懂
 * @Date 2018/3/18 15:02
 * @Description 用于程序的数据存储和数据读取, 这里只是简陋的举个例子
 */

public class DataModel extends BaseModel {

    public Observable<String> saveUserData(final User user) {
        return Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                AppContext.getInstance().getApplicationConext()
                        .getSharedPreferences("UserData", Context.MODE_PRIVATE)
                        .edit()
                        .putString("account", user.getAccount())
                        .putString("password", user.getPassword())
                        .apply();
                emitter.onNext("success");
                emitter.onComplete();
            }
        });
    }

    public Observable<User> readUserData() {

        return Observable.create(new ObservableOnSubscribe<User>() {
            @Override
            public void subscribe(ObservableEmitter<User> emitter) throws Exception {
                SharedPreferences userData = AppContext.getInstance().getApplicationConext()
                        .getSharedPreferences("UserData", Context.MODE_PRIVATE);
                String account = userData.getString("account", "");
                String password = userData.getString("password", "");
                User user = new User(account, password);
                emitter.onNext(user);
                emitter.onComplete();
            }
        });
    }


    public Observable<String> readXxxrData() {

        return null;
    }
}
