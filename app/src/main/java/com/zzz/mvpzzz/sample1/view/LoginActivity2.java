package com.zzz.mvpzzz.sample1.view;

import com.zzz.mvp.base.BaseMvpActivity;
import com.zzz.mvpzzz.R;

/**
 * @author 请叫我张懂
 * @Date 2018/3/10 9:55
 * @Description
 */

public class LoginActivity2 extends BaseMvpActivity {
    private LoginFragment loginFragment;

    @Override
    protected int setContentView() {
        return R.layout.activity_login2;
    }

    @Override
    protected void initView() {
        loginFragment = new LoginFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, loginFragment).commit();
    }

    @Override
    protected void initData() {

    }
}
