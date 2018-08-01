package random;

public class Cycle {
    public static void main(String[] args){
        for (int i = 0; i < 2; i++) {
            lable:
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    System.out.println("进入k循环：k="+k);
                    if (j==0) break lable;
                }
                System.out.println("进入j循环：j="+j);
            }
        }
    }
}
