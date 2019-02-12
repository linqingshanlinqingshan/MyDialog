package com.example.administrator.mydialog.download;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.mydialog.R;
import com.example.administrator.mydialog.email.MailSenderInfo;
import com.example.administrator.mydialog.email.SimpleMailSender;
import com.example.administrator.mydialog.util.OtherUtils;
import com.example.administrator.mydialog.util.ToastUtil;


public class DownLoadDialog extends Dialog {

    public EditText dialog_edt_email;

    public TextView dialog_downurl;
    public TextView btn_copyurl;
    public TextView btn_send;
    public TextView btn_tip;

    public TextView tv_title;



    public ImageView btn_close;
    public ImageView btn_right_close;

    public String productName;
    public String downurl;

    public String startDate;
    public String endDate;

    public Context context;

    public interface SendEmail {
        void sendEmail(String email_address);
        void tipDialog();
    }

    private SendEmail sendEmailInterface;

    public SendEmail getSendEmailInterface() {
        return sendEmailInterface;
    }

    public DownLoadDialog setSendEmailInterface(SendEmail sendEmailInterface) {
        this.sendEmailInterface = sendEmailInterface;
        return this;
    }

    protected DownLoadDialog(Context context) {
        super(context);
    }

    public DownLoadDialog(Context context, int theme, String productName, String downurl, SendEmail sendEmailInterface) {
        super(context, theme);
        this.context = context;
        this.productName = productName;
        this.downurl = downurl;
        this.sendEmailInterface = sendEmailInterface;
        this.setCancelable(true);
    }

    public DownLoadDialog(Context context, int theme, String productName, String downurl, String startDate, String endDate, SendEmail sendEmailInterface) {
        super(context, theme);
        this.context = context;
        this.productName = productName;
        this.downurl = downurl;
        this.startDate = startDate;
        this.endDate = endDate;
        this.sendEmailInterface = sendEmailInterface;
        this.setCancelable(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.dialog_download);

        dialog_downurl = (TextView)findViewById(R.id.dialog_downurl);
        btn_copyurl = (TextView)findViewById(R.id.btn_copyurl);
        dialog_edt_email = (EditText) findViewById(R.id.dialog_edt_email);
        btn_send = (TextView) findViewById(R.id.btn_send);

        btn_close = (ImageView) findViewById(R.id.btn_close);
        btn_right_close = (ImageView) findViewById(R.id.btn_right_close);
        btn_tip = (TextView) findViewById(R.id.btn_tip);


        tv_title = findViewById(R.id.tv_title);



//        ViewGroup.LayoutParams layoutParams = (ViewGroup.LayoutParams) dialog_imagelayout.getLayoutParams();
//
//        if (TextUtils.isEmpty(title) && TextUtils.isEmpty(content)) {
//            layoutParams.height = ScreenUtil.getScreenHeight(getContext()) * 60 / 100;
//            dialog_imageview.setLayoutParams(layoutParams);
//        }

        dialog_downurl.setText(TextUtils.isEmpty(downurl) ? "" : downurl);
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        btn_right_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailInput = dialog_edt_email.getText().toString();
                if (!TextUtils.isEmpty(emailInput) && emailInput.contains("@")) {
//                    Intent data = new Intent(Intent.ACTION_SENDTO);
////                    data.setData(Uri.parse("mailto:455245521@qq.com"));
//                    data.setData(Uri.parse(emailInput));
//                    data.putExtra(Intent.EXTRA_SUBJECT, "简一产品");
//                    data.putExtra(Intent.EXTRA_TEXT, downurl);
//                    context.startActivity(data);
                    if (sendEmailInterface!=null) {
                        sendEmailInterface.sendEmail(emailInput);
                    }
//                    sendUploadMessage("您好，您要的案例附件下载地址在这里 \n" + downurl);
                } else {
                    Toast.makeText(context, "请输入正确的邮箱地址", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_tip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sendEmailInterface!=null) {
                    sendEmailInterface.tipDialog();
                }
            }
        });

        btn_copyurl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OtherUtils.copyText(context, downurl);
            }
        });

    }


    private void sendMessage(final String msg) {

        /*****************************************************/
        Log.i("shuxinshuxin", "开始发送邮件");
        // 这个类主要是设置邮件
        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                MailSenderInfo mailInfo = new MailSenderInfo();
                mailInfo.setMailServerHost("smtp.163.com");
                mailInfo.setMailServerPort("25");
                mailInfo.setValidate(true);
                mailInfo.setUserName("gani.brand@163.com");
                mailInfo.setPassword("fyni wvnw rcoa bfaj");// 您的邮箱密码
                mailInfo.setFromAddress("gani.brand@163.com");
                mailInfo.setToAddress("472596846@qq.com");
                mailInfo.setSubject("案例 " + productName + " 附件");
                mailInfo.setContent(msg);

                // 这个类主要来发送邮件
                SimpleMailSender sms = new SimpleMailSender();
                boolean isSuccess = sms.sendTextMail(mailInfo);// 发送文体格式
                // sms.sendHtmlMail(mailInfo);//发送html格式
                if (isSuccess) {
                    Log.e("shuxinshuxin", "发送成功");
                    ToastUtil.showToastSHORT("发送成功");
                } else {
                    Log.e("shuxinshuxin", "发送失败");
                    ToastUtil.showToastSHORT("发送失败");
                }
            }
        }).start();}

//    //正确实现方式
//    private void showPromptDialog(String text, String function) {
//        Dialog dlg = new AlertDialog.Builder(this).create();
//        dlg.setCancelable(false);
//        dlg.show();
//        Window window = dlg.getWindow();
//        window.setContentView(R.layout.cp_alertdialog_prompt);
//        dlg.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
//    }


}
