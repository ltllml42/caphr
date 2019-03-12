package com.capinfo.util;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.text.Format;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Test {



    public static void main(String[] args) throws IOException {
        Set set = new HashSet();
        for (int i=0;i<1000;i++){
            //FileUtils.writeStringToFile(new File("D:/111.txt"), getKeyCode(), "UTF-8",true);
            //set.add(getKeyCode());
            System.out.println(getKeyCode());
        }
        System.out.println(set.size());

    }

    /**
     * 生成查询码
     * @return
     */
    private static String getKeyCode() {
        //第一位变化
        int t = new Random().nextInt();
        int v1 = Math.abs(t%5);

        int v2 = Integer.valueOf((System.nanoTime()+"").substring(9))%9999;
        //第六位到八位变化
        Long n1 = new Random().nextLong();
        int v3 = (int) Math.abs(n1%999);
        //增加一个随机数+5位数
        String sum1 = v1+""+v2+v3;
        int zz= Integer.valueOf(sum1)+(Integer.valueOf(sum1)%466175);
        try {
            //Thread.sleep(1);
            String format = String.format("%5s",HexConverter._10_to_N(zz,36).toUpperCase()).replaceAll(" ","0");
            return format;
        }catch (Exception e){
            System.out.println(e);
            //return (HexConverter._10_to_N(zz,36).toUpperCase());
        }
        return "";
    }
}


//  1千万的 8663307
//  2千万   15249729
//  100万  985059
//  10万   99851
//  1万    9996
//    1000 1000