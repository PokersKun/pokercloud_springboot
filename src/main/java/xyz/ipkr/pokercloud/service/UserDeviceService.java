package xyz.ipkr.pokercloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.ipkr.pokercloud.entity.UserDeviceEntity;
import xyz.ipkr.pokercloud.mapper.UserDeviceMapper;

import java.util.List;

@Service
public class UserDeviceService {

    @Autowired(required = false)
    private UserDeviceMapper userDeviceMapper;

    public boolean addUserDevice(String username, Long device_id) {
        return userDeviceMapper.insert(username, device_id) > 0;
    }

    public List<UserDeviceEntity> getUserDevice(String username) {
        return userDeviceMapper.queryUserDeviceByUsername(username);
    }

    public boolean deleteUserDevice(String username, Long device_id) {
        return userDeviceMapper.delete(username, device_id) > 0;
    }

    public boolean updateQuick(String username, Long device_id, Byte is_quick) {
        return userDeviceMapper.updateQuick(username, device_id, is_quick) > 0;
    }

    public boolean checkUserDevice(String username, Long device_id) {
        return userDeviceMapper.queryByInfo(username, device_id) > 0;
    }

    public boolean deleteUserDeviceByDeviceId(Long device_id) {
        return userDeviceMapper.deleteByDeviceId(device_id) > 0;
    }

}
