package cn.jason.demo.multiThread.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.*;

public class MainTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ThreadConfig.class);
        AsynTaskService service = context.getBean(AsynTaskService.class);
        ExecutorService executorService = new ThreadPoolExecutor(1, 1, 1, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>(10));
        executorService.submit(new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return null;
            }
        }));
        new Thread(new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return null;
            }
        })).start();

        for (int i = 0; i < 10; i++) {
            service.f1(); // 执行异步任务
            service.f2();
        }
        context.close();
    }

}
