package com.ashin.service.service;/**
 * Created by Administrator on 2019/10/12.
 */


import com.ashin.service.dto.MenuDto;
import com.ashin.service.dto.MenuEntity;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:debug (SteadyJack)
 * @Date: 2019/10/12 20:02
 **/
@Service
public class MenuService {

    private static final Logger log= LoggerFactory.getLogger(MenuService.class);

    public void manageMenu(MenuDto menuDto) throws Exception{
        log.info("接收到前端菜单层级列表树：{}",menuDto);

        List<MenuEntity> resList= Lists.newLinkedList();
        circleMenu(menuDto,resList);

        log.info("处理结果：{}",resList);
        for (MenuEntity entity:resList){
            log.info("遍历可以准备插入数据库：{} ",entity);
        }
    }

    private void circleMenu(MenuDto dto,List<MenuEntity> resList){
        MenuEntity entity=new MenuEntity();
        entity.setId(dto.getId());
        entity.setParentId(dto.getParentId());
        entity.setName(dto.getName());

        resList.add(entity);

        List<MenuDto> sons=dto.getSons();
        if (sons!=null && !sons.isEmpty()){
            sons.stream().forEach(m -> circleMenu(m,resList));
        }
    }
}





































