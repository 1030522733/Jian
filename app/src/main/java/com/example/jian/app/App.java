package com.example.jian.app;

import com.example.jian.mvvm.model.api.ApiClient;
import com.example.jtowers.base.BaseApp;

/**
 * @Author: JianTours
 * @Data: 2022/5/28 18:07
 * @Description:
 */
public class App extends BaseApp{

    @Override
    public void onCreate() {
        super.onCreate();
        ApiClient.getInstance().init();
    }
}
