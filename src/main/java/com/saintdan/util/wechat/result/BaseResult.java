package com.saintdan.util.wechat.result;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * Base of result.
 *
 * @author <a href="http://github.com/saintdan">Liao Yifan</a>
 * @date 2/4/16
 * @since JDK1.8
 */
public class BaseResult implements Serializable {

    private static final long serialVersionUID = 6291131185411216600L;

    private static final String SUCCESS_CODE = "0";

    // error code
    private String errcode;

    // error massage
    private String errmsg;

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public boolean isSuccess() {
        return StringUtils.isBlank(errcode) || errcode.equals(SUCCESS_CODE);
    }
}
