package com.liyj.demo.core.exception;

import lombok.Data;

/**
 * 自定义异常
 */
@Data
public class DemoException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String msg;
    private int code = 500;

    public DemoException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public DemoException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public DemoException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public DemoException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }
}
