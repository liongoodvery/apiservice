package org.lion.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by lion on 2/12/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HostResponse extends BaseResponse {
    private int count;

    public HostResponse() {
    }

    public HostResponse(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
