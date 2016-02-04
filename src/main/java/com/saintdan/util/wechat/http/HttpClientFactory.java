package com.saintdan.util.wechat.http;

import com.saintdan.util.wechat.enums.HttpScheme;
import org.apache.http.HttpHost;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

/**
 * SSL http client factory.
 *
 * @author <a href="http://github.com/saintdan">Liao Yifan</a>
 * @date 2/2/16
 * @since JDK1.8
 * @since httpclient 4.5
 */
public class HttpClientFactory {

    /**
     * Create a http client which ignores the SSL certificate and host name verifier.
     *
     * @return      http client
     */
    public static CloseableHttpClient createHttpClientIgnoreSSL() {
        try {
            // TODO Ignore the SSL certificate and host name verifier which should not be ignored in production.
            SSLContextBuilder sslBuilder = new SSLContextBuilder();
            sslBuilder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
            SSLConnectionSocketFactory factory = new SSLConnectionSocketFactory(sslBuilder.build(), new TrustAllHostNameVerifier());
            return HttpClients.custom()
                    .setSSLSocketFactory(factory)
                    .build();
        } catch (NoSuchAlgorithmException | KeyStoreException | KeyManagementException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Create a http client which ignores the SSL certificate and host name verifier.
     *
     * @return      http client
     */
    public static CloseableHttpClient createHttpClientIgnoreSSL(int maxTotal, int maxPerRoute, String hostName, int port, HttpScheme httpScheme) {
        try {
            // TODO Ignore the SSL certificate and host name verifier which should not be ignored in production.
            SSLContextBuilder sslBuilder = new SSLContextBuilder();
            sslBuilder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
            SSLConnectionSocketFactory factory = new SSLConnectionSocketFactory(sslBuilder.build(), new TrustAllHostNameVerifier());
            PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager();
            poolingHttpClientConnectionManager.setMaxTotal(maxTotal);
            poolingHttpClientConnectionManager.setMaxPerRoute(new HttpRoute(new HttpHost(hostName, port, httpScheme.description())), maxPerRoute);
            return HttpClients.custom()
                    .setSSLSocketFactory(factory)
                    .setConnectionManager(poolingHttpClientConnectionManager)
                    .build();
        } catch (NoSuchAlgorithmException | KeyStoreException | KeyManagementException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Trust all host name.
     */
    private static class TrustAllHostNameVerifier implements HostnameVerifier {
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }
}
