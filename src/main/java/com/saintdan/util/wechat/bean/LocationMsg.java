package com.saintdan.util.wechat.bean;

import com.saintdan.util.wechat.enums.MsgType;

/**
 * Location message
 *
 * @author <a href="http://github.com/saintdan">Liao Yifan</a>
 * @date 2/14/16
 * @since JDK1.8
 */
public class LocationMsg extends BaseMsg {

    private static final long serialVersionUID = 2619876403820519056L;

    private String locationX;

    private String locationY;

    private String scale;

    private String label;

    @Override
    public String subXML() {
        return null;
    }

    @Override
    public String msgType() {
        return MsgType.LOCATION.description();
    }

    public String getLocationX() {
        return convert(locationX);
    }

    public void setLocationX(String locationX) {
        this.locationX = locationX;
    }

    public String getLocationY() {
        return convert(locationY);
    }

    public void setLocationY(String locationY) {
        this.locationY = locationY;
    }

    public String getScale() {
        return convert(scale);
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getLabel() {
        return convert(label);
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
