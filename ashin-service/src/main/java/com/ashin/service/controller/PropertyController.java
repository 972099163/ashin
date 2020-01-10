package com.ashin.service.controller;/**
 * Created by Administrator on 2019/9/23.
 */


import com.ashin.api.enums.StatusCode;
import com.ashin.api.response.BaseResponse;
import com.ashin.service.dto.HandsomeDto;
import com.ashin.service.dto.OrderDto;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author:debug (SteadyJack)
 * @Date: 2019/9/23 17:59
 **/
@RestController
@RequestMapping("order")
public class PropertyController {

    @Value("${order.title}")
    private String orderTitle;

    @Value("${order.id}")
    private Integer orderId;

    @GetMapping("info/1")
    public BaseResponse info1(){
        BaseResponse response=new BaseResponse(StatusCode.Success);
        Map<String,Object> resMap= Maps.newHashMap();
        try {
            resMap.put("orderTitle",orderTitle);
            resMap.put("orderId",orderId);

            response.setData(resMap);
        }catch (Exception e){
            response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }
        return response;
    }


    @Autowired
    private Environment env;

    @GetMapping("info/2")
    public BaseResponse info2(){
        BaseResponse response=new BaseResponse(StatusCode.Success);
        Map<String,Object> resMap= Maps.newHashMap();
        try {
            resMap.put("orderInfo",env.getProperty("order.info"));
            resMap.put("orderPrice",env.getProperty("order.price",Double.class));

            response.setData(resMap);
        }catch (Exception e){
            response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }
        return response;
    }


    @Autowired
    private OrderDto orderDto;

    @GetMapping("info/3")
    public BaseResponse info3(){
        BaseResponse response=new BaseResponse(StatusCode.Success);
        Map<String,Object> resMap= Maps.newHashMap();
        try {
            resMap.put("orderDto",orderDto);
            resMap.put("orderDto的id",orderDto.getId());

            response.setData(resMap);
        }catch (Exception e){
            response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }
        return response;
    }


    @Autowired
    private HandsomeDto handsomeDto;

    @GetMapping("info/4")
    public BaseResponse info4(){
        BaseResponse response=new BaseResponse(StatusCode.Success);
        Map<String,Object> resMap= Maps.newHashMap();
        try {
            resMap.put("handsomeDto",handsomeDto);
            resMap.put("handsomeDto的title",handsomeDto.getTitle());

            response.setData(resMap);
        }catch (Exception e){
            response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }
        return response;
    }
}























