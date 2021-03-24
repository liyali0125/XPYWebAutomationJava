/*
 * @FileName Test_Neo4j: The script of testing Neo4j
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
import static appmodule.Neo4jService.linkToNeo4jPage;
import static pageobject.resourcemanagement.Neo4jService.*;
import static util.WaitElementUtil.sleep;


public class Test_Neo4j {
    static {
        DOMConfigurator.configure("log4j.xml");
    }
    @BeforeClass
    public void setUp()throws Exception {
        WebDriver driver = KeyActionsUtil.initBrowser("chrome");
        linkToNeo4jPage(driver, "yangdawei", "alex005x");
        sleep(2000);
    }
    @Test(priority = 0, description = "创建单节点无持久化Neo4j服务实例")
    public void testCreateNeo4jService() throws Exception {
        refresh_Button(driver).click();
        create_New_Instance_Button(driver).click();
        search_Instance_Name_Button(driver).click();
        search_Space_Name(driver).click();
        operation_Button(driver).click();
        operation_Restart_Button(driver).click();
        operation_Release_Button(driver).click();
        operation_Log_Button(driver).click();
        operation_Monitor_Button(driver).click();
        System.out.println("Neo4j Neo4j Neo4j");
    }
    @Test(priority = 1, description = "重启Neo4j服务")
    public void testRestartNeo4jService(){

    }
    @Test(priority = 2, description = "释放Neo4j服务")
    public void testReleaseNeo4jService(){

    }
    @Test(priority = 3, description = "管理Neo4j服务")
    public void testManageNeo4jService(){

    }
    @Test(priority = 1, description = "查看Neo4j日志")
    public void testReviewLog(){

    }
    @Test(priority = 1, description = "查看Neo4j监控")
    public void testMonitorNeo4jService(){

    }

    @AfterClass
    public void tearDown() {
    }
}