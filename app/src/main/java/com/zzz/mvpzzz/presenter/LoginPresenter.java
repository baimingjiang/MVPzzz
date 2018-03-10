package com.zzz.mvpzzz.presenter;

import android.graphics.Bitmap;
import android.util.Log;

import com.zzz.mvp.base.BasePresenter;
import com.zzz.mvp.inject.InjectModel;
import com.zzz.mvpzzz.contract.ILoginContract;
import com.zzz.mvpzzz.model.UserModel;
import com.zzz.mvpzzz.pojo.User;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * @author 请叫我张懂
 * @Date 2018/3/9 15:48
 * @Description
 */

public class LoginPresenter extends BasePresenter<ILoginContract.ILoginView> implements ILoginContract.ILoginPresenter {
    private static final String TAG = "zzz";
    @InjectModel
    private UserModel userModel;

    @Override
    public void toLogin(User user) {
        //RxJava
//        Log.i(TAG, "toLogin: user --> " + user);
//        Observable.just("url")
//                .map(new Function<String, Bitmap>() {
//                    @Override
//                    public Bitmap apply(String url) throws Exception {
//                        //去下载图片
//                        return null;
//                    }
//                })
//                .map(new Function<Bitmap, Bitmap>() {
//                    @Override
//                    public Bitmap apply(Bitmap bitmap) throws Exception {
//                        //压缩
//                        return bitmap;
//                    }
//                })
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<Bitmap>() {
//                    @Override
//                    public void accept(Bitmap bitmap) throws Exception {
//                            //去显示
//                    }
//                });


        userModel.toLogin(user)
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String result) throws Exception {
                        if ("success".equals(result)) {
                            getView().LoginSuccess();
                        } else {
                            getView().loginFail(result);
                        }
                    }
                });
    }
}
