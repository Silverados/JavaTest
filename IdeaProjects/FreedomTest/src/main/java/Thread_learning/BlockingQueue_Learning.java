package Thread_learning;

import useful.programAnalyse.RunTimeMIllis;

import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;

public class BlockingQueue_Learning {
    public static void main(String[] args){
        RunTimeMIllis runTimeMIllis = new RunTimeMIllis();
        int sum = 0;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println(sum);
        System.out.println(runTimeMIllis.caculateTime());




    }
}
