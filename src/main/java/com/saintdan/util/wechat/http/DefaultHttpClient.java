package com.saintdan.util.wechat.http;

import com.saintdan.util.wechat.component.JSONResponseHandler;
import com.saintdan.util.wechat.enums.HttpScheme;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.protocol.HttpClientContext;
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

    /**
     * Execute the http uri request.
     *
     * @param request       http uri request
     * @return              http response
     */
    public static CloseableHttpResponse execute(HttpUriRequest request){
        try {
            return httpClient.execute(request, HttpClientContext.create());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Execute the request with responseHandler.
     *
     * @param request               http uri request
     * @param responseHandler       response handler
     * @param <T>                   type of response handler
     * @return                      response
     */
    public static <T> T execute(HttpUriRequest request, ResponseHandler<T> responseHandler){
        try {
            return httpClient.execute(request, responseHandler, HttpClientContext.create());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Execute the request with JSON response handler, and convert the response to JSON.
     *
     * @param request               http uri request
     * @param clazz                 class
     * @param <T>                   type
     * @return                      JSON response
     */
    public static <T> T executeJsonResult(HttpUriRequest request,Class<T> clazz){
        return execute(request, JSONResponseHandler.createResponseHandler(clazz));
    }
}
