package com.saintdan.util.wechat.bean;

import com.saintdan.util.wechat.enums.MsgType;

/**
 * @author <a href="http://github.com/saintdan">Liao Yifan</a>
 * @date 2/14/16
 * @since JDK1.8
 */
public class TextMsg extends BaseMsg {

    private static final long serialVersionUID = -5736640002526082511L;

    private String content;

    public TextMsg() {
        setMsgTypeEnum();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private void setMsgTypeEnum() {
        super.setMsgTypeEnum(MsgType.TEXT);
    }
}
