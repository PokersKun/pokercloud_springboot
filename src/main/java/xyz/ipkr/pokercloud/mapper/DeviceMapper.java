package xyz.ipkr.pokercloud.mapper;

import org.apache.ibatis.annotations.*;
import xyz.ipkr.pokercloud.entity.DeviceEntity;

public interface DeviceMapper {

    @Insert("INSERT INTO devices VALUES (NULL, #{device_id}, #{name}, #{type}, #{location}, #{manager}, 0, 0)")
    int insert(@Param("device_id") Long device_id, @Param("name") String name, @Param("type") String type, @Param("location") String location, @Param("manager") String manager);

    @Select("SELECT id, device_id, name, type, location, manager, status, action FROM devices WHERE device_id = #{device_id}")
    DeviceEntity queryDeviceByDeviceId(@Param("device_id") Long device_id);

    @Select("SELECT IFNULL(MAX(id), 0) FROM devices WHERE device_id = #{device_id}")
    int queryDeviceIdByDeviceId(@Param("device_id") Long device_id);

    @Update("UPDATE devices SET status = #{status}, action = #{action} WHERE #{device_id} = device_id")
    void updateStatusByDeviceId(@Param("device_id") Long device_id, @Param("status") Byte status, @Param("action") Integer action);

    @Update("UPDATE devices SET name = #{name}, type = #{type}, location = #{location} WHERE device_id = #{device_id}")
    int updateInfoByDeviceId(@Param("device_id") Long device_id, @Param("name") String name, @Param("type") String type, @Param("location") String location);

    @Delete("DELETE FROM devices WHERE device_id = #{device_id}")
    int deleteByDeviceId(@Param("device_id") Long device_id);

}
