package com.mc.wechat.vo;

import com.mc.wechat.vo.menu.Menu;

import java.util.List;

public interface MenuApi {
    /**
     * 创建菜单地址
     */
    String create_menu = "/menu/create?access_token=";
    /**
     * 创建菜单地址
     */
    String query_menu = "/menu/get?access_token=";
    /**
     * 创建菜单地址
     */
    String del_menu = "/menu/delete?access_token=";

    List<Menu> getMenu();

    boolean createMenu(List<Menu> menus);

    boolean delMenu();
}
