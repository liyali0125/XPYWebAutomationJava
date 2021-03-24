/*
 * @FileName StoreManagement: 封装Kafka页面对象
 * @author davieyang
 * @create 2018-08-08 11:12
 */
package pageobject.resourcemanagement;
import util.GetElementUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static constants.Constants.CommunicationServiceManagement_Property;

public class KafkaService {
    private static WebElement element = null;
    /**
     * 指定页面元素定位表达式配置文件的绝对路径
     */
    private static GetElementUtil getElementUtil = new GetElementUtil(CommunicationServiceManagement_Property);
    private WebDriver driver;
    public KafkaService(WebDriver driver){
        this.driver = driver;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @return 返回Kafka服务页面“刷新”按钮的页面元素对象
     * @throws Exception 获取页面元素定位失败
     */
    public static WebElement refreshbutton(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.kafkaservice.refreshbutton"));
        return element;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @return 返回Kafka服务页面“创建实例”按钮的页面元素对象
     * @throws Exception 获取页面元素定位失败
     */
    public static WebElement newinstance(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.kafkaservice.newinstance"));
        return element;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @return 返回Kafka服务页面Kafka名称检索控件的页面元素对象
     * @throws Exception 获取页面元素定位失败
     */
    public static WebElement searchkafkaname(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.kafkaservice.searchkafkaname"));
        return element;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @return 返回Kafka服务页面运行空间检索控件的页面元素对象
     * @throws Exception 获取页面元素定位失败
     */
    public static WebElement searchspacename(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.kafkaservice.searchspacename"));
        return element;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @return 返回Kafka服务页面操作列“。。。”按钮的页面元素对象
     * @throws Exception 获取页面元素定位失败
     */
    public static WebElement operation(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.kafkaservice.operation"));
        return element;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @return 返回Kafka服务页面操作列“。。。”里下拉列表里的“重启”按钮的页面元素对象
     * @throws Exception 获取页面元素定位失败
     */
    public static WebElement operationrestart(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.kafkaservice.operationrestart"));
        return element;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @return 返回Kafka服务页面操作列“。。。”里下拉列表里的“释放”按钮的页面元素对象
     * @throws Exception 获取页面元素定位失败
     */
    public static WebElement operationrelease(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.kafkaservice.operationrelease"));
        return element;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @return 返回Kafka服务页面操作列“。。。”里下拉列表里的“管理”按钮的页面元素对象
     * @throws Exception 获取页面元素定位失败
     */
    public static WebElement operationmanage(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.kafkaservice.operationmanage"));
        return element;
    }
}
