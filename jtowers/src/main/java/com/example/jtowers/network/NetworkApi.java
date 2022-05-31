package com.example.jtowers.network;

import com.example.jtowers.network.interptor.RequestInterceptor;
import com.example.jtowers.network.interptor.ResponseInterceptor;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Author: JianTours
 * @Data: 2021/12/20 21:58
 * @Description:网络api
 */
public class NetworkApi {
    /**
     * API访问地址
     */
    private static String BASE_URL;

    private static OkHttpClient okHttpClient;

    private static final HashMap<String, Retrofit> retrofitHashMap = new HashMap<>();

    public  void init(String BASE_URL){
        this.BASE_URL = BASE_URL;
    }

    /**
     * 创建serviceCLass实例
     */
    public static  <T> T createService(Class<T> serviceClass) {
        return getRetrofit(serviceClass).create(serviceClass);
    }

    /**
     * 配置okhttp
     */
    private static OkHttpClient getOkHttpClient() {
        //判断是否为空
        if (okHttpClient == null) {
            //构建okhttp
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            //设置缓存
            int cacheSize = 100 * 1024 * 1024;
            //网络请求时长
            builder.connectTimeout(6, TimeUnit.SECONDS);
            //添加拦截器
            builder.addInterceptor(new RequestInterceptor());
            builder.addInterceptor(new ResponseInterceptor());
            //构建完成
            okHttpClient = builder.build();
        }
        return okHttpClient;
    }

    /**
     * 配置Retrofit
     */
    private static Retrofit getRetrofit(Class serviceClass) {
        if (retrofitHashMap.get(BASE_URL + serviceClass.getName()) != null) {
            //键值不为空时，必有返回值
            return retrofitHashMap.get(BASE_URL + serviceClass.getName());
        }
        //初始化Retrofit
        Retrofit.Builder builder = new Retrofit.Builder();
        //设置访问地址
        builder.baseUrl(BASE_URL);
        //配置okhttp客户端
        builder.client(getOkHttpClient());
        //设置数据解析器 会自动把请求返回的结果（json字符串）通过Gson转化工厂自动转化成与其结构相符的实体Bean
        builder.addConverterFactory(GsonConverterFactory.create());
        //设置请求回调，使用Rxjava对网络进行请求处理
        builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        //Retrofit配置完成
        Retrofit retrofit = builder.build();
        retrofitHashMap.put(BASE_URL + serviceClass.getName(), retrofit);
        return retrofit;
    }

    /**
     * 配置Rxjava完成线程切换
     * observer不是lifecycle里的
     */
    public static <T> ObservableTransformer<T, T> applySchedulers(final Observer<T> observer) {
        return upstream -> {
            Observable<T> observable = upstream
                    .subscribeOn(Schedulers.io())//线程订阅
                    .observeOn(AndroidSchedulers.mainThread());//观察android主线程
            //订阅观察者
            observable.subscribe(observer);
            return observable;
        };
    }
}
