package xyz.ipkr.pokercloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.ipkr.pokercloud.entity.DoorEntity;
import xyz.ipkr.pokercloud.service.DoorService;

@RestController
@RequestMapping("/door")
public class DoorController {

    @Autowired
    private DoorService doorService;

    @RequestMapping("/add")
    public String addDoor(String name) {
        return doorService.addDoor(name) ? "success" : "fail";
    }

    @RequestMapping("/update")
    public String updateDoor(Long id, Byte status, Integer action) {
        return doorService.updateDoor(id, status, action) ? "success" : "fail";
    }

    @RequestMapping("/control")
    public String controlDoor(Long id, Integer code) {
        return doorService.controlDoor(id, code);
    }

    @RequestMapping("/get")
    public DoorEntity getDoorById(Long id) {
        return doorService.getDoorById(id);
    }
}
