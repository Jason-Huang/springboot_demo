package cn.jason.demo.zk;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;

import java.io.IOException;

public class CreateGroup extends ConnectionWatcher {

    public void create(String groupName) throws KeeperException, InterruptedException {
        String path = "/" + groupName;
        String createdPath = zk.create(path, null/*data*/, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println("Created " + createdPath);
    }

    public static void main(String[] args) throws InterruptedException, KeeperException, IOException {
        CreateGroup createGroup = new CreateGroup();
        createGroup.connect("0.0.0.0:2181");
        createGroup.create("huang");
        createGroup.close();
    }
}

