package com.saintdan.util.wechat.exception;


import com.saintdan.util.wechat.enums.ErrorType;

/**
 * Unknown exception.
 *
 * @author <a href="http://github.com/saintdan">Liao Yifan</a>
 * @date 7/26/15
 * @since JDK1.8
 */
public class UnknownException extends SystemRuntimeException {

    private static final long serialVersionUID = -7431810328087316293L;

    private final static ErrorType ERROR_TYPE = ErrorType.UNKNOWN;

    public UnknownException() {
        super(ERROR_TYPE);
    }
}
