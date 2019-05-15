package com.capinfo.controller;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.bean.menu.WxMenu;
import me.chanjar.weixin.common.bean.menu.WxMenuButton;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.menu.WxMpGetSelfMenuInfoResult;
import me.chanjar.weixin.mp.bean.menu.WxMpMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.net.MalformedURLException;
import java.net.URL;

import static me.chanjar.weixin.common.api.WxConsts.MenuButtonType;

/**
 *  http://litaolin.nat300.top/wx/menu/wx72c8bfbb4f8fc348/create
 *
 * @author Binary Wang(https://github.com/binarywang)
 */
@RestController
@RequestMapping("/wx/menu/{appid}")
public class WxMenuController {
    private WxMpService wxService;

    @Autowired
    public WxMenuController(WxMpService wxService) {
        this.wxService = wxService;
    }

    /**
     * <pre>
     * 自定义菜单创建接口
     * 详情请见：https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421141013&token=&lang=zh_CN
     * 如果要创建个性化菜单，请设置matchrule属性
     * 详情请见：https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1455782296&token=&lang=zh_CN
     * </pre>
     *
     * @return 如果是个性化菜单，则返回menuid，否则返回null
     */
    @PostMapping("/create")
    public String menuCreate(@PathVariable String appid, @RequestBody WxMenu menu) throws WxErrorException {
        return this.wxService.switchover1(appid).getMenuService().menuCreate(menu);
    }

    @GetMapping("/create")
    public String menuCreateSample(@PathVariable String appid) throws WxErrorException, MalformedURLException {
        WxMenu menu = new WxMenu();
        WxMenuButton button1 = new WxMenuButton();
        button1.setName("预约验车");
        WxMenuButton button2 = new WxMenuButton();
        button2.setName("验车须知");
        WxMenuButton button3 = new WxMenuButton();
        button3.setName("我的车辆");
        menu.getButtons().add(button1);
        WxMenuButton button11 = new WxMenuButton();
        button11.setName("预约验车");
        button11.setType(MenuButtonType.VIEW);
        button11.setUrl("http://wapvs.bjjtgl.gov.cn/subscribe-order/");
        WxMenuButton button12 = new WxMenuButton();
        button12.setName("预约电话");
        button12.setType(MenuButtonType.CLICK);
        button12.setKey("YUYUEDH");

        WxMenuButton button13 = new WxMenuButton();
        button13.setName("位置导航");
        button13.setType(MenuButtonType.VIEW);
        button13.setUrl("https://ditu.amap.com/search?id=B0FFJUWLT0&city=110112&geoobj=116.382769%7C39.924715%7C116.401735%7C39.932139&query_type=IDQ&query=%E5%8C%97%E4%BA%AC%E5%85%B4%E9%80%9A%E7%88%B1%E6%B0%91%E6%9C%BA%E5%8A%A8%E8%BD%A6%E6%A3%80%E6%B5%8B%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8&zoom=16.24");

        WxMenuButton button14 = new WxMenuButton();
        button14.setName("年检车辆");
        button14.setType(MenuButtonType.VIEW_LIMITED);
        button14.setMediaId("keqTIS3JHdsfhERPHBbuxa2F5dltkQHIv8mMvaRipoc");

        button1.getSubButtons().add(button11);
        button1.getSubButtons().add(button12);
        button1.getSubButtons().add(button13);
        button1.getSubButtons().add(button14);


        //
        WxMenuButton button24 = new WxMenuButton();
        button24.setName("违章查询");
        button24.setType(MenuButtonType.VIEW);
        button24.setUrl("https://bj.122.gov.cn/views/inquiry.html");
        WxMenuButton button21 = new WxMenuButton();
        button21.setName("车检计算器");
        button21.setType(MenuButtonType.VIEW);
        button21.setUrl("https://gab.122.gov.cn/views/cljy.html");
        WxMenuButton button22 = new WxMenuButton();
        button22.setName("友情提示");
        button22.setType(MenuButtonType.VIEW_LIMITED);
        button22.setMediaId("keqTIS3JHdsfhERPHBbuxeKICPfe17BVhcXwShNwCrk");

        WxMenuButton button23 = new WxMenuButton();
        button23.setName("工作时间");
        button23.setType(MenuButtonType.CLICK);
        button23.setKey("workTimeKey");

        button2.getSubButtons().add(button21);
        button2.getSubButtons().add(button22);
        button2.getSubButtons().add(button23);
        button2.getSubButtons().add(button24);
        menu.getButtons().add(button2);
        WxMenuButton button31 = new WxMenuButton();
        button31.setName("车辆绑定");
        button31.setType(MenuButtonType.VIEW);

        button31.setUrl("http://litaolin.nat300.top/oauth2/wx72c8bfbb4f8fc348/bingingCar");

//        WxMenuButton button33 = new WxMenuButton();
//        button33.setName("年检历史");

        button3.getSubButtons().add(button31);
//        button3.getSubButtons().add(button32);
//        button3.getSubButtons().add(button33);


        menu.getButtons().add(button3);


        this.wxService.switchover(appid);
        String s = this.wxService.getMenuService().menuCreate(menu);
        System.out.println(s);
        return s;
    }

