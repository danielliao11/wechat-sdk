package com.saintdan.util.wechat.result;

/**
 * Token result.
 *
 * @author <a href="http://github.com/saintdan">Liao Yifan</a>
 * @date 2/4/16
 * @since JDK1.8
 */
public class TokenResult extends BaseResult {

    private static final long serialVersionUID = 5600379859077186400L;

    // access token
    private String access_token;

    // expires in
    private int expires_in;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }
}
