package com.mblog.web.route;

import com.jfinal.config.Routes;
import com.mblog.web.controller.LoginController;

/**
 * Created by Administrator on 2017/4/7.
 */
public class MainRoute extends Routes {
    public void config() {
        setBaseViewPath("/WEB-INF/themes/");
        add("/admin", LoginController.class, "/default");
    }
}
