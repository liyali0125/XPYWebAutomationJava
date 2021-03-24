package testscript;
import util.TestReport;
import org.testng.Assert;
import org.testng.Reporter;
import util.KeyActionsUtil;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import static pageobject.resourcemanagement.SpaceManagement.*;
import static util.KeyActionsUtil.*;
import static appmodule.SpaceManagement.linkToSpaceManagementPage;
import static util.LogUtil.info;
import static util.WaitElementUtil.sleep;

@Listeners({TestReport.class})
public class Test_SpaceManagement {
    static {
        //指定log4j配置文件为log4j.xml
        DOMConfigurator.configure("log4j.xml");
    }
    @BeforeMethod
    public void setUp()throws Exception{
        WebDriver driver = KeyActionsUtil.initBrowser("chrome");
        linkToSpaceManagementPage(driver, "yangdawei","alex005x");

    }
    @Test(priority = 0, description = "测试创建空间")
    public void test_CreateSpace()throws Exception {
        Reporter.log("创建名为testspace的空间");
        create_Space_Button(driver).click();
        info("点击创建空间按钮...");
        sleep(2000);
        space_Name_in_Create_Space_Dialog(driver).sendKeys("testspace");
        info("输入新空间名称...");
        sleep(1000);
        expiration_Date_in_Create_Space_Dialog(driver).click();
        sleep(2000);
        three_Month_in_Create_Space_Dialog(driver).click();
        cpu_in_Create_Space_Dailog(driver).clear();
        cpu_in_Create_Space_Dailog(driver).sendKeys("2");
        info("输入CPU大小...");
        memory_in_Create_Space_Dialog(driver).clear();
        memory_in_Create_Space_Dialog(driver).sendKeys("1");
        info("输入内存大小...");
        sleep(2000);
        submit_Button_in_Create_Space_Dialog(driver).click();
        info("点击保存按钮...");
        sleep(3000);
        info("等待10秒，断言...");
        Assert.assertTrue(driver.getPageSource().contains("testspace"));
        // assertString(driver, "释放");
        info("断言新空间名....");
    }
    @Test(priority = 1, description = "测试配置空间")
    public void test_ConfigSpace() throws Exception{
        Reporter.log("配置空间");
        configSpace_Button(driver).click();
        info("点击配置空间按钮...");
        sleep(3000);
        cpu_in_Config_Space_Dialog(driver).sendKeys(Keys.BACK_SPACE);
        cpu_in_Config_Space_Dialog(driver).sendKeys("5");
        sleep(3000);
        memory_in_Config_Space_Dialog(driver).sendKeys(Keys.BACK_SPACE);
        memory_in_Config_Space_Dialog(driver).sendKeys("5");
        sleep(3000);
        submit_Button_in_Config_Space_Dialog(driver).click();
        sleep(10000);
        assertString(driver,"成功");
        info("断言修改配额成功");
    }
    @Test(priority = 2, description = "测试释放空间")
    public void test_DeleteSpace() throws Exception {
        Reporter.log("释放空间");
        release_Button(driver).click();
        info("点击释放按钮...");
        sleep(2000);
        release_Confirm_Button(driver).sendKeys(Keys.ENTER);
        info("点击确认...");
        sleep(10000);
        assertString(driver,"释放成功");
        info("断言释放成功...");
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
