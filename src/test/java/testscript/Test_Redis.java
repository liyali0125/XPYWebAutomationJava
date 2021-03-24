/*
 * @FileName Test_Redis: The script of testing redis
 * @author davieyang
 * @create 2018-09-10 13:44
 */
package testscript;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.apache.log4j.xml.DOMConfigurator;
import util.KeyActionsUtil;

import static pageobject.resourcemanagement.RedisService.*;
import static util.KeyActionsUtil.*;
import static appmodule.RedisService.linkToRedisPage;
import static util.WaitElementUtil.sleep;


public class Test_Redis {
    static {
        DOMConfigurator.configure("log4j.xml");
    }
    @BeforeClass
    public void setUp()throws Exception {
        WebDriver driver = KeyActionsUtil.initBrowser("chrome");
        linkToRedisPage(driver, "yangdawei", "alex005x");
        sleep(2000);
    }
    @Test(priority = 0, description = "创建单节点无持久化Redis服务实例")
    public void testCreateRedisService() throws Exception {
        refresh_Button(driver).click();
        create_New_Instance_Button(driver).click();
        search_Instance_Name_Button(driver).click();
        search_Space_Name(driver).click();
        operation_Button(driver).click();
        operation_Restart_Button(driver).click();
        operation_Release_Button(driver).click();
        operation_Log_Button(driver).click();
        operation_Monitor_Button(driver).click();
        instance_Name_in_Create_Instance_Dialog(driver).click();
        storage_Space_in_Create_Instance_Dialog(driver).click();
        single_Noed_No_Persistence(driver).click();
        outsideaccess_in_Create_Instance_Checkbox(driver).click();
        description_in_Create_Instance_Dialog(driver).sendKeys("create redis servie with onenodenopersistence");
        submit_Button_in_Create_Instance_Dialog(driver).click();
        System.out.println("redis redis redis");
    }
    @Test(priority = 1, description = "重启Redis服务")
    public void testRestartRedisService(){

    }
    @Test(priority = 2, description = "释放Redis服务")
    public void testReleaseRedisService(){

    }
    @Test(priority = 3, description = "管理Redis服务")
    public void testManageRedisService(){

    }
    @Test(priority = 1, description = "查看Redis日志")
    public void testReviewLog(){

    }
    @Test(priority = 1, description = "查看Redis监控")
    public void testMonitorRedisService(){

    }

    @AfterClass
    public void tearDown() {
    }
}