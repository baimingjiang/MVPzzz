package com.zzz.mvpzzz.view;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zzz.mvp.base.BaseMvpFragment;
import com.zzz.mvp.inject.InjectPresenter;
import com.zzz.mvpzzz.R;
import com.zzz.mvpzzz.contract.ILoginContract;
import com.zzz.mvpzzz.pojo.User;
import com.zzz.mvpzzz.presenter.LoginPresenter;

/**
 * @author 请叫我张懂
 * @Date 2018/3/10 9:57
 * @Description
 */

public class LoginFragment extends BaseMvpFragment implements ILoginContract.ILoginView {
    private EditText etAccount;
    private EditText etPassword;
    private Button btnLogin;

    @InjectPresenter
    private LoginPresenter loginPresenter;

    @Override
    protected int createView() {
        return R.layout.fragment_login;
    }

    @Override
    protected void initView(View view) {
        btnLogin = view.findViewById(R.id.btn_login);
        etAccount = view.findViewById(R.id.et_account);
        etPassword = view.findViewById(R.id.et_password);
        //
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
    protected void loadData() {

    }


    @Override
    public void LoginSuccess() {
        Intent intent = new Intent(getContext(), MainActivity.class);
        startActivity(intent);
        getActivity().finish();
    }

    @Override
    public void loginFail(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
