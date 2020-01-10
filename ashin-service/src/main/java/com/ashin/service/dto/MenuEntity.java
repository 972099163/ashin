package com.ashin.service.dto;/**
 * Created by Administrator on 2019/10/12.
 */

import lombok.Data;

import java.io.Serializable;

/**
 * @Author:debug (SteadyJack)
 * @Date: 2019/10/12 20:01
 **/
@Data
public class MenuEntity implements Serializable{

    private Integer id;
    private Integer parentId;
    private String name;

}