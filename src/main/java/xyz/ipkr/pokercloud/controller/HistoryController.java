package xyz.ipkr.pokercloud.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.ipkr.pokercloud.entity.HistoryEntity;
import xyz.ipkr.pokercloud.service.HistoryService;

import java.util.List;

@RestController
@RequestMapping("/history")
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @RequestMapping("/add")
    public String addHistory(Long device_id, String username, String data_type, String data) {
        return historyService.addHistory(device_id, username, data_type, data) ? "success" : "fail";
    }

    @RequestMapping("/get")
    public List<HistoryEntity> getHistory(Long device_id) {
        return historyService.getHistoryByDeviceId(device_id);
    }

}
