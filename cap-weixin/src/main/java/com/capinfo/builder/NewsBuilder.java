package com.capinfo.builder;

import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutImageMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutNewsMessage;

import java.util.ArrayList;
import java.util.List;

public class NewsBuilder extends AbstractBuilder{
    public WxMpXmlOutMessage buildNews(List<WxMpXmlOutNewsMessage.Item> articles, WxMpXmlMessage wxMessage, WxMpService service) {
        WxMpXmlOutNewsMessage m = WxMpXmlOutMessage.NEWS().articles(articles)
                .fromUser(wxMessage.getToUser()).toUser(wxMessage.getFromUser())
                .build();
        return m;
    }




    @Override
    public WxMpXmlOutMessage build(String content, WxMpXmlMessage wxMessage, WxMpService service) {
        return null;
    }
}
