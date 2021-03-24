/*
 * @FileName PostGreSQLService: 封装PostGreSQL相关通用操作
 * @author davieyang
 * @create 2018-08-31 11:05
 */
package appmodule;

import util.LogUtil;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;

import static appmodule.MainPage.login;
import static pageobject.resourcemanagement.DatabaseManagement.postgreSQL;
import static constants.Constants.Database_Main;
import static util.WaitElementUtil.sleep;

public class PostGreSQLService {
    static {
        //指定log4j配置文件为log4j.xml
        DOMConfigurator.configure("log4j.xml");
    }
    public static void linkToPostgreSQLPage(WebDriver driver, String username, String password)throws Exception{
        login(driver, username, password);
        sleep(3000);
        driver.get(Database_Main);
        sleep(3000);
        LogUtil.info("进入数据库总览页面...");
        postgreSQL(driver).click();
        LogUtil.info("进入postGreSQL列表页面...");
    }

}
