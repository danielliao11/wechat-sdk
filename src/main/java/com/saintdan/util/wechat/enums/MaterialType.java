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
    THUMB("thumb"),

    UNKNOWN("unknown");

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

    /**
     * Convert description to material type.
     *
     * @param description       description
     * @return                  material type.
     */
    public static MaterialType parse(String description) {
        MaterialType[] types = MaterialType.values();
        for (MaterialType type : types) {
            if (type.description.equals(description)) {
                return type;
            }
        }
        return MaterialType.UNKNOWN;
    }
}
