package com.mall.exception;

public class MallException extends RuntimeException {
    //错误编码
    private int code;
    //错误内容
    private String msg;

    MallException() {

    }

    MallException(String msg, Exception e) {
        super(msg, e);
    }

    public MallException(int code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
