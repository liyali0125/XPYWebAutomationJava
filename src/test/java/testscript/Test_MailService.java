/*
 * @FileName Test_MailService: 邮件服务测试案例
 * @author wanglingyue
 * @create 2018-09-03 16:35
 */
package testscript;

import pageobject.resourcemanagement.CommunicationManagement;
import org.apache.log4j.xml.DOMConfigurator;

import util.KeyActionsUtil;
import util.LogUtil;
import util.ScrollBarUtil;
import appmodule.MainPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobject.resourcemanagement.MailService;

import static appmodule.MainPage.login;
import static pageobject.resourcemanagement.CommunicationManagement.email;
import static pageobject.resourcemanagement.MailService.senderBtn;
import static pageobject.resourcemanagement.MailService.sendercerateBtn;
import static util.KeyActionsUtil.assertString;
import static util.ScrollBarUtil.scrolltoBottom;
import static constants.Constants.Messageservice_Main;
import static constants.Constants.LoginPage;
import static util.WaitElementUtil.sleep;

public class Test_MailService {
    private WebDriver driver = KeyActionsUtil.initBrowser("chrome");
    private CommunicationManagement communicationManagement  =new  CommunicationManagement(driver);
    private MailService mailService = new MailService(driver);
    private  ScrollBarUtil scrollBarUtil =new ScrollBarUtil();
    private MainPage mainPage = new MainPage();
    JavascriptExecutor js = (JavascriptExecutor) driver;
    static {
        DOMConfigurator.configure("log4j.xml");
    }
    @DataProvider(name = "senderaddressCreatWords")
    public static Object[][] words(){
        return new Object[][]{{"wanglingyue@youedata.com","smtp.youedata.com","asdfASDF02","asdfASDF02"}};
    }
    @Test
    public void test_Senderaddress () throws Exception {
        driver.get(LoginPage);
        login(driver, "alanruo","123456");
        assertString(driver,"退出");
        LogUtil.info("登陆成功...");
        driver.get(Messageservice_Main);
        LogUtil.info("进入通信服务总览页面...");
        Thread.sleep(1000);
        scrolltoBottom(driver);
        LogUtil.info("滚动条滚动到页面底部...");
        email(driver).click();
        sleep(2000);
        senderBtn(driver).click();
        sendercerateBtn(driver).click();
    }
}