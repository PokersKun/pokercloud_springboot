package xyz.ipkr.pokercloud.mapper;

import org.apache.ibatis.annotations.*;
import xyz.ipkr.pokercloud.entity.UserDeviceEntity;

import java.util.List;

public interface UserDeviceMapper {


    @Insert("INSERT INTO user_devices VALUES (NULL, #{username}, #{device_id}, 0)")
    int insert(@Param("username") String username, @Param("device_id") Long device_id);

    @Select("SELECT id, username, device_id, is_quick FROM user_devices WHERE username = #{username}")
    List<UserDeviceEntity> queryUserDeviceByUsername(@Param("username") String username);

    @Delete("DELETE FROM user_devices WHERE username = #{username} AND device_id = #{device_id}")
    int delete(@Param("username") String username, @Param("device_id") Long device_id);

    @Update("UPDATE user_devices SET is_quick = #{is_quick} WHERE username = #{username} AND #{device_id} = device_id")
    int updateQuick(@Param("username") String username, @Param("device_id") Long device_id, @Param("is_quick") Byte is_quick);

    @Select("SELECT IFNULL(MAX(id), 0) FROM user_devices WHERE username = #{username} AND device_id = #{device_id}")
    int queryByInfo(@Param("username") String username, @Param("device_id") Long device_id);

    @Delete("DELETE FROM user_devices WHERE device_id = #{device_id}")
    int deleteByDeviceId(@Param("device_id") Long device_id);

}
