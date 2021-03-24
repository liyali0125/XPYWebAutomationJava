package appmodule;
/*
 * @FileName StoreManagement: 封装MongoDB相关通用操作
 * @author davieyang
 * @create 2018-08-08 11:12
 */
import util.LogUtil;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;

import static appmodule.MainPage.login;
import static pageobject.resourcemanagement.DatabaseManagement.mongodb;
import static constants.Constants.Database_Main;
import static util.WaitElementUtil.sleep;


public class MongoDBService {
    static {
        //制定log配置文件
        DOMConfigurator.configure("log4j.xml");
    }
    public static void linkToMongoDBPage(WebDriver driver,String username, String password)throws Exception{
        login(driver, username, password);
        sleep(3000);
        driver.get(Database_Main);
        LogUtil.info("进入数据库总览页面...");
        mongodb(driver).click();
        LogUtil.info("点击MongoDB panel中的立即使用...");
    }
}
