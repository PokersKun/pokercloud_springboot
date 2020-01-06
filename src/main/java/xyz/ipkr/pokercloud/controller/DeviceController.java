package xyz.ipkr.pokercloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.ipkr.pokercloud.entity.DeviceEntity;
import xyz.ipkr.pokercloud.service.DeviceService;

import java.io.IOException;

@RestController
@RequestMapping("/device")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @RequestMapping("/add")
    public String addDevice(Long device_id, String name, String type, String location, String manager) {
        return deviceService.addDevice(device_id, name, type, location, manager) ? "success" : "fail";
    }

    @RequestMapping("/get")
    public DeviceEntity getDeviceByDeviceId(Long device_id) {
        return deviceService.getDeviceByDeviceId(device_id);
    }

    @RequestMapping("/check")
    public String checkDevice(Long device_id) {
        return deviceService.checkDevice(device_id) ? "success" : "fail";
    }

    @RequestMapping("/control")
    public String controlDevice(Long device_id, String type, Integer code) {
        return deviceService.controlDevice(device_id, type, code);
    }

    @RequestMapping("/get_code")
    public String getQRCode(String content) throws IOException {
        return deviceService.creatQRCode(content,400,400);
    }

    @RequestMapping("/set_info")
    public String updateInfo(Long device_id, String name, String type, String location) {
        return deviceService.updateInfo(device_id, name, type, location) ? "success" : "fail";
    }

    @RequestMapping("/delete")
    public String deleteDevice(Long device_id) {
        return deviceService.deleteUserDeviceByDeviceId(device_id) ? "success" : "fail";
    }

}
