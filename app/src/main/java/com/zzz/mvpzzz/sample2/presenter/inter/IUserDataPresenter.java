package com.zzz.mvpzzz.sample2.presenter.inter;

import com.zzz.mvpzzz.sample2.pojo.User;

/**
 * @author 请叫我张懂
 * @Date 2018/3/18 14:59
 * @Description
 */

public interface IUserDataPresenter {
    void saveData(User user);

    void loadLastData();
}
