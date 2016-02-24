package com.saintdan.util.wechat.bean;

import com.saintdan.util.wechat.enums.MsgType;

/**
 * Text message
 *
 * @author <a href="http://github.com/saintdan">Liao Yifan</a>
 * @date 2/14/16
 * @since JDK1.8
 */
public class TextMsg extends BaseMsg {

    private static final long serialVersionUID = -5736640002526082511L;

    private String content;

    @Override
    public String subXML() {
        return new String(new StringBuilder("<Content>").append(getContent()).append("</Content>"));
    }

    @Override
    public String msgType() {
        return MsgType.TEXT.description();
    }

    public String getContent() {
        return convert(content);
    }

    public void setContent(String content) {
        this.content = content;
    }

}
