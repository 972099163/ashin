package com.ashin.service.controller;/**
 * Created by Administrator on 2019/8/24.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author:debug (SteadyJack)
 * @Date: 2019/8/24 17:25
 **/
@Controller
@RequestMapping("base/page")
public class BasePageController extends AbstractController{

    @RequestMapping("/info")
    public String info(){
        return "page";
    }

}



























