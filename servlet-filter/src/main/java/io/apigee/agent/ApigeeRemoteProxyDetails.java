package io.apigee.agent;

/**
 * Created by prabhat on 3/25/15.
 */
public class ApigeeRemoteProxyDetails {

    private String proxyUri ;
    private String proxyKey;


    public ApigeeRemoteProxyDetails (String uri, String key) {
        this.proxyUri = uri;
        this.proxyKey = key;
    }

    public String getProxyKey() {
        return proxyKey;
    }

    public void setProxyKey(String proxyKey) {
        this.proxyKey = proxyKey;
    }

    public String getProxyUri() {
        return proxyUri;
    }

    public void setProxyUri(String proxyUri) {
        this.proxyUri = proxyUri;
    }

    @Override
    public String toString() {
        String tempKey = null;
        if (proxyKey != null) {
            int l = proxyKey.length()/2;
            tempKey = proxyKey.substring(0,l);
            tempKey.concat("**********");
        }

        return "ApigeeRemoteProxyDetails{" +
                "proxyUri='" + proxyUri + '\'' +
                ", proxyKey='" + tempKey + '\'' +
                '}';
    }
}
