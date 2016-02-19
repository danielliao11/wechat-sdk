package com.saintdan.util.wechat.api;

import com.saintdan.util.wechat.constant.AuthConstant;
import com.saintdan.util.wechat.constant.ResourceConstant;
import com.saintdan.util.wechat.constant.TokenConstant;
import com.saintdan.util.wechat.constant.URIConstant;
import com.saintdan.util.wechat.enums.ErrorType;
import com.saintdan.util.wechat.exception.AuthException;
import com.saintdan.util.wechat.exception.EncryptException;
import com.saintdan.util.wechat.http.DefaultHttpClient;
import com.saintdan.util.wechat.result.IPAddressResult;
import com.saintdan.util.wechat.result.TokenResult;
import com.saintdan.util.wechat.tools.WeChatEncryptUtil;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;

import java.util.Arrays;

/**
 * API of authorization.
 *
 * @author <a href="http://github.com/saintdan">Liao Yifan</a>
 * @date 2/1/16
 * @since JDK1.8
 */
public class AuthAPI extends BaseAPI {

    /**
     * Verify the URL.
     *
     * @param signature     signature of WeChat
     * @param timestamp     time stamp
     * @param nonce         Random number
     * @param echoStr       Random String
     * @param token         own token
     * @param appId         app id
     * @param aesKey        AES key
     * @return              decrypted echo string
     * @throws AuthException
     * @throws EncryptException
     */
    public static String verifyURL(String signature, String timestamp, String nonce, String echoStr, String token, String appId, byte[] aesKey) throws AuthException, EncryptException {
        if (!signature.equals(getSHA1Signature(timestamp, nonce, echoStr, token))) {
            throw new AuthException(ErrorType.ATH0010);
        }
        return WeChatEncryptUtil.AESDecrypt(echoStr, appId, aesKey);
    }

    /**
     * Get access token of WeChat.
     *
     * @param appId         app id
     * @param secret        secret
     * @return              token result
     */
    public static TokenResult getAccessToken(String appId, String secret) {
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(new String(new StringBuilder(URIConstant.BASE_URI).append(ResourceConstant.CGI_BIN).append(AuthConstant.TOKEN)))
                .addParameter(TokenConstant.GRANT_TYPE, TokenConstant.CLIENT_CREDENTIAL)
                .addParameter(TokenConstant.APPID, appId)
                .addParameter(TokenConstant.SECRET, secret)
                .build();
        return DefaultHttpClient.executeJsonResult(httpUriRequest, TokenResult.class);
    }

    /**
     * Get IP address of WeChat.
     *
     * @param accessToken   access token
     * @return              ip address result
     */
    public static IPAddressResult getIPAddress(String accessToken) {
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(new String(new StringBuilder(URIConstant.BASE_URI).append(ResourceConstant.CGI_BIN).append(AuthConstant.IP_ADDRESS)))
                .addParameter(TokenConstant.ACCESS_TOKEN, accessToken)
                .build();
        return DefaultHttpClient.executeJsonResult(httpUriRequest, IPAddressResult.class);
    }

    /**
     * Get the SHA1 signature.
     *
     * @return          SHA1 signature
     * @throws EncryptException
     */
    private static String getSHA1Signature(String timestamp, String nonce, String echoStr, String token) throws EncryptException {
        String[] paramArrary = new String[]{ echoStr, nonce, timestamp, token };
        StringBuffer stringBuffer = new StringBuffer();
        Arrays.sort(paramArrary);
        for (String temp : paramArrary) {
            stringBuffer.append(temp);
        }
        return WeChatEncryptUtil.SHA1(stringBuffer.toString());
    }
}
