package com.saintdan.util.wechat.bean;

import java.io.Serializable;

/**
 * Description of video material.
 *
 * @author <a href="http://github.com/saintdan">Liao Yifan</a>
 * @date 2/14/16
 * @since JDK1.8
 */
public class VideoMaterialDescription implements Serializable {

    private static final long serialVersionUID = -7330157868716195602L;

    private String title;

    private String introduction;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
