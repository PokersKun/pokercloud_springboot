package xyz.ipkr.pokercloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.ipkr.pokercloud.mapper.UserDeviceMapper;

import java.util.List;

@Service
public class UserDeviceService {

    @Autowired(required = false)
    private UserDeviceMapper userDeviceMapper;

    public boolean addUserDevice(String username, Long device_id) {
        return userDeviceMapper.insert(username, device_id) > 0;
    }

    public List<Long> getDeviceId(String username) {
        return userDeviceMapper.queryDeviceIdByUsername(username);
    }

}
