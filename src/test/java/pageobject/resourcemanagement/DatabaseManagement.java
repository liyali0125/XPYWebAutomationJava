/*
 * @FileName StoreManagement: 封装数据库管理总览页面对象
 * @author davieyang
 * @create 2018-08-08 11:12
 */
package pageobject.resourcemanagement;
import util.GetElementUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static constants.Constants.DatabaseManagement_Property;
import static util.JavaScriptToDo.highLightElement;

public class DatabaseManagement {
    private static WebElement element = null;
    /**
     *指定页面元素定位表达式配置文件的绝对路径
     */
    private static GetElementUtil getElementUtil = new GetElementUtil(DatabaseManagement_Property);
    protected WebDriver driver;
    public DatabaseManagement(WebDriver driver){
        this.driver = driver;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @return 返回数据库服务总览页面中Mysql数据库服务“立即使用”按钮页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement mysql(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("pass.databasemanagement.mysql"));
        highLightElement(driver, element);
        return element;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @return 返回数据库服务总览页面中MongoDB数据库服务“立即使用”按钮页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement mongodb(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("pass.databasemanagement.mongodb"));
        highLightElement(driver, element);
        return element;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @return 返回数据库服务总览页面中Redis缓存服务“立即使用”按钮页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement redis(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("pass.databasemanagement.redis"));
        highLightElement(driver, element);
        return element;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @return 返回数据库服务总览页面中ElasticSearch服务“立即使用”按钮页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement elasticsearch(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("pass.databasemanagement.elasticsearch"));
        highLightElement(driver, element);
        return element;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @return 返回数据库服务总览页面中neo4j服务“立即使用”按钮页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement neo4j(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.databasemanagement.neo4j"));
        highLightElement(driver, element);
        return element;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @return 返回数据库服务总览页面中postgreSQL服务“立即使用”按钮页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement postgreSQL(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.databasemanagement.postgresql"));
        highLightElement(driver, element);
        return element;
    }
}
