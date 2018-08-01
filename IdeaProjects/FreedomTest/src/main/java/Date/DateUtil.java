package Date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Arrays;

public class DateUtil {

    /**
     * 日期分为两类，一类为年月日 ，一类为年月
     */

    public static final String PATTERN_1 = "yyyyMMdd";
    public static final String PATTERN_2 = "yyyyMM";
    public static final String PATTERN_3 = "yyyy-MM";
    public static final String PATTERN_4 = "yyyy.MM";
    public static final String PATTERN_5 = "yyyy/MM";
    public static final String PATTERN_6 = "yyyy--MM";

    /**
     * 昨天，最近7天，最近30天，最近90天，最近1年
     */
    public static final long YESTERDAY = 1;
    public static final long LAST_SEVEN_DAY = 7;
    public static final long LAST_THIRTY_DAY = 30;
    public static final long LAST_NINTY_DAY = 90;
    public static final long LAST_YEAR = 1;

    public static DateEntity converWithDay(String date){
        return convertWithDay(date,DateUtil.PATTERN_1);
    }

    public static DateEntity convertWithDay(String date,String pattern){
        System.out.println("传入的日期是: "+date);
        System.out.println("传入的样式是: "+pattern);
        DateEntity dateEntity = new DateEntity();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        LocalDate localDate = LocalDate.parse(date,dateTimeFormatter);
        dateEntity.setYear(localDate.getYear());
        dateEntity.setMonth(localDate.getMonthValue());
        dateEntity.setDay(localDate.getDayOfMonth());
        System.out.println(dateEntity.toString());
        return dateEntity;
    }

    public static DateEntity convertWithDay(String date,DateTimeFormatter dateTimeFormatter){
        System.out.println("传入的日期是: "+date);
        DateEntity dateEntity = new DateEntity();
        LocalDate localDate = LocalDate.parse(date,dateTimeFormatter);
        dateEntity.setYear(localDate.getYear());
        dateEntity.setMonth(localDate.getMonthValue());
        dateEntity.setDay(localDate.getDayOfMonth());
        System.out.println(dateEntity.toString());
        return dateEntity;
    }

    /**
     * 没有 Day
     */
    public static DateEntity convertWithoutDay(String date,String pattern){
        DateEntity dateEntity = new DateEntity();
        System.out.println("传入的年月是: "+date);
        System.out.println("传入的样式是: "+pattern);

        date = new StringBuilder(date).append("01").toString();
        pattern = new StringBuilder(pattern).append("dd").toString();

        DateTimeFormatter dateTimeFormatter = null;
        dateTimeFormatter= DateTimeFormatter.ofPattern(pattern);
        LocalDate localDate = LocalDate.parse(date,dateTimeFormatter);
        dateEntity.setYear(localDate.getYear());
        dateEntity.setMonth(localDate.getMonthValue());
        System.out.println(dateEntity.toString());
        return dateEntity;
    }

    public static DateEntity convertWithDay(long timestamp){
        DateEntity dateEntity = new DateEntity();
        LocalDateTime localDateTime =LocalDateTime.ofEpochSecond(timestamp/1000,0, ZoneOffset.ofHours(8));
        LocalDate localDate = localDateTime.toLocalDate();
        dateEntity.setYear(localDate.getYear());
        dateEntity.setMonth(localDate.getMonthValue());
        dateEntity.setDay(localDate.getDayOfMonth());
        System.out.println(dateEntity.toString());
        return dateEntity;
    }
    /**
     * 昨天，最近7天，最近30天，最近90天
     */
    public static LocalDate lastDay(String date,long day){
        LocalDate localDate = LocalDate.parse(date,DateTimeFormatter.BASIC_ISO_DATE);
        LocalDate last = localDate.minusDays(day);
        return last;
    }

    /**
     * 最近一年
     */
    public static LocalDate lastYear(String date,long year){
        LocalDate localDate = LocalDate.parse(date,DateTimeFormatter.BASIC_ISO_DATE);
        LocalDate last = localDate.minusYears(year);
        return last;
    }

    /**
     * 所在自然周
     */
    public static int getWeekOfYear(int d){
        String date = String.valueOf(d);
        LocalDate localDate = LocalDate.parse(date,DateTimeFormatter.BASIC_ISO_DATE);
        WeekFields weekFields = WeekFields.of(DayOfWeek.MONDAY,4);
        return localDate.get(weekFields.weekOfWeekBasedYear());
    }

    /**
     * 获取 自然周 + 对应年份
     * @param d 日期
     * @return yyyyWW
     */
    public static int getWeekOfYearWithYear(int d){
        String date = String.valueOf(d);
        LocalDate localDate = LocalDate.parse(date,DateTimeFormatter.BASIC_ISO_DATE);
        WeekFields weekFields = WeekFields.of(DayOfWeek.MONDAY,4);
        int year = localDate.get(weekFields.weekBasedYear());
        int week = localDate.get(weekFields.weekOfWeekBasedYear());
        return year * 100 + week;
    }

