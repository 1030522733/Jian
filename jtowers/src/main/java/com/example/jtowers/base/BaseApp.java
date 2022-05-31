package com.example.jtowers.base;

import android.annotation.SuppressLint;
import android.app.Application;

import com.example.jtowers.utlis.MmkvUtils;
import com.tencent.mmkv.MMKV;

/**
 * @Author: JianTours
 * @Data: 2022/5/26 23:34
 * @Description:
 */
public class BaseApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //MMKV初始化
        MMKV.initialize(this);
        //工具类初始化
        MmkvUtils.getInstance();
    }

}
