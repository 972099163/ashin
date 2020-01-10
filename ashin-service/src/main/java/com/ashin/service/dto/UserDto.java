package com.ashin.service.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * @Author:debug (SteadyJack)
 * @Link: weixin-> debug0868 qq-> 1948831260
 * @Date: 2019/11/11 23:21
 **/
@Data
public class UserDto implements Serializable{

    @NotBlank(message = "name不能为空！")
    private String name;

    @NotBlank(message = "code不能为空！")
    private String code;

    @NotBlank(message = "email不能为空！")
    private String email;

}