    /**
     * <pre>
     * 自定义菜单创建接口
     * 详情请见： https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421141013&token=&lang=zh_CN
     * 如果要创建个性化菜单，请设置matchrule属性
     * 详情请见：https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1455782296&token=&lang=zh_CN
     * </pre>
     *
     * @return 如果是个性化菜单，则返回menuid，否则返回null
     */
    @PostMapping("/createByJson")
    public String menuCreate(@PathVariable String appid, @RequestBody String json) throws WxErrorException {
        return this.wxService.switchover1(appid).getMenuService().menuCreate(json);
    }

    /**
     * <pre>
     * 自定义菜单删除接口
     * 详情请见: https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421141015&token=&lang=zh_CN
     * </pre>
     */
    @GetMapping("/delete")
    public void menuDelete(@PathVariable String appid) throws WxErrorException {
        this.wxService.switchover1(appid).getMenuService().menuDelete();
    }

    /**
     * <pre>
     * 删除个性化菜单接口
     * 详情请见: https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1455782296&token=&lang=zh_CN
     * </pre>
     *
     * @param menuId 个性化菜单的menuid
     */
    @GetMapping("/delete/{menuId}")
    public void menuDelete(@PathVariable String appid, @PathVariable String menuId) throws WxErrorException {
        this.wxService.switchover1(appid).getMenuService().menuDelete(menuId);
    }

    /**
     * <pre>
     * 自定义菜单查询接口
     * 详情请见： https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421141014&token=&lang=zh_CN
     * </pre>
     */
    @GetMapping("/get")
    public WxMpMenu menuGet(@PathVariable String appid) throws WxErrorException {
        return this.wxService.switchover1(appid).getMenuService().menuGet();
    }

    /**
     * <pre>
     * 测试个性化菜单匹配结果
     * 详情请见: http://mp.weixin.qq.com/wiki/0/c48ccd12b69ae023159b4bfaa7c39c20.html
     * </pre>
     *
     * @param userid 可以是粉丝的OpenID，也可以是粉丝的微信号。
     */
    @GetMapping("/menuTryMatch/{userid}")
    public WxMenu menuTryMatch(@PathVariable String appid, @PathVariable String userid) throws WxErrorException {
        return this.wxService.switchover1(appid).getMenuService().menuTryMatch(userid);
    }

    /**
     * <pre>
     * 获取自定义菜单配置接口
     * 本接口将会提供公众号当前使用的自定义菜单的配置，如果公众号是通过API调用设置的菜单，则返回菜单的开发配置，而如果公众号是在公众平台官网通过网站功能发布菜单，则本接口返回运营者设置的菜单配置。
     * 请注意：
     * 1、第三方平台开发者可以通过本接口，在旗下公众号将业务授权给你后，立即通过本接口检测公众号的自定义菜单配置，并通过接口再次给公众号设置好自动回复规则，以提升公众号运营者的业务体验。
     * 2、本接口与自定义菜单查询接口的不同之处在于，本接口无论公众号的接口是如何设置的，都能查询到接口，而自定义菜单查询接口则仅能查询到使用API设置的菜单配置。
     * 3、认证/未认证的服务号/订阅号，以及接口测试号，均拥有该接口权限。
     * 4、从第三方平台的公众号登录授权机制上来说，该接口从属于消息与菜单权限集。
     * 5、本接口中返回的图片/语音/视频为临时素材（临时素材每次获取都不同，3天内有效，通过素材管理-获取临时素材接口来获取这些素材），本接口返回的图文消息为永久素材素材（通过素材管理-获取永久素材接口来获取这些素材）。
     *  接口调用请求说明:
     * http请求方式: GET（请使用https协议）
     * https://api.weixin.qq.com/cgi-bin/get_current_selfmenu_info?access_token=ACCESS_TOKEN
     * </pre>
     */
    @GetMapping("/getSelfMenuInfo")
    public WxMpGetSelfMenuInfoResult getSelfMenuInfo(@PathVariable String appid) throws WxErrorException {
        return this.wxService.switchover1(appid).getMenuService().getSelfMenuInfo();
    }
}
