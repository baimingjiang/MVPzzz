package com.zzz.mvpzzz.model;

import com.zzz.mvp.base.BaseModel;
import com.zzz.mvpzzz.pojo.User;

import io.reactivex.Observable;

/**
 * @author 请叫我张懂
 * @Date 2018/3/9 15:42
 * @Description
 */

public class UserModel extends BaseModel {
    public Observable<String> toLogin(User user) {
        //Retrofit2
        String result = "fail";
        if ("zzz".equals(user.getAccount()) && "123".equals(user.getPassword())) {
            result = "success";
        }
        return Observable.just(result);
    }
}
