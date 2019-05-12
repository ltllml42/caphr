package com.capinfo.entity;

import com.capinfo.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Table(name = "cap_vehicle_info")
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
     * 车辆属性   中型车  或 小型车
     */
    @Column(name = "vehicle_prop")
    private String vehicleProp;

    @Column(name = "vehicle_kind")
    private String vehicleKind;

    @Column(name = "last_test_time")
    private Date lastTestTime;
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
            this.plateNo = plateNo.replaceAll(PLATENO_HERICIUM_ERINACEUS,PLATENO_DIAN).replaceAll(" ","");
            setLpnChar("");
            setLpnNumber("");
        }else{
            this.plateNo = plateNo;
        }

    }

    public static void main(String[] args) {
        String temp = "京 A@SB123";
        CapVehicleInfo capVehicleInfo = new CapVehicleInfo();
        capVehicleInfo.setPlateNo(temp);
        System.out.println(capVehicleInfo.getPlateNo());

    }
}