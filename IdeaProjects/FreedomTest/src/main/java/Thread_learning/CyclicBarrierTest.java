package Thread_learning;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
    //    static CyclicBarrier c = new CyclicBarrier(2);
//    public static void main(String[] args){
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    c.await();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } catch (BrokenBarrierException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(1);
//            }
//        });
//
//        thread.start();
//
//        try {
//            c.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (BrokenBarrierException e) {
//            e.printStackTrace();
//        }
//        System.out.println(2);
//
//    }
    static CyclicBarrier c = new CyclicBarrier(5, new Before());

    public static void main(String[] args) {

        Runnable r = () -> {
            System.out.println("i am a thread");
            try {
                c.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        };

        Thread[] threads = new Thread[4];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(r);
            threads[i].start();
        }

        try {
            c.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("over");
    }

    static class Before implements Runnable {

        @Override
        public void run() {
            System.out.println("i am out of barrier");
        }
    }
}
