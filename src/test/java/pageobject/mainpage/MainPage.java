
/*
 * @FileName LogCenter: 封装主页页面对象
 * @outhor davieyang
 * @create 2018-08-08 11:06
 */
package pageobject.mainpage;
import util.GetElementUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static constants.Constants.MainPageandNavigation_Property;
import static util.JavaScriptToDo.highLightElement;

public class MainPage {
    private static WebElement element = null;
    /**
     * 指定页面元素定位表达式配置文件的绝对路径
     */
    private static GetElementUtil getElementUtil = new GetElementUtil(MainPageandNavigation_Property);
    private WebDriver driver;
    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @return 返回控制台链接页面元素
     * @throws Exception 获取定位信息失败
     */
    public static WebElement controller(WebDriver driver) throws Exception {
        element = driver.findElement(getElementUtil.getLocator("paas.landPage.controller"));
        highLightElement(driver, element);
        return element;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @return 返回页面右上角个人信息链接页面元素
     * @throws Exception 获取定位信息失败
     */
    public WebElement personalinfo(WebDriver driver) throws Exception{
        element = driver.findElement(getElementUtil.getLocator("paas.personalinfo.userlink"));
        highLightElement(driver, element);
        return element;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return 返回页面中“首页”菜单页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public WebElement main(WebDriver driver) throws Exception{
        //调用ObjectMap中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.navigation.main"));
        highLightElement(driver, element);
        return element;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return 返回页面中“资源管理”菜单页面元素
     * @throws Exception 获取定位信息失败
     */
    public WebElement resouces(WebDriver driver) throws Exception{
        element = driver.findElement(getElementUtil.getLocator("paas.navigation.resources"));
        highLightElement(driver, element);
        return element;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return 返回页面中“数据市场”菜单页面元素
     * @throws Exception 获取定位信息失败
     */
    public WebElement datamarket(WebDriver driver) throws Exception{
        element = driver.findElement(getElementUtil.getLocator("paas.navigation.datamarket"));
        highLightElement(driver, element);
        return element;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return 返回页面中“能力矩阵”菜单页面元素
     * @throws Exception 获取定位信息失败
     */
    public WebElement abilitymatrix(WebDriver driver) throws Exception{
        element = driver.findElement(getElementUtil.getLocator("paas.navigation.abilitymatrix"));
        highLightElement(driver, element);
        return element;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return 返回页面中“应用管理”菜单页面元素
     * @throws Exception 获取定位信息失败
     */
    public WebElement applicationmanagement(WebDriver driver) throws Exception{
        element = driver.findElement(getElementUtil.getLocator("paas.navigation.applicationmanagement"));
        highLightElement(driver, element);
        return element;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return 返回页面中“日志监控”菜单页面元素
     * @throws Exception 获取定位信息失败
     */
    public WebElement logmonitor(WebDriver driver) throws Exception{
        element = driver.findElement(getElementUtil.getLocator("paas.navigation.logmonitor"));
        highLightElement(driver, element);
        return element;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return 返回页面中“账户中心”菜单页面元素
     * @throws Exception 获取定位信息失败
     */
    public WebElement userscenter(WebDriver driver) throws Exception{
        element = driver.findElement(getElementUtil.getLocator("paas.navigation.userscenter"));
        highLightElement(driver, element);
        return element;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return 返回页面中二级导航-资源管理“空间管理”菜单页面元素
     * @throws Exception 获取定位信息失败
     */
    public WebElement spacemanagement(WebDriver driver) throws Exception{
        element = driver.findElement(getElementUtil.getLocator("paas.resources.spacemanagement"));
        highLightElement(driver, element);
        return element;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return 返回页面中二级导航-资源管理“数据库管理”菜单页面元素
     * @throws Exception 获取定位信息失败
     */
    public WebElement databasemanagement(WebDriver driver) throws Exception{
        element = driver.findElement(getElementUtil.getLocator("paas.resources.databasemanagement"));
        highLightElement(driver, element);
        return element;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return 返回页面中二级导航-资源管理“存储管理”菜单页面元素
     * @throws Exception 获取定位信息失败
     */
    public WebElement storemanagement(WebDriver driver) throws Exception{
        element = driver.findElement(getElementUtil.getLocator("paas.resources.storemanagement"));
        highLightElement(driver, element);
        return element;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return 返回页面中二级导航-资源管理“通信服务管理”菜单页面元素
     * @throws Exception 获取定位信息失败
     */
    public WebElement communicationmanagement(WebDriver driver) throws Exception{
        element = driver.findElement(getElementUtil.getLocator("paas.resources.communicationmanagement"));
        highLightElement(driver, element);
        return element;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return 返回页面中二级导航-数据市场“数据接口”菜单页面元素
     * @throws Exception 获取定位信息失败
     */
    public WebElement datainterface(WebDriver driver) throws Exception{
        element = driver.findElement(getElementUtil.getLocator("paas.datamarket.datainterface"));
        highLightElement(driver, element);
        return element;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return 返回页面中二级导航-数据市场“数据文件”菜单页面元素
     * @throws Exception 获取定位信息失败
     */
    public WebElement datafile(WebDriver driver) throws Exception{
        element = driver.findElement(getElementUtil.getLocator("paas.datamarket.datafile"));
        highLightElement(driver, element);
        return element;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return 返回页面中二级导航-数据市场“数据管道”菜单页面元素
     * @throws Exception 获取定位信息失败
     */
    public WebElement datapip(WebDriver driver) throws Exception{
        element = driver.findElement(getElementUtil.getLocator("paas.datamarket.datapip"));
        highLightElement(driver, element);
        return element;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return 返回页面中二级导航-能力矩阵“API管理”菜单页面元素
     * @throws Exception 获取定位信息失败
     */
    public WebElement APImanagement(WebDriver driver) throws Exception{
        element = driver.findElement(getElementUtil.getLocator("paas.abilitymatrix.APImanagement"));
        highLightElement(driver, element);
        return element;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @return 返回页面中二级导航-应用管理“镜像仓库”菜单页面元素
     * @throws Exception 获取定位信息失败
     */
    public WebElement mirrorstore(WebDriver driver) throws Exception{
        element = driver.findElement(getElementUtil.getLocator("paas.applicationmanagement.mirrorstore"));
        highLightElement(driver, element);
        return element;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @return 返回页面中二级导航-应用管理“应用仓库”菜单页面元素
     * @throws Exception 获取定位信息失败
     */
    public WebElement applicationstore(WebDriver driver) throws Exception{
        element = driver.findElement(getElementUtil.getLocator("paas.applicationmanagement.applicationstore"));
        highLightElement(driver, element);
        return element;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @return 返回页面中二级导航-日志监控“日志中心”菜单页面元素
     * @throws Exception 获取定位信息失败
     */
    public WebElement logcenter(WebDriver driver) throws Exception{
        element = driver.findElement(getElementUtil.getLocator("paas.logmonitor.logcenter"));
        highLightElement(driver, element);
        return element;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @return 返回页面中二级导航-日志监控“监控中心”菜单页面元素
     * @throws Exception 获取定位信息失败
     */
    public WebElement monitorcenter(WebDriver driver) throws Exception{
        element = driver.findElement(getElementUtil.getLocator("paas.logmonitor.monitorcenter"));
        highLightElement(driver, element);
        return element;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @return 返回页面一级导航-租户管理菜单页面元素
     * @throws Exception 获取定位信息失败
     */
    public WebElement tenantmanagement(WebDriver driver) throws Exception{
        element = driver.findElement(getElementUtil.getLocator("paas.navigation.tenantmanagement"));
        highLightElement(driver, element);
        return element;
    }
}
