/*
 * @FileName accountcenter: Page objects of user center page
 * @author davieyang
 * @create 2018-09-03 16:56
 */
package pageobject.accountcenter;
import util.GetElementUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static constants.Constants.AccountCenter_Property;

public class AccountCenter {
    private static WebElement element = null;
    /**
     * 指定页面元素定位表达式配置文件的绝对路径
     */
    private static GetElementUtil getElementUtil = new GetElementUtil(AccountCenter_Property);
    private WebDriver driver;
    public AccountCenter(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return 返回账户中心“创建账户”按钮页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement createaccount(WebDriver driver) throws Exception {
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.AccountCenter.create"));
        return element;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return 返回账户中心“创建账户”按钮页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement newusername(WebDriver driver) throws Exception {
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.AccountCenter.username"));
        return element;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return 返回账户中心创建用户窗口“邮箱地址”输入框页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement emailaddress(WebDriver driver) throws Exception {
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.AccountCenter.emailaddress"));
        return element;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return 返回账户中心创建用户窗口“移动电话”输入框页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement cellphone(WebDriver driver) throws Exception {
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.AccountCenter.cellphone"));
        return element;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return 返回账户中心创建用户窗口“取消”按钮页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement cancelbutton(WebDriver driver) throws Exception {
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.AccountCenter.cancelbutton"));
        return element;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return 返回账户中心创建用户窗口“确定”按钮页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement surebutton(WebDriver driver) throws Exception {
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.AccountCenter.savebutton"));
        return element;
    }
}


