package com.saintdan.util.wechat.bean;

import com.saintdan.util.wechat.enums.MsgType;

/**
 * Image message.
 *
 * @author <a href="http://github.com/saintdan">Liao Yifan</a>
 * @date 2/14/16
 * @since JDK1.8
 */
public class ImageMsg extends BaseMsg {

    private static final long serialVersionUID = -1953693905147660680L;

    private String picUrl;

    private String mediaId;

    public ImageMsg() {
        setMsgTypeEnum();
    }

    public String getPicUrl() {
        return convert(picUrl);
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getMediaId() {
        return convert(mediaId);
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    private void setMsgTypeEnum() {
        super.setMsgTypeEnum(MsgType.IMAGE);
    }
}
