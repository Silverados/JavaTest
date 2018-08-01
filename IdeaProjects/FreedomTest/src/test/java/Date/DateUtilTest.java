package Date;

import org.junit.Test;

import java.time.LocalDate;

public class DateUtilTest {

    @Test
    public void getDiffArray() {
        for (int i : DateUtil.getDiffArray(20180605, 20180611)) {
            System.out.println(i);
        }
    }

    @Test
    public void getDiff() {
    }

    @Test
    public void getWeekOfYearWithYear() {
        System.out.println(DateUtil.getWeekOfYearWithYear(20180101));
    }

    @Test
    public void getWeekOfYearWithYear1() {
        System.out.println(DateUtil.getWeekOfYearWithYear(20150508, 20180608));
    }

    @Test
    public void converWithDay() {

    }

    @Test
    public void convertWithDay() {
    }

    @Test
    public void convertWithDay1() {
    }

    @Test
    public void convertWithoutDay() {
    }

    @Test
    public void convertWithDay2() {
    }

    @Test
    public void getDiffArray1() {
    }

    @Test
    public void getWeekByDate() {
    }

    @Test
    public void getWeekByDay() {
        System.out.println(DateUtil.getWeekByDay(0));
        System.out.println(DateUtil.getWeekByDay(1));
        System.out.println(DateUtil.getWeekByDay(-1));
    }

    @Test
    public void getDiffMonth() {
        System.out.println(DateUtil.getDiffMonth(LocalDate.now(), LocalDate.of(2018, 8, 11)));
    }
}