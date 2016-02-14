package com.saintdan.util.wechat.enums;

/**
 * Type of material.
 *
 * <pre>
 *     image: <2m, bmp/png/jpg/gif
 *     voice: <5m, <60s, amr/mp3/wav (for news, <30m, <30min)
 *     video: <10m, mp4
 *     thumb: <64k, jpg
 * </pre>
 *
 * @author <a href="http://github.com/saintdan">Liao Yifan</a>
 * @date 2/14/16
 * @since JDK1.8
 */
public enum MaterialType implements IntentStateWithDescription {

    IMAGE("image"),
    VOICE("voice"),
    VIDEO("video"),
    THUMB("thumb");

    /**
     * Description
     */
    private final String description;

    /**
     * Constructor
     *
     * @param description description
     */
    MaterialType(String description) {
        this.description = description;
    }

    @Override
    public String description() {
        return this.description;
    }

    /**
     * Material type is video?
     *
     * @return      true or false
     */
    public boolean isVideo() {
        return this.description.equals(VIDEO.description);
    }
}
