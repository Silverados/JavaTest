package LangTest;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;

public class Big {
    public static void main(String[] args){
        BigInteger a = new BigInteger("1230");
        BigInteger b = new BigInteger("12300");

        a.add(b);
        a.subtract(b);
        a.multiply(b);
        a.divide(b);

        a.abs();
        a.max(b);
        a.min(b);
        a.pow(10);
        a.gcd(b);
        System.out.println(BigInteger.probablePrime(3, new Random()));

        Double d = new Double(1.22);
        BigDecimal bigDecimal = new BigDecimal(1.22f);
        System.out.println(bigDecimal);//1.2200000286102294921875
    }
}
