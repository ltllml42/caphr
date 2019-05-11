package com.eparking.data;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
public class Image_Info extends Structure  {

	public static class ByReference extends Image_Info implements Structure.ByReference {}
	public static class ByValue extends Image_Info implements Structure.ByValue {}
	public int				nWidth;							/* 宽度					*/
	public int				nHeight;						/* 高度					*/
	public int				nPitch;							/* 图像宽度的一行像素所占内存字节数*/
	public int				nLen;							/* 图像的长度			*/
	public byte[] reserved = new byte[16];			/* 预留     			*/
	public Pointer pBuffer;
}
