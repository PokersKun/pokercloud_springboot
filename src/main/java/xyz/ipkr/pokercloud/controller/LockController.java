package xyz.ipkr.pokercloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.ipkr.pokercloud.entity.LockEntity;
import xyz.ipkr.pokercloud.service.LockService;

@RestController
@RequestMapping("/lock")
public class LockController {

    @Autowired
    private LockService lockService;

    @RequestMapping("/add")
    public String addLock(String name) {
        return lockService.addLock(name) ? "success" : "fail";
    }

    @RequestMapping("/update")
    public String updateLock(Long id, Byte status, Integer action) {
        return lockService.updateLock(id, status, action) ? "success" : "fail";
    }

    @RequestMapping("/control")
    public String controlLock(Long id, Integer code) {
        return lockService.controlLock(id, code);
    }

    @RequestMapping("/get")
    public LockEntity getLockById(Long id) {
        return lockService.getLockById(id);
    }
}
