package com.saintdan.util.wechat.param;

import java.io.Serializable;

/**
 * Base param.
 *
 * @author <a href="http://github.com/saintdan">Liao Yifan</a>
 * @date 2/1/16
 * @since JDK1.8
 */
public class BaseParam implements Serializable {

    private static final long serialVersionUID = -1338444349566688463L;

    private String appId;

    private byte[] aesKey;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public byte[] getAesKey() {
        return aesKey;
    }

    public void setAesKey(byte[] aesKey) {
        this.aesKey = aesKey;
    }
}
