package com.xmall.service;

import com.github.pagehelper.PageInfo;
import com.xmall.common.ServerResponse;
import com.xmall.pojo.Product;
import com.xmall.vo.ProductDetailVo;
import com.xmall.vo.ProductListVo;

/**
 * Created by 72703 on 2017/8/5.
 */
public interface IProductService {
    ServerResponse saveOrUpdateProduct(Product product);
    ServerResponse setSaleStatus(Integer productId, Integer status);
    ServerResponse<ProductDetailVo> manageProductDetails(Integer productId);
    ServerResponse<PageInfo> getProductList(int pageNum, int pageSize);
    ServerResponse<PageInfo> searchProduct(String productName,Integer productId,int pageNum,int pageSize);
    ServerResponse<ProductDetailVo> getProductDetails(Integer productId);
    ServerResponse<PageInfo> getProductByKeywordCategory(Integer categoryId,String keyword,int pageNum,int pageSize,String orderBy);
}
