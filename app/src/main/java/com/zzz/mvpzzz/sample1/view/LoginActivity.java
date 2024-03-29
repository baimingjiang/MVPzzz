package com.zzz.mvpzzz.sample1.view;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zzz.mvp.base.BaseMvpActivity;
import com.zzz.mvp.inject.InjectPresenter;
import com.zzz.mvpzzz.R;
import com.zzz.mvpzzz.sample1.contract.LoginContract;
import com.zzz.mvpzzz.sample1.pojo.User;
import com.zzz.mvpzzz.sample1.presenter.LoginPresenter;

/**
 * @author 请叫我张懂
 * @Date 2018/3/9 15:19
 * @Description
 */

public class LoginActivity extends BaseMvpActivity implements LoginContract.ILoginView {
    private Button btnLogin;
    private EditText etAccount;
    private EditText etPassword;

    @InjectPresenter
    private LoginPresenter loginPresenter;

    @Override
    protected int setContentView() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        etAccount = this.findViewById(R.id.et_account);
        etPassword = this.findViewById(R.id.et_password);
        btnLogin = this.findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = etAccount.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                User user = new User(account, password);
                loginPresenter.toLogin(user);
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    public void LoginSuccess() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void loginFail(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
