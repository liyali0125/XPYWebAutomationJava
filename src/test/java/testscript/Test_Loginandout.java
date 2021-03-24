package testscript;
import appmodule.MainPage;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import util.LogUtil;

import static appmodule.MainPage.login;
import static util.KeyActionsUtil.*;
import static util.WaitElementUtil.sleep;


public class Test_Loginandout {
    private WebDriver driver = initBrowser("chrome");
    private MainPage mainPage = new MainPage();
    static {
        //指定log4j配置文件为log4j.xml
        DOMConfigurator.configure("log4j.xml");
    }
    @Test
    public void test_Login_Logout() throws Exception {
        try{
            login(driver, "yangdawei","111111");
            sleep(3000);
            assertString(driver,"退出");
            LogUtil.info("登陆成功");
            mainPage.logout(driver);
            sleep(3000);
            LogUtil.info("退出成功");
            assertString(driver,"登录控制台");
            closeBrowser(driver);
        }catch (Exception e){
            LogUtil.info("登陆和退出测试不通过");
        }
    }
}

