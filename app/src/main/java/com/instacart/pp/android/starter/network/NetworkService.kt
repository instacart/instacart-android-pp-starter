package com.instacart.pp.android.starter.network

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkService {

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
                .baseUrl("https://glacial-plains-13128.herokuapp.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    val api: NetworkApi by lazy {
        retrofit.create(NetworkApi::class.java)
    }
}