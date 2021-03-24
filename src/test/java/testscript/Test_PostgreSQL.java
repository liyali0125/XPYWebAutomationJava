/*
 * @FileName Test_PostgreSQL: The script of testing PostgreSQL
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
import static util.KeyActionsUtil.*;
import static appmodule.PostGreSQLService.linkToPostgreSQLPage;
import static pageobject.resourcemanagement.PostgreSQLService.*;
import static util.WaitElementUtil.sleep;


public class Test_PostgreSQL {
    static {
        DOMConfigurator.configure("log4j.xml");
    }
    @BeforeClass
    public void setUp()throws Exception {
        WebDriver driver = KeyActionsUtil.initBrowser("chrome");
        linkToPostgreSQLPage(driver, "yangdawei", "alex005x");
        sleep(2000);
    }
    @Test(priority = 0, description = "创建单节点无持久化PostgreSQL服务实例")
    public void testCreatePostgreSQLService() throws Exception {
        refresh_Button(driver).click();
        create_New_Instance_Button(driver).click();
        search_Instance_Name_Button(driver).click();
        search_Space_Name(driver).click();
        operation_Button(driver).click();
        operation_Restart_Button(driver).click();
        operation_Release_Button(driver).click();
        operation_Log_Button(driver).click();
        operation_Monitor_Button(driver).click();
        System.out.println("PostgreSQL PostgreSQL PostgreSQL");
    }
    @Test(priority = 1, description = "重启PostgreSQL服务")
    public void testRestartPostgreSQLService(){

    }
    @Test(priority = 2, description = "释放PostgreSQL服务")
    public void testReleasePostgreSQLService(){

    }
    @Test(priority = 3, description = "管理PostgreSQL服务")
    public void testManagePostgreSQLService(){

    }
    @Test(priority = 1, description = "查看PostgreSQL日志")
    public void testReviewLog(){

    }
    @Test(priority = 1, description = "查看PostgreSQL监控")
    public void testMonitorPostgreSQLService(){

    }

    @AfterClass
    public void tearDown() {
    }
}