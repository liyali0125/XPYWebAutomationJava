/*
 * @FileName Test_HiveService: Test Hive Service Scripts
 * @author davieyang
 * @create 2018-10-25 15:36
 */
package testscript;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.Test;


import static com.davieyang.util.paas.HiveVerification.connectHive;

public class Test_HiveService {
    static {
        //指定log4j配置文件为log4j.xml
        DOMConfigurator.configure("log4j.xml");
    }
    @Test
    public void connect() throws Exception {
        connectHive();
    }

}
