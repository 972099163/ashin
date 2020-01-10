package com.ashin.service.dto;/**
 * Created by Administrator on 2019/9/23.
 */

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @Author:debug (SteadyJack)
 * @Date: 2019/9/23 21:35
 **/
@Data
@ToString
@ConfigurationProperties(prefix = "www.baidu.com")
@PropertySource(value = "classpath:handsome.properties")
@Component
public class HandsomeDto implements Serializable{

    private String title;

    private Integer age;

}




















