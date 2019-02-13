package com.example.administrator.mydialog.select_date;


import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.util.Log;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.administrator.mydialog.util.LogUtil;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SelectTimeUtils {

    private static final String TAG = "----->SelectTimeUtils";
    private static Calendar c = null;



    /**
     * 选择时间
     *
     * @param textView
     * @param activity
     * @return
     */
    public static Dialog onCreateDialog(final TextView textView, Activity activity) {
        Dialog dialog = null;
        c = Calendar.getInstance();
        dialog = new DatePickerDialog(activity, new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker dp, int year, int month, int dayOfMonth) {

                if (month > 8 && dayOfMonth > 9) {//月10-日10

                    textView.setText(year + "-" + (month + 1) + "-" + dayOfMonth);

                } else if (month > 8 && dayOfMonth <= 9) {//月10-日02

                    textView.setText(year + "-" + (month + 1) + "-0" + dayOfMonth);

                } else if (month <= 8 && dayOfMonth <= 9) {//月02-日03

                    textView.setText(year + "-0" + (month + 1) + "-0" + dayOfMonth);

                } else if (month <= 8 && dayOfMonth > 9) {//月02-日10

                    textView.setText(year + "-0" + (month + 1) + "-" + dayOfMonth);

                }
            }
        }, c.get(Calendar.YEAR), // 传入年份
                c.get(Calendar.MONTH), // 传入月份
                c.get(Calendar.DAY_OF_MONTH) // 传入天数
        );

        return dialog;
    }

    /**
     * 返回 1 return  比较两个时间的大小 DATE1 > DATE2
     *
     * @param DATE1
     * @param DATE2
     * @return
     */
    public static int compare_date(String DATE1, String DATE2) {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            if (dt1.getTime() > dt2.getTime()) {
                Log.d(TAG, "------> dt1 在 dt2 前 = " + " ---> dt1 = " + dt1.getTime()
                        + " ---> dt2 = " + dt2.getTime());
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                Log.d(TAG, "------> dt1 在 dt2 后 = " + " ---> dt1 = " + dt1.getTime()
                        + " ---> dt2 = " + dt2.getTime());
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }


    /**
     * 时间格式转换 2018-11-01 00-00-00  --->> 2018-11-01    //就是去掉 时 分 秒
     *
     * @param time
     * @return
     */
    public static String TimeFormatConversion(String time) {
        String format_1 = "yyyy-MM-dd HH:mm:ss";
        String format_2 = "yyyy-MM-dd";
        String date = "";
        boolean b = parseDate(time, format_1);

        if (b) {
            SimpleDateFormat OldDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat NewFormat = new SimpleDateFormat("yyyy-MM-dd");

            try {
                date = NewFormat.format(OldDateFormat.parse(time));
                return date;
            } catch (ParseException e) {
                e.printStackTrace();
                return "";
            }
        } else {
            boolean b1 = parseDate(time, format_2);
            if (b1) {
                return time;
            }
        }
        return "";
    }

    /**
     * 先判断是不是这种格式
     *
     * @param data
     * @param formats
     * @return
     */
    public static boolean parseDate(String data, String formats) {
        // 利用java中的SimpleDateFormat类，指定日期格式，注意yyyy,MM大小写
        // 这里的日期格式要求javaAPI中有详细的描述，不清楚的话可以下载相关API查看
        SimpleDateFormat format = new SimpleDateFormat(formats);

        // 设置日期转化成功标识
        boolean dateflag = true;

        try {
            Date date = format.parse(data);
        } catch (Exception e) {
            dateflag = false;
        }
        // 成功：true ;失败:false
        return dateflag;
    }


    /**
     * 获取未来 第  n 天的日期
     *
     * @param n
     * @return
     */
    public static String getFetureDate(int n) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + n);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String date = format.format(today);

        LogUtil.logDebug(TAG, "--->获取未来 第  n 天的日期 " + date);

        return date;
    }


    /**
     * 获取过去第几天的日期
     *
     * @param past
     * @return
     */
    public static String getPastDate(int past) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String date = format.format(today);

        LogUtil.logDebug(TAG, "--->获取未来 第  n 天的日期 " + date);

        return date;
    }


    /**
     * 获取年
     *
     * @return
     */
    public static int getYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    /**
     * 获取月
     *
     * @return
     */
    public static int getMonth() {
        return ((Calendar.getInstance().get(Calendar.MONTH)) + 1);
    }

    /**
     * 获取日
     *
     * @return
     */
    public static int getDay() {
        return Calendar.getInstance().get(Calendar.DATE);
    }


    /**
     * @param titleTv 显示标题的控件
     * @param title   按月查询还是按日查询的标题
     * @param startTv 开始日期  日则往前推7日  月则往前推1年
     * @param endTv   结束日期  日则当天  月则当月
     * @param type    按月还是按日的类型
     * @param past    过去几天
     */
    public static void setMoreTime(TextView titleTv, String title, TextView startTv, TextView endTv, String type, int past) {

        LogUtil.logDebug(TAG, "--->setMoreTime getMonth() = " + getMonth());

        titleTv.setText(title);

        String day = "";

        String month = "";

        month = "" + getMonth();
        if (month.length() == 1) {
            month = "0" + month;
        }

        if (type.equals("MONTH")) {

            String year;

            year = "" + (getYear() - 1);

            startTv.setText(year + "-" + month);

            endTv.setText(getYear() + "-" + month);


        } else if (type.equals("DAY")) {


            day = "" + getDay();
            if (day.length() == 1) {
                day = "0" + day;
            }


            String endDate = getYear() + "-" + month + "-" + day;

            endTv.setText(endDate);

            startTv.setText(getPastDate(past));
        }


        LogUtil.logDebug(TAG, "--->setMoreTime month = " + month);
        LogUtil.logDebug(TAG, "--->setMoreTime day = " + day);

    }


    /**
     * @param titleTv 显示标题的控件
     * @param title   按月查询还是按日查询的标题
     * @param timeTv  日期
     * @param type    按月还是按日的类型
     */
    public static void setSingleTime(TextView titleTv, String title, TextView timeTv, String type) {

        titleTv.setText(title);


        String day;
        day = "" + getDay();
        if (day.length() == 1) {
            day = "0" + day;
        }

        String month;
        month = "" + getMonth();
        if (month.length() == 1) {
            month = "0" + month;
        }

        String year;

        year = "" + getYear();


        if (type.equals("MONTH")) {

            timeTv.setText(year + "-" + month);

        } else if (type.equals("DAY")) {

            timeTv.setText(year + "-" + month + "-" + day);

        }


        LogUtil.logDebug(TAG, "--->setMoreTime month = " + month);
        LogUtil.logDebug(TAG, "--->setMoreTime day = " + day);

    }

}
