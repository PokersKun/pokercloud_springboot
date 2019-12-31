package xyz.ipkr.pokercloud.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDeviceMapper {


    @Insert("INSERT INTO user_devices VALUES (NULL, #{username}, #{device_id}, 0)")
    int insert(@Param("username") String username, @Param("device_id") Long device_id);

    @Select("SELECT device_id FROM user_devices WHERE username = #{username}")
    List<Long> queryDeviceIdByUsername(@Param("username") String username);

}
