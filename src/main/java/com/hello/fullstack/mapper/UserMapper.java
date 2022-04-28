package com.hello.fullstack.mapper;


import com.hello.fullstack.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<UserVo> selectAll();
}
