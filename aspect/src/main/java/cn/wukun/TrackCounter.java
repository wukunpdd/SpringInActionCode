package cn.wukun;

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

}
