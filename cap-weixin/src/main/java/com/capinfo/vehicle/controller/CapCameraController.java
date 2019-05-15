package com.capinfo.vehicle.controller;

import com.capinfo.entity.CapVehicleInfo;
import com.capinfo.entity.CapWorkOrderRecord;
import com.capinfo.entity.SysUser;
import com.capinfo.service.CapVehicleInfoService;
import com.capinfo.service.CapWorkOrderRecordService;
import com.capinfo.service.FlowMessagePushService;
import com.capinfo.service.SysUserService;
import com.capinfo.vehicle.utilEntity.CarCardInfo;
import com.capinfo.vehicle.utilEntity.VehicleConstant;
import com.capinfo.vehicle.utilEntity.VehicleFlowEntity;
import net.sf.json.JSONObject;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/car")
public class CapCameraController {


    @Autowired
    private CapVehicleInfoService capVehicleInfoService;
    @Autowired
    private CapWorkOrderRecordService capWorkOrderRecordService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private FlowMessagePushService flowMessagePushService;


    /**
     * 获取摄像头中车牌信息的接口
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "getCarCardInfo")
    @ResponseBody
    public String getCarCardInfo(HttpServletRequest request) throws IOException {
        InputStream in=request.getInputStream();
        int size=request.getContentLength();
        String charset= "gb2312";
        CarCardInfo info = getPostData(in,size,charset);
        if (info != null) {
            if (StringUtils.isNotBlank(info.getLicense())) {
                capVehicleInfoService.createVehicleInfo(info.getLicense());
            }
        }
        String jsonStr ="{\"Response\":{\"Open\":1,\"SerialData\":{\"data\":\"/pgAbJdUAAAAAAAAAAAAAQEB/lxLiVkAAAAxAABsuUYAAAAwMDAwMDAwMDEsAQT/MDEwMTAxOTkxMjMxEwAAAFWqAAA3MjIxMTEAAAgAEAABEQASAAAAu7bTrbniwdn/AAEAAQABAGd8//+BbII=\",\"datalen\":148}}}";
        return jsonStr;
    }


    /**
     * 模拟摄像头捕捉。测试一下
     * @param request
     * @return
     */
    @RequestMapping(value = "testGetCarCardInfo")
    @ResponseBody
    public String testGetCarCardInfo(HttpServletRequest request) {
        capVehicleInfoService.createVehicleInfo("京A·TE012");
        String jsonStr ="{\"Response\":{\"Open\":1,\"SerialData\":{\"data\":\"/pgAbJdUAAAAAAAAAAAAAQEB/lxLiVkAAAAxAABsuUYAAAAwMDAwMDAwMDEsAQT/MDEwMTAxOTkxMjMxEwAAAFWqAAA3MjIxMTEAAAgAEAABEQASAAAAu7bTrbniwdn/AAEAAQABAGd8//+BbII=\",\"datalen\":148}}}";
        return jsonStr;
    }


    /**
     * 外观检测通过后的摄像头接口
     * @param request
     * @return
     */
    @RequestMapping(value = "checkAppearInfo")
    @ResponseBody
    public String checkAppearInfo(HttpServletRequest request) throws IOException {

        InputStream in=request.getInputStream();
        int size=request.getContentLength();
        String charset = "gb2312";
        CarCardInfo carInfo = getPostData(in,size,charset);
        if (carInfo != null) {
            //capVehicleInfoService.createVehicleInfo(info.getLicense());
           /* CapVehicleInfo vehicleInfo = new CapVehicleInfo();
            vehicleInfo.setPlateNo(carInfo.getLicense());
            List<CapVehicleInfo> list = capVehicleInfoService.selectListByCondition(vehicleInfo);*/
           CapWorkOrderRecord record = new CapWorkOrderRecord();
           record.setPlateNo(carInfo.getLicense());
           record.setNowLink(VehicleConstant.PROCESS_ENTER);
            List<CapWorkOrderRecord> list = capWorkOrderRecordService.selectListByCondition(record);
            if (list.size()>0) {
                capVehicleInfoService.startFlowByCamera(carInfo.getLicense());
            } else {
                //判断一下有没有在其他步骤的数据。
                // 如果没有就去创建，如果有，那么可能是某一步没有通过进入车检厂复检的情况，这种情况不去创建，这种情况直接发送给对应步骤的用户消息
                capVehicleInfoService.createVehicleInfo(carInfo.getLicense());
                capVehicleInfoService.startFlowByCamera(carInfo.getLicense());
            }

        }
        String jsonStr ="{\"Response\":{\"Open\":1,\"SerialData\":{\"data\":\"/pgAbJdUAAAAAAAAAAAAAQEB/lxLiVkAAAAxAABsuUYAAAAwMDAwMDAwMDEsAQT/MDEwMTAxOTkxMjMxEwAAAFWqAAA3MjIxMTEAAAgAEAABEQASAAAAu7bTrbniwdn/AAEAAQABAGd8//+BbII=\",\"datalen\":148}}}";
        return jsonStr;
    }




