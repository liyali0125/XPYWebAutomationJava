/*
 * @FileName Test_ZookeeperVerification: The test script of zookeeper
 * @author davieyang
 * @create 2018-08-30 15:18
 */
package testscript;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.Test;

public class Test_ZookeeperVerification {
    static {
        //指定log4j配置文件为log4j.xml
        DOMConfigurator.configure("log4j.xml");
    }
    @Test
    public void test_watchzookeeper() throws Exception {
      //  connectZooKeeper("210.13.50.105:31973", 5000);
        //createNode("210.13.50.105:31973", 5000);
       // getNode("210.13.50.105:31973", 5000);
       // modifyNode("210.13.50.105:31973", 5000);
       // deleteNode("210.13.50.105:31973", 5000);
    }
}
