package com.example.jian.mvvm.ui.act;

import android.annotation.SuppressLint;

import com.example.jian.R;
import com.example.jian.mvvm.model.bean.UserBean;
import com.example.jian.databinding.ActivityMainBinding;
import com.example.jian.mvvm.ui.widget.CuDialog;
import com.example.jtowers.base.BaseAct;
import com.example.jtowers.base.NullVM;
import com.example.jtowers.network.BaseObserver;
import com.example.jtowers.network.BaseResponse;
import com.example.jtowers.network.NetworkApi;
import com.example.jtowers.utlis.LogUtils;
import com.example.jian.mvvm.model.api.ApiClient;

public class MainActivity extends BaseAct<NullVM, ActivityMainBinding> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @SuppressLint("CheckResult")
    @Override
    protected void init() {
        ApiClient.apiService.getUser("15286111054").compose(NetworkApi.applySchedulers(new BaseObserver<BaseResponse<UserBean>>() {
            @Override
            public void onSucceed(BaseResponse<UserBean> userBeanBaseResponse) {
                LogUtils.json(userBeanBaseResponse);
            }

            @Override
            public void onFailure(Throwable e) {

            }
        }));

    }

}