package com.ashin.service.dto;/**
 * Created by Administrator on 2019/9/7.
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author:debug (SteadyJack)
 * @Date: 2019/9/7 22:32
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PersonDto implements Serializable{

    private Integer id;

    private Integer age;

    private String name;

}