import ch.qos.logback.core.net.SyslogOutputStream;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class TestUtils {
    @Test
    public void test1(){

        System.out.println(ObjectUtils.identityToString(1).toString());


        System.out.println(ObjectUtils.allNotNull(""));
        System.out.println(ObjectUtils.allNotNull(new Date()));

        Date d = null;

        System.out.println(ObjectUtils.allNotNull(d));

        System.out.println("=====================");


        System.out.println("litaolin");


    }





    // 想去哪拍就去哪拍
    @Test
    public void test2(){



        List<Map<String,Object>> dataMap = new ArrayList<Map<String,Object>>();


    }



}
