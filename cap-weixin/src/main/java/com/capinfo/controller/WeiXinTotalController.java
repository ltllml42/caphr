package com.capinfo.controller;

import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/wx/message/")
public class WeiXinTotalController {


    @GetMapping("fail")
    public String fail(){
        //失败
        return "/weixin/fail";
    }


    @GetMapping("njType")
    @ResponseBody
    public String aic(){
        String temp = "[\n" +
                "    {\n" +
                "      \"title\": \"营运载客汽车\",\n" +
                "      \"value\": \"1\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"载货汽车和大型、中型非营运载客汽车\",\n" +
                "      \"value\": \"2\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"小型、微型非营运载客汽车\",\n" +
                "      \"value\": \"3\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"摩托车\",\n" +
                "      \"value\": \"4\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"拖拉机和其他机动车\",\n" +
                "      \"value\": \"5\"\n" +
                "    }\n" +
                "]";

        return temp;
    }



    @GetMapping("sex")
    @ResponseBody
    public String sex(){
        String temp = "[\n" +
                "    {\n" +
                "      \"title\": \"男\",\n" +
                "      \"value\": \"1\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"女\",\n" +
                "      \"value\": \"2\"\n" +
                "    }\n" +
                "]";

        return temp;
    }


}
