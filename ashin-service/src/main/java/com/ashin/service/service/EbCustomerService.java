package com.ashin.service.service;

import com.ashin.model.entity.EbCustomer;

import java.util.List;

public interface EbCustomerService {
    public List<EbCustomer> selectAll();
    public int deleteBatch(Long[] ids);
    public int insert(EbCustomer ebCustomer);
}
