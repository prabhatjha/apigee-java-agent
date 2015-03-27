package io.apigee.agent;

/**
 * Created by prabhat on 3/25/15.
 */
public class KeyTokenDetails {

    private String keyName;
    private String keyLocation;
    private boolean continueOnNetworkError;

    public KeyTokenDetails (String name, String location, boolean continueOnError) {
        this.keyName = name;
        this.keyLocation = location;
        this.continueOnNetworkError = continueOnError;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getKeyLocation() {
        return keyLocation;
    }

    public void setKeyLocation(String keyLocation) {
        this.keyLocation = keyLocation;
    }

    public boolean isContinueOnNetworkError() {
        return continueOnNetworkError;
    }

    public void setContinueOnNetworkError(boolean continueOnNetworkError) {
        this.continueOnNetworkError = continueOnNetworkError;
    }

    @Override
    public String toString() {
        return "KeyTokenDetails{" +
                "keyName='" + keyName + '\'' +
                ", keyLocation='" + keyLocation + '\'' +
                ", continueOnNetworkError=" + continueOnNetworkError +
                '}';
    }
}
