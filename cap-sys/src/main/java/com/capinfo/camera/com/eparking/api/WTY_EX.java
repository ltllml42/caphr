package com.capinfo.camera.com.eparking.api;

import com.capinfo.camera.com.eparking.callback.IOnConnectStatus;
import com.capinfo.camera.com.eparking.callback.IOnGetDataEx2;
import com.capinfo.camera.com.eparking.callback.IOnJpegCallback;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.win32.StdCallLibrary;

public interface WTY_EX extends StdCallLibrary
{
	public static String strFilePath = System.getProperty("user.dir") + "\\..\\..\\DLL开发包\\windows\\64bit\\WTY.dll";

	public static WTY_EX INSTANCE = (WTY_EX)Native.loadLibrary(strFilePath, WTY_EX.class);
	/************************************************************************/
	/* CLIENT_LPRC_InitSDK: 连接相机
	/*		Parameters:
	/*			nPort[in]:		连接相机的端口，现默认为8080
	/*			hWndHandle[in]:	接收消息的窗体句柄，当为NULL时，表示无窗体
	/*			uMsg[in]:		用户自定义消息，当hWndHandle不为NULL时，
	/*							检测到有新的车牌识别结果并准备好当前车牌
	/*							缓冲区信息后，用::PostMessage 给窗口
	/*							hWndHandle发送uMsg消息，其中WPARAM参数为0，
	/*							LPARAM参数为0
	/*			chServerIP[in]:	相机的IP地址
	/*          dwUser[in]:     用户自定义字段，主要用来回传给回调函数。
	/*		Return Value:   int
	/*							0	相机连接成功
	/*							1	相机连接失败
	/*		Notice:
	/*				如果采用回调的方式获取数据时，hWndHandle句柄为NULL，
	/*				uMsg为0，并且注册回调函数，通知有新的数据；
	/*				反之，在主窗口收到消息时，调用CLIENT_LPRC_GetVehicleInfoEx获取
	/*				数据。													    */
	/************************************************************************/
	public int CLIENT_LPRC_InitSDK(int nPort, Void hWndHandle, int uMsg,String chServerIP,long dwUser);

	/*
	 * 断开所有已经连接WTY，释放资源
	 */
	public void CLIENT_LPRC_QuitSDK();

	/************************************************************************/
	/* 触发识别
	/* @param pCameraIP
	/*            相机IP
	/* @param nPort
	/*            连接相机的端口，现默认为8080
	/*
	/* @return 0 成功， 非0 失败                                               										*/
	/************************************************************************/
	public int CLIENT_LPRC_SetTrigger(String pCameraIP, int nCameraPort);



	/************************************************************************/
	/* 1：连接状态回调函数的注册，必须在连接设备函数(WTY_InitSDK)之前 调用。 2：此方式是被动获取PC 与设备之间的连接状态
	/*
	/* @param obj
	/*            回调接口														*/
	/************************************************************************/
	public void CLIENT_LPRC_RegCLIENTConnEvent(IOnConnectStatus obj);


	/************************************************************************/
	/* 1: 一台PC 连接多台设备时，此函数仅需实现一次。当区分不同设备的识别结 果时，可以通过输出参数中recResult 中的chWTYIP
	/* 来区分。
	/*
	/* @param recResult
	/*            可为NULL
	/* @param obj
	/*            回调类，类名、方法名必须与Demo中的保持一致，否则会注册失败。					*/
	/************************************************************************/
	public void CLIENT_LPRC_RegDataEx2Event(IOnGetDataEx2 odj);

	/************************************************************************/
	/* 1: 注册获取Jpeg流的回调函数
	/*
	/* @param obj
	/*            1:此功能目前适用于V6.0.0.0版本,
	/* 				V5.1.2.0、V5.2.1.0、V5.2.2.0不能使用此功能						*/
	/************************************************************************/
	public void CLIENT_LPRC_RegJpegEvent(IOnJpegCallback obj);


	/************************************************************************/
	/* 	函数: 根据IP地址，断开指定设备链接
	/*		Parameters:
	/*			pCameraIP[in]:			相机IP地址
	/*		Return Value:   int
	/*							0	获取成功
	/*							1	获取失败									*/
	/************************************************************************/
	public int CLIENT_LPRC_QuitDevice(String pCameraIP);


	/************************************************************************/
	/* 函数说明: 控制继电器的闭合
	/*		Parameters:
	/*			pCameraIP[in]:			相机IP
	/*			nCameraPort[in]:		端口,默认9110
	/*		Return Value:   int
	/*							0	设置成功
	/*						  非0	失败
	/*		Notice:
	/*				通过此功能，可以在PC端通过一体机设备，来控制道闸的抬起
	/*				设备继电器输出信号为：开关量信号。									*/
	/************************************************************************/
	public int CLIENT_LPRC_SetRelayClose(String pCameraIP, int nCameraPort);


