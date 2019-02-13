package com.example.administrator.mydialog.select_time;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;


import com.example.administrator.mydialog.R;
import com.example.administrator.mydialog.util.LogUtil;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 选择时间 年月日 年月。。。  都可选
 */
public class TimerUtil {

    public TimerUtil() {

    }

    private TimePickerView pvCustomTime_day;  //显示年月日
    private TimePickerView pvCustomTime_month;  //显示年月

    /**
     * 显示年月日
     *
     * @param context
     * @param textView
     * @return
     */
    public TimePickerView initCustomTimePicker_day(Context context, final TextView textView) {


        /**
         * @description
         *
         * 注意事项：
         * 1.自定义布局中，id为 optionspicker 或者 timepicker 的布局以及其子控件必须要有，否则会报空指针.
         * 具体可参考demo 里面的两个自定义layout布局。
         * 2.因为系统Calendar的月份是从0-11的,所以如果是调用Calendar的set方法来设置时间,月份的范围也要是从0-11
         * setRangDate方法控制起始终止时间(如果不设置范围，则使用默认时间1900-2100年，此段代码可注释)
         */
        Calendar selectedDate = Calendar.getInstance();//系统当前时间
//        Calendar startDate = Calendar.getInstance();
//        startDate.set(2014, 1, 23);
//        Calendar endDate = Calendar.getInstance();
//        endDate.set(2027, 2, 28);
        //时间选择器 ，自定义布局

        pvCustomTime_day = new TimePickerBuilder(context, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                textView.setText(getTime_day(date));
            }
        })
                /*.setType(TimePickerView.Type.ALL)//default is all
                .setCancelText("Cancel")
                .setSubmitText("Sure")
                .setContentTextSize(18)
                .setTitleSize(20)
                .setTitleText("Title")
                .setTitleColor(Color.BLACK)
               /*.setDividerColor(Color.WHITE)//设置分割线的颜色
                .setTextColorCenter(Color.LTGRAY)//设置选中项的颜色
                .setLineSpacingMultiplier(1.6f)//设置两横线之间的间隔倍数
                .setTitleBgColor(Color.DKGRAY)//标题背景颜色 Night mode
                .setBgColor(Color.BLACK)//滚轮背景颜色 Night mode
                .setSubmitColor(Color.WHITE)
                .setCancelColor(Color.WHITE)*/
                /*.animGravity(Gravity.RIGHT)// default is center*/
                .setDate(selectedDate)
//                .setRangDate(startDate, endDate)
//                .setGravity(Gravity.RIGHT)
                .setLayoutRes(R.layout.pickerview_custom_time_1, new CustomListener() {

                    @Override
                    public void customLayout(View v) {

                        WheelView hour;
                        WheelView min;
                        WheelView year;
                        WheelView month;
                        WheelView day;
                        WheelView second;

                        hour = v.findViewById(R.id.hour);
                        min = v.findViewById(R.id.min);
                        year = v.findViewById(R.id.year);
                        month = v.findViewById(R.id.month);
                        day = v.findViewById(R.id.day);
                        second = v.findViewById(R.id.second);


                        final TextView tvSubmit = (TextView) v.findViewById(R.id.tv_finish);
                        TextView ivCancel = (TextView) v.findViewById(R.id.iv_cancel);
                        tvSubmit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                pvCustomTime_day.returnData();
                                pvCustomTime_day.dismiss();
                            }
                        });
                        ivCancel.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                pvCustomTime_day.dismiss();
                            }
                        });
                    }
                })
                .setContentTextSize(18)
                .setType(new boolean[]{true, true, true, false, false, false})
                .setLabel("年", "月", "日", "时", "分", "秒")
                .setLineSpacingMultiplier(1.5f)
                .setTextXOffset(0, 0, 0, 40, 0, -40)
                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .setDividerColor(Color.parseColor("#ABA9A2"))
                .isCyclic(true)
                .build();

        pvCustomTime_day.setOutSideCancelable(false);

