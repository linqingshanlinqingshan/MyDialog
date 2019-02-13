package com.example.administrator.mydialog.edit_data;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.mydialog.R;
import com.example.administrator.mydialog.util.LogUtil;
import com.example.administrator.mydialog.util.SPUtils;
import com.example.administrator.mydialog.util.ScreenUtil;

import java.util.Arrays;

public class ShowEditDataDialog {

    private static final String TAG = "----->ShowEditDataDialog";

    Activity activity;

    public ShowEditDataDialog(Activity activity) {
        this.activity = activity;
        initData();
    }


    // 户型
    private String string_selectHuxing = "";

    // 色系
    private String string_selectColorSystem = "";

    // 风格
    private String string_selectStyle = "";

    // 预算
    private String string_selectBudget = "";

    // 行业
    private String string_selectIndustry = "";

    // 兴趣
    private String string_selectInterest = "";

    // 倾向
    private String string_selectInclination = "";

    private void initData() {
        // 户型
        string_selectHuxing = activity.getResources().getString(R.string.selectHuxing);

        // 色系
        string_selectColorSystem = activity.getResources().getString(R.string.selectColorSystem);

        // 风格
        string_selectStyle = activity.getResources().getString(R.string.selectStyle);

        // 预算
        string_selectBudget = activity.getResources().getString(R.string.selectBudget);

        // 行业
        string_selectIndustry = activity.getResources().getString(R.string.selectIndustry);

        // 兴趣
        string_selectInterest = activity.getResources().getString(R.string.selectInterest);

        // 倾向
        string_selectInclination = activity.getResources().getString(R.string.selectInclination);
    }


    // 户型--临时保存的数据
    private static String temp_textView_Huxing = "";

    // 色系--临时保存的数据
    private static String temp_textView_ColorSystem = "";

    // 风格--临时保存的数据
    private static String temp_textView_Style = "";

    // 预算--临时保存的数据
    private static String temp_textView_Budget = "";

    // 行业--临时保存的数据
    private static String temp_textView_Industry = "";

    // 兴趣--临时保存的数据
    private static String temp_textView_Interest = "";

    // 倾向--临时保存的数据
    private static String temp_textView_Inclination = "";

    // 户型
    private String txt_Huxing = "";


    // 色系
    private String txt_ColorSystem = "";


    // 风格
    private String txt_Style = "";


    // 预算
    private String txt_Budget = "";


    // 行业
    private String txt_Industry = "";


    // 兴趣
    private String txt_Interest = "";


    // 倾向
    private String txt_Inclination = "";


    // 户型
    private TextView textView_Huxing;

    // 色系
    private TextView textView_ColorSystem;

    // 风格
    private TextView textView_Style;

    // 预算
    private TextView textView_Budget;

    // 行业
    private TextView textView_Industry;

    // 兴趣
    private TextView textView_Interest;

    // 倾向
    private TextView textView_Inclination;


    private static final String[] Huxing = new String[]{"一室", "两室", "三口", "五口", "别墅"};
    private static final String[] ColorSystem = new String[]{"红色", "橙色", "黄色", "绿色", "青色", "靛色", "紫色", "白色"};
    private static final String[] Style = new String[]{"复古", "中式", "美式", "现代"};
    private static final String[] Budget = new String[]{"2万以下", "2-4万", "4-6万", "6-8万", "8-10万", "10万以上"};
    private static final String[] Industry = new String[]{"IT", "金融", "贸易", "医药", "广告", "房地产", "教育", "服务业", "物流", "能源", "政务"};
    private static final String[] Interest = new String[]{"跑步", "跳舞", "打球", "游戏"};
    private static final String[] Inclination = new String[]{"自己装修", "装修公司"};

    CommonDialogBuilder dialogBuilder;

