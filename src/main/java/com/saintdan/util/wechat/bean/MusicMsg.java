package com.saintdan.util.wechat.bean;

import com.saintdan.util.wechat.enums.MsgType;

/**
 * Music message
 *
 * @author <a href="http://github.com/saintdan">Liao Yifan</a>
 * @date 2/14/16
 * @since JDK1.8
 */
public class MusicMsg extends BaseMsg {

    private static final long serialVersionUID = -2355242717491727434L;

    private String title;

    private String description;

    private String musicUrl;

    private String hQMusicUrl;

    private String thumbMediaId;

    @Override
    public String subXML() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<Music>");
        stringBuilder.append("<Title>").append(title == null ? "" : getTitle()).append("</Title>");
        stringBuilder.append("<Description>").append(description == null ? "" : getDescription()).append("</Description>");
        stringBuilder.append("<MusicUrl>").append(musicUrl == null ? "" : getMusicUrl()).append("</MusicUrl>");
        stringBuilder.append("<HQMusicUrl>").append(hQMusicUrl == null ? "" : gethQMusicUrl()).append("</HQMusicUrl>");
        stringBuilder.append("<ThumbMediaId>").append(getThumbMediaId()).append("</ThumbMediaId>");
        stringBuilder.append("</Music>");
        return stringBuilder.toString();
    }

    @Override
    public String msgType() {
        return MsgType.MUSIC.description();
    }

    public String getTitle() {
        return convert(title);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return convert(description);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMusicUrl() {
        return convert(musicUrl);
    }

    public void setMusicUrl(String musicUrl) {
        this.musicUrl = musicUrl;
    }

    public String gethQMusicUrl() {
        return convert(hQMusicUrl);
    }

    public void sethQMusicUrl(String hQMusicUrl) {
        this.hQMusicUrl = hQMusicUrl;
    }

    public String getThumbMediaId() {
        return convert(thumbMediaId);
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }
}
