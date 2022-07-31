package com.example.jian.mvvm.vm;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.example.jtowers.base.BaseVM;

/**
 * @Author: JianTours
 * @Data: 2022/7/31 16:31
 * @Description:
 */
public class HomeVM extends BaseVM {

    public MutableLiveData<String> msg = new MutableLiveData<>("");
    public MutableLiveData<String> next = new MutableLiveData<>("");

    public HomeVM(Application application){
        super(application);
    }

    @Override
    public void initData() {
        msg.setValue("");
        next.setValue("");
    }
}
