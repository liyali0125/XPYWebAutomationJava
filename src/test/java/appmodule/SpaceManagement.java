package appmodule;
/*
 * @FileName StoreManagement: 封装空间管理相关通用操作
 * @author davieyang
 * @create 2018-08-08 11:12
 */
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;

import static appmodule.MainPage.login;
import static constants.Constants.Spacemanagement_Main;
import static util.LogUtil.info;
import static util.WaitElementUtil.sleep;


public class SpaceManagement {
    static {
        //指定log4j配置文件为log4j.xml
        DOMConfigurator.configure("log4j.xml");
    }

    /**
     *
     * @param driver 浏览器驱动
     * @param username 登陆PaaS的用户名
     * @param password 登陆PaaS的密码
     * @throws Exception 获取定位元素异常
     */
    public static void linkToSpaceManagementPage(WebDriver driver, String username, String password)throws Exception{
        login(driver, username, password);
        sleep(1000);
        info("等待3秒...");
        driver.get(Spacemanagement_Main);
        info("进入空间管理页面...");
        sleep(1000);
        info("等待3秒...");
    }
}
