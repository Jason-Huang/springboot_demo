package cn.jason.demo.zk.lock;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessSemaphoreMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

public class ZookeeperHelper {

    private static String firstCacheKey;
    private CuratorFramework cf;

    @PostConstruct
    public void init() {
        //创建zookeeper客户端
        try (CuratorFramework client = CuratorFrameworkFactory.newClient("127.0.0.1:2181", new ExponentialBackoffRetry(1000, 3))) {
            client.start();
        }
    }

    public InterProcessSemaphoreMutex getLock(String subPath) {
        String path = "zookeeper_lock" + "/" + subPath;
        return new InterProcessSemaphoreMutex(cf, path);
    }

    public static void main(String[] args) throws Exception {


        ZookeeperHelper zookeeperHelper = new ZookeeperHelper();
        InterProcessSemaphoreMutex lock = zookeeperHelper.getLock(firstCacheKey);
        if (lock.acquire(15, TimeUnit.SECONDS)) {
            try {
//                do something ......
            } finally {
                if (lock.isAcquiredInThisProcess()) {
                    lock.release();
                }
            }
        }
    }

}

