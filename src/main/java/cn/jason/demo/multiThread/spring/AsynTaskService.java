package cn.jason.demo.multiThread.spring;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service // 注解的方式把AsyncService交给Spring来管理
public class AsynTaskService {

    // 这里可以注入spring中管理的其他bean，这也是使用spring来实现多线程的一大优势


    @Async    // 这里进行标注为异步任务，在执行此方法的时候，会单独开启线程来执行
    public void f1() {
        System.out.println("f1 : " + Thread.currentThread().getName() + "   " + UUID.randomUUID().toString());
        try {
            Thread.sleep(new Random().nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Async
    public void f2() {
        System.out.println("f2 : " + Thread.currentThread().getName() + "   " + UUID.randomUUID().toString());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
