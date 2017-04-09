package com.mblog.core.config;

import com.jfinal.config.*;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;
import com.mblog.core.handler.BaseHandler;
import com.mblog.core.model.User;
import com.mblog.web.route.MainRoute;

/**
 * Created by Administrator on 2017/4/7.
 */
public class MainConfig extends JFinalConfig{

    public void configConstant(Constants constants) {
        PropKit.use("jdbc.properties");
        constants.setDevMode(true);
        constants.setViewType(ViewType.VELOCITY);
        constants.setError500View("/error/500.html");
        constants.setError404View("/error/404.html");
        constants.setError403View("/error/403.html");
        constants.setError401View("/error/reject.html");
    }

    public void configRoute(Routes routes) {
        routes.add(new MainRoute());
    }

    public void configEngine(Engine engine) {

    }

    public void configPlugin(Plugins plugins) {
        DruidPlugin dp = new DruidPlugin(PropKit.get("jdbcUrl"),PropKit.get("username"),PropKit.get("password"));
        plugins.add(dp);

        ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
        plugins.add(arp);
        arp.addMapping("mto_users", User.class);
    }

    public void configInterceptor(Interceptors interceptors) {

    }

    public void configHandler(Handlers handlers) {
        handlers.add(new BaseHandler());
    }
}
