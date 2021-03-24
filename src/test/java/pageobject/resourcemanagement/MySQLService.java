/*
 * @FileName StoreManagement: 封装Mysql页面对象
 * @outhor davieyang
 * @create 2018-08-08 11:12
 */
package pageobject.resourcemanagement;
import util.GetElementUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static constants.Constants.MysqlService_Property;
import static util.JavaScriptToDo.highLightElement;

public class MySQLService {
    private static WebElement element = null;
    /**指定页面元素定位表达式配置文件的绝对路径
     *
     */
    private static GetElementUtil getElementUtil = new GetElementUtil(MysqlService_Property);
    private WebDriver driver;
    public MySQLService(WebDriver driver){
        this.driver = driver;
    }

    /**返回MySQL数据库服务页面“刷新”按钮的页面元素对象
     *
     * @param driver 浏览器驱动
     * @return
     * @throws Exception 获取定位信息失败
     */
    public static WebElement refresh_Button(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.mysql.refreshbutton"));
        highLightElement(driver, element);
        return element;
    }

    /**返回MySQL数据库服务页面“创建实例”按钮的页面元素对象
     *
     * @param driver 浏览器驱动
     * @return
     * @throws Exception 获取定位信息失败
     */
    public static WebElement create_New_Instance_Button(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.mysql.createnewinstance"));
        highLightElement(driver, element);
        return element;
    }

    /**
     *
     * @param driver
     * @return
     * @throws Exception
     */
    public static WebElement search_Instance_Name_Input(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.mysql.searchinstancenameinput"));
        highLightElement(driver, element);
        return element;
    }
    /**返回MySQL数据库服务页面MySQL名称检索控件的页面元素对象
     *
     * @param driver 浏览器驱动
     * @return
     * @throws Exception 获取定位信息失败
     */
    public static WebElement search_Instance_Name_Button(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.mysql.searchinstancenamebutton"));
        highLightElement(driver, element);
        return element;
    }

    /**返回MySQL数据库服务页面运行空间检索控件页面元素对象
     *
     * @param driver 浏览器驱动
     * @return
     * @throws Exception 获取定位信息失败
     */
    public static WebElement search_Space_Name(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.mysql.searchspacename"));
        highLightElement(driver, element);
        return element;
    }

    /**返回MySQL数据库服务页面操作列“。。。”按钮的页面元素对象
     *
     * @param driver 浏览器驱动
     * @return
     * @throws Exception 获取定位信息失败
     */
    public static WebElement operation_Button(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.mysql.operation"));
        highLightElement(driver, element);
        return element;
    }

    /**返回MySQL数据库服务页面操作列“。。。”里下拉列表里的“重启”按钮的页面元素对象
     *
     * @param driver 浏览器驱动
     * @return
     * @throws Exception 获取定位信息失败
     */
    public static WebElement operation_Restart_Button(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.mysql.operationrestart"));
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
        element = driver.findElement(getElementUtil.getLocator("paas.mysql.confirmrestart"));
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
        element = driver.findElement(getElementUtil.getLocator("paas.mysql.cancelrestart"));
        highLightElement(driver, element);
        return element;
    }


    /**返回MySQL数据库服务页面操作列“。。。”里下拉列表里的“释放”按钮的页面元素对象
     *
     * @param driver 浏览器驱动
     * @return
     * @throws Exception 获取定位信息失败
     */
    public static WebElement operation_Release_Button(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.mysql.operationrelease"));
        highLightElement(driver, element);
        return element;
    }
    public static WebElement release_Confirm_Button(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.mysql.releaseconfirmbutton"));
        highLightElement(driver, element);
        return element;
    }
    public static WebElement release_Cancel_button(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.mysql.releasecancelbutton"));
        highLightElement(driver, element);
        return element;
    }

    /**返回MySQL数据库服务页面操作列“。。。”里下拉列表里的“管理”按钮的页面元素对象
     * 
     * @param driver 浏览器驱动
     * @return
     * @throws Exception 获取定位信息失败
     */
    public static WebElement operation_Manage_Button(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.mysql.operationmanage"));
        highLightElement(driver, element);
        return element;
    }
    /**返回MySQL数据库服务页面操作列“。。。”里下拉列表里的“管理”按钮的页面元素对象
     *
     * @param driver 浏览器驱动
     * @return
     * @throws Exception 获取定位信息失败
     */
    public static WebElement database_Link_Tab(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.detailed.databaselink"));
        highLightElement(driver, element);
        return element;
    }

    /**返回MySQL数据库服务页面操作列“。。。”里下拉列表里的“日志”按钮的页面元素对象
     * 
     * @param driver 浏览器驱动
     * @return
     * @throws Exception 获取定位信息失败
     */
    public static WebElement operation_Log_Button(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.mysql.operationlog"));
        highLightElement(driver, element);
        return element;
    }

