package com.ffyc.myfirstboot.util;

/**
 *  结果封装类
 */
public class CommonResult<T> {

      private Integer code;
      private String msg;
      private T data;
      private  Long total;


    public CommonResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public CommonResult(Integer code, String msg, T data,Long total) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.total=total;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
