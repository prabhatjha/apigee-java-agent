package io.apigee.agent;

/**
 * Created by prabhat on 3/25/15.
 */
public class ApigeeAgentConstants {

    //These are to be used in filter configuration in web.xml

    /*configuration json file which has details of Apigee Remote Proxy and other details.
    Assumes the file pointed by agentConfigFile is in classpath. If there is any problem loading
    this file, we will log error/exception it but will not cause web app to not start
     */
    public static final String AGENT_CONFIG_FILE = "agentConfigFile";

    /**
     * For simple cases, it might be better to define Filter configurations in web.xml
     * itself instead of pointing to separate file. We will only read these configurations
     * when APIGEE_AGENT_CONFIG is not set.
     * */

    public static final String REMOTE_PROXY_URL = "remoteProxyUrl";
    public static final String REMOTE_PROXY_KEY = "remoteProxyKey";

    public static final String VERIFY_API_KEY = "oauthVerifyApiKey";
    public static final String API_KEY_NAME = "apiKeyName";
    //valid values are either header or queryParameter
    public static final String KEY_OR_TOKEN_LOCATION = "keyOrTokenLocation";

    public static final String KEY_OR_TOKEN_LOCATION_HEADER = "header";
    public static final String KEY_OR_TOKEN_LOCATION_QUERY_PARAMETER = "queryParameter";

    //valid values are true or false
    public static final String CONTINUE_ON_NETWORK_ERROR = "continueOnNetworkError";




}
