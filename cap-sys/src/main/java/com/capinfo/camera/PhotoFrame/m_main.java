package com.capinfo.camera.PhotoFrame;

import java.awt.Dialog;
import java.awt.event.*;
import java.util.Arrays;

import javax.swing.JDialog;

import java.awt.event.ItemListener;

import com.capinfo.camera.com.eparking.api.WTY_EX;
import com.capinfo.camera.com.eparking.callback.IOnConnectStatus;
import com.capinfo.camera.com.eparking.callback.IOnGetDataEx2;
import com.capinfo.camera.com.eparking.callback.IOnJpegCallback;
import com.capinfo.camera.com.eparking.data.PlateResult_Ex;
import com.eparking.data.CLIENT_LPRC_DeviceInfo.ByReference;
import com.eparking.data.CLIENT_LPRC_DeviceInfo.ByValue;
import com.sun.jna.WString;

import java.util.Calendar;


public class m_main
{
	//JPGE每帧长度
	public final static int max_jpg_len = 200000 - 312;    // jpeg高清可能会大于此大小
	//识别结果全景图图片长度
	public final static int max_image_len=818888;
	//识别结果车牌图片长度
	public final static int max_plate_len=10000;
	public static byte[] byteA = new byte[max_jpg_len];  // jpeg流 camera 1
	public static byte[] byteB = new byte[max_jpg_len];  // jpeg流 camera 2
	public static byte[] resbyte=new byte[max_plate_len];  // plate 1
	public static byte[] resbyte2=new byte[max_plate_len];  // plate 2
	private static byte bzero = 0;

	private static String ip1;   // 相机1 ip
	private static String ip2;   // 相机2 ip
	public static boolean nRunning1 = false;  // 相机1运行开关
	public static boolean nRunning2 = false;  // 相机2运行开关
	static PhotoFrame.myFrame dialog = new PhotoFrame.myFrame();                     			//对话框
	public static IOnJpegCallback jpegStream = new OnJpegStream();		//jpeg回调函数
	public static IOnConnectStatus connStatus = new OnConnectStatus();	//连接状态的回调函数
	public static IOnGetDataEx2 getData2=new OnGetDataEx2();			//识别结果的回调函数
	public static com.eparking.data.CLIENT_LPRC_DeviceInfo[] dev_info=(com.eparking.data.CLIENT_LPRC_DeviceInfo[])new com.eparking.data.CLIENT_LPRC_DeviceInfo().toArray(255);//搜索设备的设备信息
	public static int SearchNum=0;										//搜索到设备的数量
	//jpeg回调函数
	public static class OnJpegStream implements IOnJpegCallback
	{

		public void callback(com.eparking.data.DevData_info.ByReference JpegInfo, long dwUser) {
			long m_user=dwUser&0x00FFFFFFF;
			//System.out.println("初始化成功，IP=" + dwUser+" JpegInfo.nStatus="+JpegInfo.nStatus+"     "+m_user);
			if(m_user==666)
			{
				if(JpegInfo.nStatus==0)
				{
					int nLen = 0;
					if ((JpegInfo.nLen > 0) && (JpegInfo.pchBuf != null)) {
						if (JpegInfo.nLen > max_jpg_len)
						{
							nLen = max_jpg_len;
						}
						else
						{
							nLen = JpegInfo.nLen;
						}
						Arrays.fill(byteA, bzero);
						System.arraycopy(JpegInfo.pchBuf.getByteArray(0,
								JpegInfo.nLen), 0, byteA, 0, nLen);

						// 控件显示动态图像
						if (dialog != null && dialog.panel != null) {
							dialog.jpegShow(dialog.panel, byteA, 1);
						}
					}
				}
			}


			if(m_user==777)
			{
				if(JpegInfo.nStatus==0)
				{
					if ((JpegInfo.nLen > 0) && (JpegInfo.pchBuf != null)) {
						int nLen = 0;
						if (JpegInfo.nLen > max_jpg_len)
						{
							nLen = max_jpg_len;
						}
						else
						{
							nLen = JpegInfo.nLen;
						}
						Arrays.fill(byteB, bzero);
						System.arraycopy(JpegInfo.pchBuf.getByteArray(0,
								JpegInfo.nLen), 0, byteB, 0, nLen);

						// 控件显示动态图像
						if (dialog != null && dialog.panel_1 != null) {
							dialog.jpegShow(dialog.panel_1, byteB, 1);
						}
					}
				}
			}
		}
	}

