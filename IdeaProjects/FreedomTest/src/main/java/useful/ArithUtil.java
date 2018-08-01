/**
 * Amendment History
 *
 * 	Amended       by: weiyuwang
 * 	Amendment   Date: 2018/6/23
 * 	Amendment Number: A20180623
 * 	Amendment Detail: amend bugs about scale
 *
 * Copyright (C) 2018 1ziton
 *
 * WARNING:
 * This code is the sole property of 1ziton and is protected
 * by international copyright laws.
 * This program is confidential and proprietary, not to be disclosed
 * without written authorization from Ignite Vision Limited.
 * Any use, duplication, or disclosure of this program by other than
 * 1ziton strictly forbidden by law.
 */
package useful;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ArithUtil {

    public static final int SCALE_ZERO = 0;
    public static final int SCALE_TWO = 2;

    public static final BigDecimal ONE = new BigDecimal(1);

    /**
     * Add and return BigDecimal value
     *
     * @param a
     * @param b
     * @param scale
     * @return
     */
    public static BigDecimal add(double a, double b, int scale){
        BigDecimal result = null;
        BigDecimal b1 = BigDecimal.valueOf(a);
        BigDecimal b2 = BigDecimal.valueOf(b);
        result = b1.add(b2).divide(ONE, scale, RoundingMode.HALF_UP);

        return result;
    }

    /**
     * Substract and return BigDecimal value
     *
     * @param a
     * @param b
     * @param scale
     * @return
     */
    public static BigDecimal subtract(double a, double b, int scale){
        BigDecimal result = null;
        BigDecimal b1 = null;
        BigDecimal b2 = null;

        b1 = BigDecimal.valueOf(a);
        b2 = BigDecimal.valueOf(b);

        result = b1.subtract(b2).divide(ONE, scale, RoundingMode.HALF_UP);

        return result;
    }

    /**
     * Multiply and return BigDecimal
     *
     * @param a
     * @param b
     * @param scale
     * @return
     */
    public static BigDecimal multiply(double a, double b, int scale){
        BigDecimal result = null;
        BigDecimal b1 = null;
        BigDecimal b2 = null;

        b1 = BigDecimal.valueOf(a);
        b2 = BigDecimal.valueOf(b);

        result = b1.multiply(b2).divide(ONE, scale, RoundingMode.HALF_UP);

        return result;
    }

    /**
     * Divisor and return BigDecimal
     *
     * @param dividend
     * @param divisor
     * @param scale
     * @return
     */
    public static BigDecimal divide(double dividend, double divisor, int scale) {
        BigDecimal result = null;
        BigDecimal b1 = null;
        BigDecimal b2 = null;

        b1 = BigDecimal.valueOf(dividend);
        b2 = BigDecimal.valueOf(divisor);

        result = b1.divide(b2, scale, RoundingMode.HALF_UP);

        return result;
    }
}
