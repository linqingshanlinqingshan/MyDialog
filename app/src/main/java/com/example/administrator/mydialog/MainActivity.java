package com.example.administrator.mydialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.mydialog.download.DownLoadDialog;
import com.example.administrator.mydialog.edit_data.ShowEditDataDialog;
import com.example.administrator.mydialog.select_date.SelectTimeUtils;
import com.example.administrator.mydialog.select_time.TimePickerView;
import com.example.administrator.mydialog.select_time.TimerUtil;
import com.example.administrator.mydialog.util.LogUtil;
import com.example.administrator.mydialog.util.ToastUtil;

import java.util.ArrayList;

/**
 * 各种 dialog 参考网上的类
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "----->MainActivity";

    TextView tv_download;

    TextView tv_select_time_day;
    TextView tv_select_time_month;
    TextView tv_edit_data;
    TextView tv_select_date;

    DownLoadDialog dialogDownload;

    TextView tv_01;
    TextView tv_02;
    TextView tv_03;
    TextView tv_04;
    TextView tv_05;
    TextView tv_06;
    TextView tv_07;
    TextView tv_08;
    TextView tv_09;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_01 = findViewById(R.id.tv_01);
        tv_02 = findViewById(R.id.tv_02);
        tv_03 = findViewById(R.id.tv_03);
        tv_04 = findViewById(R.id.tv_04);
        tv_05 = findViewById(R.id.tv_05);
        tv_06 = findViewById(R.id.tv_06);
        tv_07 = findViewById(R.id.tv_07);
        tv_08 = findViewById(R.id.tv_08);
        tv_09 = findViewById(R.id.tv_09);

        tv_01.setOnClickListener(this);
        tv_02.setOnClickListener(this);
        tv_03.setOnClickListener(this);
        tv_04.setOnClickListener(this);
        tv_05.setOnClickListener(this);
        tv_06.setOnClickListener(this);
        tv_07.setOnClickListener(this);
        tv_08.setOnClickListener(this);
        tv_09.setOnClickListener(this);

        tv_download = findViewById(R.id.tv_download);
        tv_download.setOnClickListener(this);

        tv_select_time_day = findViewById(R.id.tv_select_time_day);
        tv_select_time_day.setOnClickListener(this);

        tv_select_time_month = findViewById(R.id.tv_select_time_month);
        tv_select_time_month.setOnClickListener(this);

        tv_edit_data = findViewById(R.id.tv_edit_data);
        tv_edit_data.setOnClickListener(this);

        tv_select_date = findViewById(R.id.tv_select_date);
        tv_select_date.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_download:

                if (dialogDownload != null && dialogDownload.isShowing()) {
                    dialogDownload.dismiss();
                }

                dialogDownload = new DownLoadDialog(this, R.style.Style_LoadingDialog, "", "", new DownLoadDialog.SendEmail() {
                    @Override
                    public void sendEmail(String email_address) {
                        LogUtil.logDebug("email", "email:" + email_address);
                        ToastUtil.showToastSHORT(email_address);
                    }

                    @Override
                    public void tipDialog() {

                    }
                });

                dialogDownload.show();

                break;

            case R.id.tv_select_time_day:

                TimePickerView timePickerView_day;

                TimerUtil timerUtil_day = new TimerUtil();  //在 Activity 按返回键时销毁
                timePickerView_day = timerUtil_day.initCustomTimePicker_day(this, tv_select_time_day);
                timePickerView_day.show();

                break;

            case R.id.tv_select_time_month:

                TimePickerView timePickerView_month;

                TimerUtil timerUtil_month = new TimerUtil();  //在 Activity 按返回键时销毁
                timePickerView_month = timerUtil_month.initCustomTimePicker_month(this, tv_select_time_month);
                timePickerView_month.show();

                break;

            case R.id.tv_edit_data:

                ShowEditDataDialog showEditDataDialog = new ShowEditDataDialog(this);
                showEditDataDialog.showEditDataDialog();

                break;

            case R.id.tv_select_date:

                Dialog dialog = SelectTimeUtils.onCreateDialog(tv_select_date, this);
                dialog.show();

                break;

            case R.id.tv_01:
                tv_01();
                break;
            case R.id.tv_02:
                tv_02();
                break;
            case R.id.tv_03:
                tv_03();
                break;
            case R.id.tv_04:
                tv_04();
                break;
            case R.id.tv_05:
                tv_05();
                break;
            case R.id.tv_06:
                tv_06();
                break;
            case R.id.tv_07:
                tv_07();
                break;
            case R.id.tv_08:
                tv_08();
                break;
            case R.id.tv_09:
                tv_09();
                break;
        }

    }

    private void tv_01() {
        final AlertDialog.Builder normalDialog =
                new AlertDialog.Builder(MainActivity.this);
        normalDialog.setIcon(R.drawable.icon);
        normalDialog.setTitle("这是一个Dialog");
        normalDialog.setMessage("你要点击哪一个按钮?");
        normalDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //...To-do
                    }
                });
        normalDialog.setNegativeButton("关闭",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //...To-do
                    }
                });

        normalDialog.show();

    }

    private void tv_02() {
        AlertDialog.Builder normalDialog =
                new AlertDialog.Builder(MainActivity.this);
        normalDialog.setIcon(R.drawable.icon);
        normalDialog.setTitle("我是一个Dialog").setMessage("你要点击哪一个按钮?");
        normalDialog.setPositiveButton("按钮1",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // ...To-do
                    }
                });
        normalDialog.setNeutralButton("按钮2",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // ...To-do
                    }
                });
        normalDialog.setNegativeButton("按钮3", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // ...To-do
            }
        });

        normalDialog.show();
    }

    /**
     * 列表
     */
    private void tv_03() {
        final String[] items = {"我是1", "我是2", "我是3", "我是4"};
        AlertDialog.Builder listDialog =
                new AlertDialog.Builder(MainActivity.this);
        listDialog.setTitle("我是一个列表Dialog");
        listDialog.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // which 下标从0开始
                // ...To-do
                ToastUtil.showToastSHORT("你点击了" + items[which]);
            }
        });
        listDialog.show();
    }

    int yourChoice;

    /**
     * 单选
     */
    private void tv_04() {
        final String[] items = {"我是1", "我是2", "我是3", "我是4"};
        yourChoice = -1;
        AlertDialog.Builder singleChoiceDialog =
                new AlertDialog.Builder(MainActivity.this);
        singleChoiceDialog.setTitle("我是一个单选Dialog");
        // 第二个参数是默认选项，此处设置为0
        singleChoiceDialog.setSingleChoiceItems(items, 0,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        yourChoice = which;
                    }
                });
        singleChoiceDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (yourChoice != -1) {
                            ToastUtil.showToastSHORT("你选择了" + items[yourChoice]);
                        }
                    }
                });
        singleChoiceDialog.show();
    }

    /**
     * 多选
     */
    private void tv_05() {

        final ArrayList<Integer> yourChoices = new ArrayList<>();

        final String[] items = {"我是1", "我是2", "我是3", "我是4"};
        // 设置默认选中的选项，全为false默认均未选中
        final boolean initChoiceSets[] = {false, false, false, false};
        yourChoices.clear();
        AlertDialog.Builder multiChoiceDialog =
                new AlertDialog.Builder(MainActivity.this);
        multiChoiceDialog.setTitle("我是一个多选Dialog");
        multiChoiceDialog.setMultiChoiceItems(items, initChoiceSets,
                new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which,
                                        boolean isChecked) {
                        if (isChecked) {
                            yourChoices.add(which);
                        } else {
                            yourChoices.remove(which);
                        }
                    }
                });
        multiChoiceDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int size = yourChoices.size();
                        String str = "";
                        for (int i = 0; i < size; i++) {
                            str += items[yourChoices.get(i)] + " ";
                        }
                        ToastUtil.showToastSHORT("你选中了" + str);
                    }
                });
        multiChoiceDialog.show();

    }

    /**
     * 等待
     */
    private void tv_06() {
        ProgressDialog waitingDialog =
                new ProgressDialog(MainActivity.this);
        waitingDialog.setTitle("我是一个等待Dialog");
        waitingDialog.setMessage("等待中...");
        waitingDialog.setIndeterminate(true);
        waitingDialog.setCancelable(false);
        waitingDialog.show();
    }

    /**
     * 进度条
     */
    private void tv_07() {
        /* @setProgress 设置初始进度
         * @setProgressStyle 设置样式（水平进度条）
         * @setMax 设置进度最大值
         */
        final int MAX_PROGRESS = 100;
        final ProgressDialog progressDialog =
                new ProgressDialog(MainActivity.this);
        progressDialog.setProgress(0);
        progressDialog.setTitle("我是一个进度条Dialog");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setMax(MAX_PROGRESS);
        progressDialog.show();
        /* 模拟进度增加的过程
         * 新开一个线程，每个100ms，进度增加1
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                int progress = 0;
                while (progress < MAX_PROGRESS) {
                    try {
                        Thread.sleep(100);
                        progress++;
                        progressDialog.setProgress(progress);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 进度达到最大值后，窗口消失
                progressDialog.cancel();
            }
        }).start();
    }

    /**
     * 编辑
     */
    private void tv_08() {
        /*@setView 装入一个EditView
         */
        final EditText editText = new EditText(this);
        AlertDialog.Builder inputDialog =
                new AlertDialog.Builder(this);
        inputDialog.setTitle("我是一个输入Dialog").setView(editText);
        inputDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ToastUtil.showToastSHORT(editText.getText().toString());
                    }
                }).show();
    }

    /**
     * 自定义
     */
    private void tv_09() {
        /* @setView 装入自定义View ==> R.layout.dialog_customize
         * 由于dialog_customize.xml只放置了一个EditView，因此和图8一样
         * dialog_customize.xml可自定义更复杂的View
         */
        AlertDialog.Builder customizeDialog = new AlertDialog.Builder(MainActivity.this);
        final View dialogView = LayoutInflater.from(MainActivity.this).inflate(R.layout.dialog_customize, null);
        customizeDialog.setTitle("我是一个自定义Dialog");
        customizeDialog.setView(dialogView);
        customizeDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 获取EditView中的输入内容
                        EditText edit_text = dialogView.findViewById(R.id.edit_text);
                        ToastUtil.showToastSHORT(edit_text.getText().toString());
                    }
                });
        customizeDialog.show();
    }

}