	/*************************************************************************/
	/*CLIENT_LPRC_SnapJpegFrame 快速抓拍一帧，两种保存方式，直接保存到固定目录或者保存到特定内存,要是保存特定内存模式需要传入内存最大值,两种方式可选
	/*		Parameters:
	/*			chIp[in]		   相机的IP地址
	/*			pSaveFileName[in]  路径和带JPEG后缀名的文件名，用于把当前抓拍到的帧保存为特定文件  默认先匹配文件名
	/*          pSaveBuf[in]       用于保存当前帧在特定内存的,并且需要传输内存可存储的最大值，当文件名为空的时候这个才会生效。
	/*          Maxlen[in]         保存当前帧特定内存的最大值*/
	/*		Return Value:   int
	/*						   0	保存到特定目录成功
	/*                         >0   保存到特定内存的数据的实际大小
	/*						  -1	失败										*/
	/************************************************************************/
	public int CLIENT_LPRC_SnapJpegFrame(String pCameraIP,String pSaveFileName,String pSaveBuf,int Maxlen);



	/************************************************************************/
	/* CLIENT_LPRC_RS485Send: RS485透明传输
	/*		Parameters:
	/*			pCameraIP[in]				相机设备IP地址
	/*			nPort[in]					端口,默认9110
	/*			chData[in]					将要传输的数据块的首地址
	/*			nSendLen[in]				将要传输的数据块的字节数
	/*		Return Value:   int
	/*							0	成功
	/*						  非0	失败
	/*		notice：
	/*				1：用户通过此接口，往相机发送数据，相机设备会原样将数据
	/*				通过RS485接口转发出去，到客户所接的外部设备上。
	/*				2：使用此功能前，需要在演示DEMO的设置界面上，设置相机不
	/*				能传输识别结果(默认S485传输识别结果)。								*/
	/************************************************************************/
	public int CLIENT_LPRC_RS485Send(String pCameraIP,int nCameraPort,byte[] b1,int nSendLen);


	/************************************************************************/
	/* CLIENT_LPRC_SearchDeviceList:    搜索设备IP列表
	/*		Parameters:
	/*		pBuf[out]			存储搜索到的相机列表信息结构体数组
	/*		Return Value:   	int
	/*							大于0	成功搜索到的设备数
	/*						  	-1	失败										*/
	/************************************************************************/
	public int CLIENT_LPRC_SearchDeviceList(com.eparking.data.CLIENT_LPRC_DeviceInfo[] dev_info);



/************************************************************************/
/* CLIENT_LPRC_AlterDeviceInfo:    修改指定的设备的设备信息
/*		Parameters:
/*		pCameraIP[in]		需要修改的相机设备的ip地址
/*		pBuf[out]			存储需要修改的设备信息结构体
/*		Return Value:   	int
/*							==0	成功
/*						  	非0	失败										*/
	/************************************************************************/
//int __stdcall CLIENT_LPRC_AlterDeviceInfo(char *pCameraIP,CLIENT_LPRC_DeviceInfo pBuf);
	public int 	CLIENT_LPRC_AlterDeviceInfo(String pCameraIP, com.eparking.data.CLIENT_LPRC_DeviceInfo.ByValue pBuf);







/************************************************************************/
/* CLIENT_LPRC_SetDevTimeParam:    修改设备系统时间
/*		Parameters:
/*		pCameraIP[in]		需要修改的相机设备的ip地址
/*		sysTime[in]			设置时间结构体		*/
/*		Return Value:   	int
/*							==0	成功
/*						  	非0	失败										*/
	/************************************************************************/
//int __stdcall CLIENT_LPRC_SetDevTimeParam(char *pCameraIP, CLIENT_LPRC_CAMERA_TIME *sysTime);
	public int CLIENT_LPRC_SetDevTimeParam(String pCameraIP, com.eparking.data.CameraTime.ByReference sysTime);





/************************************************************************/
/* CLIENT_LPRC_SetJpegStreamPlayOrStop: 设置jpeg流的开关
/*		Parameters:
/*		pCameraIP[in]		需要设置的相机设备的ip地址
/*		onoff[in]			jpeg流开关项，0表示关闭流，1表示打开流
/*		Return Value:   	int
/*							0	成功
/*						  	非0	失败										*/
	/************************************************************************/
//int __stdcall CLIENT_LPRC_SetJpegStreamPlayOrStop(char *pCameraIP,int onoff);
	public int CLIENT_LPRC_SetJpegStreamPlayOrStop(String pCameraIP,int onoff);






}
