package Date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil2 {

    /**
     * date : 20180105
     */
    public static DateEntity convertWithDay(int date){
        DateEntity dateEntity = new DateEntity();
        int year = date/10000; // 2018
        int month = (date - year*10000)/100; // 01
        int day = date - year*10000 - month*100;
        dateEntity.setYear(year);
        dateEntity.setMonth(month);
        dateEntity.setDay(day);
        return dateEntity;
    }

    /**
     * date : 201801
     */
    public static DateEntity convertWithoutDay(int date){
        DateEntity dateEntity = new DateEntity();
        int year = date/100; // 2018
        int month = date - year*100; // 01
        dateEntity.setYear(year);
        dateEntity.setMonth(month);
        return dateEntity;
    }

//    /**
//     * date : 20180105
//     */
//    public static LocalDate convertWithDay(int date){
//        return LocalDate.parse(String.valueOf(date),DateTimeFormatter.BASIC_ISO_DATE);
//    }
//
//    /**
//     * date : 201801
//     */
//    public static LocalDate convertWithoutDay(int date){
//        return LocalDate.parse(new StringBuilder().append(String.valueOf(date)).append("01").toString(),DateTimeFormatter.BASIC_ISO_DATE);
//    }

    /**
     * date : 20180105
     */
    public static DateEntity convertWithDay(String dateString){
        DateEntity dateEntity = new DateEntity();
        int date = Integer.valueOf(dateString);
        int year = date/10000; // 2018
        int month = (date - year*10000)/100; // 01
        int day = date - year*10000 - month*100;
        dateEntity.setYear(year);
        dateEntity.setMonth(month);
        dateEntity.setDay(day);
        return dateEntity;
    }


    /**
     * date : 201801
     */
    public static DateEntity convertWithoutDay(String dateString){
        DateEntity dateEntity = new DateEntity();
        int date = Integer.valueOf(dateString);
        int year = date/100; // 2018
        int month = date - year*100; // 01
        dateEntity.setYear(year);
        dateEntity.setMonth(month);
        return dateEntity;
    }


}