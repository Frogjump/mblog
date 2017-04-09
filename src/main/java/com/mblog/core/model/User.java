package com.mblog.core.model;

import com.jfinal.plugin.activerecord.Model;

/**
 * @Author Ocoder
 * @Date 2017/4/8
 */
public class User extends Model<User> {
    public static final User dao = new User().dao();
}
