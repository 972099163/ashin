package com.ashin.service.dto;/**
 * Created by Administrator on 2019/9/23.
 */

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 将配置文件的变量配置映射为java bean
 * @Author:debug (SteadyJack)
 * @Date: 2019/9/23 18:21
 **/
@ConfigurationProperties(prefix = "order")
@Component
@ToString
@Data
public class OrderDto implements Serializable{

    private String title;

    private String info;

    private Double price;

    private Integer id;
}