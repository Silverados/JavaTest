package random;

import java.math.BigDecimal;

public class SC {
    public static void main(String[] args){
        BigDecimal[] caculate = caculate(49580, 4.9,100);
        for (BigDecimal bigDecimal : caculate) {
            System.out.println(bigDecimal+" ");
        }
        boolean b = null == null;
    }

    public static BigDecimal[] caculate(double a,double b,int maxRecyle) {
        BigDecimal aB = BigDecimal.valueOf(a);
        BigDecimal bB = BigDecimal.valueOf(b);
        BigDecimal cB = BigDecimal.valueOf(a/b);
        for (int i = 0; i < maxRecyle; i++) {
            if (cB.scale() > 2) {
                bB = BigDecimal.valueOf((b+0.025*(i+1)));
                cB = BigDecimal.valueOf(a/(b+0.025*(i+1)));
            }
            else return new BigDecimal[]{bB, cB};
        }
        return new BigDecimal[]{};
    }
}
