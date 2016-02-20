package com.saintdan.util.wechat.tools;

import org.w3c.dom.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Jaxb util.
 *
 * @author <a href="http://github.com/saintdan">Liao Yifan</a>
 * @date 2/14/16
 * @since JDK1.8
 */
public class JaxbUtil {

    /**
     * Convert xml to xml object
     *
     * @param clazz         xml object
     * @param xmlStr        xml string
     * @param <T>           T
     * @return              xml object
     */
    @SuppressWarnings("unchecked")
    public static <T> T xmlStr2Obj(Class<T> clazz, String xmlStr) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            return (T) jaxbUnmarshaller.unmarshal(new StringReader(xmlStr));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Convert xml object to xml string.
     *
     * @param object        xml object
     * @return              xml string
     */
    public static String obj2XmlStr(Object object) {
        try {
            Class<?> clazz = object.getClass();
            if (clazz.getAnnotation(XmlRootElement.class) == null) {
                throw new IllegalArgumentException("Object must be generate by jaxb.");
            }
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            StringWriter w = new StringWriter();
            jaxbMarshaller.marshal(object, w);
            return w.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Convert xml to map.
     *
     * @param xml xml string
     * @return linked hash map
     */
    public static Map<String, String> convertToMap(String xml) {
        Map<String, String> map = new LinkedHashMap<>();
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            StringReader sr = new StringReader(xml);
            InputSource is = new InputSource(sr);
            Document document = db.parse(is);
            Element root = document.getDocumentElement();
            if (root != null) {
                NodeList childNodes = root.getChildNodes();
                if (childNodes != null && childNodes.getLength() > 0) {
                    for (int i = 0; i < childNodes.getLength(); i++) {
                        Node node = childNodes.item(i);
                        if (node != null && node.getNodeType() == Node.ELEMENT_NODE) {
                            map.put(node.getNodeName(), node.getTextContent());
                        }
                    }
                }
            }
        } catch (DOMException | ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}
