package com.example.administrator.mydialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.mydialog.download.DownLoadDialog;
import com.example.administrator.mydialog.edit_data.CommonDialogBuilder;
import com.example.administrator.mydialog.edit_data.ShowEditDataDialog;
import com.example.administrator.mydialog.edit_data.WheelView;
import com.example.administrator.mydialog.select_date.SelectTimeUtils;
import com.example.administrator.mydialog.select_time.TimePickerView;
import com.example.administrator.mydialog.select_time.TimerUtil;
import com.example.administrator.mydialog.util.LogUtil;
import com.example.administrator.mydialog.util.SPUtils;
import com.example.administrator.mydialog.util.ScreenUtil;
import com.example.administrator.mydialog.util.ToastUtil;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "----->MainActivity";

    TextView tv_download;

    TextView tv_select_time_day;
    TextView tv_select_time_month;
    TextView tv_edit_data;
    TextView tv_select_date;

    DownLoadDialog dialogDownload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        }

    }

}