//        pvCustomTime_day.setGravityRight_(Gravity.RIGHT);
//        pvCustomTime_day.setGravityLeft_(Gravity.LEFT);
//        pvCustomTime_day.setGravityRightBool_(true);
//        pvCustomTime_day.setGravityLeftBool_(true);

        return pvCustomTime_day;
    }

    private String getTime_day(Date date) {//可根据需要自行截取数据显示
        LogUtil.logDebug("getTime()", "choice date millis: " + date.getTime());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        return format.format(date);
    }


    /**
     * 显示年月
     *
     * @param context
     * @param textView
     * @return
     */
    public TimePickerView initCustomTimePicker_month(Context context, final TextView textView) {


        /**
         * @description
         *
         * 注意事项：
         * 1.自定义布局中，id为 optionspicker 或者 timepicker 的布局以及其子控件必须要有，否则会报空指针.
         * 具体可参考demo 里面的两个自定义layout布局。
         * 2.因为系统Calendar的月份是从0-11的,所以如果是调用Calendar的set方法来设置时间,月份的范围也要是从0-11
         * setRangDate方法控制起始终止时间(如果不设置范围，则使用默认时间1900-2100年，此段代码可注释)
         */
        Calendar selectedDate = Calendar.getInstance();//系统当前时间
//        Calendar startDate = Calendar.getInstance();
//        startDate.set(2014, 1, 23);
//        Calendar endDate = Calendar.getInstance();
//        endDate.set(2027, 2, 28);
        //时间选择器 ，自定义布局

        pvCustomTime_month = new TimePickerBuilder(context, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                textView.setText(getTime_month(date));
            }
        })
                /*.setType(TimePickerView.Type.ALL)//default is all
                .setCancelText("Cancel")
                .setSubmitText("Sure")
                .setContentTextSize(18)
                .setTitleSize(20)
                .setTitleText("Title")
                .setTitleColor(Color.BLACK)
               /*.setDividerColor(Color.WHITE)//设置分割线的颜色
                .setTextColorCenter(Color.LTGRAY)//设置选中项的颜色
                .setLineSpacingMultiplier(1.6f)//设置两横线之间的间隔倍数
                .setTitleBgColor(Color.DKGRAY)//标题背景颜色 Night mode
                .setBgColor(Color.BLACK)//滚轮背景颜色 Night mode
                .setSubmitColor(Color.WHITE)
                .setCancelColor(Color.WHITE)*/
                /*.animGravity(Gravity.RIGHT)// default is center*/
                .setDate(selectedDate)
//                .setRangDate(startDate, endDate)
                .setLayoutRes(R.layout.pickerview_custom_time_2, new CustomListener() {

                    @Override
                    public void customLayout(View v) {

                        WheelView hour;
                        WheelView min;
                        WheelView year;
                        WheelView month;
                        WheelView day;
                        WheelView second;

                        hour = v.findViewById(R.id.hour);
                        min = v.findViewById(R.id.min);
                        year = v.findViewById(R.id.year);
                        month = v.findViewById(R.id.month);
                        day = v.findViewById(R.id.day);
                        second = v.findViewById(R.id.second);


                        final TextView tvSubmit = (TextView) v.findViewById(R.id.tv_finish);
                        TextView ivCancel = (TextView) v.findViewById(R.id.iv_cancel);
                        tvSubmit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                pvCustomTime_month.returnData();
                                pvCustomTime_month.dismiss();
                            }
                        });
                        ivCancel.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                pvCustomTime_month.dismiss();
                            }
                        });
                    }
                })
                .setContentTextSize(18)
                .setType(new boolean[]{true, true, false, false, false, false})
                .setLabel("年", "月", "日", "时", "分", "秒")
                .setLineSpacingMultiplier(1.5f)
                .setTextXOffset(0, 0, 0, 40, 0, -40)
                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .setDividerColor(Color.parseColor("#ABA9A2"))
                .isCyclic(true)
                .build();

        pvCustomTime_month.setOutSideCancelable(false);

//        pvCustomTime_month.setGravityRight_(Gravity.RIGHT);
//        pvCustomTime_month.setGravityLeft_(Gravity.LEFT);
//        pvCustomTime_month.setGravityRightBool_(true);
//        pvCustomTime_month.setGravityLeftBool_(true);

        return pvCustomTime_month;
    }

    private String getTime_month(Date date) {//可根据需要自行截取数据显示
        LogUtil.logDebug("getTime()", "choice date millis: " + date.getTime());
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        return format.format(date);
    }

}
