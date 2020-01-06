package xyz.ipkr.pokercloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.ipkr.pokercloud.mapper.DeviceMapper;
import xyz.ipkr.pokercloud.mapper.QuickMapper;

@Service
public class QuickService {

    @Autowired(required = false)
    private QuickMapper quickMapper;

    public boolean addQuick(Long device_id, String username) {
        return quickMapper.insert(device_id, username) > 0;
    }

    public Long getDeviceId(String username) {
        return quickMapper.queryDeviceIdByUsername(username);
    }

    public boolean deleteQuick(String username, Long device_id) {
        return quickMapper.delete(username, device_id) > 0;
    }


}
