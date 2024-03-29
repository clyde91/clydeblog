package com.clyde.blog.model;

/**
 * @author clyde
 */
public class OssPolicyResult {
    private String accessKeyId;
    private String policy;
    private String signature;
    private String dir;
    private String host;
    private String callback;

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getCallback() {
        return callback;
    }

    @Override
    public String toString() {
        return "OssPolicyResult{" +
                "accessKeyId='" + accessKeyId + '\'' +
                ", policy='" + policy + '\'' +
                ", signature='" + signature + '\'' +
                ", dir='" + dir + '\'' +
                ", host='" + host + '\'' +
                ", callback='" + callback + '\'' +
                '}';
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }
}
