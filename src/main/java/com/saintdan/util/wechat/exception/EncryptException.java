package com.saintdan.util.wechat.exception;

import com.saintdan.util.wechat.enums.ErrorType;

/**
 * Exception of auth API.
 *
 * @author <a href="http://github.com/saintdan">Liao Yifan</a>
 * @date 2/1/16
 * @since JDK1.8
 */
public class EncryptException extends SystemException {

    private static final long serialVersionUID = 236065181913866400L;

    private final static ErrorType ERROR_TYPE = ErrorType.ENC0001;

    public EncryptException(ErrorType type, Throwable t, String errorMsg) {
        super(type, t, errorMsg);
    }

    public EncryptException(ErrorType type, String errorMsg) {
        super(type, errorMsg);
    }

    public EncryptException(ErrorType type) {
        super(type);
    }

    public EncryptException() {
        super(ERROR_TYPE);
    }
}
