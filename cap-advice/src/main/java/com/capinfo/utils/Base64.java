package com.capinfo.utils;


import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;

public class Base64 {  
    // 加密  
    public static String getBase64(String str) {  
        byte[] b = null;  
        String s = null;  
        try {  
            b = str.getBytes("utf-8");  
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
        }  
        if (b != null) {  
            s = new BASE64Encoder().encode(b);  
        }  
        return s;  
    }  
  
    // 解密  
    public static String getFromBase64(String s) {  
        byte[] b = null;  
        String result = null;  
        if (s != null) {  
            BASE64Decoder decoder = new BASE64Decoder();  
            try {  
                b = decoder.decodeBuffer(s);  
                result = new String(b, "utf-8");  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
        return result;  
    }  
    
    /**
     * 图片base64码解密放到指定路径下
     * @param base64
     * @param path
     * @param imgName
     */
	public static void Base64ToImage(String base64, String path,  
            String imgName) {  
        BASE64Decoder decoder = new BASE64Decoder();  
        try {  
            FileOutputStream os = new FileOutputStream(new File(path));  
            byte[] decoderBytes = decoder.decodeBuffer(base64);  
            os.write(decoderBytes);  
            os.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    } 
	
	
	public static File base64ToFile(String base64) {
		   String imgPath = "";
		   if("\\".equals(File.separator)){
			   imgPath = "D:\\base64";
		   }else{
			   imgPath = "/base64";
		   }
		   BASE64Decoder d = new BASE64Decoder();  
		   FileOutputStream os = null;
		   	File file = null;
	       byte[] bs;
			try {
				bs = d.decodeBuffer(base64);
				os = new FileOutputStream(new File(imgPath));  
		        os.write(bs);  
		        file = new File(imgPath);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
	           try {
	               if (os!= null) {
	                   os.close();
	               }
	           } catch (IOException e) {
	               e.printStackTrace();
	           }
	       } 
	       return file;
	   }
	
	/**
	 * 把本地图片转成base64字符串
	 * @param imgPath
	 * @return
	 */
    public static String GetImageStrFromPath(String imgPath) {  
        InputStream in = null;  
        byte[] data = null;  
        // 读取图片字节数组  
        try {  
            in = new FileInputStream(imgPath);  
            data = new byte[in.available()];  
            in.read(data);  
            in.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        // 对字节数组Base64编码  
        BASE64Encoder encoder = new BASE64Encoder();  
        // 返回Base64编码过的字节数组字符串  
        return encoder.encode(data);  
    } 
	
    
}  