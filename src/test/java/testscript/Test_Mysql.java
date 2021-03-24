package testscript;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;
import util.KeyActionsUtil;
import static util.KeyActionsUtil.*;
import java.util.List;
import static appmodule.MysqlService.linkToMysqlPage;
import static util.KeyBoardUtil.pressTabKey;
import static util.LogUtil.info;
import static pageobject.resourcemanagement.MySQLService.*;
import static util.ScrollBarUtil.scrolltoBottom;
import static util.WaitElementUtil.sleep;
// @Listeners({util.TestReport.class})
public class Test_Mysql {

    static {
        DOMConfigurator.configure("log4j.xml");
    }
    @BeforeClass
    public void setUp()throws Exception {
        WebDriver driver = KeyActionsUtil.initBrowser("chrome");
        linkToMysqlPage(driver, "yangdawei", "alex005x");
        sleep(2000);
    }

    @Test(priority = 0, description = "测试创建mysql数据库服务1CPU2G")
    public void test_CreateMysqlInstance() throws Exception {
        create_New_Instance_Button(driver).click();
        info("点击创建实例按钮...");
        sleep(1000);
        info("等待3秒...");
        instance_Name_in_Create_Instance_Dialog(driver).sendKeys("automationtest");
        info("输入实例名：automationtesta");
        sleep(1000);
        info("等待3秒...");
        //页面存在相同属性的元素，取所有放到list里，用序号操作
        List<WebElement> radios = driver.findElements(By.className("el-radio-button__inner"));
        radios.get(1).click();
        sleep(1000);
        info("选择数据库版本5.7...");
        instance_Standard_in_Create_Instance_Dialog(driver).click();
        info("点击实例规格...");
        sleep(2000);
        info("等待2秒...");
        one_Core_two_GB(driver).click();
        info("选择1CPU2GB...");
        storage_Space_in_Create_Instance_Dialog(driver).clear();
        info("清空存储空间字段...");
        storage_Space_in_Create_Instance_Dialog(driver).sendKeys("1");
        info("输入1G....");
        scrolltoBottom(driver);
        sleep(2000);
        pressTabKey();
        outsideaccess_Checkbox_in_Create_Instance_Dialog(driver).click();
        info("选择外部链接...");
        password_in_Create_Instance_Dialog(driver).sendKeys("111111");
        info("输入密码111111...");
        repassword_in_Create_Instance_Dialog(driver).sendKeys("111111");
        info("确认密码111111...");
        description_in_Create_Instance_Dialog(driver).sendKeys("automationtest");
        info("描述信息输入automationtest");
        sleep(2000);
        submit_Button_in_Create_Instance_Dialog(driver).sendKeys(Keys.ENTER);
        info("确认创建...");
        sleep(2000);
        refresh_Button(driver).click();
        Assert.assertTrue(driver.getPageSource().contains("automationtest"));
        Assert.assertTrue(driver.getPageSource().contains("创建中"));
    }
    @Test(priority = 1, description = "重启mysql服务")
    public void test_RestartMysqlInstance()throws Exception {
        operation_Button(driver).click();
        info("点击列表里最后一列的...");
        sleep(2000);
        info("等待3秒...");
        operation_Restart_Button(driver).click();
        info("点击下拉菜单中的重启按钮...");
        sleep(2000);
        info("等待3秒...");
        restart_Confirm_Button(driver).click();
        info("点击确定按钮...");
        sleep(2000);
        info("等待3秒...");
        Assert.assertTrue(driver.getPageSource().contains("重启请求成功"));
        Assert.assertTrue(driver.getPageSource().contains("重启中"));
    }

    @Test(priority = 2, description = "管理mysql服务页面")
    public void test_Review_Basic_Mysql_Info()throws Exception{
        operation_Button(driver).click();
        info("点击列表里最后一列的...");
        sleep(2000);
        info("等待3秒...");
        operation_Manage_Button(driver).click();
        info("点击下拉菜单里的管理按钮...");
        sleep(2000);
        info("等待三秒");
        assertString(driver,"基本信息");
    }
    @Test(priority = 3, description = "管理mysql服务页面")
    public void test_Review_Mysql_Link()throws Exception{
        database_Link_Tab(driver).click();
        sleep(2000);
        Assert.assertTrue(driver.getPageSource().contains("210.13.50.105"));
    }

    @Test(priority = 4,description = "查看Mysql日志")
    public void test_ReviewLog()throws Exception{
        operation_Button(driver).click();
        info("点击列表里最后一列的...");
        sleep(2000);
        info("等待3秒...");
        operation_Log_Button(driver).click();
        info("点击下拉菜单中的日志按钮...");
        sleep(2000);
        info("等待3秒...");
        extend_Button_in_Log_Page(driver).click();
        info("点击展开按钮...");
        sleep(2000);
        info("等待3秒...");
        datefrom_in_Log_Page(driver).click();
        info("点击第一个日期空间，弹出下拉...");
        sleep(2000);
        info("等待3秒...");
        datefrom_by_Date_in_Log_Page(driver).clear();
        datefrom_by_Date_in_Log_Page(driver).sendKeys("2018-09-01");
        info("输入日期”2018-09-01");
        sleep(2000);
        info("等待3秒...");
        datefrom_Sure_Button_in_Log_Page(driver).click();
        info("点击确定按钮...");
        sleep(2000);
        info("等待3秒...");
        search_Button_in_Log_Page(driver).click();
        info("点击筛选按钮...");
        sleep(2000);
        info("等待3秒...");
        Assert.assertTrue(driver.getPageSource().contains("Initializing database"));

    }

    @Test(priority = 5, description = "查看Mysql服务监控")
    public void test_MonitorMysqlService()throws Exception{
        operation_Button(driver).click();
        info("点击列表里最后一列的...");
        sleep(3000);
        info("等待3秒...");
        operation_Monitor_Button(driver).click();
        info("点击下拉菜单里的监控按钮...");
        sleep(3000);
        info("等待3秒...");
    }

    @Test(priority = 6, description = "释放mysql服务")
    public void test_ReleaseMysqlService()throws Exception{
        operation_Button(driver).click();
        info("点击列表里最后一列的...");
        sleep(3000);
        info("等待3秒...");
        operation_Release_Button(driver).click();
        info("点击下拉菜单里的释放按钮...");
        sleep(3000);
        info("等待3秒...");
        release_Confirm_Button(driver).click();
        info("点击确定按钮...");
        sleep(3000);
        info("等待3秒...");
        Assert.assertTrue(driver.getPageSource().contains("操作成功"));
        Assert.assertTrue(driver.getPageSource().contains("删除中"));
    }

    @AfterClass
    public void afterMethod(){
        driver.quit();
    }
}
