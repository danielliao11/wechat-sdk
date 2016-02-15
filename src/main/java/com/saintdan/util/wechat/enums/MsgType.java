package com.saintdan.util.wechat.enums;

/**
 * Message type.
 *
 * @author <a href="http://github.com/saintdan">Liao Yifan</a>
 * @date 2/14/16
 * @since JDK1.8
 */
public enum MsgType implements IntentStateWithDescription {

    TEXT("text"),
    IMAGE("image"),
    VOICE("voice"),
    VIDEO("video"),
    SHORT_VIDEO("shortvideo"),
    LOCATION("location"),
    LINK("link");

    /**
     * Description
     */
    private final String description;

    /**
     * Constructor
     *
     * @param description description
     */
    MsgType(String description) {
        this.description = description;
    }

    @Override
    public String description() {
        return this.description;
    }
}