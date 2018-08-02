package cn.wukun;

import org.springframework.stereotype.Component;

@Component
public class PerformanceImpl implements Performance {
    @Override
    public void perform() {
        System.out.println("哥哥我才是主程序啊");
    }

    public void track(int age){
        System.out.println("哥哥我才是主程序啊"+age);
    }
}
