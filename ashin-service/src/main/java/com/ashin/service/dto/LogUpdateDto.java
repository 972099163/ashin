package com.ashin.service.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * @Author:debug (SteadyJack)
 * @Link: weixin-> debug0868 qq-> 1948831260
 * @Date: 2019/11/7 16:14
 **/
@Data
public class LogUpdateDto implements Serializable{

    @NotBlank
    private String name;

    @NotBlank
    private String code;

}