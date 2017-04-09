package com.mblog;

/**
 * Created by Administrator on 2017/4/7.
 */
public class Const {
    public static final String WEBROOT = "base"; //项目根目录
    public static final String VIEWROOT_NAME = "viewRoot"; //视图根目录名称
    public static final String VIEWROOT_PATH = "/WEB-INF/themes"; //视图根目录路径
    public static final String ADMIN_LOGIN = "/admin/login"; //后台登录URL
    public static final String LOGINNAME = "username"; //登录用户名
    public static final String[] EXCLUDED = {"/admin/login","/admin/postlogin"}; //过滤URL

}
