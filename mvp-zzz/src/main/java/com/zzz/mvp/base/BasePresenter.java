package com.zzz.mvp.base;

import android.util.Log;

import com.zzz.mvp.proxy.presenter.IPresenterMvpProxy;
import com.zzz.mvp.proxy.presenter.impl.PresenterMvpProxy;

import java.lang.ref.SoftReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 请叫我张懂
 * @Date 2018/3/9 12:59
 * @Description
 */

public class BasePresenter<V extends IBaseView> {
    private SoftReference<V> mReferenceView;
    private V mProxyView;

    private IPresenterMvpProxy presenterMvpProxy;

    @SuppressWarnings("unchecked")
    public void attach(V view) {
        Class<?>[] interfaces = view.getClass().getInterfaces();
        if (!checkView(interfaces)) {
            throw new RuntimeException("<<<<<<<<<< " + view.getClass().getName() + "'s interfaces without \"IBaseView\" >>>>>>>>>>");
        }
        mReferenceView = new SoftReference<>(view);
        //用于防止view界面已经销毁处理
        mProxyView = (V) Proxy.newProxyInstance(view.getClass().getClassLoader(), view.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if (null == mReferenceView || null == mReferenceView.get()) {
                            return null;
                        }
                        return method.invoke(mReferenceView.get(), args);
                    }
                });
        //
        injectModel();
    }

    /**
     * 检查View是否有接口且继承于IBaseView
     *
     * @param interfaces
     * @return
     */
    private boolean checkView(Class<?>[] interfaces) {
        for (Class<?> anInterface : interfaces) {
            if (IBaseView.class.isAssignableFrom(anInterface)) {
                return true;
            }
        }
        return false;
    }

    private void injectModel() {
        if (null == presenterMvpProxy) {
            presenterMvpProxy = new PresenterMvpProxy(this);
        }
        presenterMvpProxy.injectModels();
    }

    public void detach() {
        mReferenceView.clear();
        mReferenceView = null;
        //
        presenterMvpProxy.detachModels();
    }

    protected V getView() {
        return mProxyView;
    }
}
