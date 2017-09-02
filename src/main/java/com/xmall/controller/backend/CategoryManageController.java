package com.xmall.controller.backend;

import com.xmall.common.Const;
import com.xmall.common.ResponseCode;
import com.xmall.common.ServerResponse;
import com.xmall.pojo.Category;
import com.xmall.pojo.User;
import com.xmall.service.ICategoryService;
import com.xmall.service.IUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by 72703 on 2017/8/4.
 */
@Controller
@RequestMapping(value="/manage/category")
public class CategoryManageController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private ICategoryService iCategoryService;

    @RequestMapping("add_category.do")
    @ResponseBody
    public ServerResponse<String> addCategory(HttpSession session,String categoryName,@RequestParam(value = "parentId",defaultValue = "0") int parentId){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登陆");
        }
        if(iUserService.checkAdminRole(user).isSuccess()){
            ServerResponse response = iCategoryService.addCategory(categoryName,parentId);
            return response;
        }else{
            return ServerResponse.createByErrorMessage("无管理员权限");
        }
    }

    @RequestMapping("get_category.do")
    @ResponseBody
    public ServerResponse<List<Category>> getCategory(HttpSession session, @RequestParam(value = "categoryId" , defaultValue = "0")int categoryId){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登陆");
        }
        if(iUserService.checkAdminRole(user).isSuccess()){
            return iCategoryService.getChildrenParallelCategoryByParentId(categoryId);
        }
        return ServerResponse.createByErrorMessage("无管理员权限");
    }

    @RequestMapping("/set_category_name.do")
    @ResponseBody
    public ServerResponse<String> setCategoryName(HttpSession session, String categoryName, int categoryId){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        //验证用户是否登陆
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登陆");
        }
        //验证用户是否有权限
        if(iUserService.checkAdminRole(user).isSuccess()){
            return iCategoryService.setCategoryName(categoryId,categoryName);
        }
        return ServerResponse.createByErrorMessage("无管理员权限");

    }

    @RequestMapping("/get_deep_category.do")
    @ResponseBody
    public ServerResponse getCategoryAndDeepChildrenCategory(HttpSession session, @RequestParam(value ="category",defaultValue = "0") int categoryId){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登陆");
        }
        if(iUserService.checkAdminRole(user).isSuccess()){
            return iCategoryService.getCategoryAndChildrenCategoryById(categoryId);
        }
        return ServerResponse.createByErrorMessage("无管理员权限");
    }
}
