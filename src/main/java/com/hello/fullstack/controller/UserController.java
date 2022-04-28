package com.hello.fullstack.controller;

import com.hello.fullstack.dto.AllUsersResDto;
import com.hello.fullstack.dto.ResultCode;
import com.hello.fullstack.service.UserService;
import com.hello.fullstack.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("user")
    public AllUsersResDto allUsers(){
        AllUsersResDto resDto = new AllUsersResDto();
        try {
            List<UserVo> userList;
            userList = userService.selectAll();
            resDto.setUserList(userList);
            resDto.setResultCode(ResultCode.SUCCESSFUL.value());
        } catch (DataAccessException e) {
            log.error("Exception Occurred.", e);
            resDto.setResultCode(ResultCode.UNKNOWN_DATABASE_ERROR.value());
        } catch (Exception e) {
            log.error("Exception Occurred.", e);
            resDto.setResultCode(ResultCode.UNKNOWN_ERROR.value());
        }
        return resDto;
    }

}
