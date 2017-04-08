package com.mblog.core.handler;


import com.jfinal.handler.Handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/4/7.
 */
public class BaseHandler extends Handler{

    public void handle(String target, HttpServletRequest request, HttpServletResponse response, boolean[] isHandled) {
        String webRoot = request.getContextPath();
        request.setAttribute("base", webRoot);
        request.setAttribute("viewRoot", "/WEB-INF/themes");
        if (target.endsWith("admin") || target.endsWith("admin/"))
            target += "/index";
        next.handle(target, request, response, isHandled);
    }
}
