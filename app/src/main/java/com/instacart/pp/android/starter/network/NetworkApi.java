package com.instacart.pp.android.starter.network;

import retrofit2.http.GET;
import rx.Observable;

public interface NetworkApi {

  @GET("/")
  Observable<NetworkResponse> hello();
}
