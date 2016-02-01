package com.saintdan.util.wechat.param;

import com.saintdan.util.wechat.exception.EncryptException;
import com.saintdan.util.wechat.tools.WeChatEncryptUtil;

import java.util.Arrays;

/**
 * Verify the url.
 *
 * @author <a href="http://github.com/saintdan">Liao Yifan</a>
 * @date 2/1/16
 * @since JDK1.8
 */
public class UrlVerifyParam extends BaseParam {

    private static final long serialVersionUID = -1094534454089872810L;

    // WeChat's signature
    private String signature;

    private String timestamp;

    // Random number
    private String nonce;

    // Random string
    private String echoStr;

    // Actually, this is just a key
    private String token;

    public UrlVerifyParam(String signature, String timestamp, String nonce, String echoStr, String token) {
        this.signature = signature;
        this.timestamp = timestamp;
        this.nonce = nonce;
        this.echoStr = echoStr;
        this.token = token;
    }

    /**
     * Get the SHA1 signature.
     *
     * @return          SHA1 signature
     * @throws EncryptException
     */
    public String getSHA1Signature() throws EncryptException {
        String[] paramArrary = new String[]{ echoStr, nonce, timestamp, token };
        StringBuffer stringBuffer = new StringBuffer();
        Arrays.sort(paramArrary);
        for (String temp : paramArrary) {
            stringBuffer.append(temp);
        }
        return WeChatEncryptUtil.SHA1(stringBuffer.toString());
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getEchoStr() {
        return echoStr;
    }

    public void setEchoStr(String echoStr) {
        this.echoStr = echoStr;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
