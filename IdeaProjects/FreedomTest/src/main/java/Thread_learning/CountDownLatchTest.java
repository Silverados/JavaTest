package Thread_learning;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

//    static CountDownLatch c = new CountDownLatch(2);
//
//    public static void main(String[] args) throws InterruptedException {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(1);
//                c.countDown();
//                System.out.println(2);
//                c.countDown();
//            }
//        }).start();
//
//        c.await();
//        System.out.println(3);
//    }


        public static void main(String[] args) throws InterruptedException {
            Thread parser1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("parser1 finish");
                }
            });

            Thread parser2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("parser2 finish");
                }
            });

            parser1.start();
            parser2.start();
            parser1.join();
            parser1.join();
            System.out.println("all parser finish");
        }

}
