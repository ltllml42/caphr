package com.capinfo.entity;

import com.capinfo.base.BaseEntity;
import com.capinfo.util.DateUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import java.util.Date;

/**
 *         model.addAttribute("cvInfo", cvInfo);
 *         model.addAttribute("workList",workList);
 *
 *
 *           <option value="${cl.id}" <#if cl.id == declare.customerId>selected = selected"</#if> >${cl.customerName}</option>
 */
@Getter
@Setter
@Table(name = "cap_vehicle_info")
@AllArgsConstructor //生成全参数构造函数
@NoArgsConstructor//生成无参构造函数
@Builder
public class CapVehicleInfo extends BaseEntity {

    public final static String FORMAT_DATE = "yyyy年MM月dd日";
    public final static int PLATENO_LPNCHAR = 0;
    public final static int PLATENO_LPNNUMBER = 1;

    public final static String PLATENO_HERICIUM_ERINACEUS = "@";


    public final static String PLATENO_DIAN = "·";



    @Id
    @GeneratedValue(generator = "JDBC")
    private String id;
    /**
     * 车牌号
     */
    @Column(name = "plate_no")
    private String plateNo;
    /**
     * 车辆类型
     */
    @Column(name = "vehicle_type")
    private String vehicleType;
    /**
     * 车辆属性   中型车  或 小型车    1：小型车   2：中型车
     */
    @Column(name = "vehicle_prop")
    private String vehicleProp;

    @Column(name = "vehicle_kind")
    private String vehicleKind;

    @Column(name = "last_test_time")
    private Date lastTestTime; //最后一次验车时间
    @Transient
    @JsonIgnore
    private String lastTestTimeStr;

    @Column(name = "buy_time")
    private Date buyTime;
    @Transient
    @JsonIgnore
    private String buyTimeStr;

    @Column(name = "openId")
    private String openid;
    @Column(name = "fans_id")
    private String fansId;
    @Transient
    @JsonIgnore
    private String lpnChar;
    @Transient
    @JsonIgnore
    private String lpnNumber;
    @Column(name = "nj_type")
    private String njType;
    @Transient
    private int yearCheckCount;//年检次数

    @Transient
    private CapWorkOrderRecord capWorkOrderRecord;



    public String getLpnChar() {
        return splitPlateNo(PLATENO_LPNCHAR,PLATENO_DIAN);
    }

    private String splitPlateNo(int type,String symbol) {
        if(StringUtils.isNotBlank(plateNo)){
            return plateNo.split(symbol)[type];
        }else{
            return "";
        }

    }

    public String getLpnNumber() {
        return splitPlateNo(PLATENO_LPNNUMBER,PLATENO_DIAN);
    }

    public void setLpnChar(String lpnChar) {
        if(StringUtils.isNotBlank(plateNo)&&plateNo.indexOf(PLATENO_HERICIUM_ERINACEUS)!=-1){
            this.lpnChar = splitPlateNo(PLATENO_LPNCHAR,PLATENO_HERICIUM_ERINACEUS);
        }else{
            this.lpnChar = lpnChar;
        }
    }

    public void setLpnNumber(String lpnNumber) {
        if(StringUtils.isNotBlank(plateNo)&&plateNo.indexOf(PLATENO_HERICIUM_ERINACEUS)!=-1){
            this.lpnChar = splitPlateNo(PLATENO_LPNNUMBER,PLATENO_HERICIUM_ERINACEUS);
        }else{
            this.lpnNumber = lpnNumber;
        }
    }


    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        if(StringUtils.isNotBlank(plateNo)){
            this.plateNo = plateNo.replaceAll(PLATENO_HERICIUM_ERINACEUS,"").replaceAll(" ","");
            setLpnChar("");
            setLpnNumber("");
        }else{
            this.plateNo = plateNo;
        }
    }


    public String getLastTestTimeStr() {
        if(lastTestTime!=null){
            this.lastTestTimeStr= DateUtils.formatDate(lastTestTime);
        }
        return lastTestTimeStr;
    }

    public String getBuyTimeStr() {
        if(buyTime!=null){
            this.buyTimeStr= DateUtils.formatDate(buyTime);
        }
        return buyTimeStr;
    }

    public static void main(String[] args) {
        String temp = "京 A@SB123";
        CapVehicleInfo capVehicleInfo = new CapVehicleInfo();
        capVehicleInfo.setPlateNo(temp);
        System.out.println(capVehicleInfo.getPlateNo());

    }
}