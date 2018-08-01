package Thread_learning;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

public class Pool_Learning {
    public static void main(String[] args){
        System.out.println(Runtime.getRuntime().availableProcessors());
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(16, 20, 1000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(),new ThreadFactoryBuilder().setNameFormat("XX-task-%d").build(),new ThreadPoolExecutor.AbortPolicy());
        Future<?> future = threadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {

            }
        });
        try {
            future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        threadPoolExecutor.shutdown();
        threadPoolExecutor.isTerminated();
    }
}
