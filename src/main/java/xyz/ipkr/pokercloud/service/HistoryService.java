package xyz.ipkr.pokercloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.ipkr.pokercloud.entity.HistoryEntity;
import xyz.ipkr.pokercloud.mapper.HistoryMapper;

import java.util.List;

@Service
public class HistoryService {

    @Autowired(required = false)
    private HistoryMapper historyMapper;

    public boolean addHistory(Long device_id, String username, String data_type, String data) {
        return historyMapper.insert(device_id, username, data_type, data) > 0;
    }

    public List<HistoryEntity> getHistoryByDeviceId(Long device_id) {
        return historyMapper.queryHistoryByDeviceId(device_id);
    }


}
