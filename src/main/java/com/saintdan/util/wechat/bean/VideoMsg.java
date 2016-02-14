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

    private String thumbMediaId;

    public VideoMsg() {
        setMsgTypeEnum();
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    private void setMsgTypeEnum() {
        super.setMsgTypeEnum(MsgType.VIDEO);
    }
}
