package xyz.ipkr.pokercloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.ipkr.pokercloud.service.QuickService;

@RestController
@RequestMapping("/quick")
public class QuickController {

    @Autowired
    private QuickService quickService;

    @RequestMapping("/add")
    public String addQuick(Long device_id, String username) {
        return quickService.addQuick(device_id, username) ? "success" : "fail";
    }

    @RequestMapping("/get")
    public Long getDeviceId(String username) {
        return quickService.getDeviceId(username);
    }

}
