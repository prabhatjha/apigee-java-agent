package io.apigee.agent;

import org.apache.log4j.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;

import java.io.IOException;



class ApigeeAgentFilter implements Filter {

    private static Logger logger = Logger.getLogger(ApigeeAgentFilter.class);

    private ApigeeRemoteProxyDetails proxyDetails = null;
    private KeyTokenDetails keyDetails = null;
    private boolean validConfiguration = false;

    @Override
    public void init (FilterConfig filterConfig) throws ServletException {
        initRemoteProxyInfo(filterConfig);
        initApiKeyInfo(filterConfig);
        validateConfiguration();
        if (!validConfiguration) {
            logger.error("ApigeeAgent Servlet Filter configurations is not valid. Verify that " +
                    "Remote Proxy is deployed to your org and you are using correct URI and Key");
            logger.error(proxyDetails.toString());
            throw new ServletException("Invalid Filter Configuration");
        }

    }

    private void validateConfiguration() {

        validConfiguration =  proxyDetails.getProxyKey() != null &&
                proxyDetails.getProxyUri() != null;
    }

    private void initRemoteProxyInfo(FilterConfig filterConfig) {
        String uri = filterConfig.getInitParameter(ApigeeAgentConstants.REMOTE_PROXY_URL );
        String key = filterConfig.getInitParameter(ApigeeAgentConstants.REMOTE_PROXY_KEY);
        this.proxyDetails = new ApigeeRemoteProxyDetails(uri, key);
        logger.debug(proxyDetails.toString());

    }

    private void initApiKeyInfo(FilterConfig filterConfig) {
        String keyName = filterConfig.getInitParameter(ApigeeAgentConstants.API_KEY_NAME);
        String keyLocation = filterConfig.getInitParameter(ApigeeAgentConstants.KEY_OR_TOKEN_LOCATION);
        boolean continueOnError = Boolean.getBoolean(
                filterConfig.getInitParameter(ApigeeAgentConstants.CONTINUE_ON_NETWORK_ERROR));
        this.keyDetails = new KeyTokenDetails(keyName, keyLocation, continueOnError);
        logger.debug(keyDetails.toString());

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }


    @Override
    public void destroy () {

    }


}
