package useful;

public class SuitableHeartRate {
    /**
     * 最佳运动心率控制区域计算法：(适合一般人)
     * （220─现在年龄）×0.8=最大运动心率
     * （220─现在年龄）×0.6=最小运动心率
     */
    public static void main(String[] args){
        float[] suit = suit(22);
        for (float v : suit) {
            System.out.println(v);
        }
    }

    public static float[] suit(int age){
        Float max = (220 - age) * 0.8f;
        Float min = (220 - age)*0.6f;
        return new float[]{min,max};
    }

}
