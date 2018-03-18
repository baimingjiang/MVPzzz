package com.zzz.mvpzzz.sample2.view;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zzz.mvp.base.BaseMvpActivity;
import com.zzz.mvp.inject.InjectPresenter;
import com.zzz.mvpzzz.R;
import com.zzz.mvpzzz.sample2.pojo.User;
import com.zzz.mvpzzz.sample2.presenter.LoginPresenter;
import com.zzz.mvpzzz.sample2.presenter.UserDataPresenter;
import com.zzz.mvpzzz.sample2.view.inter.ILoginView;
import com.zzz.mvpzzz.sample2.view.inter.IUserDataView;

/**
 * @author 请叫我张懂
 * @Date 2018/3/9 15:19
 * @Description
 */

public class LoginActivity extends BaseMvpActivity implements ILoginView, IUserDataView {
    private Button btnLogin;
    private EditText etAccount;
    private EditText etPassword;
    @InjectPresenter
    private LoginPresenter loginPresenter;
    @InjectPresenter
    private UserDataPresenter userDataPresenter;

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
        btnLogin.setClickable(false);
        userDataPresenter.loadLastData();
    }


    @Override
    public void showLoginLoading() {
        Log.i("login", "showLoginLoading: 正在登陆");
    }

    @Override
    public void hideLoginLoading() {
        Log.i("login", "hideLoginLoading: 登录结束");
    }

    @Override
    public void loginSuccess() {
        Log.i("login", "loginSuccess: 登录成功");
        String account = etAccount.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        User user = new User(account, password);
        userDataPresenter.saveData(user);
    }

    @Override
    public void loginFail(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }



    @Override
    public void saveDataSuccess() {
        Log.i("login", "saveDataSuccess: 保存数据成功");
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void saveDataFail(String msg) {
        Log.i("login", "saveDataFail: 保存数据失败 " + msg);
    }

    @Override
    public void readDataSuccess(User user) {
        Log.i("login", "readDataSuccess: 读取数据成功");
        btnLogin.setClickable(true);
        if (!TextUtils.isEmpty(user.getAccount()) && !TextUtils.isEmpty(user.getPassword())) {
            etAccount.setText(user.getAccount());
            etPassword.setText(user.getPassword());
           // loginPresenter.toLogin(user);
        }
    }

    @Override
    public void readDataFail(String msg) {
        Log.i("login", "loadDataFail: 读取数据失败" + msg);
    }
}
