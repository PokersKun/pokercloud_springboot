package xyz.ipkr.pokercloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.ipkr.pokercloud.entity.DeviceEntity;
import xyz.ipkr.pokercloud.mapper.DeviceMapper;

@Service
public class DeviceService {

    @Autowired(required = false)
    private DeviceMapper deviceMapper;

    public boolean addDevice(Long device_id, String name, String type, String location, String manager) {
        return deviceMapper.insert(device_id, name, type, location, manager) > 0;
    }

    public DeviceEntity getDeviceById(Long id) {
        return deviceMapper.queryById(id);
    }
}
