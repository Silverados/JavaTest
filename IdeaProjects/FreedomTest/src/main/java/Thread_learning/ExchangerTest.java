package Thread_learning;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExchangerTest {
    private static final Exchanger<String> ex = new Exchanger<>();
    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);
    public static void main(String[] args){
        threadPool.execute(()->{
            String A = "银行流水A";
            try {
                ex.exchange(A);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadPool.execute(()->{
            String B = "银行流水B";
            try {
                String A = ex.exchange("B");
                System.out.println("A录入："+A);
                System.out.println("B录入："+B);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        threadPool.shutdown();
    }
}
