package com.capinfo.engine.utils;

import com.capinfo.engine.data.DictBean;
import com.capinfo.engine.dict.CheckPostConfig;
import com.capinfo.engine.dict.PromoteTimeConfing;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MockDictUtils {

    public static List<DictBean> mockDict(String name){
        List<DictBean> list = new ArrayList<DictBean>();
        DictBean bean1  = new DictBean("1","1","10","15");
        DictBean bean2  = new DictBean("2","1","10","15");
        DictBean bean3  = new DictBean("3","1","10","15");
        DictBean bean4  = new DictBean("4","1","10","15");
        list.add(bean1);
        list.add(bean2);
        list.add(bean3);
        list.add(bean4);

        list.sort(new Comparator<DictBean>(){

            @Override
            public int compare(DictBean o1, DictBean o2) {
                return 0;
            }
        });
        return list;

    }

    /**
     * 5、晋升时间要求
     * @param name
     * @return
     */
    public static List<PromoteTimeConfing> mockDict1(String name){
        List<PromoteTimeConfing> list = new ArrayList<PromoteTimeConfing>();

        PromoteTimeConfing pc1 =
                new PromoteTimeConfing("2x","二级巡视员",
                        "1x","一级巡视员","4","48");
        PromoteTimeConfing pc2 =
                new PromoteTimeConfing("1d","一级调研员",
                        "2x","二级巡视员","4","48");
        PromoteTimeConfing pc3 =
                new PromoteTimeConfing("2d","二级调研员",
                        "1d","一级调研员","3","36");
        PromoteTimeConfing pc4 =
                new PromoteTimeConfing("3d","三级调研员",
                        "2d","二级调研员","2","24");
        PromoteTimeConfing pc5 =
                new PromoteTimeConfing("4d","四级调研员",
                        "3d","三级调研员","2","24");
        PromoteTimeConfing pc6 =
                new PromoteTimeConfing("1z","一级主任科员",
                        "4d","四级调研员","2","24");
        PromoteTimeConfing pc7 =
                new PromoteTimeConfing("2z","二级主任科员",
                        "1z","一级主任科员","2","24");
        PromoteTimeConfing pc8 =
                new PromoteTimeConfing("3z","三级主任科员",
                        "2z","二级主任科员","2","24");
        PromoteTimeConfing pc9 =
                new PromoteTimeConfing("4z","四级主任科员",
                        "3z","三级主任科员","2","24");
        PromoteTimeConfing pc10 =
                new PromoteTimeConfing("1k","一级科员",
                        "4z","四级主任科员","2","24");
        PromoteTimeConfing pc11 =
                new PromoteTimeConfing("2k","二级科员",
                        "1k","一级科员","2","24");


        list.add(pc1);
        list.add(pc2);
        list.add(pc3);
        list.add(pc4);
        list.add(pc5);
        list.add(pc6);
        list.add(pc7);
        list.add(pc8);
        list.add(pc9);
        list.add(pc10);
        list.add(pc11);

//        list.sort(new Comparator<PromoteTimeConfing>(){
//
//            @Override
//            public int compare(PromoteTimeConfing o1, PromoteTimeConfing o2) {
//                return 0;
//            }
//        });
        return list;

    }

    /**
     * 4、年度考核对任职年限的影响
     * @param name
     * @return
     */
    public static List<CheckPostConfig> mockDict2(String name){

        List<CheckPostConfig> list = new ArrayList<CheckPostConfig>();
        CheckPostConfig bean1  = new CheckPostConfig("1","考核优秀","6");
        CheckPostConfig bean2  = new CheckPostConfig("2","考核基本职称","-12");
        list.add(bean1);
        list.add(bean2);

//        list.sort(new Comparator<DictBean>(){
//
//            @Override
//            public int compare(DictBean o1, DictBean o2) {
//                return 0;
//            }
//        });
        return list;

    }


}
