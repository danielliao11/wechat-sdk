package com.saintdan.util.wechat.enums;

/**
 * Error type enums.
 *
 * @author <a href="http://github.com/saintdan">Liao Yifan</a>
 * @date 7/21/15
 * @since JDK1.8
 */
public enum ErrorType implements IntentStateWithDescription {

    // System
    SYS0001("System error."),

    // AUTH
    ATH0001("Authorization error."),
    ATH0010("Verify signature failed."),

    // Encrypt
    ENC0001("Encrypt error."),
    ENC0002("Decrypt error."),
    ENC0010("SHA1 encrypt failed."),
    ENC0011("AES encrypt failed."),
    ENC0020("AES decrypt failed"),

    // Unknown error.
    UNKNOWN("unknown error.");

    /**
     * Description
     */
    private final String description;

    /**
     * Constructor
     *
     * @param description description
     */
    ErrorType(String description) {
        this.description = description;
    }

    @Override
    public String description() {
        return this.description;
    }
}
