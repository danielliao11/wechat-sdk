package com.saintdan.util.wechat.api;

import com.saintdan.util.wechat.enums.ErrorType;
import com.saintdan.util.wechat.exception.AuthException;
import com.saintdan.util.wechat.exception.EncryptException;
import com.saintdan.util.wechat.param.UrlVerifyParam;
import com.saintdan.util.wechat.tools.WeChatEncryptUtil;

/**
 * API of authorization.
 *
 * @author <a href="http://github.com/saintdan">Liao Yifan</a>
 * @date 2/1/16
 * @since JDK1.8
 */
public class AuthAPI {

    /**
     * Verify the URL
     *
     * @param param     URL verify param
     * @return          decrypted encode string
     * @throws AuthException
     * @throws EncryptException
     */
    public String verifyURL(UrlVerifyParam param) throws AuthException, EncryptException {
        if (param.getSignature().equals(param.getSHA1Signature())) {
            throw new AuthException(ErrorType.ATH0010);
        }
        return WeChatEncryptUtil.AESDecrypt(param.getEchoStr(), param.getAppId(), param.getAesKey());
    }
}
