package com.example.jian.mvvm.model.api;

import com.example.jtowers.network.NetworkApi;

/**
 * @Author: JianTours
 * @Data: 2022/5/26 22:56
 * @Description:
 */
public class ApiClient{

    private volatile static ApiClient apiClient;

    public static ApiClient getInstance(){
        if (apiClient == null){
            synchronized (ApiClient.class){
                if (apiClient ==null){
                    apiClient = new ApiClient();
                }
            }
        }
        return apiClient;
    }

    public static NetworkApi networkApi;
    public  static ApiService apiService;

    public void init(){
        networkApi = new NetworkApi();
        networkApi.init("http://192.168.10.116:8080");
        apiService = NetworkApi.createService(ApiService.class);
    }

}
