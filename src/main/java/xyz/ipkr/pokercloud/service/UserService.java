package xyz.ipkr.pokercloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import xyz.ipkr.pokercloud.entity.UserInfoEntity;
import xyz.ipkr.pokercloud.mapper.UserMapper;

@Service
public class UserService {

    @Autowired(required = false)
    private UserMapper userMapper;

    public boolean addUser(String username, String phone, String password, String email, String nickname) {
        return userMapper.insert(username, phone, DigestUtils.md5DigestAsHex(password.getBytes()), email, nickname) > 0;
    }

    public boolean loginUser(String username, String password) {
        return userMapper.queryByInfo(username, DigestUtils.md5DigestAsHex(password.getBytes())) > 0;
    }

    public boolean checkUser(String username) {
        return userMapper.queryByUsername(username) > 0;
    }

    public UserInfoEntity getUserInfo(String username) {
        return userMapper.queryInfoByUsername(username);
    }
}
