package com.example.jian.mvvm.model.api;



import com.example.jian.mvvm.model.bean.UserBean;
import com.example.jtowers.network.BaseResponse;

import io.reactivex.Observable;
import retrofit2.http.*;

/**
 * @Author: JianTours
 * @Data: 2021/12/21 19:57
 * @Description:所有网络接口
 */
public interface ApiService {

    //查询个人信息
    @GET("/user/query/phone")
    Observable<BaseResponse<UserBean>> getUser(@Query("phone")String phone);
}
