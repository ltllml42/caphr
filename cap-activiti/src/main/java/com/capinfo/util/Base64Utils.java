package com.capinfo.util;

import cn.hutool.core.codec.Base64;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by user on 2018/7/12.
 */
@Slf4j
public class Base64Utils {

    public static String ioToBase64(InputStream in) throws IOException {
        String strBase64 = null;
        try {
            byte[] bytes = new byte[in.available()];
            // 将文件中的内容读入到数组中
            in.read(bytes);
            strBase64 = Base64.encode(bytes);      //将字节流数组转换为字符串
            in.close();
        } catch (IOException ioe) {
            log.debug("图片转64编码异常",ioe);
        }
        return strBase64;
    }
}
