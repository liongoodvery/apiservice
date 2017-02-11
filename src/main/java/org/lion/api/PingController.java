package org.lion.api;

import org.slf4j.LoggerFactory;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lion on 2/11/17.
 */
@RestController
public class PingController {
    @RequestMapping("/api/ping")
    public int greeting(@RequestParam(value="ips", defaultValue="") String ips) {
        byte[] bytes = Base64Utils.decodeFromString(ips);
        String[] split = new String(bytes).split("-");
        System.out.println(ips);
        for (String s : split) {
            System.out.println(s);
            LoggerFactory.getLogger(PingController.class).info(s);
        }

        return 0;
    }
}
