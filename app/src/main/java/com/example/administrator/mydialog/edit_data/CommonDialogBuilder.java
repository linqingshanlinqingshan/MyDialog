package com.example.administrator.mydialog.edit_data;

import android.app.Activity;
import android.app.Dialog;

import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;

import android.view.Window;
import android.view.WindowManager;

import android.widget.TextView;

import com.example.administrator.mydialog.R;


/**
 * Created by longhengdong on 2018/5/30.
 * <p>
 * 自定义dialog创建类
 */
public class CommonDialogBuilder {

    private Dialog dialog;
    View contentView;

    /**
     * 创建 dialog
     *
     * @param activity 依赖的窗体
     * @param layoutId 弹出框的 layoutId
     */
    public CommonDialogBuilder createDailog(Activity activity, int layoutId) {
        return createDailog(activity, layoutId, 0.8f, 0.4f);
    }

    /**
     * 创建 dialog 重载类
     *
     * @param layoutId   弹出框的 layoutId
     * @param widthRate  宽度比率
     * @param heightRate 高度比率
     */
    public CommonDialogBuilder createDailog(Activity activity, int layoutId, float widthRate, float heightRate) {
        View contentView = LayoutInflater.from(activity).inflate(layoutId, null);

        if (dialog != null) {
            dialog.show();
            return this;
        }
        this.contentView = contentView;
        try {
            dialog = new Dialog(activity, R.style.MyDialogTheme);

            WindowManager wm = activity.getWindowManager();
            Display d = wm.getDefaultDisplay();
            // 设置宽度为屏宽、靠近屏幕底部。
            Window window = dialog.getWindow();
            WindowManager.LayoutParams wlp = window.getAttributes();
            wlp.gravity = Gravity.CENTER;
            wlp.width = (int) (d.getWidth() * widthRate);
            wlp.height = (int) (d.getHeight() * heightRate);

            window.setAttributes(wlp);

            dialog.setContentView(contentView);
            dialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    /**
     * 创建 dialog 重载类
     *
     * @param layoutId   弹出框的 layoutId
     * @param widthRate  宽度比率
     * @param heightRate 高度比率
     */
    public CommonDialogBuilder createDailog2(Activity activity, int layoutId, float widthRate, float heightRate, boolean isLANDSCAPE, int screenWidth) {
        View contentView = LayoutInflater.from(activity).inflate(layoutId, null);

//        if (isLANDSCAPE) {
//            LinearLayout right_menu_layout = contentView.findViewById(R.id.right_menu_layout);
//
//            ViewGroup.LayoutParams layoutParams = right_menu_layout.getLayoutParams();
//            layoutParams.width = screenWidth / 2;
//            layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
//
//            right_menu_layout.setLayoutParams(layoutParams);
//
//        }

        if (dialog != null) {
            dialog.show();
            return this;
        }
        this.contentView = contentView;
        try {
            dialog = new Dialog(activity, R.style.MyDialogTheme);
//            dialog = new Dialog(activity, R.style.MyDialogTheme2);
//            dialog = new Dialog(activity);


//            WindowManager wm = activity.getWindowManager();
//            Display d = wm.getDefaultDisplay();
//            // 设置宽度为屏宽、靠近屏幕底部。
//            Window window = dialog.getWindow();
//            WindowManager.LayoutParams wlp = window.getAttributes();
//            wlp.gravity = Gravity.CENTER;
//            wlp.width = (int) (d.getWidth() * widthRate);
//            wlp.height = (int) (d.getHeight() * heightRate);
//
//
//            LogUtil.logDebug("屏的_", "--->竖屏的_width = " + wlp.width);
//            LogUtil.logDebug("屏的_", "--->竖屏的_height = " + wlp.height);
//
//
//            window.setAttributes(wlp);

            dialog.setContentView(contentView);
            dialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    /**
     * 设置子布局 textview 的文字
     *
     * @param resourceId textview 的 layoutId
     * @param text       设置的文字
     */
    public CommonDialogBuilder setText(int resourceId, String text) {
        if (contentView != null) {
            ((TextView) contentView.findViewById(resourceId)).setText(text);
        }
        return this;
    }

    /**
     * 设置子布局 View 点击事件
     *
     * @param resourceId      View 的 layoutId
     * @param onClickListener 点击事件回调
     */
    public CommonDialogBuilder setOnClick(int resourceId, View.OnClickListener onClickListener) {
        if (contentView != null) {
            ((View) contentView.findViewById(resourceId)).setOnClickListener(onClickListener);
        }
        return this;
    }

    /**
     * 获取子布局 View
     *
     * @param resourceId View 的 layoutId
     * @param <T>        返回的 View
     */
    public <T extends View> T getView(int resourceId) {
        View view = null;
        if (contentView != null) {
            view = contentView.findViewById(resourceId);
        }

        return (T) view;
    }

    /**
     * 显示 dialog
     */
    public void showDialog() {
        if (dialog != null && !dialog.isShowing()) {
            dialog.show();
        }
    }

    /**
     * cancle dialog
     */
    public void cancle() {
        if (dialog != null && dialog.isShowing()) {
            dialog.cancel();
        }
    }


}
