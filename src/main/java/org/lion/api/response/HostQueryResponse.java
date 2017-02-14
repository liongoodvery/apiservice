package org.lion.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.lion.model.HostQueryModel;

import java.util.List;

/**
 * Created by lion on 2/14/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HostQueryResponse extends BaseResponse {

    private List<HostQueryModel> data;

    public HostQueryResponse() {
    }

    public HostQueryResponse(List<HostQueryModel> data) {
        this.data = data;
    }


    public List<HostQueryModel> getData() {
        return data;
    }

    public void setData(List<HostQueryModel> data) {
        this.data = data;
    }
}
