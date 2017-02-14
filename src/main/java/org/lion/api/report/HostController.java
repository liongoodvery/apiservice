package org.lion.api.report;

import org.lion.api.response.HostQueryResponse;
import org.lion.api.response.HostResponse;
import org.lion.dao.ReportHostDao;
import org.lion.model.HostQueryModel;
import org.lion.model.ReportHostModel;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.Base64;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by lion on 2/11/17.
 */
@RestController
public class HostController {
    @RequestMapping("/api/report/host")
    public HostResponse greeting(@RequestParam(name = "parent", required = false) String parent,
                                 @RequestParam(name = "children", required = false) String children,
                                 @RequestParam(name = "src", required = false) String src) {
        HostResponse response = new HostResponse();
        if (StringUtils.isEmpty(parent)) {
            response.setRetcode(-1);
            response.require("parent");
        } else {
            ReportHostModel model = new ReportHostModel();
            parent = new String(Base64.getDecoder().decode(parent));
            model.setParent(parent);
            Set<String> set = new TreeSet<>();
            if (!StringUtils.isEmpty(children)) {
                children = new String(Base64.getDecoder().decode(children));
                model.setChildren(children);
                String[] splits = children.split("\u0000");
                for (String s : splits) {
                    set.add(parent + s);
                }
                response.setCount(set.size());

            } else {
                response.setCount(1);
            }
            response.setRetcode(0);
            try {
                new ReportHostDao().addReport(model);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return response;
    }


    @RequestMapping("/api/report/query-host")
    public HostQueryResponse queryHost(@RequestParam(name = "time", required = false) Long timestamp,
                                       @RequestParam(name = "count", required = false) Integer count,
                                       @RequestParam(name = "src", required = false) String src) {
        HostQueryResponse response = new HostQueryResponse();
        if (timestamp == null || timestamp < 0) {
            timestamp = System.currentTimeMillis();
        }
        if (count == null || count <= 0) {
            count = 1;
        }

        ReportHostDao dao = new ReportHostDao();

        try {
            List<HostQueryModel> models = dao.query(timestamp, count, src);
            response.setData(models);
        } catch (SQLException e) {
            e.printStackTrace();
            response.setRetcode(-1);
            response.setMsg(e.getMessage());
        }
        return response;
    }
}