    public void showEditDataDialog() {

        float width = 0.0f;
        float height = 0.0f;

        boolean isLANDSCAPE = false;

        int screenWidth = ScreenUtil.getScreenWidth(activity);

        int screenHeight = ScreenUtil.getScreenHeight(activity);

        Configuration mConfiguration = activity.getResources().getConfiguration();                      //获取设置的配置信息

        int ori = mConfiguration.orientation;                                                       //获取屏幕方向

        if (ori == mConfiguration.ORIENTATION_LANDSCAPE) {                                          //横屏
//            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);                    //强制为竖屏

            LogUtil.logDebug(TAG, "--->横屏的_screenWidth = " + screenWidth);
            LogUtil.logDebug(TAG, "--->横屏的_screenHeight = " + screenHeight);

            width = 1.0f;
            height = 0.0f;

            isLANDSCAPE = true;

        } else if (ori == mConfiguration.ORIENTATION_PORTRAIT) {                                    //竖屏
//            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);                   //强制为横屏

            LogUtil.logDebug(TAG, "--->竖屏的_screenWidth = " + screenWidth);
            LogUtil.logDebug(TAG, "--->竖屏的_screenHeight = " + screenHeight);

            width = 1.0f;
            height = 1.0f;

            isLANDSCAPE = false;
        }


        dialogBuilder = new CommonDialogBuilder()
                .createDailog2(activity, R.layout.dialog_recordinfo, width, height, isLANDSCAPE, screenWidth)
                .setOnClick(R.id.btn_selectHuxing, new View.OnClickListener() {                     // 户型
                    @Override
                    public void onClick(View v) {
                        TextView textView = dialogBuilder.getView(R.id.btn_selectHuxing);
                        showWheelView("户型", Huxing, textView);
                    }
                })
                .setOnClick(R.id.btn_selectColorSystem, new View.OnClickListener() {                // 色系
                    @Override
                    public void onClick(View v) {
                        TextView textView = dialogBuilder.getView(R.id.btn_selectColorSystem);
                        showWheelView("色系", ColorSystem, textView);
                    }
                })
                .setOnClick(R.id.btn_selectStyle, new View.OnClickListener() {                      // 风格
                    @Override
                    public void onClick(View v) {
                        TextView textView = dialogBuilder.getView(R.id.btn_selectStyle);
                        showWheelView("风格", Style, textView);
                    }
                })
                .setOnClick(R.id.btn_selectBudget, new View.OnClickListener() {                     // 预算
                    @Override
                    public void onClick(View v) {
                        TextView textView = dialogBuilder.getView(R.id.btn_selectBudget);
                        showWheelView("预算", Budget, textView);
                    }
                })
                .setOnClick(R.id.btn_selectIndustry, new View.OnClickListener() {                   // 行业
                    @Override
                    public void onClick(View v) {
                        TextView textView = dialogBuilder.getView(R.id.btn_selectIndustry);
                        showWheelView("行业", Industry, textView);
                    }
                })
                .setOnClick(R.id.btn_selectInterest, new View.OnClickListener() {                   // 兴趣
                    @Override
                    public void onClick(View v) {
                        TextView textView = dialogBuilder.getView(R.id.btn_selectInterest);
                        showWheelView("兴趣", Interest, textView);
                    }
                })
                .setOnClick(R.id.btn_selectInclination, new View.OnClickListener() {                // 倾向
                    @Override
                    public void onClick(View v) {
                        TextView textView = dialogBuilder.getView(R.id.btn_selectInclination);
                        showWheelView("倾向", Inclination, textView);
                    }
                })
                .setOnClick(R.id.btn_nextStep, new View.OnClickListener() {                         // 确定
                    @Override
                    public void onClick(View v) {
                        final EditText dialog_name = dialogBuilder.getView(R.id.dialog_name);
                        EditText dialog_count = dialogBuilder.getView(R.id.dialog_count);
                        EditText dialog_contact = dialogBuilder.getView(R.id.dialog_contact);

//                        final TextView dialog_selectMan = dialogBuilder.getView(R.id.dialog_selectMan);
//                        final TextView dialog_selectWoman = dialogBuilder.getView(R.id.dialog_selectWoman);
//
//                        final TextView dialog_NewCostom = dialogBuilder.getView(R.id.dialog_selectWoman);
//                        final TextView dialog_oldCostom = dialogBuilder.getView(R.id.dialog_oldCostom);

                        String record_id = (String) SPUtils.get(SPUtils.sp_param_recordId, "");


                        LogUtil.logDebug(TAG, "--->record_id = " + record_id);


                        // 保存现有数据
                        SPUtils.put("dialog_name", dialog_name.getText().toString());
                        SPUtils.put("dialog_count", dialog_count.getText().toString());
                        SPUtils.put("dialog_contact", dialog_contact.getText().toString());


//                        //是否已经填写过资料了，否则开始填写，是则保存填写的资料，下次进来时，读取资料，直到点击停止记录
//                        if (!isEnter) {  //第一次填写
//                            isEnter = true;

                        // 户型--临时保存的数据
                        temp_textView_Huxing = textView_Huxing.getText().toString().trim();

                        // 色系--临时保存的数据
                        temp_textView_ColorSystem = textView_ColorSystem.getText().toString().trim();

                        // 风格--临时保存的数据
                        temp_textView_Style = textView_Style.getText().toString().trim();

                        // 预算--临时保存的数据
                        temp_textView_Budget = textView_Budget.getText().toString().trim();

                        // 行业--临时保存的数据
                        temp_textView_Industry = textView_Industry.getText().toString().trim();

                        // 兴趣--临时保存的数据
                        temp_textView_Interest = textView_Interest.getText().toString().trim();

                        // 倾向--临时保存的数据
                        temp_textView_Inclination = textView_Inclination.getText().toString().trim();


//                        } else {        //记下数据
//
//                        }


                        // 户型
                        txt_Huxing = textView_Huxing.getText().toString().trim();

                        if (!TextUtils.isEmpty(txt_Huxing)) {
                            if (txt_Huxing.equalsIgnoreCase(string_selectHuxing)) {
                                txt_Huxing = "";
                            }
                        }


                        // 色系
                        txt_ColorSystem = textView_ColorSystem.getText().toString().trim();

                        if (!TextUtils.isEmpty(txt_ColorSystem)) {
                            if (txt_ColorSystem.equalsIgnoreCase(string_selectColorSystem)) {
                                txt_ColorSystem = "";
                            }
                        }

                        // 风格
                        txt_Style = textView_Style.getText().toString().trim();

                        if (!TextUtils.isEmpty(txt_Style)) {
                            if (txt_Style.equalsIgnoreCase(string_selectStyle)) {
                                txt_Style = "";
                            }
                        }

                        // 预算
                        txt_Budget = textView_Budget.getText().toString().trim();

                        if (!TextUtils.isEmpty(txt_Budget)) {
                            if (txt_Budget.equalsIgnoreCase(string_selectBudget)) {
                                txt_Budget = "";
                            }
                        }

                        // 行业
                        txt_Industry = textView_Industry.getText().toString().trim();

                        if (!TextUtils.isEmpty(txt_Industry)) {
                            if (txt_Industry.equalsIgnoreCase(string_selectIndustry)) {
                                txt_Industry = "";
                            }
                        }

                        // 兴趣
                        txt_Interest = textView_Interest.getText().toString().trim();

                        if (!TextUtils.isEmpty(txt_Interest)) {
                            if (txt_Interest.equalsIgnoreCase(string_selectInterest)) {
                                txt_Interest = "";
                            }
                        }

                        // 倾向
                        txt_Inclination = textView_Inclination.getText().toString().trim();

                        if (!TextUtils.isEmpty(txt_Inclination)) {
                            if (txt_Inclination.equalsIgnoreCase(string_selectInclination)) {
                                txt_Inclination = "";
                            }
                        }

                        dialogBuilder.cancle();

                        LogUtil.logDebug(TAG, "户型:" + txt_Huxing + "  色系:" + txt_ColorSystem + "  风格:" + txt_Style + "  预算:" + txt_Budget + "  行业:" + txt_Industry + "  兴趣:" + txt_Interest + "  倾向:" + txt_Inclination);
                    }
                });

        // 户型
        textView_Huxing = dialogBuilder.getView(R.id.btn_selectHuxing);

        // 色系
        textView_ColorSystem = dialogBuilder.getView(R.id.btn_selectColorSystem);

        // 风格
        textView_Style = dialogBuilder.getView(R.id.btn_selectStyle);

        // 预算
        textView_Budget = dialogBuilder.getView(R.id.btn_selectBudget);

        // 行业
        textView_Industry = dialogBuilder.getView(R.id.btn_selectIndustry);

        // 兴趣
        textView_Interest = dialogBuilder.getView(R.id.btn_selectInterest);

        // 倾向
        textView_Inclination = dialogBuilder.getView(R.id.btn_selectInclination);
    }

    private void showWheelView(final String title, String[] selectItems, final TextView textView) {
        View outerView = LayoutInflater.from(activity).inflate(R.layout.wheel_view, null);
        WheelView wv = outerView.findViewById(R.id.wheel_view_wv);
        wv.setOffset(2);
        wv.setItems(Arrays.asList(selectItems));
        wv.setSeletion(0);
        textView.setText(selectItems[0]);

        wv.setOnWheelViewListener(new WheelView.OnWheelViewListener() {
            @Override
            public void onSelected(int selectedIndex, String item) {
                SPUtils.put(title, item);
                if (textView != null) {
                    textView.setText(item);
                }
            }
        });

        new AlertDialog.Builder(activity)
                .setTitle(title)
                .setView(outerView)
                .setPositiveButton("确定", null)
                .show();

    }

}
