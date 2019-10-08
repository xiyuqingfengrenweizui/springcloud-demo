package com.renweizui.clouddemo.common;

/**
 * @PackageName:weizuiren.cloud.weizuirencloudsboot.common
 * @ClassName:DataResponse
 * @Description:统一数据返回封装类
 * @Author: justin zheng
 * @Date: 2019/9/23 13:35
 */
public class DataResponse<T> {

    private int code;
    private T data;
    private String msg;


    public DataResponse() {
        this.code = 200;
        this.data = null;
        this.msg = "";
    }

    public DataResponse(T data) {
        this.data = data;
        this.code=200;
        this.msg="";
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
