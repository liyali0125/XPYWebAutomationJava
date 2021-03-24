/*
 * @FileName Test_ElasticSearch: The script of testing elasticsearch
 * @author davieyang
 * @create 2018-09-10 13:43
 */
package testscript;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.apache.log4j.xml.DOMConfigurator;
import util.KeyActionsUtil;
import static pageobject.resourcemanagement.ElasticSearchService.*;
import static util.KeyActionsUtil.*;
import static appmodule.ElasticSearchService.linkToElasticSearchPage;
import static util.WaitElementUtil.sleep;


public class Test_ElasticSearch {
    static {
        DOMConfigurator.configure("log4j.xml");
    }
    @BeforeClass
    public void setUp()throws Exception {
        WebDriver driver = KeyActionsUtil.initBrowser("chrome");
        linkToElasticSearchPage(driver, "yangdawei", "alex005x");
        sleep(2000);
    }
    @Test(priority = 0, description = "创建ES服务实例")
    public void test_CreateElasticSearchService() throws Exception {
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
        outsideaccess_in_Create_Instance_Checkbox(driver).click();
        description_in_Create_Instance_Dialog(driver).sendKeys("create es servie");
        submit_Button_in_Create_Instance_Dialog(driver).click();

    }
    @Test(priority = 1, description = "重启ES服务实例")
    public void test_RestartElasticSearchService(){

    }
    @Test(priority = 2, description = "释放ES服务实例")
    public void test_ReleaseElasticSearchService(){

    }
    @Test(priority = 3, description = "管理ES服务实例")
    public void test_ManageElasticSearchService(){

    }
    @Test(priority = 4, description = "查看ES服务实例日志")
    public void test_ReviewLog(){

    }
    @Test(priority = 5, description = "查看ES服务实例监控")
    public void test_MonitorElasticSearchService(){
    }

    @AfterClass
    public void tearDown() {
    }
}