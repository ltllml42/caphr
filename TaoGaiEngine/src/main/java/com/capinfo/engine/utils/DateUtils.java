package com.capinfo.engine.utils;

import com.capinfo.engine.utils.entity.DateAddEntity;
import com.capinfo.engine.utils.entity.DateCount;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 工具类
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils{

    private static final String DEFAULT_DATA = "yyyy-MM";

    public static final String YEAR_TYPE = "year";
    public static final String MONTH_TYPE = "month";

    private static String[] parsePatterns = {
            "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};

    /**
     *  得到传入日期到当前日期之间的每年的对应月份。如传入2015-01 得到 2015-01，2016-01，2017-01，,218-01,2019-01
     *  并且，如果类型和添加月份或年份数传入的不为空，则每个算出来的DateCount对象中再算出加上对应年数或对应月数的对象
     * @param dateStr 当前日期
     * @param addYearOrMonth 类型
     * @param addNum 添加的月份或者年份
     * @return
     */
    public static DateAddEntity getAfterAddDate(String dateStr, String addYearOrMonth, String addNum) {
        DateAddEntity entity = new DateAddEntity();
        if(valiDate(dateStr)){
            Date date = null;
                date = getDateFromDateStr(dateStr);
                return getAfterAddDate(date,addYearOrMonth,addNum);
        }else{
            try {
                throw new Exception("传入的格式不正确");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return entity;
    }


    public static DateCount getDateYearAndMonth(Date date) {
        DateCount entity = new DateCount();
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        entity.setYear(instance.get(Calendar.YEAR));
        entity.setMonth(getNowMonth(instance.get(Calendar.MONTH)));
        return entity;
    }


    /**
     *  得到传入日期到当前日期之间的每年的对应月份。如传入2015-01 得到 2015-01，2016-01，2017-01，,218-01,2019-01
     *  并且，如果类型和添加月份或年份数传入的不为空，则每个算出来的DateCount对象中再算出加上对应年数或对应月数的对象
     * @param date 当前日期
     * @param addYearOrMonth 类型
     * @param addNum 添加的月份或者年份
     * @return
     */
    public static DateAddEntity getAfterAddDate(Date date, String addYearOrMonth, String addNum) {
        DateAddEntity entity = new DateAddEntity();
        try {
            //date = sdf.parse(dateStr);
            String year = getYear(date);
            String month = getMonth(date);
            //输入的dateStr    形如2015-01，要得到这个月的对应对象，并算出当时年到当前年的相隔的每一年对应对象
            DateCount dateEntity = new DateCount();
            if (StringUtils.isNotBlank(addYearOrMonth)){
                dateEntity.setAddYearOrMonth(addYearOrMonth);
            }
            if (StringUtils.isNotBlank(addNum)){
                dateEntity.setAddNum(addNum);
            }
            dateEntity.setYear(Integer.parseInt(year));
            dateEntity.setMonth(Integer.parseInt(month));
            dateEntity.setYearMonthDate(date);
            entity = getDateCountList(dateEntity);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return entity;
    }
    public static DateAddEntity getDateDif(Date date, Date date1) {
        DateAddEntity entity = new DateAddEntity();
        try {
            int result = 0;

            Calendar c1 = Calendar.getInstance();
            Calendar c2 = Calendar.getInstance();

            c1.setTime(date);
            c2.setTime(date1);

           result =  getNowMonth(c2.get(Calendar.MONTH)) - (getNowMonth(c1.get(Calendar.MONTH)));


            entity.setMonthNum(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }


    private static int getNowMonth(int i) {
        return i + 1;
    }

    public static DateAddEntity getAfterAddMonth(Date date) {
        return getAfterAddDate(date,MONTH_TYPE,"0");
    }


    public static DateAddEntity getAfterAddYear(Date date) {
        return getAfterAddDate(date,YEAR_TYPE,"0");
    }


    public static int getMonthCount(Date start, Date end) {
        Calendar can = Calendar.getInstance();
        can.setTime(start);
        int count = 0;
        while (can.getTime().before(end)) {
            can.add(Calendar.MONTH, 1);
            count++;
        }
        return count;
    }




    /**
     * 传进来输入的要开始的目标月份
     * @param dateCount
     * @return
     */
    private static DateAddEntity getDateCountList(DateCount dateCount) throws ParseException {
        DateAddEntity entity = new DateAddEntity();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATA);
        String nowDate = sdf.format(date);
        Integer nowYear = Integer.parseInt(getYear(date));
        Integer nowMonth = Integer.parseInt(getMonth(date));
        Date start = dateCount.getYearMonthDate();
        Date end = sdf.parse(nowDate);
        Calendar can = Calendar.getInstance();
        //设置开始时间
        can.setTime(start);
        int monthCount = 0;
        Integer dateCountYear = dateCount.getYear();
        Integer dateCountMonth = dateCount.getMonth();
        List<DateCount> list = new ArrayList<DateCount>();
        while (can.getTime().before(end)) {
            //未到结束月份
            //Integer year = Integer.parseInt(getYear(can.getTime()));
            Integer month = Integer.parseInt(getMonth(can.getTime()));
            //if (year!=dateCountYear && month==dateCountMonth) {
            if (month==dateCountMonth) {
                DateCount dateEntity = getDateCountEntity(can);
                if (StringUtils.isNotBlank(dateCount.getAddYearOrMonth()) && StringUtils.isNotBlank(dateCount.getAddNum())) {
                    //传入的增加年增加月标识和增加数量不为空的时候
                    DateCount dateCountAfterAdd = getDateCountAfterAdd(dateEntity, dateCount.getAddYearOrMonth(), dateCount.getAddNum());
                    dateEntity.setAfterAddDateCount(dateCountAfterAdd);
                }
                list.add(dateEntity);
            }
            //月份+1
            can.add(Calendar.MONTH, 1);
            monthCount++;
        }
        if (dateCountMonth>nowMonth) {
            DateCount dateEntity = new DateCount();
            dateEntity.setYear(nowYear);
            dateEntity.setMonth(nowMonth);
            dateEntity.setYearMonthDate(sdf.parse(nowYear+"-"+nowMonth));
            DateCount dateCountAfterAdd = getDateCountAfterAdd(dateEntity, dateCount.getAddYearOrMonth(), dateCount.getAddNum());
            dateEntity.setAfterAddDateCount(dateCountAfterAdd);
            list.add(dateEntity);
        }
        entity.setDateCountList(list);
        entity.setDateCountNum(list.size());
        //while循环条件是这样的。can.getTime().before(end)。所以最后一个月要再+1
        entity.setMonthNum(getNowMonth(monthCount));
        return entity;
    }
    /**
     * 得到加几个月或几年之后的DateCount对象
     * @param dateCount
     * @param type
     * @param addNum
     * @return
     * @throws ParseException
     */
    private static DateCount getDateCountAfterAdd(DateCount dateCount, String type, String addNum) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATA);
        DateCount dateEntity = new DateCount();
        Calendar can = Calendar.getInstance();
        can.setTime(dateCount.getYearMonthDate());
        if (YEAR_TYPE.equals(type) || "2".equals(type)) {
            if (Integer.parseInt(addNum) != 0) {
                switch (type) {
                    case YEAR_TYPE:
                        can.add(Calendar.YEAR, Integer.parseInt(addNum));
                        dateEntity = getDateCountEntity(can);
                        return dateEntity;
                    case MONTH_TYPE:
                        can.add(Calendar.MONTH, Integer.parseInt(addNum));
                        dateEntity = getDateCountEntity(can);
                        return dateEntity;
                }
            }
        }
        return null;
    }

    /**
     * Calendar方法加了几个月或几年时候得到新的DateCount对象
     * @param can
     * @return
     */
    private static DateCount getDateCountEntity(Calendar can) {
        DateCount dateEntity = new DateCount();
        Integer year = Integer.parseInt(getYear(can.getTime()));
        Integer month = Integer.parseInt(getMonth(can.getTime()));
        dateEntity.setYear(year);
        dateEntity.setMonth(month);
        dateEntity.setYearMonthDate(can.getTime());
        return dateEntity;
    }



    /**
     * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String formatDate(Date date, Object... pattern) {
        String formatDate = null;
        if (pattern != null && pattern.length > 0) {
            formatDate = DateFormatUtils.format(date, pattern[0].toString());
        } else {
            formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
        }
        return formatDate;
    }



    /**
     * 得到传入日期的年份字符串 格式（yyyy）
     */
    public static String getYear(Date date) {
        return formatDate(date, "yyyy");
    }

    /**
     * 得到传入日期的月份字符串 格式（MM）
     */
    public static String getMonth(Date date) {
        return formatDate(date, "MM");
    }


    public static String getDate(String pattern) {
        return DateFormatUtils.format(new Date(), pattern);
    }




    public static boolean valiDate(Object dateStr) {
        Date data = parseDate(dateStr);
        if (data!=null){
            return true;
        }
        return false;
    }

    public static Date getDateFromDateStr(String dateStr) {
        SimpleDateFormat sdf = null;
        for (int i = 0; i < parsePatterns.length; i++) {
            sdf = new SimpleDateFormat(parsePatterns[i]);
            try {
                Date date = sdf.parse(dateStr);
                return date;
            } catch (ParseException e) {
                //e.printStackTrace();
                continue;
            }
        }
        return null;
    }




    public static Date parseDate(Object str) {
        if (str == null){
            return null;
        }
        try {
            return (Date) parseDate(str.toString(), parsePatterns);
        } catch (ParseException e) {
            return null;
        }
    }


    //如何进行累计任职年限   需要哪些参数

    /**
     * 套改的任职年限
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     * @param args
     */









    public static void main(String[] args) {


        DateAddEntity dateDif = getDateDif(DateUtils.parseDate("201811"), DateUtils.parseDate("201911"));
        System.out.println(dateDif.getDateCountNum());



    }


}
