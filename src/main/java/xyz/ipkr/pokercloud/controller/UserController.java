package xyz.ipkr.pokercloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.ipkr.pokercloud.entity.UserInfoEntity;
import xyz.ipkr.pokercloud.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/add")
    public String addUser(String username, String phone, String password, String email, String nickname) {
        return userService.addUser(username, phone, password, email, nickname) ? "success" : "fail";
    }

    @RequestMapping("/login")
    public String loginUser(String username, String password) {
        return userService.loginUser(username, password) ? "success" : "fail";
    }

    @RequestMapping("/check")
    public String checkUser(String username) {
        return userService.checkUser(username) ? "success" : "fail";
    }

    @RequestMapping("/get_info")
    public UserInfoEntity getUserInfo(String username) {
        return userService.getUserInfo(username);
    }
}
