package com.zzz.mvpzzz;

import android.content.Context;

/**
 * @author 请叫我张懂
 * @Date 2018/3/18 15:15
 * @Description
 */

public class AppContext {
    private Context mContext;

    public static AppContext getInstance() {
        return InstanceHolder.instance;
    }

    public void init(Context context) {
        mContext = context.getApplicationContext();
    }

    public Context getApplicationContext() {
        if (null == mContext) {
            throw new NullPointerException("AppContext must init in Application");
        }
        return mContext;
    }

    private static class InstanceHolder {
        private final static AppContext instance = new AppContext();

    }
}
