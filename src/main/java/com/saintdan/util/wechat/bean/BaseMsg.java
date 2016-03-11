package com.saintdan.util.wechat.bean;

import java.io.Serializable;

/**
 * Message bean.
 *
 * @author <a href="http://github.com/saintdan">Liao Yifan</a>
 * @date 2/14/16
 * @since JDK1.8
 */
public abstract class BaseMsg implements Serializable {

    private static final long serialVersionUID = -2876985813601131566L;

    private String toUserName;

    private String fromUserName;

    private String createTime;

    private String msgType;

    private Long msgId;

    private static final String PREFIX = "<![CDATA[";

    private static final String SUFFIX = "]]>";

    protected String convert(String content) {
        return new String(new StringBuilder(PREFIX).append(content).append(SUFFIX));
    }

    /**
     * XML of subclass.
     *
     * @return      XML string of subclass.
     */
    public abstract String subXML();

    /**
     * Message type of subclass.
     *
     * @return      message type of subclass.
     */
    public abstract String msgType();

    /**
     * Message bean to XML
     *
     * @return      XML string
     */
    public String toXML() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<xml>");
        stringBuilder.append("<ToUserName>").append(getToUserName()).append("</ToUserName>");
        stringBuilder.append("<FromUserName>").append(getFromUserName()).append("</FromUserName>");
        stringBuilder.append("<CreateTime>").append(System.currentTimeMillis() / 1000).append("</CreateTime>");
        stringBuilder.append("<MsgType>").append(getMsgType()).append("</MsgType>");
        stringBuilder.append(subXML());
        stringBuilder.append("</xml>");
        return stringBuilder.toString();
    }

    public String getToUserName() {
        return convert(toUserName);
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return convert(fromUserName);
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return convert(msgType());
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public Long getMsgId() {
        return msgId;
    }

    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }
}
