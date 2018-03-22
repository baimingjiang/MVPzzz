package com.zzz.mvp.base;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * @author 请叫我张懂
 * @Date 2018/3/22 16:41
 * @Description
 */

class KeyboardActivity extends AppCompatActivity {

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                View view = getCurrentFocus();
                hideKeyboard(event, view, KeyboardActivity.this);//调用方法判断是否需要隐藏键盘
                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }


    /**
     * 根据传入控件的坐标和用户的焦点坐标，判断是否隐藏键盘，如果点击的位置在控件内，则不隐藏键盘
     *
     * @param view  控件view
     * @param event 焦点位置
     * @return 是否隐藏
     */
    public static void hideKeyboard(MotionEvent event, View view,
                                    Activity activity) {
        try {
            if (view != null && view instanceof EditText) {
                int[] location = {0, 0};
                view.getLocationInWindow(location);

                int left = location[0];
                int top = location[1];
                int right = left + view.getWidth();
                int bottom = top + view.getHeight();

                // 判断焦点位置坐标是否在空间内
                if (event.getRawX() < left ||
                        event.getRawX() > right ||
                        event.getY() < top ||
                        event.getRawY() > bottom) {
                    // 隐藏键盘
                    IBinder token = view.getWindowToken();
                    InputMethodManager inputMethodManager = (InputMethodManager) activity
                            .getSystemService(Context.INPUT_METHOD_SERVICE);
                    assert inputMethodManager != null;
                    inputMethodManager.hideSoftInputFromWindow(token,
                            InputMethodManager.HIDE_NOT_ALWAYS);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
