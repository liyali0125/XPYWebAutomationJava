/*
 * @FileName StoreManagement: 封装通讯服务管理总览页面对象
 * @author davieyang
 * @create 2018-08-08 11:12
 */
package pageobject.resourcemanagement;
import util.GetElementUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static constants.Constants.CommunicationServiceManagement_Property;
import static util.JavaScriptToDo.highLightElement;

public class CommunicationManagement {
    private static WebElement element = null;
    /**
     * 指定页面元素定位表达式配置文件的绝对路径
     */
    private static GetElementUtil getElementUtil = new GetElementUtil(CommunicationServiceManagement_Property);
    private WebDriver driver;
    public CommunicationManagement(WebDriver driver){
        this.driver = driver;
    }

    /**
     *
     * @param driver：浏览器驱动
     * @return 返回通信服务总览页面中Kafka服务“立即使用”按钮页面元素对象
     * @throws Exception 获取元素定位信息失败
     */
    public static WebElement kafkaservice(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.communicationmanagement.kafkaservice"));
        highLightElement(driver, element);
        return element;
    }

    /**
     *
     * @param driver：浏览器驱动
     * @return 返回通信服务总览页面中sms服务“立即使用”按钮页面元素对象
     * @throws Exception 获取元素定位信息失败
     */
    public static WebElement sms(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.communicationmanagement.sms"));
        highLightElement(driver, element);
        return element;
    }

    /**
     *
     * @param driver：浏览器驱动
     * @return 返回通信服务总览页面中email服务“立即使用”按钮页面元素对象
     * @throws Exception 获取元素定位信息失败
     */
    public static WebElement email(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.communicationmanagement.email"));
        highLightElement(driver, element);
        return element;
    }
}
