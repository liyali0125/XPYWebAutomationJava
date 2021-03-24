/*
 * @FileName TestCreateAccount_DPdemo: the scripts of creating account
 * @author davieyang
 * @create 2018-09-03 16:40
 */
package testscript;
import appmodule.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import pageobject.accountcenter.AccountCenter;
import util.KeyActionsUtil;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static appmodule.MainPage.login;
import static appmodule.MysqlService.linkToMysqlPage;
import static constants.Constants.MirrorStorage_Main;
import static pageobject.accountcenter.AccountCenter.*;
import static util.KeyActionsUtil.assertString;
import static util.KeyBoardUtil.pressDownKey;
import static util.KeyBoardUtil.pressEnterKey;
import static util.LogUtil.info;
import static util.WaitElementUtil.sleep;

public class Demo_How_to_use_testNG {
    public WebDriver driver = KeyActionsUtil.initBrowser("chrome");
    private AccountCenter accountCenter = new AccountCenter(driver);
    private MainPage mainPage = new MainPage();
    static {
        //指定log4j配置文件为log4j.xml
        DOMConfigurator.configure("log4j.xml");
    }
    @BeforeMethod
    public void beforeMethod() throws Exception {
        login(driver,"yangdawei", "alex005x");
        info("登陆系统...");
        driver.get(MirrorStorage_Main);
        sleep(3000);
        info("等待3秒...");

    }
    @DataProvider(name = "accountinfo")
    public static Object[][] words(){
        return new Object[][]{{"paasweb9","paaswebtest9@qq.com","15901281919"}};
    }
    @Test(dataProvider = "accountinfo")
    public void test_CreateAccount(String username, String email, String cellphone)throws Exception{
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
    @Test
    public void test_Table() throws Exception {
        linkToMysqlPage(driver, "yangdawei", "alex005x");
        sleep(5000);
        //获取表单，xpath是表单的定位
        WebElement tableElement=driver.findElement(By.xpath("//*[@id='app']/section/section/main/section/div[1]/div[3]/table"));
        //将表单的所有tr放进列表，每个tr是表单的一行，逐行遍历
        List<WebElement> rows=tableElement.findElements(By.tagName("tr"));
        for (int i = 0; i < rows.size(); i++) {
            //将表单的td放进list里，每个td是表单的一列，逐列遍历
            List<WebElement> cols=rows.get(i).findElements(By.tagName("td"));
            for (int j = 0; j < cols.size();) {
                String tdText = cols.get(j).getText();
                sleep(1000);
                System.out.println(tdText +"\t");
                //判断哪行哪列的内容包含字段"mysql01", 如果包含则进行操作
                if(tdText.contains("mysql01")){
                    System.out.println(i+1);
                    System.out.println(j+1);
                    int row = i + 1;
                    //点击mysql列表页面，最后一列的。。。按钮
                    WebElement dropdown = driver.findElement(By.xpath("//*[@id='app']/section/section/main/section/div[1]/div[3]/table/tbody/tr["+row+"]/td[6]/div/div/span"));
                    dropdown.click();
                }break;
            }
        }

    }
    @Test
    public void test_DownKey(){
        driver.findElement(By.xpath("//*[@id='app']/section/section/main/div[2]/div/div[3]/button")).click();
        sleep(3000);
        driver.findElement(By.xpath("//*[@id='imageForm']/div[4]/div/div[1]/div[1]/input")).click();
        sleep(3000);
        driver.findElement(By.xpath("//*[@id='imageForm']/div[4]/div/div[1]/div[1]/input")).sendKeys("base/jre7");
        sleep(3000);
        pressDownKey();
        sleep(3000);
        pressEnterKey();
        sleep(3000);
    }
    @AfterClass
    public void afterClass(){
        driver.quit();
        info("关闭浏览器");
    }
}

