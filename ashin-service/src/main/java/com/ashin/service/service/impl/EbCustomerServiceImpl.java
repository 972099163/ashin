package com.ashin.service.service.impl;

import com.ashin.model.entity.EbCustomer;
import com.ashin.model.mapper.EbCustomerMapper;
import com.ashin.service.service.EbCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EbCustomerServiceImpl implements EbCustomerService {

    @Autowired
    private EbCustomerMapper ebCustomerMapper;

    @Override
    public List<EbCustomer> selectAll() {
        return ebCustomerMapper.selectAll();
}

    @Override
    public int deleteBatch(Long[] ids) {
        return ebCustomerMapper.deleteBatch(ids);
    }

    @Override
    public int insert(EbCustomer ebCustomer) {
        return ebCustomerMapper.insert(ebCustomer);
    }
}
