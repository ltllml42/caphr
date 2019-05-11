package com.capinfo.vehicle.controller;

import com.capinfo.entity.CapVehicleInfo;
import com.capinfo.service.CapVehicleInfoService;
import com.capinfo.service.CapWorkOrderRecordService;
import com.capinfo.vehicle.utilEntity.CarCardInfo;
import net.sf.json.JSONObject;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller
@RequestMapping(value = "/car")
public class CapCameraController {


    @Autowired
    private CapVehicleInfoService capVehicleInfoService;
    @Autowired
    private CapWorkOrderRecordService capWorkOrderRecordService;
    @Autowired
    private RuntimeService runtimeService;


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
        String charset=null;
        CarCardInfo info = getPostData(in,size,charset);

        CapVehicleInfo vehicleInfo = new CapVehicleInfo();
        vehicleInfo.setPlateNo(info.getLicense());
        List<CapVehicleInfo> list = capVehicleInfoService.selectListByCondition(vehicleInfo);
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            String nowLink = list.get(i).getCapWorkOrderRecord().getNowLink();
            String procInstId = list.get(i).getCapWorkOrderRecord().getProcInstId();
            ProcessInstance instance = runtimeService.createProcessInstanceQuery()
                    .processInstanceId(procInstId).singleResult();
            if (instance != null || !"7".equals(nowLink)) {
                count++;
            }
        }
        //可能需要判断一下是哪一步的摄像头。如果第进入车检厂的这个摄像头，那么这样判断。如果是外观检测的摄像头
        // ip地址摄像头id应该不一样，如果都用这个方法那么再做判断
        if (count == 0) {
            //这个时候添数据到数据库里
            CapVehicleInfo capVehicleInfo = new CapVehicleInfo();
            capVehicleInfo.setPlateNo(info.getLicense());

            capVehicleInfo = capVehicleInfoService.save(capVehicleInfo);
            //在这要再加一条record表的数据
            capWorkOrderRecordService.saveRecordByVehicleInfo(capVehicleInfo);
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

                if ((charset == null || charset.length() == 0) && (size ==readCount))
                {
                    //m_savetxt.m_fwrite(buf,"D:/newfile.txt");
                    //show_json(new String(buf));
                    CarCardInfo info = getJson(new String(buf));
                    System.out.println("车辆信息：车牌号-"+info.getLicense()+ "=====车牌颜色-" + info.getPlatecolor() + "====识别时间-" + info.getRecotime());
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


    }





}
