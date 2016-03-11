package com.saintdan.util.wechat.result;

/**
 * Get the ip address of WeChat's server.
 *
 * @author <a href="http://github.com/saintdan">Liao Yifan</a>
 * @date 2/4/16
 * @since JDK1.8
 */
public class IPAddressResult extends BaseResult {

    private static final long serialVersionUID = 90251662862389887L;

    // list of ip address
    private String ip_list;

    public String getIp_list() {
        return ip_list;
    }

    public void setIp_list(String ip_list) {
        this.ip_list = ip_list;
    }
}
