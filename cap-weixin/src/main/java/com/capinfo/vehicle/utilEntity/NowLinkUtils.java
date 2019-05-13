package com.capinfo.vehicle.utilEntity;

public class NowLinkUtils {


    public static String getNowLinkStr(String nowLink) {
        String str = "";
        switch (nowLink) {
            case VehicleConstant.PROCESS_APPEAR:
                str = VehicleProcessEnum.PROCESS_APPEAR.getTypeName();
                break;
            case VehicleConstant.PROCESS_GAS:
                str = VehicleProcessEnum.PROCESS_GAS.getTypeName();
                break;
            case VehicleConstant.PROCESS_ONLINE:
                str = VehicleProcessEnum.PROCESS_ONLINE.getTypeName();
                break;
            case VehicleConstant.PORCESS_LIGHT:
                str = VehicleProcessEnum.PROCESS_LIGHT.getTypeName();
                break;
            case VehicleConstant.PROCESS_PAY:
                str = VehicleProcessEnum.PROCESS_PAY.getTypeName();
        }
        return str;
    }


    public static String getRoleIdByNowLink(String nowLink) {
        String roleId = "";
        if (VehicleConstant.PROCESS_APPEAR.equals(nowLink)) {
            roleId = VehicleConstant.ROLEID_APPEAR;
        } else if (VehicleConstant.PROCESS_GAS.equals(nowLink)) {
            roleId = VehicleConstant.ROLEID_GAS;
        } else if (VehicleConstant.PROCESS_ONLINE.equals(nowLink)) {
            roleId = VehicleConstant.ROLEID_ONLINE;
        } else if (VehicleConstant.PORCESS_LIGHT.equals(nowLink)) {
            roleId = VehicleConstant.PORCESS_LIGHT;
        }
        return roleId;
    }



}
