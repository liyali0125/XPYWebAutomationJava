/*
 * @FileName KafkaService: 封装Kafka相关通用操作
 * @author davieyang
 * @create 2018-08-08 11:38
 */
package appmodule;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;

import static appmodule.MainPage.login;
import static pageobject.resourcemanagement.CommunicationManagement.kafkaservice;
import static util.LogUtil.info;
import static util.WaitElementUtil.sleep;

public class KafkaService {
    static {
        //制定log配置文件
        DOMConfigurator.configure("log4j.xml");
    }

    /**
     *
     * @param driver 浏览器驱动
     * @param username 用户名
     * @param password 密码
     * @throws Exception 定位元素失败
     */
    public static void linkToKafkaPage(WebDriver driver, String username, String password)throws Exception{
        login(driver, username, password);
        info("登陆系统...");
        sleep(3000);
        info("等待3秒...");
        kafkaservice(driver);
        info("进入kafka页面...");
        sleep(3000);
        info("等待3秒...");
    }
}
