package org.lion.api.report;

import org.lion.api.response.HostResponse;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lion on 2/11/17.
 */
@RestController
public class HostController {
    @RequestMapping("/api/report/host")
    public HostResponse greeting(@RequestParam(name = "parent", required = false) String parent,
                                 @RequestParam(name = "children", required = false) String children,
                                 @RequestParam(name = "from", required = false) String from) {
        HostResponse response = new HostResponse();
        if (StringUtils.isEmpty(parent)) {
            response.setRetcode(-1);
            response.require("parent");
        } else {
            parent = new String(Base64.getDecoder().decode(parent));
            Set<String> set = new HashSet<>();
            if (!StringUtils.isEmpty(children)) {
                children = new String(Base64.getDecoder().decode(children));
                String[] splits = children.split("\u0000");
                for (String s : splits) {
                    set.add(parent + s);
                }
                response.setCount(set.size());

            } else {
                response.setCount(1);
            }
            response.setRetcode(0);
        }
        return response;
    }
}
