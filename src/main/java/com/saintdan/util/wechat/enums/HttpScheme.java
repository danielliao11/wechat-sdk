package com.saintdan.util.wechat.enums;

/**
 * Http scheme.
 *
 * @author <a href="http://github.com/saintdan">Liao Yifan</a>
 * @date 2/2/16
 * @since JDK1.8
 */
public enum HttpScheme implements IntentStateWithDescription {

    HTTP("http"),
    HTTPS("https");

    /**
     * Description
     */
    private final String description;

    /**
     * Constructor
     *
     * @param description description
     */
    HttpScheme(String description) {
        this.description = description;
    }

    @Override
    public String description() {
        return this.description;
    }
}
