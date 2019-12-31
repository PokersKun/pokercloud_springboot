package xyz.ipkr.pokercloud.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import xyz.ipkr.pokercloud.entity.DeviceEntity;

public interface QuickMapper {

    @Insert("INSERT INTO quicks VALUES (NULL, #{device_id}, #{username})")
    int insert(@Param("device_id") Long device_id, @Param("username") String username);

    @Select("SELECT device_id FROM quicks WHERE username = #{username}")
    Long queryDeviceIdByUsername(@Param("username") String username);

}
