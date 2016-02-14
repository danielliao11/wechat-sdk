package com.saintdan.util.wechat.bean;

import com.saintdan.util.wechat.enums.MsgType;

import java.io.Serializable;

/**
 * Message bean.
 *
 * @author <a href="http://github.com/saintdan">Liao Yifan</a>
 * @date 2/14/16
 * @since JDK1.8
 */
public class BaseMsg implements Serializable {

    private static final long serialVersionUID = -2876985813601131566L;

    private String toUserName;

    private String fromUserName;

    private String createTime;

    private MsgType msgTypeEnum;

    private String msgType;

    private Long msgId;

    private static final String PREFIX = "<![CDATA[";

    private static final String SUFFIX = "]]>";

    protected String convert(String content) {
        return new String(new StringBuilder(PREFIX).append(content).append(SUFFIX));
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

    public MsgType getMsgTypeEnum() {
        return msgTypeEnum;
    }

    public void setMsgTypeEnum(MsgType msgTypeEnum) {
        this.msgTypeEnum = msgTypeEnum;
    }

    public String getMsgType() {
        return convert(msgTypeEnum.description());
    }

    public Long getMsgId() {
        return msgId;
    }

    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }
}
