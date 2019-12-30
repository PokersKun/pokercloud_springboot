package xyz.ipkr.pokercloud.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import xyz.ipkr.pokercloud.entity.DoorEntity;

public interface DoorMapper {

    @Select("SELECT id, name, status, action FROM door WHERE id = #{id}")
    DoorEntity findById(@Param("id") Long id);

    @Insert("INSERT INTO door VALUES (NULL, #{name}, 0, 0)")
    int insert(@Param("name") String name);

    @Update("UPDATE door SET status = #{status}, action = #{action} WHERE id = #{id}")
    int update(@Param("id") Long id, @Param("status") Byte status, @Param("action") Integer action);

}
