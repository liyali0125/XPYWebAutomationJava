/*
 * @FileName Test_RabbitMQ: The script of testing rabbitmq
 * @author davieyang
 * @create 2018-09-10 13:57
 */
package testscript;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.apache.log4j.xml.DOMConfigurator;

public class Test_RabbitMQ {
    static {
        //指定log4j配置文件为log4j.xml
        DOMConfigurator.configure("log4j.xml");
    }

    @BeforeMethod
    public void setUp() {
    }

    @Test
    public void test_RabbitMQ() {
    }

    @AfterClass
    public void tearDown() {
    }
}