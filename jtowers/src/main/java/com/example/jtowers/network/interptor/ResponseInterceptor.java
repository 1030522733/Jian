package com.example.jtowers.network.interptor;



import com.example.jtowers.utlis.LogUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @Author: JianTours
 * @Data: 2021/12/20 21:44
 * @Description:返回拦截器
 */
public class ResponseInterceptor implements Interceptor {

    private static final String TAG = "ResponseInterceptor";

    @Override
    public Response intercept(Chain chain) throws IOException {
        long requestTime = System.currentTimeMillis();
        Request request = chain.request();
        Response response = chain.proceed(request);
        LogUtils.d("  requestSpendTime  ─────  "+(System.currentTimeMillis()-requestTime)+" ms");
        return response;
    }
}
