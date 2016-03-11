package com.saintdan.util.wechat.bean;

import com.saintdan.util.wechat.enums.MsgType;

/**
 * Link message.
 *
 * @author <a href="http://github.com/saintdan">Liao Yifan</a>
 * @date 2/14/16
 * @since JDK1.8
 */
public class LinkMsg extends BaseMsg {

    private static final long serialVersionUID = -3899000055824899924L;

    private String title;

    private String description;

    private String url;

    @Override
    public String subXML() {
        return null;
    }

    @Override
    public String msgType() {
        return MsgType.LINK.description();
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

    public String getUrl() {
        return convert(url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
