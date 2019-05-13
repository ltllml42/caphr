package test;

import com.capinfo.Application;
import com.capinfo.entity.CapVehicleSpendtime;
import com.capinfo.service.CapWorkOrderRecordService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class VehicleTest {

    @Autowired
    private CapWorkOrderRecordService capWorkOrderRecordService;


    @Test
    public void testDuration() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        CapVehicleSpendtime spendtime = new CapVehicleSpendtime();
        spendtime.setStartTime(new Date());
        spendtime.setEndTime(new Date());
        capWorkOrderRecordService.countDuration(spendtime);
        System.out.println("开始时间："+sdf.format(spendtime.getStartTime())+"====结束时间："+sdf.format(spendtime.getEndTime()));
        System.out.println("耗时:"+spendtime.getDuration()+" s");


    }


}
