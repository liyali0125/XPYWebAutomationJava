/*
 * @FileName StoreManagement: 封装redis页面对象
 * @author davieyang
 * @create 2018-08-08 11:12
 */
package pageobject.resourcemanagement;
import util.GetElementUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static constants.Constants.RedisService_Property;
import static util.JavaScriptToDo.highLightElement;

public class RedisService {
    private static WebElement element = null;
    /**
     * 指定页面元素定位表达式配置文件的绝对路径
     */
    private static GetElementUtil getElementUtil = new GetElementUtil(RedisService_Property);
    private WebDriver driver;
    public RedisService(WebDriver driver){
        this.driver = driver;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @return 返回Redis数据库服务页面“刷新”按钮的页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement refresh_Button(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.redis.refreshbutton"));
        return element;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @return 返回Redis数据库服务页面“创建实例”按钮的页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement create_New_Instance_Button(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.redis.createnewinstance"));
        return element;
    }
    /**
     *
     * @param driver 浏览器驱动
     * @return 返回Redis数据库服务页面Redis名称检索控件的页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement search_Instance_Name_Input(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.redis.searchinstancenameinput"));
        return element;
    }
    /**
     *
     * @param driver 浏览器驱动
     * @return 返回Redis数据库服务页面Redis名称检索控件的页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement search_Instance_Name_Button(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.redis.searchinstancenamebutton"));
        return element;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @return 返回Redis数据库服务页面运行空间检索控件页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement search_Space_Name(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.redis.searchspacename"));
        return element;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @return 返回Redis数据库服务页面操作列“。。。”按钮的页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement operation_Button(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.redis.operation"));
        return element;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @return 返回Redis数据库服务页面操作列“。。。”里下拉列表里的“重启”按钮的页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement operation_Restart_Button(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.redis.operationrestart"));
        return element;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @return 返回Redis数据库服务页面操作列“。。。”里下拉列表里的“释放”按钮的页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement operation_Release_Button(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.redis.operationrelease"));
        return element;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @return 返回Redis数据库服务页面操作列“。。。”里下拉列表里的“管理”按钮的页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement operation_Manage_Button(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.redis.operationmanage"));
        return element;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @return 返回Redis数据库服务页面操作列“。。。”里下拉列表里的“日志”按钮的页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement operation_Log_Button(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.redis.operationlog"));
        return element;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @return 返回Redis数据库服务页面操作列“。。。”里下拉列表里的“监控”按钮的页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement operation_Monitor_Button(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.redis.operationmonitor"));
        return element;
    }

    /**
     *
     * @param driver
     * @return
     * @throws Exception
     */
    public static WebElement release_Confirm_Button(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.redis.releaseconfirmbutton"));
        highLightElement(driver, element);
        return element;
    }
    /**
     *
     * @param driver 浏览器驱动
     * @return 返回确认按钮
     * @throws Exception 获取定位信息失败
     */
    public static WebElement restart_Confirm_Button(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.redis.confirmrestart"));
        highLightElement(driver, element);
        return element;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @return 返回取消按钮
     * @throws Exception 定位信息失败
     */
    public static WebElement restart_Cancel_Button(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.redis.cancelrestart"));
        highLightElement(driver, element);
        return element;
    }

    /**
     *
     * @param driver
     * @return
     * @throws Exception
     */
    public static WebElement release_Cancel_button(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.redis.releasecancelbutton"));
        highLightElement(driver, element);
        return element;
    }
    /**
     *
     * @param driver 浏览器驱动
     * @return 返回创建Redis窗口的“服务名”页面元素对象
     * @throws Exception 获取定位失败
     */
    public static WebElement instance_Name_in_Create_Instance_Dialog(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.createredisdialog.servicename"));
        return element;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @return 返回创建Redis窗口的“存储”页面元素对象
     * @throws Exception 获取定位失败
     */
    public static WebElement storage_Space_in_Create_Instance_Dialog(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.createredisdialog.store"));
        return element;
    }

    /**
     *
     * @param driver
     * @return
     * @throws Exception
     */
    public static WebElement single_Noed_No_Persistence(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.createredisdialog.nodetype1"));
        return element;
    }

    /**
     *
     * @param driver
     * @return
     * @throws Exception
     */
    public static WebElement one_Noed_With_Persistence(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.createredisdialog.nodetype2"));
        return element;
    }

    /**
     *
     * @param driver
     * @return
     * @throws Exception
     */
    public static WebElement Master_Slave_With_Persistence(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.createredisdialog.nodetype3"));
        return element;
    }

    /**
     *
     * @param driver
     * @return
     * @throws Exception
     */
    public static WebElement outsideaccess_in_Create_Instance_Checkbox(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.createredisdialog.outsideaccess"));
        return element;
    }

    /**
     *
     * @param driver
     * @return
     * @throws Exception
     */
    public static WebElement description_in_Create_Instance_Dialog(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.createredisdialog.description"));
        return element;
    }

    /**
     *
     * @param driver
     * @return
     * @throws Exception
     */
    public static WebElement submit_Button_in_Create_Instance_Dialog(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.createredisdialog.submitbutton"));
        return element;
    }
}
