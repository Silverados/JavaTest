package aspect_learning;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class Audience {

//    @Before("execution(* aspect_learning.Performance.perform(..))")
//    public void silenceCellPhones(){
//        System.out.println("Silence cell phones");
//    }
//
//    @Before("execution(* aspect_learning.Performance.perform(..))")
//    public void takeSeats(){
//        System.out.println("Taking seats");
//    }
//
//    @AfterReturning("execution(* aspect_learning.Performance.perform(..))")
//    public void applause(){
//        System.out.println("CLAP CLAP CLAP");
//    }
//
//    @AfterThrowing("execution(* aspect_learning.Performance.perform(..))")
//    public void demandRefund(){
//        System.out.println("Demand a refund");
//    }
    
    
    @Pointcut("execution(* aspect_learning.Performance.perform(..))")
    public void performance(){}

//    @Before("performance()")
//    public void silenceCellPhones(){
//        System.out.println("Silence cell phones");
//    }
//
//    @Before("performance()")
//    public void takeSeats(){
//        System.out.println("Taking seats");
//    }
//
//    @AfterReturning("performance()")
//    public void applause(){
//        System.out.println("CLAP CLAP CLAP");
//    }
//
//    @AfterThrowing("performance()")
//    public void demandRefund(){
//        System.out.println("Demand a refund");
//    }

    public void watchPerformance(ProceedingJoinPoint jp){
        try {
            System.out.println("Silencing cell phones");
            System.out.println("Taking seats");
            jp.proceed();
            System.out.println("CLAP CLAP CLAP");
        }catch (Throwable e){
            System.out.println("Demanding a refund");
        }
    }
}
