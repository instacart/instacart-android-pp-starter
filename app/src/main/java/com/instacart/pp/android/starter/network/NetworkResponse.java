package com.instacart.pp.android.starter.network;

public class NetworkResponse {

  class Meta {

    private int code;

    Meta() {
      code = -1;
    }

    Meta(int code) {
      this.code = code;
    }

    public int getCode() {
      return code;
    }

    public void setCode(int code) {
      this.code = code;
    }
  }
}

