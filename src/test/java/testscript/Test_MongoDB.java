/*
 * @FileName Test_MongoDB: The script of testing MongoDB
 * @author davieyang
 * @create 2018-09-10 13:44
 */
package testscript;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.KeyActionsUtil;

import static appmodule.MongoDBService.linkToMongoDBPage;
import static pageobject.resourcemanagement.MongoDBService.*;
import static util.KeyActionsUtil.*;
import static util.WaitElementUtil.sleep;


public class Test_MongoDB {
    static {
        DOMConfigurator.configure("log4j.xml");
    }
    @BeforeClass
    public void setUp()throws Exception {
        WebDriver driver = KeyActionsUtil.initBrowser("chrome");
        linkToMongoDBPage(driver, "yangdawei", "alex005x");
        sleep(2000);
    }
    @Test(priority = 0, description = "创建单节点无持久化MongoDB服务实例")
    public void testCreateMongoDBService() throws Exception {
        refresh_Button(driver).click();
        create_New_Instance_Button(driver).click();
        search_Instance_Name_Button(driver).click();
        search_Space_Name(driver).click();
        operation_Button(driver).click();
        operation_Restart_Button(driver).click();
        operation_Release_Button(driver).click();
        operation_Log_Button(driver).click();
        operation_Monitor_Button(driver).click();
        System.out.println("MongoDB MongoDB MongoDB");
    }
    @Test(priority = 1, description = "重启MongoDB服务")
    public void testRestartMongoDBService(){

    }
    @Test(priority = 2, description = "释放MongoDB服务")
    public void testReleaseMongoDBService(){

    }
    @Test(priority = 3, description = "管理MongoDB服务")
    public void testManageMongoDBService(){

    }
    @Test(priority = 1, description = "查看MongoDB日志")
    public void testReviewLog(){

    }
    @Test(priority = 1, description = "查看MongoDB监控")
    public void testMonitorMongoDBService(){

    }

    @AfterClass
    public void tearDown() {
    }
}