	//连接状态的回调函数
	public static class OnConnectStatus implements IOnConnectStatus
	{
		public void callback(String chWTYIP, int nStatus,long dwUser)
		{
			// 设备的连接状态
			if (nStatus != 1) {
				dialog.listModel.add(0, chWTYIP+"连接断开！");
				dialog.listinfo.setSelectedIndex(0);
			}
		}
	}


	//识别结果的回调函数
	public static class OnGetDataEx2 implements IOnGetDataEx2
	{
		public void callback(PlateResult_Ex.ByReference plateResult, long dwUser)
		{
			long m_user=dwUser&0x00FFFFFFF;
			if(m_user==666)
			{
				if((plateResult.pPlateImage.nLen > 0) && (plateResult.pPlateImage.pBuffer != null))
				{
					dialog.editorPane_3.setText(new String(plateResult.chLicense));
					Arrays.fill(resbyte, bzero);
					dialog.listinfo.setSelectedIndex(0);
					System.arraycopy(plateResult.pPlateImage.pBuffer.getByteArray(0,
							plateResult.pPlateImage.nLen), 0, resbyte, 0, plateResult.pPlateImage.nLen);
					// 控件显示动态图像
					if (dialog != null && dialog.panel_2 != null) {
						dialog.jpegShow(dialog.panel_2, resbyte, 2);
					}
				}
				else
				{
					dialog.editorPane_3.setText("\u65E0\u8F66\u724C");
				}
			}

			if(m_user==777)
			{
				if((plateResult.pPlateImage.nLen > 0) && (plateResult.pPlateImage.pBuffer != null))
				{
					dialog.editorPane_6.setText(new String(plateResult.chLicense));
					Arrays.fill(resbyte2, bzero);
					System.arraycopy(plateResult.pPlateImage.pBuffer.getByteArray(0,
							plateResult.pPlateImage.nLen), 0, resbyte2, 0, plateResult.pPlateImage.nLen);
					// 控件显示动态图像
					if (dialog != null && dialog.panel_3 != null) {
						dialog.jpegShow(dialog.panel_3, resbyte2, 2);
					}
				}
				else
				{
					dialog.editorPane_6.setText("\u65E0\u8F66\u724C");
				}
			}
		}
	}


