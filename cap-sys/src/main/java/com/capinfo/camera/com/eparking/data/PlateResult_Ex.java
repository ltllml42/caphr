package com.capinfo.camera.com.eparking.data;
import com.sun.jna.Structure;
public class PlateResult_Ex extends Structure  {
	public static class ByReference extends PlateResult_Ex implements Structure.ByReference {}
	public static class ByValue extends PlateResult_Ex implements Structure.ByValue {}
	public byte[] chWTYIP = new byte[16]; 				// 相机IP
	public byte[] chColor = new byte[8]; 				// 车牌颜色
	public byte[] chLicense = new byte[16]; 			// 车牌号码
	public com.eparking.data.PlateLocation.ByValue pcLocation; 			// 车牌在图像中的坐标
	public com.eparking.data.CameraTime.ByValue shootTime; 				// 识别出车牌的时间
	public int					nConfidence;						/* 车牌可信度			*/
	public int					nTime;								/* 识别耗时				*/
	public int					nDirection;							/* 车牌方向		    	*/
	public byte[] reserved = new byte[256]; 					/* 预留     			*/
	public com.eparking.data.Image_Info.ByValue		pFullImage;						/* 全景图像数据(注意：相机不传输，此处指针为空) */
	public com.eparking.data.Image_Info.ByValue		pPlateImage;						/* 车牌图像数据(注意：相机不传输，此处指针为空) */
}
