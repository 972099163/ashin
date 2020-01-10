package com.ashin.service.controller;/**
 * Created by Administrator on 2019/8/24.
 */


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ashin.api.enums.StatusCode;
import com.ashin.api.response.BaseResponse;
import com.ashin.model.entity.EbCustomer;
import com.ashin.service.annotation.LogAnnotation;
import com.ashin.service.dto.MenuDto;
import com.ashin.service.service.EbCustomerService;
import com.ashin.service.service.IBaseService;
import com.ashin.service.service.MenuService;
import com.ashin.service.utils.ValidatorUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author:debug (SteadyJack)
 * @Date: 2019/8/24 16:07
 **/
@RestController
@RequestMapping("base")
public class BaseController {

    @Autowired
    private IBaseService baseService;
    @Autowired
    private EbCustomerService ebCustomerService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    /**
     * json交互获取基本的信息一
     * @param name
     * @return
     */
    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public BaseResponse info(String name){
        BaseResponse response=new BaseResponse(StatusCode.Success);
        try {
            response.setData(name);

        }catch (Exception e){
            response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }
        return response;
    }

    /**
     * json交互获取基本的信息二
     * @param id
     * @return
     */
    @RequestMapping(value = "/item",method = RequestMethod.GET)
    public BaseResponse item(@RequestParam(required = false,defaultValue = "1") Integer id){
        BaseResponse response=new BaseResponse(StatusCode.Success);
        try {
            response.setData(baseService.getItem(id));

        }catch (Exception e){
            response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }
        return response;
    }

    /**
     * json交互获取基本的信息二
     * @param id
     * @return
     */
    @RequestMapping(value = "/getEbCustomer",method = RequestMethod.GET)
    public BaseResponse getEbCustomer(@RequestParam(required = false,defaultValue = "1") Integer id){
        BaseResponse response=new BaseResponse(StatusCode.Success);
        try {
            String a=stringRedisTemplate.opsForValue().get("aab");
            if(StringUtils.isNotBlank(a))
            {
                response.setData(a);
            }else
            {
                List<EbCustomer> ebCustomers=ebCustomerService.selectAll();
               a= JSON.toJSONString(ebCustomers, SerializerFeature.WriteMapNullValue,SerializerFeature.WriteNullStringAsEmpty);
                response.setData(a);
               stringRedisTemplate.opsForValue().set("aab",a);
            }


        }catch (Exception e){
            response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }
        return response;
    }

    @LogAnnotation("新增用户数据")
    @RequestMapping(value = "/insertEbCustomer",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse insertEbCustomer(@RequestBody @Validated EbCustomer ebCustomer, BindingResult result){

        String error= ValidatorUtil.checkResult(result);
        if (StringUtils.isNotBlank(error)){
            return new BaseResponse(StatusCode.Fail.getCode(),error);
        }
        BaseResponse response=new BaseResponse(StatusCode.Success);
        try {
            response.setData(ebCustomerService.insert(ebCustomer));

        }catch (Exception e){
            response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/deleteEbCustomer",method = RequestMethod.POST)
    public BaseResponse deleteEbCustomer(@RequestParam(value="ids[]") Long[] ids){


        BaseResponse response=new BaseResponse(StatusCode.Success);
        try {
            response.setData(ebCustomerService.deleteBatch(ids));

        }catch (Exception e){
            response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/menu",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse menu(@RequestBody MenuDto menuDto){
        BaseResponse response=new BaseResponse(StatusCode.Success);
        try {
            menuService.manageMenu(menuDto);
        }catch (Exception e){
            response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }
        return response;
    }
}



































