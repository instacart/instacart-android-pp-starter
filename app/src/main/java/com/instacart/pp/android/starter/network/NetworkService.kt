package com.instacart.pp.android.starter.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class NetworkService {

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
                .baseUrl("http://boiling-dusk-12902.herokuapp.com/")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    val api: NetworkApi by lazy {
        retrofit.create(NetworkApi::class.java)
    }
}
