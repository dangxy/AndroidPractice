package com.dangxy.androidpractice.api;

import java.security.cert.X509Certificate;

import javax.net.ssl.X509TrustManager;

/**
 * @author dangxueyi
 * @description
 * @date 2018/2/3
 */

public class TrustAllCerts implements X509TrustManager {
    @Override
    public void checkClientTrusted(X509Certificate[] chain, String authType) {}

    @Override
    public void checkServerTrusted(X509Certificate[] chain, String authType) {}

    @Override
    public X509Certificate[] getAcceptedIssuers() {return new X509Certificate[]{};}


}
