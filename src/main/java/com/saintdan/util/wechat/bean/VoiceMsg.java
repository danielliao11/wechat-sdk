package com.saintdan.util.wechat.bean;

import com.saintdan.util.wechat.enums.MsgType;

/**
 * Voice message.
 *
 * @author <a href="http://github.com/saintdan">Liao Yifan</a>
 * @date 2/14/16
 * @since JDK1.8
 */
public class VoiceMsg extends BaseMsg {

    private static final long serialVersionUID = 3413449983613893902L;

    private String mediaId;

    private String format;

    @Override
    public String subXML() {
        return new String(new StringBuilder("<Voice><MediaId>").append(getMediaId()).append("</MediaId></Voice>"));
    }

    @Override
    public String msgType() {
        return MsgType.VOICE.description();
    }

    public String getMediaId() {
        return convert(mediaId);
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getFormat() {
        return convert(format);
    }

    public void setFormat(String format) {
        this.format = format;
    }

}
