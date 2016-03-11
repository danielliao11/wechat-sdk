package com.saintdan.util.wechat.bean;

import com.saintdan.util.wechat.enums.MsgType;

/**
 * Video message.
 *
 * @author <a href="http://github.com/saintdan">Liao Yifan</a>
 * @date 2/14/16
 * @since JDK1.8
 */
public class VideoMsg extends BaseMsg {

    private static final long serialVersionUID = 5621624517902633363L;

    private String mediaId;

    private String title;

    private String description;

    private String thumbMediaId;

    @Override
    public String subXML() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<Video>");
        stringBuilder.append("<MediaId>").append(mediaId == null ? "" : getMediaId()).append("</MediaId>");
        stringBuilder.append("<Title>").append(title == null ? "" : getTitle()).append("</Title>");
        stringBuilder.append("<Description>").append(description == null ? "" : getDescription()).append("</Description>");
        stringBuilder.append("</Video>");
        return stringBuilder.toString();
    }

    @Override
    public String msgType() {
        return MsgType.VIDEO.description();
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }
}