    /**
     * 模拟测试一下   外观检测完成后的摄像头捕捉
     * 在这里把信息加到消息队列里
     * 把数据开始流程
     * @param request
     * @return
     */
    @RequestMapping(value = "testCheckAppear")
    @ResponseBody
    public String testCheckAppear(HttpServletRequest request) {

        /*CapVehicleInfo vehicleInfo = new CapVehicleInfo();
        vehicleInfo.setPlateNo("京A-TE123");
        List<CapVehicleInfo> list = capVehicleInfoService.selectListByCondition(vehicleInfo);*/
        CapWorkOrderRecord record = new CapWorkOrderRecord();
        record.setPlateNo("京A·TE012");
        record.setNowLink(VehicleConstant.PROCESS_ENTER);
        List<CapWorkOrderRecord> list = capWorkOrderRecordService.selectListByCondition(record);
        if (list.size()>0) {
            capVehicleInfoService.startFlowByCamera("京A·TE012");
        } else {
            capVehicleInfoService.createVehicleInfo("京A·TE012");
            capVehicleInfoService.startFlowByCamera("京A·TE012");
        }
        String jsonStr ="{\"Response\":{\"Open\":1,\"SerialData\":{\"data\":\"/pgAbJdUAAAAAAAAAAAAAQEB/lxLiVkAAAAxAABsuUYAAAAwMDAwMDAwMDEsAQT/MDEwMTAxOTkxMjMxEwAAAFWqAAA3MjIxMTEAAAgAEAABEQASAAAAu7bTrbniwdn/AAEAAQABAGd8//+BbII=\",\"datalen\":148}}}";
        return jsonStr;
    }






    /**
     * 获取数据
     * @param in
     * @param size
     * @param charset
     * @return
     */
    public static CarCardInfo getPostData(InputStream in, int size, String charset) {
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

                if ((charset == null || charset.length() == 0))
                {
                    //m_savetxt.m_fwrite(buf,"D:/newfile.txt");
                    //show_json(new String(buf));
                    if (size ==readCount) {
                        CarCardInfo info = getJson(new String(buf));
                        return info;
                    }

                } else {
                    /*if (size ==readCount) {
                        CarCardInfo info = getJson(new String(buf, charset));
                        return info;
                    }*/
                    CarCardInfo info = getJson(new String(buf, charset));
                    return info;
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
    public static CarCardInfo getJson(String m_str) {
        try {
            CarCardInfo info = new CarCardInfo();
            //获取设备名称
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
            //String imageFile=Json.getJSONObject("AlarmInfoPlate").getJSONObject("result").getJSONObject("PlateResult").getString("imageFile");
            //int imageFileLen=Json.getJSONObject("AlarmInfoPlate").getJSONObject("result").getJSONObject("PlateResult").getInt("imageFileLen");
        /*if(imageFileLen!=0)
            m_savetxt.m_fwrite(m_decode(imageFile),"D:/imageFile.gif");*/

            //获取并保存识别结果小图
            //String imageFragmentFile=Json.getJSONObject("AlarmInfoPlate").getJSONObject("result").getJSONObject("PlateResult").getString("imageFragmentFile");
            //int imageFragmentFileLen=Json.getJSONObject("AlarmInfoPlate").getJSONObject("result").getJSONObject("PlateResult").getInt("imageFragmentFileLen");
        /*if(imageFragmentFileLen!=0)
            m_savetxt.m_fwrite(m_decode(imageFragmentFile),"D:/imageFragmentFile.gif");*/

            //车牌颜色
            String platecolor = Json.getJSONObject("AlarmInfoPlate").getJSONObject("result").getJSONObject("PlateResult").getString("platecolor");
            System.out.println(platecolor);
            //识别时间
            String recotime = Json.getJSONObject("AlarmInfoPlate").getJSONObject("result").getJSONObject("PlateResult").getString("recotime");
            String parkId = Json.getJSONObject("AlarmInfoPlate").getString("ParkID");

            info.setIpaddr(ipaddr);
            info.setLicense(license);
            info.setPlatecolor(platecolor);
            info.setRecotime(recotime);
            info.setParkId(parkId);

            return info;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }

}
