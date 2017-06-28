package com.instacart.pp.android.starter.network;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface NetworkApi {

  @GET("/")
  Flowable<NetworkResponse> hello();
}
