package com.zzz.mvpzzz;

import android.app.Application;

/**
 * @author 请叫我张懂
 * @Date 2018/3/18 15:07
 * @Description
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AppContext.getInstance().init(this);
    }
}
