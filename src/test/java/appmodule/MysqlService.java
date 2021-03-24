package appmodule;
/*
 * @FileName StoreManagement: 封装Mysql相关通用操作
 * @author davieyang
 * @create 2018-08-08 11:12
 */
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;

import static appmodule.MainPage.login;
import static pageobject.resourcemanagement.DatabaseManagement.mysql;
import static constants.Constants.Database_Main;
import static util.LogUtil.info;
import static util.WaitElementUtil.sleep;


public class MysqlService {
    static {
        //制定log配置文件
        DOMConfigurator.configure("log4j.xml");
    }
    public static void linkToMysqlPage(WebDriver driver, String username, String password) throws Exception {
        login(driver, username, password);
        sleep(1000);
        driver.get(Database_Main);
        sleep(1000);
        mysql(driver).click();
        info("点击Mysql panel中的立即使用按钮...");
    }
}
