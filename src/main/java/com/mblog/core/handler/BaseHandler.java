package com.mblog.core.handler;


import com.jfinal.handler.Handler;
import com.mblog.Const;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author Ocoder
 * @Date 2017/4/7
 *
 */
public class BaseHandler extends Handler{

    public void handle(String target, HttpServletRequest request, HttpServletResponse response, boolean[] isHandled) {
        String webRoot = request.getContextPath();
        request.setAttribute(Const.WEBROOT, webRoot);
        request.setAttribute(Const.VIEWROOT_NAME, Const.VIEWROOT_PATH);
        if (target.endsWith("admin") || target.endsWith("admin/"))
            target += "/index";
        if (target.contains("/admin") && filterUrl(target)){
            String username = (String) request.getSession(true).getAttribute(Const.LOGINNAME);
            if (username == null || username.equals("")){
                target = webRoot + Const.ADMIN_LOGIN;
                try {
                    response.sendRedirect(Const.ADMIN_LOGIN);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        next.handle(target, request, response, isHandled);
    }

    private boolean filterUrl(String target){
        boolean ret = true;
        for (String s : Const.EXCLUDED){
            if (target.contains(s)){
                ret = false;
                break;
            }
        }
        return ret;
    }
}
