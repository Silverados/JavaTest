package random;

import static java.lang.System.*;

public class StringTest {
    public static void main(String[] args){
//        long millis = System.nanoTime();
//        String a = "h"+"e"+"l"+"l"+"o"+1.1+1+2.2;
//        System.out.println(System.nanoTime()-millis);
//
//        long mills1 = System.nanoTime();
//        String b = new StringBuilder("h").append("e").append("l").append("l").append("o").append(1.1).append(1).append(2.2).toString();
//        System.out.println(System.nanoTime()-mills1);

        String s = "201805";
        long nanoTime = nanoTime();
        String b = s + "01";
        long nanoTime2 = nanoTime();
        long l = nanoTime2 - nanoTime;
        long nanoTime3 = nanoTime();
        String c = new StringBuilder(s).append("01").toString();
        long nanoTime4 = nanoTime();
        long l1 = nanoTime4 - nanoTime3;
    }
}
