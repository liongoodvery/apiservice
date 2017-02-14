package org.lion.model;

import java.util.List;

public class HostQueryModel {
    private long timestamp;
    private List<String> hosts;

    public HostQueryModel() {
    }

    public HostQueryModel(long timestamp, List<String> hosts) {
        this.timestamp = timestamp;
        this.hosts = hosts;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public List<String> getHosts() {
        return hosts;
    }

    public void setHosts(List<String> hosts) {
        this.hosts = hosts;
    }
}
