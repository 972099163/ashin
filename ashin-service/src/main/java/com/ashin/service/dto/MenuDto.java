package com.ashin.service.dto;/**
 * Created by Administrator on 2019/10/12.
 */

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author:debug (SteadyJack)
 * @Date: 2019/10/12 19:54
 **/
@Data
public class MenuDto implements Serializable{

    private Integer id;
    private Integer parentId;
    private String name;

    private List<MenuDto> sons;
}