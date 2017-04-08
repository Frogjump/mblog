package com.mblog.web.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.GET;
import com.jfinal.ext.interceptor.POST;

/**
 * Created by Administrator on 2017/4/7.
 */
public class LoginController extends Controller{

    public void index(){
        render("index.vm");
    }

    @Before(GET.class)
    public void login(){
        render("login.vm");
    }

    @Before(POST.class)
    public void postlogin(){
        System.out.print(getAttrForStr("username")+"--"+getAttrForStr("password"));
    }
}
