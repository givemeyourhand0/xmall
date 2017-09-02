package com.xmall.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.xmall.common.ServerResponse;
import com.xmall.dao.CategoryMapper;
import com.xmall.pojo.Category;
import com.xmall.service.ICategoryService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by 72703 on 2017/8/4.
 */
@Service("iCategoryService")
public class CategoryServiceImpl implements ICategoryService {

    private Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public ServerResponse addCategory(String categoryName, Integer parentId) {
        if(parentId == null|| StringUtils.isBlank(categoryName)){
            return ServerResponse.createByErrorMessage("参数错误");
        }
        Category category = new Category();
        category.setName(categoryName);
        category.setParentId(parentId);
        category.setStatus(true);

        int rowCount = categoryMapper.insert(category);
        if(rowCount>0){
            return ServerResponse.createBySuccessMessage("添加商品分类成功");
        }
        return ServerResponse.createByErrorMessage("添加商品分类失败");
    }

    @Override
    public ServerResponse<String> setCategoryName(Integer categoryId,String categoryNameNew) {
        if(categoryId == null||StringUtils.isBlank(categoryNameNew)){
            return ServerResponse.createByErrorMessage("参数错误");
        }

        Category category = categoryMapper.selectByPrimaryKey(categoryId);
        if(category == null){
            return ServerResponse.createByErrorMessage("分类不存在");
        }
        category.setName(categoryNameNew);

        int rowCount = categoryMapper.updateByPrimaryKeySelective(category);
        if(rowCount>0){
            return ServerResponse.createBySuccessMessage("修改成功");
        }
        return ServerResponse.createByErrorMessage("修改失败");
    }

    @Override
    public ServerResponse<List<Category>> getChildrenParallelCategoryByParentId(Integer categoryId) {
        if(categoryId == null){
            return ServerResponse.createByErrorMessage("参数错误");
        }
        List<Category> list = categoryMapper.selectChildrenCategoryByParentId(categoryId);
        if(CollectionUtils.isEmpty(list)){
            logger.info("未找到当前分类的子分类");
        }
        return ServerResponse.createBySuccess(list);
    }

    @Override
    public ServerResponse<List<Integer>> getCategoryAndChildrenCategoryById(Integer categoryId) {
        Set<Category> categorySet = Sets.newHashSet();
        findChildrenCategory(categorySet,categoryId);

        List<Integer> categoryIdList = Lists.newArrayList();
        if(categoryId != null){
            for(Category categoryItem:categorySet){
                categoryIdList.add(categoryItem.getId());
            }
        }
        return ServerResponse.createBySuccess(categoryIdList);
    }

    private Set<Category> findChildrenCategory(Set<Category> categorySet,int categoryId){
        Category category = categoryMapper.selectByPrimaryKey(categoryId);
        if(category != null){
            categorySet.add(category);
        }

        List<Category> categoryList = categoryMapper.selectChildrenCategoryByParentId(categoryId);
        for(Category categoryItem:categoryList){
            findChildrenCategory(categorySet,categoryItem.getId());
        }
        return categorySet;
    }

}
