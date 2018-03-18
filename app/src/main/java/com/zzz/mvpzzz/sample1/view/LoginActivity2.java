package com.zzz.mvpzzz.sample1.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.zzz.mvpzzz.R;

/**
 * @author 请叫我张懂
 * @Date 2018/3/10 9:55
 * @Description
 */

public class LoginActivity2 extends AppCompatActivity {
    private LoginFragment loginFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        loginFragment = new LoginFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, loginFragment).commit();
    }
}
