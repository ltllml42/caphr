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

    /**
     * 根据传入的nowlink车检步骤，得到对应的能查看这一步数据的角色id
     * @param nowLink
     * @return
     */
    public static String getRoleIdByNowLink(String nowLink) {
        String roleId = "";
        if (VehicleConstant.PROCESS_APPEAR.equals(nowLink)) {
            roleId = VehicleConstant.ROLEID_APPEAR;
        } else if (VehicleConstant.PROCESS_GAS.equals(nowLink)) {
            roleId = VehicleConstant.ROLEID_GAS;
        } else if (VehicleConstant.PROCESS_ONLINE.equals(nowLink)) {
            roleId = VehicleConstant.ROLEID_ONLINE;
        } else if (VehicleConstant.PORCESS_LIGHT.equals(nowLink)) {
            roleId = VehicleConstant.ROLEID_LIGHT;
        }
        return roleId;
    }

    /**
     * 根据传入的角色id判断对应的应该显示哪一步的数据
     * @param roleId
     * @return
     */
    public static String getNowLinkByRoleId(String roleId) {
        String nowLink = "";
        switch (roleId) {
            case VehicleConstant.ROLEID_APPEAR:
                nowLink = VehicleConstant.PROCESS_APPEAR;
                break;
            case VehicleConstant.ROLEID_GAS:
                nowLink = VehicleConstant.PROCESS_GAS;
                break;
            case VehicleConstant.ROLEID_ONLINE:
                nowLink = VehicleConstant.PROCESS_ONLINE;
                break;
            case VehicleConstant.ROLEID_LIGHT:
                nowLink = VehicleConstant.PORCESS_LIGHT;
                break;
            /*case VehicleConstant.ROLEID_PAY:
                nowLink = VehicleConstant.PROCESS_PAY;
                break;*/
            default:
                nowLink = "0";
                break;
        }
        return nowLink;
    }



}
