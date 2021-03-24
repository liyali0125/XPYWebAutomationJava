
/*
 * @FileName LogCenter: 封装登陆页页面对象
 * @outhor davieyang
 * @create 2018-08-08 11:06
 */
package pageobject.mainpage;
import util.GetElementUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.*;

import static constants.Constants.MainPageandNavigation_Property;
import static util.JavaScriptToDo.highLightElement;

public class LoginPage {
    private static WebElement element = null;
    /**
     * 指定页面元素定位表达式配置文件的绝对路径
     */
    private static GetElementUtil getElementUtil = new GetElementUtil(MainPageandNavigation_Property);
    private WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return 返回登陆页面中的用户名输入框页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement userName(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.loginPage.username"));
        highLightElement(driver, element);
        return element;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return 返回登陆页面中的密码输入框页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement password(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于密码的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.loginPage.password"));
        highLightElement(driver, element);
        return element;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return 返回登陆页面中的用户名输入框页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement loginButton(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于登陆按钮的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.loginPage.loginbutton"));
        return element;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return 返回登陆成功后推出按钮元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement logoutButton(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置关于退出按钮的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("pass.loginPage.logoutbutton"));
        return element;
    }
}
