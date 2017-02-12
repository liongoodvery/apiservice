package org.lion.api.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by lion on 2/12/17.
 */
public class BaseResponse {
    private int retcode;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String msg;

    public BaseResponse() {
    }

    public BaseResponse(int retcode, String msg) {
        this.retcode = retcode;
        this.msg = msg;
    }

    public int getRetcode() {
        return retcode;
    }

    public void setRetcode(int retcode) {
        this.retcode = retcode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void require(String param) {
        this.msg = param + " is required";
    }

    public void succuess() {
        this.msg = "success";
        this.retcode = 0;
    }
}
