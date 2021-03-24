/*
 * @FileName ZookeeperVerification: Some methods for operating zookeeper services
 * @author davieyang
 * @create 2018-08-30 14:43
 */
package util.paas;

import util.LogUtil;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

public class
ZookeeperVerification {
    static {
        //指定log4j配置文件为log4j.xml
        DOMConfigurator.configure("log4j.xml");
    }

    /**
     * 链接服务
     * @param CONNECT_ADDR
     * @param SESSION_OUTTIME
     * @throws Exception
     */
    public static void connectZooKeeper(String CONNECT_ADDR, int SESSION_OUTTIME) throws Exception {
        ZooKeeper connectZK = new ZooKeeper(CONNECT_ADDR, SESSION_OUTTIME, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                // 获取事件的状态
                KeeperState keeperState = event.getState();
                EventType eventType = event.getType();
                // 如果是建立连接
                if (KeeperState.SyncConnected == keeperState) {
                    if (EventType.None == eventType) {
                        // 如果建立连接成功，则发送信号量，让后续阻塞程序向下执行
                        System.out.println("connectZK 建立连接");
                        LogUtil.info("建立连接成功");
                    }
                }
            }
        });
        connectZK.close();
        System.out.println("关闭连接connectZK");
        LogUtil.info("关闭连接成功");
    }

    /**
     * 创建节点
     * @param CONNECT_ADDR
     * @param SESSION_OUTTIME
     * @throws Exception
     */
    public static void createNode(String CONNECT_ADDR, int SESSION_OUTTIME)throws Exception{
        ZooKeeper connectZK = new ZooKeeper(CONNECT_ADDR, SESSION_OUTTIME, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                // 获取事件的状态
                KeeperState keeperState = event.getState();
                EventType eventType = event.getType();
                // 如果是建立连接
                if (KeeperState.SyncConnected == keeperState) {
                    if (EventType.None == eventType) {
                        // 如果建立连接成功，则发送信号量，让后续阻塞程序向下执行
                        System.out.println("connectZK 建立连接");
                        LogUtil.info("建立连接成功");
                    }
                }
            }
        });
        try{
            connectZK.create("/testRoot", "PaaSWebTest".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            byte[] data = connectZK.getData("/testRoot", false, null);
            LogUtil.info("创建节点testRoot,节点值为PaaSWebTest" + (new String(data)));
        }catch (Exception e){
            e.printStackTrace();
            LogUtil.info("创建节点失败");
        }
        connectZK.close();
        LogUtil.info("关闭连接成功");
    }

    /**
     * 获取节点信息
     * @param CONNECT_ADDR
     * @param SESSION_OUTTIME
     * @throws Exception
     */
    public static void getNode(String CONNECT_ADDR, int SESSION_OUTTIME)throws Exception{
        ZooKeeper connectZK = new ZooKeeper(CONNECT_ADDR, SESSION_OUTTIME, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                // 获取事件的状态
                KeeperState keeperState = event.getState();
                EventType eventType = event.getType();
                // 如果是建立连接
                if (KeeperState.SyncConnected == keeperState) {
                    if (EventType.None == eventType) {
                        // 如果建立连接成功，则发送信号量，让后续阻塞程序向下执行
                        System.out.println("connectZK 建立连接");
                        LogUtil.info("建立连接成功");
                    }
                }
            }
        });
        try{
            // 获取节点信息
            byte[] data = connectZK.getData("/testRoot", false, null);
            System.out.println(new String(data));
            LogUtil.info("节点testRoot,节点值为PaaSWebTest" + (new String(data)));
        }catch (Exception e){
            e.printStackTrace();
            LogUtil.info("获取节点信息失败");
        }

        connectZK.close();
    }

    /**
     * 修改节点信息
     * @param CONNECT_ADDR
     * @param SESSION_OUTTIME
     * @throws Exception
     */
    public static void modifyNode(String CONNECT_ADDR, int SESSION_OUTTIME)throws Exception{
        ZooKeeper connectZK = new ZooKeeper(CONNECT_ADDR, SESSION_OUTTIME, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                // 获取事件的状态
                KeeperState keeperState = event.getState();
                EventType eventType = event.getType();
                // 如果是建立连接
                if (KeeperState.SyncConnected == keeperState) {
                    if (EventType.None == eventType) {
                        // 如果建立连接成功，则发送信号量，让后续阻塞程序向下执行
                        System.out.println("connectZK 建立连接");
                        LogUtil.info("建立连接成功");
                    }
                }
            }
        });
        try{
            // 修改节点的值
            connectZK.setData("/testRoot", "TestPaaSWeb".getBytes(), -1);
            byte[] data = connectZK.getData("/testRoot", false, null);
            System.out.println(new String(data));
        }catch (Exception e){
            e.printStackTrace();
            LogUtil.info("修改节点值失败");
        }
        connectZK.close();
    }

    /**
     * 删除节点
     * @param CONNECT_ADDR
     * @param SESSION_OUTTIME
     * @throws Exception
     */
    public static void deleteNode(String CONNECT_ADDR, int SESSION_OUTTIME)throws Exception{
        ZooKeeper connectZK = new ZooKeeper(CONNECT_ADDR, SESSION_OUTTIME, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                // 获取事件的状态
                KeeperState keeperState = event.getState();
                EventType eventType = event.getType();
                // 如果是建立连接
                if (KeeperState.SyncConnected == keeperState) {
                    if (EventType.None == eventType) {
                        // 如果建立连接成功，则发送信号量，让后续阻塞程序向下执行
                        System.out.println("connectZK 建立连接");
                        LogUtil.info("建立连接成功");
                    }
                }
            }
        });
        try {
            // 删除节点
            connectZK.delete("/testRoot", -1);
            //System.out.println(connectZK.exists("/testRoot", true));
            LogUtil.info("删除节点成功");
        }catch (Exception e){
            e.printStackTrace();
            LogUtil.info("删除节点失败");
        }
        connectZK.close();
        LogUtil.info("关闭连接成功");
    }
}

