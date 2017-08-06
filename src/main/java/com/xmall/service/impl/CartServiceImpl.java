package com.xmall.service.impl;

import com.xmall.common.ServerResponse;
import com.xmall.service.ICartService;
import com.xmall.vo.CartVo;
import org.springframework.stereotype.Service;

/**
 * Created by 72703 on 2017/8/5.
 */
@Service("iCartService")
public class CartServiceImpl implements ICartService {
    @Override
    public ServerResponse<CartVo> list(Integer userId) {
        CartVo cartVo = this
        return null;
    }
}
