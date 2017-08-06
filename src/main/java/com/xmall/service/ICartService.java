package com.xmall.service;

import com.xmall.common.ServerResponse;
import com.xmall.controller.portal.CartController;
import com.xmall.vo.CartVo;

/**
 * Created by 72703 on 2017/8/5.
 */
public interface ICartService {
    ServerResponse<CartVo> list(Integer userId);
}