    /**
     * 所在年+自然周 数组
     */
    public static ArrayList<Integer> getWeekOfYearWithYear(int start,int end){
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        String startString = String.valueOf(start);
        String endString = String.valueOf(end);
        LocalDate startLocalDate = LocalDate.parse(startString,DateTimeFormatter.BASIC_ISO_DATE);
        LocalDate endLocalDate = LocalDate.parse(endString,DateTimeFormatter.BASIC_ISO_DATE);
        WeekFields weekFields = WeekFields.of(DayOfWeek.MONDAY,4);
        int year = startLocalDate.get(weekFields.weekBasedYear());
        int week = startLocalDate.get(weekFields.weekOfWeekBasedYear());
        int resultYearWeek = year*100 + week;
        int maxWeekDate = year * 10000 + 1228;

        if (endLocalDate.getYear() - startLocalDate.getYear() == 0){
            for (int i = 0; i <= getWeekOfYearWithYear(end) - getWeekOfYearWithYear(start); i++) {
                arrayList.add(resultYearWeek+i);
            }
        }else if (endLocalDate.getYear() - startLocalDate.getYear() == 1){
            for (int i = 0; i <= getWeekOfYearWithYear(maxWeekDate) - resultYearWeek; i++) {
                arrayList.add(resultYearWeek+i);
            }
            year = endLocalDate.get(weekFields.weekBasedYear());
            week = endLocalDate.get(weekFields.weekOfWeekBasedYear());
            resultYearWeek = year*100 + week;
            for (int i = -getWeekOfYear(end) +1 ; i <= 0; i++) {
                arrayList.add(resultYearWeek+i);
            }
        }else {
            for (int i = 0; i <= getWeekOfYearWithYear(maxWeekDate) - resultYearWeek; i++) {
                arrayList.add(resultYearWeek+i);
            }
            for (int i = 1; i <= (end - start)/10000 ; i++) {
                resultYearWeek = (year+i)*100+1;
                maxWeekDate = (year+i)*10000 + 1228;
                for (int j = 0; j < getWeekOfYear(maxWeekDate); j++) {
                    arrayList.add(resultYearWeek+j);
                }
            }

            year = endLocalDate.get(weekFields.weekBasedYear());
            week = endLocalDate.get(weekFields.weekOfWeekBasedYear());
            resultYearWeek = year*100 + week;
            for (int i = -getWeekOfYear(end) +1 ; i <= 0; i++) {
                arrayList.add(resultYearWeek+i);
            }
        }
        return arrayList;
    }

    /**
     * 将LocalDate类型转化成int类型
     */
    public static int toInt(LocalDate localDate){
        int year = localDate.getYear();
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();
        return year*10000+month*100+day;
    }

    /**
     * 所在天数相差
     */
    public static int getDiff(int start,int end){
        String s = String.valueOf(start);
        String e = String.valueOf(end);
        LocalDate startLocalDate = LocalDate.parse(s,DateTimeFormatter.BASIC_ISO_DATE);
        LocalDate endLocalDate = LocalDate.parse(e,DateTimeFormatter.BASIC_ISO_DATE);
        int d = (int)(endLocalDate.toEpochDay() - startLocalDate.toEpochDay());
        return d;
    }

    /**
     * 所在月数相差,a大
     */
    public static int getDiffMonth(LocalDate now,LocalDate later){
        int months = later.getMonthValue() - now.getMonthValue();
        int years = later.getYear() - now.getYear();
        if (now.getDayOfMonth() > later.getDayOfMonth()) {
            months--;
        }
        return 12*years+months;
    }

    /**
     * 相差天数数组
     */
    public static int[] getDiffArray(int start,int end){
        String s = String.valueOf(start);
        String e = String.valueOf(end);
        LocalDate startLocalDate = LocalDate.parse(s,DateTimeFormatter.BASIC_ISO_DATE);
        LocalDate endLocalDate = LocalDate.parse(e,DateTimeFormatter.BASIC_ISO_DATE);
        int[] dates = new int[getDiff(start,end)+1];
        Arrays.fill(dates,0);
        for (int i = 0; i < dates.length; i++) {
            dates[i] = toInt(startLocalDate);
            startLocalDate = startLocalDate.plusDays(1);
        }
        return dates;
    }

    /**
     * 返回 某天是星期几
     * @param date 形如20180704
     * @return
     */
    public static DayOfWeek getWeekByDate(int date){
        LocalDate localDate = LocalDate.parse(String.valueOf(date),DateTimeFormatter.BASIC_ISO_DATE);
        return localDate.getDayOfWeek();
    }

    /**
     * 传入一个 days，求days天的星期
     * @param days 正数代表今天之后，负数代表今天之前。和今天相差的天数
     * @return
     */
    public static DayOfWeek getWeekByDay(int days){
        LocalDate now = LocalDate.now();
        LocalDate localDate = now.plusDays(days);
        return localDate.getDayOfWeek();
    }
}
