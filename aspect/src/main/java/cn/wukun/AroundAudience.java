package cn.wukun;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AroundAudience {
    @Pointcut("execution(* cn.wukun.Performance.perform(..))")
    public void performance(){}

    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint joinPoint){
        try{
            System.out.println("执行前1号");
            System.out.println("执行前2号");

            //将控制权限交给被通知的方法
            joinPoint.proceed();

            System.out.println("正常执行完成");
        }catch (Throwable e){
            System.out.println("出错了");
        }
    }
}
