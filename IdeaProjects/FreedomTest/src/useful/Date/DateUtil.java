package useful.Date;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtil {

    /**
     * 1.yyyyMM 2.yyyyMMdd 3.yyyy-MM-dd 4.yyyy-MM
     */
    public static final String YMD = "yyyyMMdd";
    public static final String YM = "yyyyMM";
    public static final String Y_M_D = "yyyy-MM-dd";
    public static final String Y_M = "yyyy-MM";
    public static final String YMDPoint = "yyyy.MM.dd";
    public static final String YMPoint = "yyyy.MM";
    public static final String YMDSlash = "yyyy/MM/dd";
    public static final String YMSlash = "yyyy/MM";


    /**
     * 默认 yyyyMMdd
     */
    public static DateEntity convert(String date) {
        return convert(date, DateUtil.YMD);
    }

    /**
     * 对日期的解析：
     * 1. 分析输入的日期是否符合规范，能否进行解析
     * 2. 获取对应的信息
     * @param date:需要进行转换的日期 pattern:样式，用DateUtil里的常量。
     * @return DateEntity类型，内部封装年月日以及toString()方法
     */
    public static DateEntity convert(String date, String pattern) {

        DateEntity dateEntity = new DateEntity();
        LocalDate localDate = null;
//        DateTimeFormatter dateTimeFormatter = null;
        date = date.replaceAll("[^0-9]", "");
        if (pattern.equals(DateUtil.YMD) || pattern.equals(DateUtil.YMDSlash) || pattern.equals(DateUtil.YMDPoint) ||
                pattern.equals(DateUtil.Y_M_D)) {
//            dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
//            localDate = LocalDate.parse(date, dateTimeFormatter);
            localDate = LocalDate.parse(date, DateTimeFormatter.BASIC_ISO_DATE);
            dateEntity.setYear(localDate.getYear());
            dateEntity.setMonth(localDate.getMonthValue());
            dateEntity.setDay(localDate.getDayOfMonth());
        } else if (pattern.equals(DateUtil.YM) || pattern.equals(DateUtil.YMSlash) || pattern.equals(DateUtil
                .YMPoint) || pattern.equals(DateUtil.Y_M)) {
            StringBuilder stringBuilder = new StringBuilder(date).append("01");
            localDate = LocalDate.parse(stringBuilder, DateTimeFormatter.BASIC_ISO_DATE);
            dateEntity.setYear(localDate.getYear());
            dateEntity.setMonth(localDate.getMonthValue());
        }
        return dateEntity;
//        if (pattern.equals(DateUtil.YMD)) {
//            localDate = LocalDate.parse(date, DateTimeFormatter.BASIC_ISO_DATE);
//        } else if (pattern.equals(DateUtil.YM)) {
//            localDate = LocalDate.parse(date + "01", DateTimeFormatter.BASIC_ISO_DATE);
//        } else if (pattern.equals(DateUtil.Y_M_D)) {
//            localDate = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
//        } else if (pattern.equals(DateUtil.Y_M)) {
//            localDate = LocalDate.parse(date + "-01", DateTimeFormatter.ISO_LOCAL_DATE);
//        } else if (pattern.equals(DateUtil.YMDPoint)) {
//            date = date.replace(".", "-");
//            localDate = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
//        } else if (pattern.equals(DateUtil.YMPoint)) {
//            date = date.replace(".", "-");
//            localDate = LocalDate.parse(date+"-01", DateTimeFormatter.ISO_LOCAL_DATE);
//        } else if (pattern.equals(DateUtil.YMDSlash)) {
//            date = date.replace('/','-');
//            localDate = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
//        } else if (pattern.equals(DateUtil.YMSlash)) {
//            date = date.replace('/','-');
//            localDate = LocalDate.parse(date+"-01", DateTimeFormatter.ISO_LOCAL_DATE);
//        }


    }

    public static DateEntity convert(Date date, String pattern) {
        DateEntity dateEntity = new DateEntity();
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDate localDate = instant.atZone(zoneId).toLocalDate();
        int year = localDate.getYear() - 1900;
        int month = localDate.getMonthValue() - 1;
        int day = localDate.getDayOfMonth();
        if (pattern.equals(DateUtil.YMD)) {
            dateEntity.setYear(year);
            dateEntity.setMonth(month);
            dateEntity.setDay(day);
        }
        if (pattern.equals(DateUtil.YM)) {
            dateEntity.setYear(year);
            dateEntity.setMonth(month);
        }
        return dateEntity;
    }

    public static void main(String[] args) {
        DateEntity dateEntity = DateUtil.convert("201802", DateUtil.YM);
        System.out.println(dateEntity.toString());
        DateEntity dateEntity1 = DateUtil.convert(new Date(2000, 02, 28), DateUtil.YMD);
        System.out.println(dateEntity1.toString());
    }


}
