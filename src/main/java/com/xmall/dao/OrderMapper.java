package com.xmall.dao;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.xmall.pojo.Order;
import com.xmall.vo.OrderVo;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    Order selectByUserIdAndOrderNo(Integer userId,Long orderNo);

    List<Order> selectByUserId(Integer userId);

    List<Order> selectAllOrder();

    Order selectByOrderNo(Long orderNo);

}