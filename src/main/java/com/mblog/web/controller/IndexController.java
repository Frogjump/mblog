package com.mblog.web.controller;

import com.jfinal.core.Controller;

/**
 * @Author Ocoder
 * @Date 2017/4/8
 */
public class IndexController extends Controller {

    public void index(){
        render("index.vm");
    }
}
