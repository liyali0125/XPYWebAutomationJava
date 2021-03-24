/*
 * @FileName Test_Kafka: The script of teseting kafka
 * @author davieyang
 * @create 2018-09-10 13:56
 */
package testscript;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.apache.log4j.xml.DOMConfigurator;

public class Test_Kafka {
    static {
        //指定log4j配置文件为log4j.xml
        DOMConfigurator.configure("log4j.xml");
    }

    @BeforeMethod
    public void setUp() {
    }

    @Test
    public void test_Kafka() {
    }

    @AfterClass
    public void tearDown() {
    }
}