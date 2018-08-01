package useful;

import java.time.LocalTime;
import java.util.*;

public class RandPerson {

    //往届班委名单+参选名单
    public static final int[] DONE = {51,45,9,52,7,40,43,19,32,37,14,12,22,48,15,25,55,33,24,50,42,1,16,18,4,39,10,17,36,27,38,31,30,46,23,49,29, 47, 5, 3, 53, 11,35};
    //要抽6个
    public static final int num = 7;
    //总共人数55个
    public static final int total = 55;

    public static void main(String[] args) {

        LocalTime time = LocalTime.now();
        System.out.println("现在的时间：" + time.toString());
        Arrays.sort(DONE);
        List list = new ArrayList();
        for (int i : DONE) {
            list.add(i);
        }
        System.out.println("往届班委尾号+已参选尾号" + list.toString());

        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        while (arrayList.size() != num) {
            Random random = new Random();
            //int nextInt(int n)：返回[0,n) 范围内的随机数。这里n取55,对结果加1表示取 [1,56)
            int tem = random.nextInt(total) + 1;
            if (!list.contains(tem) && !arrayList.contains(tem)) {
                arrayList.add(tem);
            }
        }
        System.out.println("被抽中的人："+arrayList.toString());
        System.out.println("班长1：" + arrayList.get(0));
        System.out.println("班长2：" + arrayList.get(1));
        System.out.println("团支书：" + arrayList.get(2));
        System.out.println("宣委兼文体委：" + arrayList.get(3));
        System.out.println("生委2：" + arrayList.get(4));
        System.out.println("就业助理1：" + arrayList.get(5));
        System.out.println("就业助理2：" + arrayList.get(6));
        System.out.println("组委：  23号");
        System.out.println("学委1： 31号");
        System.out.println("学委2： 46号");
        System.out.println("生委1： 49号");
    }

}
