package com.example.jtowers.base;

import android.app.Application;

import androidx.annotation.NonNull;

/**
 * @Author: JianTours
 * @Data: 2022/5/27 0:05
 * @Description:
 */
public class NullVM extends BaseVM{
    public NullVM(@NonNull Application application) {
        super(application);
    }

    @Override
    public void initData() {

    }
}
