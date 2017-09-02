package com.xmall.controller.portal;

import com.github.pagehelper.PageInfo;
import com.xmall.common.ServerResponse;
import com.xmall.pojo.Product;
import com.xmall.service.IProductService;
import com.xmall.vo.ProductDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 72703 on 2017/8/5.
 */
@Controller
@RequestMapping("/product/")
public class ProductController {

    @Autowired
    IProductService iProductService;

    @RequestMapping("detail.do")
    @ResponseBody
    public ServerResponse<ProductDetailVo> getProductDetail(Integer productId){
        return iProductService.getProductDetails(productId);
    }

    @RequestMapping("list.do")
    @ResponseBody
    public ServerResponse<PageInfo> list(@RequestParam(value = "categoryId",required = false) Integer categoryId,
                                         @RequestParam(value = "keyword",required = false) String keyword,
                                         @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                         @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                                         @RequestParam(value = "orderBy",defaultValue = "") String orderBy){
        return iProductService.getProductByKeywordCategory(categoryId,keyword,pageNum,pageSize,orderBy);
    }
}