	//初始化
	public void Dev_Init() {
		int m_err1=1;
		int m_err2=1;
		ip1=dialog.editorPane.getText();
		ip2=dialog.editorPane_1.getText();
		try {

			//注册jpeg回调函数 （可选）
			WTY_EX.INSTANCE.CLIENT_LPRC_RegJpegEvent(jpegStream);
			//注册连接状态的回调函数（必选）
			WTY_EX.INSTANCE.CLIENT_LPRC_RegCLIENTConnEvent(connStatus);
			//注册识别结果的回调函数（必选）
			WTY_EX.INSTANCE.CLIENT_LPRC_RegDataEx2Event(getData2);
			if(nRunning1==false)
			{//连接设备1
				m_err1=WTY_EX.INSTANCE.CLIENT_LPRC_InitSDK(8080, null, 0, ip1, 666);
			}
			if(nRunning2==false)
			{//连接设备2
				m_err2=WTY_EX.INSTANCE.CLIENT_LPRC_InitSDK(8080, null, 0, ip2, 777);
			}

			if (m_err1 == 0) {

				dialog.listModel.add(0, ip1+"初始化成功！");
				dialog.listinfo.setSelectedIndex(0);
				nRunning1  = true;
			} else {
				dialog.listModel.add(0, ip1+"初始化失败！");
				dialog.listinfo.setSelectedIndex(0);

			}

			if (m_err2 == 0) {
				dialog.listModel.add(0, ip2+"初始化成功！");
				dialog.listinfo.setSelectedIndex(0);
				nRunning2  = true;
			} else {
				dialog.listModel.add(0, ip2+"初始化失败！");
				dialog.listinfo.setSelectedIndex(0);
			}

		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	//抬杆命令
	public void Dev_SetRelayClose()
	{
		if(nRunning1==true)
		{
			if(WTY_EX.INSTANCE.CLIENT_LPRC_SetRelayClose(ip1,9110)==0)
			{
				dialog.listModel.add(0, ip1+"抬杆成功(继电器闭合)！");
				dialog.listinfo.setSelectedIndex(0);
			}
			else
			{
				dialog.listModel.add(0, ip1+"抬杆失败(继电器闭合)！");
				dialog.listinfo.setSelectedIndex(0);
			}

		}
		if(nRunning2==true)
		{
			if(WTY_EX.INSTANCE.CLIENT_LPRC_SetRelayClose(ip2,9110)==0)
			{
				dialog.listModel.add(0, ip2+"抬杆成功(继电器闭合)！");
				dialog.listinfo.setSelectedIndex(0);
			}
			else
			{
				dialog.listModel.add(0, ip2+"抬杆失败(继电器闭合)！");
				dialog.listinfo.setSelectedIndex(0);
			}
		}
	}


	//断开连接
	public void Dev_Close()
	{
		WTY_EX.INSTANCE.CLIENT_LPRC_QuitSDK();
		nRunning1=false;
		dialog.listModel.add(0, ip1+"断开成功！");
		dialog.listinfo.setSelectedIndex(0);
		nRunning2=false;
		dialog.listModel.add(0, ip2+"断开成功！");
		dialog.listinfo.setSelectedIndex(0);


//		if(nRunning1==true)
//		{
//			if(WTY_EX.INSTANCE.CLIENT_LPRC_QuitDevice(ip1)==0)
//			{
//				nRunning1=false;
//				dialog.listModel.add(0, ip1+"断开成功！");
//				dialog.listinfo.setSelectedIndex(0);
//			}
//			else
//			{
//				dialog.listModel.add(0, ip1+"断开失败！");
//				dialog.listinfo.setSelectedIndex(0);
//			}
//		}
//		if(nRunning2==true)
//		{
//			if(WTY_EX.INSTANCE.CLIENT_LPRC_QuitDevice(ip2)==0)
//			{
//				nRunning2=false;
//				dialog.listModel.add(0, ip2+"断开成功！");
//				dialog.listinfo.setSelectedIndex(0);
//			}
//			else
//			{
//				dialog.listModel.add(0, ip2+"断开失败！");
//				dialog.listinfo.setSelectedIndex(0);
//			}
//		}
	}



	//模拟触发
	public void Dev_SetTrigger()
	{
		if(nRunning1==true)
		{
			if(WTY_EX.INSTANCE.CLIENT_LPRC_SetTrigger(ip1, 8080)==0)
			{
				dialog.listModel.add(0, ip1+"模拟触发成功！");
				dialog.listinfo.setSelectedIndex(0);
			}
			else
			{
				dialog.listModel.add(0, ip1+"模拟触发失败！");
				dialog.listinfo.setSelectedIndex(0);
			}
		}
		if(nRunning2==true)
		{
			if(WTY_EX.INSTANCE.CLIENT_LPRC_SetTrigger(ip2, 8080)==0)
			{
				dialog.listModel.add(0, ip2+"模拟触发成功！");
				dialog.listinfo.setSelectedIndex(0);
			}
			else
			{
				dialog.listModel.add(0, ip2+"模拟触发失败！");
				dialog.listinfo.setSelectedIndex(0);
			}
		}
	}


	//发送抓拍命令
	public void Dev_SnapJpegFrame()
	{
		if(nRunning1==true)
		{
			String path = System.getProperty("user.dir") + "\\camera1.jpg";
			if(WTY_EX.INSTANCE.CLIENT_LPRC_SnapJpegFrame(ip1,path,null,0)==0)
			{

				dialog.listModel.add(0, ip1+"抓拍成功！保存为："+path);
				dialog.listinfo.setSelectedIndex(0);
			}
			else
			{
				dialog.listModel.add(0, ip1+"抓拍成功失败！");
				dialog.listinfo.setSelectedIndex(0);
			}
		}
		if(nRunning2==true)
		{
			String path = System.getProperty("user.dir") + "\\camera2.jpg";
			if(WTY_EX.INSTANCE.CLIENT_LPRC_SnapJpegFrame(ip2,path,null,0)==0)
			{

				dialog.listModel.add(0, ip2+"抓拍成功！保存为："+path);
				dialog.listinfo.setSelectedIndex(0);
			}
			else
			{
				dialog.listModel.add(0, ip2+"抓拍成功失败！");
				dialog.listinfo.setSelectedIndex(0);
			}
		}
	}

	//发送RS485
	public void	Dev_RS485Send()
	{
		ip1=dialog.editorPane.getText();
		ip2=dialog.editorPane_1.getText();
		byte[] b1 ={(byte) 0xA5,(byte) 0x00,0x04,0x3F,0x3B,0X5A};
		if(WTY_EX.INSTANCE.CLIENT_LPRC_RS485Send(ip1, 9110, b1, 7)==0)
		{
			dialog.listModel.add(0, ip1+"发送485命令成功!");
			dialog.listinfo.setSelectedIndex(0);
		}
		else
		{
			dialog.listModel.add(0, ip1+"发送485命令失败!");
			dialog.listinfo.setSelectedIndex(0);
		}
		if(WTY_EX.INSTANCE.CLIENT_LPRC_RS485Send(ip2, 9110, b1, 7)==0)
		{
			dialog.listModel.add(0, ip2+"发送485命令成功!");
			dialog.listinfo.setSelectedIndex(0);
		}
		else
		{
			dialog.listModel.add(0, ip2+"发送485命令失败!");
			dialog.listinfo.setSelectedIndex(0);
		}
	}


	public void Dev_SearchDeviceList()
	{
		int a=0;
		SearchNum=WTY_EX.INSTANCE.CLIENT_LPRC_SearchDeviceList(dev_info);
		if(SearchNum>0)
		{
			dialog.listModel.add(0, "搜索成功，数量为 :"+SearchNum);
			dialog.listinfo.setSelectedIndex(0);
			for(int n=0;n<SearchNum;n++)
			{
				a=n+1;
				String strPlateIp = new String(dev_info[n].chIp).trim();
				dialog.listModel.add(0, "设备编号"+a+"    ip地址为:"+strPlateIp);
				dialog.listinfo.setSelectedIndex(0);
			}
		}
		else if (SearchNum == 0)
		{
			dialog.listModel.add(0, "没有搜索到相机！");
			dialog.listinfo.setSelectedIndex(0);
		}
		else
		{
			dialog.listModel.add(0, "搜索失败！");
			dialog.listinfo.setSelectedIndex(0);
		}
	}


	//修改IP地址
//	public void Dev_ModifyIP()
//	{
//		try {
//		    int DevNum = Integer.parseInt(dialog.editorPane_2.getText());
//			if(DevNum>SearchNum)
//			{
//
//				System.out.println("参数接受错误,devnum非法，需要前搜索设备");
//
//			}
//			else
//			{
//				CLIENT_LPRC_DeviceInfo.ByValue m_dev_info=new CLIENT_LPRC_DeviceInfo.ByValue();
//				String dev_ip_old=new String(dev_info[DevNum-1].chIp);
//				Arrays.fill(m_dev_info.chIp, bzero);
//				Arrays.fill(m_dev_info.chGateway, bzero);
//				Arrays.fill(m_dev_info.chMac, bzero);
//				Arrays.fill(m_dev_info.chNetmask, bzero);
//				System.arraycopy(dialog.editorPane_5.getText().getBytes(),0,m_dev_info.chIp,0,dialog.editorPane_5.getText().getBytes().length);
//				System.arraycopy(dev_info[DevNum-1].chGateway,0,m_dev_info.chGateway,0,dev_info[DevNum-1].chGateway.length);
//				System.arraycopy(dev_info[DevNum-1].chMac,0,m_dev_info.chMac,0,dev_info[DevNum-1].chMac.length);
//				System.arraycopy(dev_info[DevNum-1].chNetmask,0,m_dev_info.chNetmask,0,dev_info[DevNum-1].chNetmask.length);
//				System.out.println("准备修改：预设修改内容： 设备编号为"+DevNum+"    待修改设备的原ip地址"+dev_ip_old+"    将要修改ip地址为:"+new String(m_dev_info.chIp));
//				if(WTY_EX.INSTANCE.CLIENT_LPRC_AlterDeviceInfo(dev_ip_old,m_dev_info)==0)
//				{
//					System.out.println("修改成功");
//					if(nRunning1==true)
//					{
//						WTY_EX.INSTANCE.CLIENT_LPRC_QuitDevice(ip1);
//						nRunning1=false;
//					}
//					if(nRunning2==true)
//					{
//						WTY_EX.INSTANCE.CLIENT_LPRC_QuitDevice(ip2);
//						nRunning2=false;
//					}
//				}
//				else
//				{
//					System.out.println("修改失败");
//				}
//			}
//		} catch (NumberFormatException e) {
//			System.out.println("参数接受错误,devnum非法，需要前搜索设备");
//		}
//
//	}


	//修改时间
	public void Dev_time()
	{
//		com.eparking.data.CameraTime.ByReference dev_camertime = (com.eparking.data.CameraTime.ByReference)new com.eparking.data.CameraTime.ByReference();
//		//CameraTime dev_camertime = null;
//		Calendar c = Calendar.getInstance();
//		dev_camertime.Year = c.get(Calendar.YEAR);
//		dev_camertime.Month = c.get(Calendar.MONTH)+1;
//		dev_camertime.Day = c.get(Calendar.DATE);
//		dev_camertime.Hour = c.get(Calendar.HOUR_OF_DAY);
//		dev_camertime.Minute = c.get(Calendar.MINUTE);
//		dev_camertime.Second = c.get(Calendar.SECOND);
//		dev_camertime.Millisecond=0;
//		if(nRunning1==true)
//		{
//
//			if(WTY_EX.INSTANCE.CLIENT_LPRC_SetDevTimeParam(ip1,dev_camertime)==0)
//			{
//				System.out.println("更新成功,时间为:"+dev_camertime.Year + "/" + dev_camertime.Month + "/" + dev_camertime.Day + " " +dev_camertime.Hour + ":" +dev_camertime.Minute + ":" + dev_camertime.Second);
//			}
//			else
//			{
//				System.out.println("更新失败");
//			}
//		}

	}


	//JPGE开关
//	public void Dev_JPGEOpen()
//	{
//		if(nRunning1==true)
//		{
//			if(dialog.rdbtnNewRadioButton.isSelected()==true)
//			{
//				if(WTY_EX.INSTANCE.CLIENT_LPRC_SetJpegStreamPlayOrStop(ip1, 1)==0)
//				{
//					System.out.println("设备1 jpeg流开启");
//				}
//
//			}
//			else
//			{
//				if(WTY_EX.INSTANCE.CLIENT_LPRC_SetJpegStreamPlayOrStop(ip1, 0)==0)
//				{
//					System.out.println("设备1 jpeg流关闭");
//				}
//			}
//		}
//		if(nRunning2==true)
//		{
//			if(dialog.rdbtnNewRadioButton.isSelected()==true)
//			{
//				if(WTY_EX.INSTANCE.CLIENT_LPRC_SetJpegStreamPlayOrStop(ip2, 1)==0)
//				{
//					System.out.println("设备2 jpeg流开启");
//				}
//			}
//			else
//			{
//				if(WTY_EX.INSTANCE.CLIENT_LPRC_SetJpegStreamPlayOrStop(ip2, 0)==0)
//				{
//					System.out.println("设备2 jpeg流关闭");
//				}
//			}
//		}
//	}



	public static void main(String[] args) {
		try {

//			String s = System.getProperty("user.dir");
//			System.out.println(s);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			//dialog.rdbtnNewRadioButton.setSelected(true);
			final m_main wintone = new m_main();
			dialog.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					if(nRunning1==true)
					{
						WTY_EX.INSTANCE.CLIENT_LPRC_QuitDevice(ip1);
						nRunning1=false;
					}
					if(nRunning2==true)
					{
						WTY_EX.INSTANCE.CLIENT_LPRC_QuitDevice(ip2);
						nRunning2=false;
					}
				}
			});
			//连接按钮
			dialog.btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					wintone.Dev_Init();
				}
			});
			//发送抬杆命令
			dialog.btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					wintone.Dev_SetRelayClose();
				}
			});

			//断开连接
			dialog.btnNewButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					wintone.Dev_Close();
				}
			});


			//发送抓拍命令
			dialog.btnNewButton_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					wintone.Dev_SnapJpegFrame();
				}
			});
			//发送485命令
			dialog.btnNewButton_5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					wintone.Dev_RS485Send();
				}
			});
			//搜索相机
			dialog.button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					wintone.Dev_SearchDeviceList();
				}
			});
			//修改IP地址
//			dialog.btnip.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					wintone.Dev_ModifyIP();
//
//				}
//			});
			//更新时间
			dialog.button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					wintone.Dev_time();
				}
			});

			//JPGE开关
//			dialog.rdbtnNewRadioButton.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent arg0) {
//					wintone.Dev_JPGEOpen();
//				}
//			});

			//模拟触发
			dialog.btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					wintone.Dev_SetTrigger();
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

}
