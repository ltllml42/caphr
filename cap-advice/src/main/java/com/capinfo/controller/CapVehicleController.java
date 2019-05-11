package com.capinfo.controller;

import com.alibaba.fastjson.JSONObject;
import com.capinfo.utils.utilEntity.CarCardInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;

@Controller
@RequestMapping(value = "/car")
public class CapVehicleController {



    @RequestMapping(value = "getCarCardInfo")
    @ResponseBody
    public String getCarCardInfo(HttpServletRequest request) throws IOException {

        InputStream in=request.getInputStream();
        int size=request.getContentLength();
        String charset=null;
        getPostData(in,size,charset);

        System.out.println("11111");

        return "";
    }





    /**
     * 获取数据
     * @param in
     * @param size
     * @param charset
     * @return
     */
    public static String getPostData(InputStream in, int size, String charset) {
        if (in != null && size > 0) {
            int readCount = 0; // 已经成功读取的字节的个数
            int nRead = 0;
            byte[] buf = new byte[size];
            try {
                while (readCount < size) {
                    nRead = in.read(buf, readCount, size - readCount);
                    if( nRead == -1) // 到末尾
                    {
                        break;
                    }
                    readCount += nRead;
                    //readCount += in.read(buf, readCount, size - readCount);
                }

                if ((charset == null || charset.length() == 0) && (size ==readCount))
                {
                    //m_savetxt.m_fwrite(buf,"D:/newfile.txt");
                    //show_json(new String(buf));
                    CarCardInfo info = getJson(new String(buf));
                    System.out.println("车辆信息：车牌号-"+info.getLicense()+ "=====车牌颜色-" + info.getPlatecolor() + "====识别时间-" + info.getRecotime());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    /**
     * json解析数据
     * @param
     */
    /*public static void show_json(String m_str) {
        //获取设备名称
        JSONObject jo = JSONObject.parseObject(m_str);

        JSONObject Json = JSONObject.fromObject(m_str);
        String deviceName= Json.getJSONObject("AlarmInfoPlate").getString("deviceName");
        System.out.println(deviceName);

        //设备IP地址
        String ipaddr= Json.getJSONObject("AlarmInfoPlate").getString("ipaddr");
        System.out.println(ipaddr);
        //获取识别车牌号
        String license= Json.getJSONObject("AlarmInfoPlate").getJSONObject("result").getJSONObject("PlateResult").getString("license");
        System.out.println(license);

        //获取并保存识别结果大图
        String imageFile=Json.getJSONObject("AlarmInfoPlate").getJSONObject("result").getJSONObject("PlateResult").getString("imageFile");
        int imageFileLen=Json.getJSONObject("AlarmInfoPlate").getJSONObject("result").getJSONObject("PlateResult").getInt("imageFileLen");
        *//*if(imageFileLen!=0)
            m_savetxt.m_fwrite(m_decode(imageFile),"D:/imageFile.gif");*//*

        //获取并保存识别结果小图
        String imageFragmentFile=Json.getJSONObject("AlarmInfoPlate").getJSONObject("result").getJSONObject("PlateResult").getString("imageFragmentFile");
        int imageFragmentFileLen=Json.getJSONObject("AlarmInfoPlate").getJSONObject("result").getJSONObject("PlateResult").getInt("imageFragmentFileLen");
        *//*if(imageFragmentFileLen!=0)
            m_savetxt.m_fwrite(m_decode(imageFragmentFile),"D:/imageFragmentFile.gif");
*//*
    }*/

    public static CarCardInfo getJson(String str) {
        CarCardInfo info = new CarCardInfo();
        JSONObject json = JSONObject.parseObject(str);
        String deviceName = json.getJSONObject("AlarmInfoPlate").getString("deviceName");
        System.out.println(deviceName);
        //设备IP地址
        String ipaddr= json.getJSONObject("AlarmInfoPlate").getString("ipaddr");
        System.out.println(ipaddr);
        String parkId = json.getJSONObject("AlarmInfoPlate").getString("ParkID");


        //获取识别车牌号
        String license= json.getJSONObject("AlarmInfoPlate").getJSONObject("result").getJSONObject("PlateResult").getString("license");
        System.out.println(license);
        //车牌颜色
        String platecolor = json.getJSONObject("AlarmInfoPlate").getJSONObject("result").getJSONObject("PlateResult").getString("platecolor");
        System.out.println(platecolor);
        //识别时间
        String recotime = json.getJSONObject("AlarmInfoPlate").getJSONObject("result").getJSONObject("PlateResult").getString("recotime");

        info.setIpaddr(ipaddr);
        info.setLicense(license);
        info.setPlatecolor(platecolor);
        info.setRecotime(recotime);
        info.setParkId(parkId);

        return info;
    }



}
