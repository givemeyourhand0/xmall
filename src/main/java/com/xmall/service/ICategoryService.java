package com.xmall.service;

import com.xmall.common.ServerResponse;
import com.xmall.pojo.Category;

import java.util.List;

/**
 * Created by 72703 on 2017/8/4.
 */
public interface ICategoryService {
    ServerResponse<String> addCategory(String categoryName, Integer parentId);

    ServerResponse<String> setCategoryName(Integer categoryId, String categoryNameNew);

    ServerResponse<List<Category>> getChildrenParallelCategoryByParentId(Integer categoryId);

    ServerResponse<List<Integer>> getCategoryAndChildrenCategoryById(Integer categoryId);
}
