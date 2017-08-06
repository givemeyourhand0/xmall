package com.xmall.controller.portal;

import com.xmall.common.Const;
import com.xmall.common.ResponseCode;
import com.xmall.common.ServerResponse;
import com.xmall.pojo.User;
import com.xmall.service.ICartService;
import com.xmall.vo.CartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by 72703 on 2017/8/5.
 * 购物车提供的功能有：列出所有商品，添加商品，删除商品，更新购物车，
 * 选择/不选择，全选/全不选
 * 获得购物车商品数量
 */
@Controller
@RequestMapping("/cart/")
public class CartController {

    @Autowired
    ICartService iCartService;

    @RequestMapping("list.do")
    @ResponseBody
    public ServerResponse<CartVo> list(HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCartService.
    }
}
