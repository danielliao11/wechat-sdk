package com.saintdan.util.wechat.component;

import com.saintdan.util.wechat.tools.JaxbUtil;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Xml response handler.
 *
 * @author <a href="http://github.com/saintdan">Liao Yifan</a>
 * @date 2/14/16
 * @since JDK1.8
 */
public class XmlResponseHandler {

    private static Map<String, ResponseHandler<?>> map = new HashMap<>();

    /**
     * Create response handler
     *
     * @param clazz     class
     * @param <T>       type
     * @return          response handler
     */
    @SuppressWarnings("unchecked")
    public static <T> ResponseHandler<T> createResponseHandler(final Class<T> clazz) {
        if (map.containsKey(clazz.getName())) {
            return (ResponseHandler<T>) map.get(clazz.getName());
        } else {
            ResponseHandler<T> responseHandler = response -> {
                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
                    String str = EntityUtils.toString(entity);
                    Header contentType = response.getEntity().getContentType();
                    if (contentType != null && contentType.toString().matches(".*[uU][tT][fF]-8$")) {
                        return JaxbUtil.convert2Obj(clazz, str);
                    } else {
                        return JaxbUtil.convert2Obj(clazz, new String(str.getBytes("iso-8859-1"), "utf-8"));
                    }
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            };
            map.put(clazz.getName(), responseHandler);
            return responseHandler;
        }
    }
}
