package com.saintdan.util.wechat.exception;

import com.saintdan.util.wechat.enums.ErrorType;

/**
 * Exception of auth API.
 *
 * @author <a href="http://github.com/saintdan">Liao Yifan</a>
 * @date 2/1/16
 * @since JDK1.8
 */
public class AuthException extends SystemException {

    private static final long serialVersionUID = 1342885615809575632L;

    private final static ErrorType ERROR_TYPE = ErrorType.ATH0001;

    public AuthException(ErrorType type, Throwable t, String errorMsg) {
        super(type, t, errorMsg);
    }

    public AuthException(ErrorType type, String errorMsg) {
        super(type, errorMsg);
    }

    public AuthException(ErrorType type) {
        super(type);
    }

    public AuthException() {
        super(ERROR_TYPE);
    }
}
