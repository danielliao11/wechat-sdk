//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.02.14 at 03:34:08 PM CST 
//


package com.saintdan.util.wechat.xmlObj;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ToUserName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FromUserName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CreateTime" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="MsgType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Location_X" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="Location_Y" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="Scale" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *         &lt;element name="Label" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MsgId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "toUserName",
    "fromUserName",
    "createTime",
    "msgType",
    "locationX",
    "locationY",
    "scale",
    "label",
    "msgId"
})
@XmlRootElement(name = "xml")
public class LocationMsgXmlObj {

    @XmlElement(name = "ToUserName", required = true)
    protected String toUserName;
    @XmlElement(name = "FromUserName", required = true)
    protected String fromUserName;
    @XmlElement(name = "CreateTime")
    protected long createTime;
    @XmlElement(name = "MsgType", required = true)
    protected String msgType;
    @XmlElement(name = "Location_X")
    protected float locationX;
    @XmlElement(name = "Location_Y")
    protected float locationY;
    @XmlElement(name = "Scale")
    protected byte scale;
    @XmlElement(name = "Label", required = true)
    protected String label;
    @XmlElement(name = "MsgId")
    protected long msgId;

    /**
     * Gets the value of the toUserName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToUserName() {
        return toUserName;
    }

    /**
     * Sets the value of the toUserName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToUserName(String value) {
        this.toUserName = value;
    }

    /**
     * Gets the value of the fromUserName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFromUserName() {
        return fromUserName;
    }

    /**
     * Sets the value of the fromUserName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFromUserName(String value) {
        this.fromUserName = value;
    }

    /**
     * Gets the value of the createTime property.
     * 
     */
    public long getCreateTime() {
        return createTime;
    }

    /**
     * Sets the value of the createTime property.
     * 
     */
    public void setCreateTime(long value) {
        this.createTime = value;
    }

    /**
     * Gets the value of the msgType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsgType() {
        return msgType;
    }

    /**
     * Sets the value of the msgType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsgType(String value) {
        this.msgType = value;
    }

    /**
     * Gets the value of the locationX property.
     * 
     */
    public float getLocationX() {
        return locationX;
    }

    /**
     * Sets the value of the locationX property.
     * 
     */
    public void setLocationX(float value) {
        this.locationX = value;
    }

    /**
     * Gets the value of the locationY property.
     * 
     */
    public float getLocationY() {
        return locationY;
    }

    /**
     * Sets the value of the locationY property.
     * 
     */
    public void setLocationY(float value) {
        this.locationY = value;
    }

    /**
     * Gets the value of the scale property.
     * 
     */
    public byte getScale() {
        return scale;
    }

    /**
     * Sets the value of the scale property.
     * 
     */
    public void setScale(byte value) {
        this.scale = value;
    }

    /**
     * Gets the value of the label property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabel() {
        return label;
    }

    /**
     * Sets the value of the label property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabel(String value) {
        this.label = value;
    }

    /**
     * Gets the value of the msgId property.
     * 
     */
    public long getMsgId() {
        return msgId;
    }

    /**
     * Sets the value of the msgId property.
     * 
     */
    public void setMsgId(long value) {
        this.msgId = value;
    }

}
