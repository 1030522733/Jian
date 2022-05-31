package com.example.jtowers.network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @Author: JianTours
 * @Data: 2021/12/20 21:08
 * @Description:基础返回类
 */
public class BaseResponse<T>{

    public int code = 0;

    public String msg;

    @SerializedName(value = "data")
    public T data ;
}
