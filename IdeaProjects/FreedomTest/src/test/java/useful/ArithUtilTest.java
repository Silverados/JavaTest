package useful;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.Assert.*;

public class ArithUtilTest {

    @Test
    public void add() {
        Double d = 1.12345;

        BigDecimal bigDecimal = BigDecimal.valueOf(2.123456789).setScale(4,RoundingMode.HALF_UP);
        System.out.println(bigDecimal.doubleValue()*100);
    }

    @Test
    public void subtract() {
    }

    @Test
    public void multiply() {
    }

    @Test
    public void divide() {
    }
}