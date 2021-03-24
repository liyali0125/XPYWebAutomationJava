/*
 * @FileName MailService: 封装邮件相关通用操作
 * @author davieyang.wanglingyue
 * @create 2018-08-08 11:39
 */
package appmodule;

import pageobject.resourcemanagement.CommunicationManagement;
import util.LogUtil;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;

import static appmodule.MainPage.login;
import static constants.Constants.Messageservice_Main;
import static util.WaitElementUtil.sleep;

public class MailService {
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
    public static void linkToMailServicePage(WebDriver driver, String username, String password) throws Exception {
        login(driver, username, password);
        sleep(3000);
        driver.get(Messageservice_Main);
        LogUtil.info("进入通信服务总览页面...");
        CommunicationManagement.email(driver).click();
        LogUtil.info("进入邮件服务列表页面...");
    }

}