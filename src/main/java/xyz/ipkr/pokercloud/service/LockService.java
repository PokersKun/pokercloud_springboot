package xyz.ipkr.pokercloud.service;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.ipkr.pokercloud.entity.ControlEntity;
import xyz.ipkr.pokercloud.entity.LockEntity;
import xyz.ipkr.pokercloud.mapper.LockMapper;
import xyz.ipkr.pokercloud.mqtt.IMqttSender;

import javax.annotation.Resource;

@Service
public class LockService {

    private static Gson gson = new Gson();

    @Resource
    private IMqttSender iMqttSender;

    @Autowired(required = false)
    private LockMapper lockMapper;

    public boolean addLock(String name) {
        return lockMapper.insert(name) > 0;
    }

    public boolean updateLock(Long id, Byte status, Integer action) {
        return lockMapper.update(id, status, action) > 0;
    }

    public String controlLock(Long id, Integer code) {
        ControlEntity controlEntity = new ControlEntity();
        controlEntity.setId(id);
        controlEntity.setCode(code);
        iMqttSender.sendToMqtt(gson.toJson(controlEntity));
        return "success";
    }

    public LockEntity getLockById(Long id) {
        return lockMapper.queryById(id);
    }

}
