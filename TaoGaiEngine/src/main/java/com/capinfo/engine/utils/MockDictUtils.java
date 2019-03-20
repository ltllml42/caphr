package com.capinfo.engine.utils;

import com.capinfo.engine.data.DictBean;

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


}
