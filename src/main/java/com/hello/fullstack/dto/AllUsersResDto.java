package com.hello.fullstack.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hello.fullstack.vo.UserVo;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)      // 값이 NULL인 항목을 제외하고 json 매핑
public class AllUsersResDto {
    private int resultCode;
    private List<UserVo> userList;
}