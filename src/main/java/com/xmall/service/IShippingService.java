package com.xmall.service;

import com.github.pagehelper.PageInfo;
import com.xmall.common.ServerResponse;
import com.xmall.pojo.Shipping;
import org.springframework.stereotype.Service;

/**
 * Created by 72703 on 2017/8/6.
 */
@Service
public interface IShippingService {
    ServerResponse add(Integer userId, Shipping shipping);
    ServerResponse delete(Integer userId, Integer shippingId);
    ServerResponse update(Integer userId, Shipping shipping);
    ServerResponse<Shipping> select(Integer userId,Integer shippingId);
    ServerResponse<PageInfo> list(Integer userId,int pageNum,int pageSize);
}
