package org.lion.api.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lion on 2/14/17.
 */
@RestController
public class UserController {
    @RequestMapping("/api/user/login")
    public void login(@RequestParam(name = "username", required = true) String username,
                      @RequestParam(name = "password", required = true) String password,
                      @RequestParam(name = "callback", required = true) String callback) {

    }
}
