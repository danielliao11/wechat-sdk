package com.saintdan.util.wechat.http;

import com.saintdan.util.wechat.enums.HttpScheme;
import org.apache.http.impl.client.CloseableHttpClient;

import java.io.IOException;

/**
 * Default http client.
 *
 * @author <a href="http://github.com/saintdan">Liao Yifan</a>
 * @date 2/2/16
 * @since JDK1.8
 */
public class DefaultHttpClient {

    protected static CloseableHttpClient httpClient = HttpClientFactory.createHttpClientIgnoreSSL();

    /**
     * Init the http client.
     *
     * @param maxTotal          max total connections
     * @param maxPerRoute       max per route
     * @param hostName          host name
     * @param port              port
     * @param httpScheme        httpScheme {@link HttpScheme}
     */
    public static void init(int maxTotal, int maxPerRoute, String hostName, int port, HttpScheme httpScheme) {
        try {
            httpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        httpClient = HttpClientFactory.createHttpClientIgnoreSSL(maxTotal, maxPerRoute, hostName, port, httpScheme);
    }
}
