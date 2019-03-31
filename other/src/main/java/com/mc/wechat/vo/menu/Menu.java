package com.mc.wechat.vo.menu;

import com.mc.EventType;
import lombok.Data;
import org.nutz.json.JsonField;

import java.util.List;

/**
 * @ClassName Menu
 * @Author ZhengRongZe
 * @Date 2019/3/11 13:29
 **/
@Data
public class Menu {
    /**
     * 菜单的响应动作类型，view表示网页类型，click表示点击类型，miniprogram表示小程序类型
     */
    private String type;
    /**
     *菜单标题，不超过16个字节，子菜单不超过60个字节
     */
    private String name;
    /**
     * 点击类型菜单KEY值，用于消息接口推送，不超过128字节
     */
    private String key;
    /**
     * 网页链接，用户点击菜单可打开链接，不超过256字节
     */
    private String url;
    @JsonField(value = "sub_button")
    private List<Menu> subButtons;
    public Menu() {
    }

    public Menu(String name) {
        this.name = name;
    }

    public Menu(String name, String type, String val) {
        setName(name);
        setType(type);
            if(EventType.view.name().equals(type)){
            setUrl(val);
        }
        else {
            setKey(val);
        }
    }
}
