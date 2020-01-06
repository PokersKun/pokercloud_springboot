package xyz.ipkr.pokercloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.ipkr.pokercloud.entity.UserDeviceEntity;
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
    public List<UserDeviceEntity> getUserDevice(String username) {
        return userDeviceService.getUserDevice(username);
    }

    @RequestMapping("/delete")
    public String deleteUserDevice(String username, Long device_id) {
        return userDeviceService.deleteUserDevice(username, device_id) ? "success" : "fail";
    }

    @RequestMapping("/update_quick")
    public String updateQuick(String username, Long device_id, Byte is_quick) {
        return userDeviceService.updateQuick(username, device_id, is_quick) ? "success" : "fail";
    }

    @RequestMapping("/check")
    public String checkUserDevice(String username, Long device_id) {
        return userDeviceService.checkUserDevice(username, device_id) ? "success" : "fail";
    }

    @RequestMapping("/delete_all")
    public String deleteAllUserDevice(Long device_id) {
        return userDeviceService.deleteUserDeviceByDeviceId(device_id) ? "success" : "fail";
    }

}
