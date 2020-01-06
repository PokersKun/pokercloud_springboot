package xyz.ipkr.pokercloud.mapper;

import org.apache.ibatis.annotations.*;
import xyz.ipkr.pokercloud.entity.HistoryEntity;

import java.util.List;

public interface HistoryMapper {

    @Insert("INSERT INTO historys VALUES (NULL, #{device_id}, #{username}, NOW(), #{data_type}, #{data})")
    int insert(@Param("device_id") Long device_id, @Param("username") String username, @Param("data_type") String data_type, @Param("data") String data);

    @Select("SELECT id, device_id, username, date, data_type, data FROM historys WHERE device_id = #{device_id}")
    List<HistoryEntity> queryHistoryByDeviceId(@Param("device_id") Long device_id);

}
