package com.hello.fullstack.service;

import com.hello.fullstack.mapper.UserMapper;
import com.hello.fullstack.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<UserVo> getUserList() {
        return userMapper.getUserList();
    }
}
