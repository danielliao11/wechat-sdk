package com.saintdan.util.wechat.tools;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringReader;
import java.io.StringWriter;

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
}
