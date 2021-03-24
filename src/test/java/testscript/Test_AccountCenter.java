/*
 * @FileName Test_AccountCenter: The test  script of account center
 * @author davieyang
 * @create 2018-09-03 17:34
 */
package testscript;
import appmodule.MainPage;
import org.testng.annotations.*;
import pageobject.accountcenter.AccountCenter;
import util.KeyActionsUtil;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;

import static constants.Constants.AccountCenter_Main;
import static pageobject.accountcenter.AccountCenter.*;
import static util.KeyActionsUtil.assertString;
import static util.LogUtil.info;
import static util.WaitElementUtil.sleep;

public class Test_AccountCenter {
    public WebDriver driver = KeyActionsUtil.initBrowser("chrome");
    private AccountCenter accountCenter = new AccountCenter(driver);
    private MainPage mainPage = new MainPage();
    static {
        //指定log4j配置文件为log4j.xml
        DOMConfigurator.configure("log4j.xml");
    }
    @BeforeMethod
    public void beforeMethod() throws Exception {
        mainPage.login(driver,"yangdawei", "alex005x");

    }
    @DataProvider(name = "accountinfo")
    public static Object[][] words(){
        return new Object[][]{{"paasweb9","paaswebtest9@qq.com","15901281919"}};
    }
    @Test(dataProvider = "accountinfo")
    public void test_CreateAccount(String username, String email, String cellphone)throws Exception{
        driver.get(AccountCenter_Main);
        sleep(3000);
        createaccount(driver).click();
        info("点击创建账户按钮");
        newusername(driver).sendKeys(username);
        info("输入用户名");
        emailaddress(driver).sendKeys(email);
        info("输入邮箱");
        cellphone(driver).sendKeys(cellphone);
        info("输入移动电话号码");
        surebutton(driver).click();
        info("点击确定按钮");
        sleep(3000);
        assertString(driver, "paasweb9");
    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
