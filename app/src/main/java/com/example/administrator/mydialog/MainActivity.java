package com.example.administrator.mydialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.mydialog.download.DownLoadDialog;
import com.example.administrator.mydialog.util.LogUtil;
import com.example.administrator.mydialog.util.ToastUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tv_download;

    DownLoadDialog dialogDownload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_download = findViewById(R.id.tv_download);
        tv_download.setOnClickListener(this);

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
        }
    }
}
