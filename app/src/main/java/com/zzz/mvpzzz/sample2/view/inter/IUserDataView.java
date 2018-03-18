package com.zzz.mvpzzz.sample2.view.inter;

import com.zzz.mvp.base.IBaseView;
import com.zzz.mvpzzz.sample2.pojo.User;

/**
 * @author 请叫我张懂
 * @Date 2018/3/18 14:47
 * @Description
 */

public interface IUserDataView extends IBaseView {

    void saveDataSuccess();

    void saveDataFail(String msg);

    void readDataSuccess(User user);

    void readDataFail(String msg);
}
