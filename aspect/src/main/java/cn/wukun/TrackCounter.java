package cn.wukun;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class TrackCounter {
    @Pointcut(value = "execution(* cn.wukun.Performance.track(int)) && args(i)")
    public void declareJoinPointExpression(int i) {}

    @Before(value="declareJoinPointExpression(i)",argNames = "i")
    public void beforeMethod( int i) {
        System.out.println("---------begins with " + i);
    }

    @Around(value = "declareJoinPointExpression(i)", argNames = "point, i")
    public Object Method(ProceedingJoinPoint point, int i) {
        Object result = null;
        try {
            result = point.proceed();
        } catch (Throwable e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("---------Around with " + i +"-"+result);
        return 33;
    }
}
