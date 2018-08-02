package cn.wukun;

import org.aspectj.lang.annotation.*;

@Aspect
public class Audience {
    @Pointcut("execution(* cn.wukun.Performance.perform(..))")
    public void performance(){}

    @Before("performance()")
    public void silenceCellPhones(){
        System.out.println("执行前1号");
    }

    @Before("performance()")
    public void takeSeats(){
        System.out.println("执行前2号");
    }

    @After("performance()")
    public void applause(){
        System.out.println("执行完了就执行老子");
    }

    @AfterReturning("performance()")
    public void demandRefund(){
        System.out.println("正常执行的");
    }

    @AfterThrowing("performance()")
    public void errorRefund(){
        System.out.println("程序执行时出现了错误");
    }
}
