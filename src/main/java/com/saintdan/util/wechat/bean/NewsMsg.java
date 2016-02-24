package com.saintdan.util.wechat.bean;

import com.saintdan.util.wechat.enums.MsgType;

import java.util.List;

/**
 * News message
 *
 * @author <a href="http://github.com/saintdan">Liao Yifan</a>
 * @date 2/14/16
 * @since JDK1.8
 */
public class NewsMsg extends BaseMsg {

    private static final long serialVersionUID = -2355242717491727434L;

    private List<Article> articles;

    @Override
    public String subXML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<ArticleCount>").append(articles.size()).append("</ArticleCount>");
        sb.append("<Articles>");
        for (Article article : articles) {
            sb.append("<item>");
            sb.append("<Title><![CDATA[").append(article.title == null ? "" : article.title).append("]]></Title>");
            sb.append("<Description><![CDATA[").append(article.description == null ? "" : article.description).append("]]></Description>");
            sb.append("<PicUrl><![CDATA[").append(article.picUrl == null ? "" : article.picUrl).append("]]></PicUrl>");
            sb.append("<Url><![CDATA[").append(article.url == null ? "" : article.url).append("]]></Url>");
            sb.append("</item>");
        }
        sb.append("</Articles>");
        return sb.toString();
    }

    @Override
    public String msgType() {
        return MsgType.NEWS.description();
    }

    public static class Article {
        private String title;
        private String description;
        private String url;
        private String picUrl;

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

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }
    }
}
