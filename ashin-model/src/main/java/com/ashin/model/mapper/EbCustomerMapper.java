package com.ashin.model.mapper;

import com.ashin.model.entity.EbCustomer;
import java.util.List;

public interface EbCustomerMapper {
    int insert(EbCustomer record);
    int deleteBatch(Long[] ids);
    List<EbCustomer> selectAll();
}