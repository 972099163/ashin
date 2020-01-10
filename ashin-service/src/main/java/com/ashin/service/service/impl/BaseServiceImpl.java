package com.ashin.service.service.impl;/**
 * Created by Administrator on 2019/8/24.
 */


import com.ashin.model.entity.Item;
import com.ashin.model.mapper.ItemMapper;
import com.ashin.service.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:debug (SteadyJack)
 * @Date: 2019/8/24 17:18
 **/
@Service
public class BaseServiceImpl implements IBaseService {

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public Item getItem(Integer id) throws Exception {
        return itemMapper.selectByPrimaryKey(id);
    }
}