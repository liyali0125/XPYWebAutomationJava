package appmodule;
/*
 * @FileName StoreManagement: 封装ES相关通用操作
 * @author davieyang
 * @create 2018-08-08 11:12
 */
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;

import static appmodule.MainPage.login;
import static constants.Constants.Database_Main;
import static pageobject.resourcemanagement.DatabaseManagement.elasticsearch;
import static util.LogUtil.info;
import static util.WaitElementUtil.sleep;

public class ElasticSearchService {
    ElasticSearchService elasticSearchService = new ElasticSearchService();
    static {
        //制定log配置文件
        DOMConfigurator.configure("log4j.xml");
    }
    public static void linkToElasticSearchPage(WebDriver driver, String username, String password)throws Exception{
        login(driver,username,password);
        sleep(3000);
        driver.get(Database_Main);
        info("进入数据库总览页面...");
        elasticsearch(driver).click();
        info("点击Es Panel中的立即使用...");
    }
}
