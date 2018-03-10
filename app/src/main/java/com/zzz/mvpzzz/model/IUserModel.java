package com.zzz.mvpzzz.model;

import com.zzz.mvpzzz.pojo.User;

import io.reactivex.Observable;

/**
 * @author 请叫我张懂
 * @Date 2018/3/9 15:41
 * @Description
 */

public interface IUserModel {

    Observable<String> toLogin(User user);
}
