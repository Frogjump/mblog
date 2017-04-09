package com.mblog.web.controller.admin;

import com.jfinal.core.Controller;
import com.mblog.core.model.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/7.
 */
public class LoginController extends Controller{

    public void index(){
        render("index.vm");
    }

    /**
     * 处理登录请求
     */
    public void login(){
        String method = getRequest().getMethod();
        if ("GET".equalsIgnoreCase(method)){
            render("login.vm");
        }else if ("POST".equalsIgnoreCase(method)){
            String username = getPara("username");
            String pwd = getPara("password");
            Map<String, String> ret = new HashMap<String, String>();
            User user = User.dao.findFirst("select * from mto_users where username = ?", username);
            if (user == null){
                ret.put("code", "10");
                ret.put("message", "用户名不存在");
                renderJson(ret);
            }else {
                if (pwd.equals(user.getStr("password"))){
                    ret.put("code", "20");
                    ret.put("message", "验证成功");
                }else {
                    ret.put("code", "30");
                    ret.put("message", "密码错误");
                }
            }
            renderJson(ret);
        }
    }

    public void forgot(){}

}
