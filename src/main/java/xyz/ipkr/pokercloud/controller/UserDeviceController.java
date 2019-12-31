package xyz.ipkr.pokercloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.ipkr.pokercloud.service.UserDeviceService;

import java.util.List;

@RestController
@RequestMapping("/user_device")
public class UserDeviceController {

    @Autowired
    private UserDeviceService userDeviceService;

    @RequestMapping("/add")
    public String addUserDevice(String username, Long device_id) {
        return userDeviceService.addUserDevice(username, device_id) ? "success" : "fail";
    }

    @RequestMapping("/get")
    public List<Long> getDeviceId(String username) {
        return userDeviceService.getDeviceId(username);
    }
}
