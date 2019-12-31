package xyz.ipkr.pokercloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.ipkr.pokercloud.entity.DeviceEntity;
import xyz.ipkr.pokercloud.service.DeviceService;

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
    public DeviceEntity getDeviceById(Long id) {
        return deviceService.getDeviceById(id);
    }

}
