package com.xmall.service;

import com.github.pagehelper.PageInfo;
import com.xmall.common.ServerResponse;
import com.xmall.vo.OrderVo;

/**
 * Created by 72703 on 2017/8/7.
 */
public interface IOrderService {
    ServerResponse createOrder(Integer userId,Integer shippingId);
    ServerResponse cancel(Integer userId,Long orderNo);
    ServerResponse getOrderCartProduct(Integer userId);
    ServerResponse<OrderVo> getOrderDetail(Integer userId,Long orderNo);
    ServerResponse<PageInfo> getOrderList(Integer userId,int pageNum,int pageSize);

    ServerResponse<PageInfo> manageList(int pageNum,int PageSize);
    ServerResponse<OrderVo> manageDetail(Long orderNo);
    ServerResponse<PageInfo> manageSearch(Long orderNo,int pageNum,int oageSize);
    ServerResponse manageSendGoods(Long orderNo);
}