    /**返回MySQL数据库服务页面操作列“。。。”里下拉列表里的“监控”按钮的页面元素对象
     * 
     * @param driver 浏览器驱动
     * @return
     * @throws Exception 获取定位信息失败
     */
    public static WebElement operation_Monitor_Button(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.mysql.operationmonitor"));
        highLightElement(driver, element);
        return element;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return
     * @throws Exception 获取定位信息失败
     */
    public static WebElement instance_Name_in_Create_Instance_Dialog(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.newinstance.instancename"));
        highLightElement(driver, element);
        return element;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return
     * @throws Exception 获取定位信息失败
     */
    public static WebElement description_in_Create_Instance_Dialog(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.newinstance.description"));
        highLightElement(driver, element);
        return element;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return
     * @throws Exception 获取定位信息失败
     */
    public static WebElement standard5_6in_Create_Instance_Dialog(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.newinstance.standard5.6"));
        highLightElement(driver, element);
        return element;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return
     * @throws Exception 获取定位信息失败
     */
    public static WebElement standard5_7_in_Create_Instance_Dialog(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.newinstance.standard5.7"));
        highLightElement(driver, element);
        return element;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return
     * @throws Exception 获取定位信息失败
     */
    public static WebElement storage_Space_in_Create_Instance_Dialog(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.newinstance.storespace"));
        highLightElement(driver, element);
        return element;
    }
    /**
     * 
     * @param driver 浏览器驱动
     * @return
     * @throws Exception 获取定位信息失败
     */
    public static WebElement running_Space_in_Create_Instance_Dialog(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.newinstance.runtimespace"));
        highLightElement(driver, element);
        return element;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return
     * @throws Exception 获取定位信息失败
     */
    public static WebElement outsideaccess_Checkbox_in_Create_Instance_Dialog(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.newinstance.outsideaccess"));
        highLightElement(driver, element);
        return element;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return
     * @throws Exception 获取定位信息失败
     */
    public static WebElement password_in_Create_Instance_Dialog(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.newinstance.password"));
        highLightElement(driver, element);
        return element;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return
     * @throws Exception 获取定位信息失败
     */
    public static WebElement repassword_in_Create_Instance_Dialog(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.newinstance.repassword"));
        highLightElement(driver, element);
        return element;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @return
     * @throws Exception 获取定位信息失败
     */
    public static WebElement cancel_Button_in_Create_Instance_Dialog(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.newinstance.cancelbutton"));
        highLightElement(driver, element);
        return element;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @return
     * @throws Exception 获取定位信息失败
     */
    public static WebElement submit_Button_in_Create_Instance_Dialog(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.newinstance.surebutton"));
        highLightElement(driver, element);
        return element;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return instance standard in create instance dialog
     * @throws Exception 获取定位信息失败
     */
    public static WebElement instance_Standard_in_Create_Instance_Dialog(WebDriver driver)throws Exception{
        element = driver.findElement(getElementUtil.getLocator("paas.newinstance.instancestandard"));
        highLightElement(driver, element);
        return element;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return 返回创建Mysql窗口的实例规格下拉菜单的一核一GB
     * @throws Exception 获取定位信息失败
     */
    public static WebElement one_Core_two_GB(WebDriver driver)throws Exception{
        element = driver.findElement(getElementUtil.getLocator("paas.newinstance.1c2gb"));
        highLightElement(driver, element);
        return element;
    }
    // Msyql Log Page

    /**
     *
     * @param driver 浏览器驱动
     * @return 返回展开按钮
     * @throws Exception 定位失败
     */
    public static WebElement extend_Button_in_Log_Page(WebDriver driver)throws Exception{
        element = driver.findElement(getElementUtil.getLocator("paas.mysqllog.extendbutton"));
        highLightElement(driver, element);
        return element;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @return 返回第一个日期输入窗口
     * @throws Exception 定位失败
     */
    public static WebElement datefrom_in_Log_Page(WebDriver driver)throws Exception{
        element = driver.findElement(getElementUtil.getLocator("paas.mysqllog.datefrom"));
        highLightElement(driver, element);
        return element;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @return 返回日历浮动窗口的日期input窗
     * @throws Exception 定位失败
     */
    public static WebElement datefrom_by_Date_in_Log_Page(WebDriver driver)throws Exception{
        element = driver.findElement(getElementUtil.getLocator("paas.mysqllog.datefromdate"));
        highLightElement(driver, element);
        return element;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @return 返回日历浮动窗口中的时间input窗
     * @throws Exception 定位失败
     */
    public static WebElement datefrom_by_Time_in_Log_Page(WebDriver driver)throws Exception{
        element = driver.findElement(getElementUtil.getLocator("paas.mysqllog.datefromtime"));
        highLightElement(driver, element);
        return element;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @return 返回日历浮动窗口的“确定”按钮
     * @throws Exception 定位失败
     */
    public static WebElement datefrom_Sure_Button_in_Log_Page(WebDriver driver)throws Exception{
        element = driver.findElement(getElementUtil.getLocator("paas.mysqllog.datefromsurebutton"));
        highLightElement(driver, element);
        return element;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @return 返回“筛选” 按钮
     * @throws Exception 定位失败
     */
    public static WebElement search_Button_in_Log_Page(WebDriver driver)throws Exception{
        element = driver.findElement(getElementUtil.getLocator("paas.mysqllog.searchebutton"));
        highLightElement(driver, element);
        return element;
    }
}
