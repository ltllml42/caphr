package com.capinfo.handler;

import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutNewsMessage;
import me.chanjar.weixin.mp.builder.outxml.TextBuilder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static me.chanjar.weixin.common.api.WxConsts.MenuButtonType;

/**
 *
 *
 * 暂无图片地址 https://hbimg.huabanimg.com/bdaca9a07e1a8947c00c2f826ebf848750927aa24963-cATwbg_fw658
 * @author Binary Wang(https://github.com/binarywang)
 */
@Component
public class MenuHandler extends AbstractHandler {

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService weixinService,
                                    WxSessionManager sessionManager) {
        System.out.println("我来到MenuHandler了");
        String msg = String.format("type:%s, event:%s, key:%s",
            wxMessage.getMsgType(), wxMessage.getEvent(),
            wxMessage.getEventKey());
        if (MenuButtonType.VIEW.equalsIgnoreCase(wxMessage.getEvent())) {
            return null;
        }
        if(MenuButtonType.CLICK.equalsIgnoreCase(wxMessage.getEvent())){

            switch (wxMessage.getEventKey()){
                case "YUYUEDH" :
                    String message = "工作时间：周一至周六\n" +
                            "上午：8:00—12:00\n" +
                            "下午：13:00—17:00\n" +
                            "法定节假日休息\n" +
                            "预约电话：010-80519721";

                    return WxMpXmlOutMessage.TEXT().content(message)
                            .fromUser(wxMessage.getToUser()).toUser(wxMessage.getFromUser())
                            .build();
                case "NJCL":
                    break;
                case "FriendshipTipsKey":
                    break;
                case "workTimeKey":
                    String mess = "工作时间：周一至周六\n" +
                            "上午：8:00—12:00\n" +
                            "下午：13:00—17:00\n" +
                            "法定节假日休息\n" +
                            "预约电话：010-80519721";

                    return WxMpXmlOutMessage.TEXT().content(mess)
                            .fromUser(wxMessage.getToUser()).toUser(wxMessage.getFromUser())
                            .build();
                default:
                    return null;

            }






        }

        return WxMpXmlOutMessage.TEXT().content(msg)
            .fromUser(wxMessage.getToUser()).toUser(wxMessage.getFromUser())
            .build();
    }

}
