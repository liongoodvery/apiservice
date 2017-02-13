package org.lion.model;

/**
 * Created by lion on 2/13/17.
 */
public class ReportHostModel {
    private String id;
    private long timestamp;
    private String detailId;
    private String parent;
    private String children;
    private String src;

    public ReportHostModel() {
    }

    public ReportHostModel(String id, String detailId, String parent, String children, String src) {
        this.id = id;
        this.detailId = detailId;
        this.parent = parent;
        this.children = children;
        this.src = src;
   }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getDetailId() {
        return detailId;
    }

    public void setDetailId(String detailId) {
        this.detailId = detailId;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getChildren() {
        return children;
    }

    public void setChildren(String children) {
        this.children = children;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}
