package com.example.administrator.mydialog.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.administrator.mydialog.DemoApplication;

import java.util.Map;

/**
 * Created by Jay on 2015/9/2 0002.
 *
 */
public class SPUtils {

    public static String SP_FILE_NAME = "sp_dialog";

    /**
     * 保存在手机里的SP文件名
     */
    public static String sp_file_name = SP_FILE_NAME;

    public static String sp_param_versionCode = "sp_param_versionCode";
    public static String sp_param_isRecordPsw = "sp_param_isRecordPsw";

    public static String sp_param_recordAccount = "sp_param_recordAccount";
    public static String sp_param_recordPassword = "sp_param_recordPassword";

    public static String sp_param_recordId = "sp_param_recordId";

    public static SharedPreferences getSharedPreferences(){
        return DemoApplication.getInstance().getSharedPreferences(sp_file_name, Context.MODE_PRIVATE);
    }

    /**
     * 保存数据
     */
    public static String put(String key, Object obj) {
        SharedPreferences sp = DemoApplication.getInstance().getSharedPreferences(sp_file_name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        if (obj instanceof Boolean) {
            editor.putBoolean(key, (Boolean) obj);
        } else if (obj instanceof Float) {
            editor.putFloat(key, (Float) obj);
        } else if (obj instanceof Integer) {
            editor.putInt(key, (Integer) obj);
        } else if (obj instanceof Long) {
            editor.putLong(key, (Long) obj);
        } else {
            editor.putString(key, (String) obj);
        }
        editor.commit();
        return key;
    }


    /**
     * 获取指定数据
     */
    public static Object get(String key, Object defaultObj) {
        SharedPreferences sp = DemoApplication.getInstance().getSharedPreferences(sp_file_name, Context.MODE_PRIVATE);
        if (defaultObj instanceof Boolean) {
            return sp.getBoolean(key, (Boolean) defaultObj);
        } else if (defaultObj instanceof Float) {
            return sp.getFloat(key, (Float) defaultObj);
        } else if (defaultObj instanceof Integer) {
            return sp.getInt(key, (Integer) defaultObj);
        } else if (defaultObj instanceof Long) {
            return sp.getLong(key, (Long) defaultObj);
        } else if (defaultObj instanceof String) {
            return sp.getString(key, (String) defaultObj);
        }
        return null;
    }

    /**
     * 删除指定数据
     */
    public static void remove(String key) {
        SharedPreferences sp = DemoApplication.getInstance().getSharedPreferences(sp_file_name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(key);
        editor.commit();
    }


    /**
     * 返回所有键值对
     */
    public static Map<String, ?> getAll() {
        SharedPreferences sp = DemoApplication.getInstance().getSharedPreferences(sp_file_name, Context.MODE_PRIVATE);
        Map<String, ?> map = sp.getAll();
        return map;
    }

    /**
     * 删除所有数据
     */
    public static void clear() {
        SharedPreferences sp = DemoApplication.getInstance().getSharedPreferences(sp_file_name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.commit();
    }

    /**
     * 检查key对应的数据是否存在
     */
    public static boolean contains( String key) {
        SharedPreferences sp = DemoApplication.getInstance().getSharedPreferences(sp_file_name, Context.MODE_PRIVATE);
        return sp.contains(key);
    }


}