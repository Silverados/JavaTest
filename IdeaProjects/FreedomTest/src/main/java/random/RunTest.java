package random;

public class RunTest {
    public static void main(String[] args){

            long first = System.currentTimeMillis();
            long start = System.nanoTime();
            int a = 2000%4;
            System.out.println(a);
            long second = System.currentTimeMillis();
            long end = System.nanoTime();
            System.out.println(second - first);
            System.out.println(end - first);

            long third = System.currentTimeMillis();
            long thirdNaono  = System.nanoTime();
            int b = 2000&3;
            System.out.println(b);
            long forth = System.currentTimeMillis();
            long forthNano = System.nanoTime();
            System.out.println(forth - third);
            long nanoResult = forthNano - thirdNaono;
            System.out.println(nanoResult);
        }

}
