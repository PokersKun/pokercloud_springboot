package xyz.ipkr.pokercloud.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import xyz.ipkr.pokercloud.entity.DeviceEntity;

public interface DeviceMapper {

    @Insert("INSERT INTO devices VALUES (NULL, #{device_id}, #{name}, #{type}, #{location}, #{manager})")
    int insert(@Param("device_id") Long device_id, @Param("name") String name, @Param("type") String type, @Param("location") String location, @Param("manager") String manager);

    @Select("SELECT id, device_id, name, type, location, manager FROM devices WHERE id = #{id}")
    DeviceEntity queryById(@Param("id") Long id);
}
