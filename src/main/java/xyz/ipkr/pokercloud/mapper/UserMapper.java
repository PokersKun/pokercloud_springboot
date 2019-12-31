package xyz.ipkr.pokercloud.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import xyz.ipkr.pokercloud.entity.UserInfoEntity;

public interface UserMapper {

    @Insert("INSERT INTO users VALUES (NULL, #{username}, #{phone}, #{password}, #{email}, #{nickname})")
    int insert(@Param("username") String username, @Param("phone") String phone, @Param("password") String password, @Param("email") String email, @Param("nickname") String nickname);

    @Select("SELECT IFNULL(MAX(id), 0) FROM users WHERE username = #{username} AND password = #{password}")
    int queryByInfo(@Param("username") String username, @Param("password") String password);

    @Select("SELECT IFNULL(MAX(id), 0) FROM users WHERE username = #{username}")
    int queryByUsername(@Param("username") String username);

    @Select("SELECT phone, email, nickname FROM users WHERE username = #{username}")
    UserInfoEntity queryInfoByUsername(@Param("username") String username);
}
