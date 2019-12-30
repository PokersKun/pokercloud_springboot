package xyz.ipkr.pokercloud.service;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.ipkr.pokercloud.entity.ControlEntity;
import xyz.ipkr.pokercloud.entity.DoorEntity;
import xyz.ipkr.pokercloud.mapper.DoorMapper;
import xyz.ipkr.pokercloud.mqtt.IMqttSender;

import javax.annotation.Resource;

@Service
public class DoorService {

    private static Gson gson = new Gson();

    @Resource
    private IMqttSender iMqttSender;

    @Autowired(required = false)
    private DoorMapper doorMapper;

    public boolean addDoor(String name) {
        return doorMapper.insert(name) > 0;
    }

    public boolean updateDoor(Long id, Byte status, Integer action) {
        return doorMapper.update(id, status, action) > 0;
    }

    public String controlDoor(Long id, Integer code) {
        ControlEntity controlEntity = new ControlEntity();
        controlEntity.setId(id);
        controlEntity.setCode(code);
        iMqttSender.sendToMqtt(gson.toJson(controlEntity));
        return "success";
    }

    public DoorEntity getDoorById(Long id) {
        return doorMapper.findById(id);
    }

}
