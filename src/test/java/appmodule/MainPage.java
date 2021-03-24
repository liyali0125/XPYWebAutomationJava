package appmodule;
/*
 * @FileName StoreManagement: 封装登陆/退出以及主页等相关通用操作
 * @author davieyang
 * @create 2018-08-08 11:12
 */
import constants.Constants;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;

import static pageobject.mainpage.LoginPage.*;
import static util.KeyActionsUtil.*;
import static util.LogUtil.info;

public class MainPage {
    static {
        //指定log4j配置文件为log4j.xml
        DOMConfigurator.configure("log4j.xml");
    }

    /**
     * 登陆系统
     * @param driver 浏览器驱动
     * @param userName 用户名
     * @param password 密码
     * @throws Exception
     */
    public static void login(WebDriver driver, String userName, String password) throws Exception {
        navigate(Constants.LoginPage);
        maxBrowser(driver);
        info("最大化浏览器...");
        userName(driver).clear();
        info("清空输入窗...");
        userName(driver).sendKeys(userName);
        info("输入用户名...");
        password(driver).clear();
        info("清空输入框...");
        password(driver).sendKeys(password);
        info("输入密码...");
        loginButton(driver).click();
        info("点击登陆...");
    }

    /**
     * 退出系统
     * @param driver 浏览器驱动
     * @throws Exception
     */
    public void logout(WebDriver driver) throws Exception{
        logoutButton(driver).click();
        info("点击退出按钮...");
        info("退出系统...");
    }
}
