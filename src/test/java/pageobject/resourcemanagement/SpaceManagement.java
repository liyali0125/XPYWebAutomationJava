/*
 * @FileName StoreManagement: 封装空间管理页面对象
 * @outhor davieyang
 * @create 2018-08-08 11:12
 */
package pageobject.resourcemanagement;
import util.GetElementUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static constants.Constants.SpaceManagement_Property;
import static util.JavaScriptToDo.highLightElement;

public class SpaceManagement {
    public static WebElement element = null;
    private static GetElementUtil getElementUtil = new GetElementUtil(SpaceManagement_Property);
    private WebDriver driver;
    public SpaceManagement(WebDriver driver){
        this.driver = driver;
    }


    /**
     * @param driver 浏览器驱动
     * @return 返回空间管理页面中“创建空间”按钮页面元素对象
     * @throws Exception:获取定位表达式失败
     */
    public static WebElement create_Space_Button(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.spacemanagement.newspacebutton"));
        highLightElement(driver, element);
        return element;
    }
    /**
     * @param driver 浏览器驱动
     * @return 返回空间管理页面-新增空间窗口中“空间名称”页面元素对象
     * @throws Exception:获取定位表达式失败
     */
    public static WebElement space_Name_in_Create_Space_Dialog(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.newspace.spacename"));
        highLightElement(driver, element);
        return element;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @return 返回空间管理-新增空间窗口中“有效期长度”页面元元素
     * @throws Exception 获取定位表达式失败
     */
    public static WebElement expiration_Date_in_Create_Space_Dialog(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.newsapce.expirationdate"));
        highLightElement(driver, element);
        return element;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @return 返回空间管理-新增空间窗口中有效期长度的三个月选项
     * @throws Exception 获取定位表达式失败
     */
    public static WebElement three_Month_in_Create_Space_Dialog(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("pass.newspace.threemonth"));
        highLightElement(driver, element);
        return element;
    }
    /**
     * @param driver 浏览器驱动
     * @return 返回空间管理页面-新增空间窗口中“cpu输入框”页面元素对象
     * @throws Exception:获取定位表达式失败
     */
    public static WebElement cpu_in_Create_Space_Dailog(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.newspace.cpu"));
        highLightElement(driver, element);
        return element;
    }
    /**
     * @param driver 浏览器驱动
     * @return 返回空间管理页面-新增空间窗口中“内存输入框”页面元素对象
     * @throws Exception:获取定位表达式失败
     */
    public static WebElement memory_in_Create_Space_Dialog(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.newspace.mem"));
        highLightElement(driver, element);
        return element;
    }
    /**
     * @param driver 浏览器驱动
     * @return 返回空间管理页面-新增空间窗口中“保存”按钮页面元素对象
     * @throws Exception:获取定位表达式失败
     */
    public static WebElement submit_Button_in_Create_Space_Dialog(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.newspace.submit"));
        highLightElement(driver, element);
        return element;
    }
    /**
     * @param driver 浏览器驱动
     * @return 返回空间管理页面-新增空间窗口中“取消”按钮页面元素对象
     * @throws Exception:获取定位表达式失败
     */
    public static WebElement cancel_Button_in_Create_Space_Dialog(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.newspace.cancelbutton"));
        highLightElement(driver, element);
        return element;
    }
    /**
     * @param driver 浏览器驱动
     * @return 返回空间管理页面中“配置空间”按钮页面元素对象
     * @throws Exception:获取定位表达式失败
     */
    public static WebElement configSpace_Button(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.spacemanagement.configbutton"));
        highLightElement(driver, element);
        return element;
    }
    /**
     * @param driver 浏览器驱动
     * @return 返回空间管理页面-空间扩容窗口中“租户空间”下拉框页面元素对象
     * @throws Exception:获取定位表达式失败
     */

    public static WebElement space_Name_in_Config_Space_Dialog(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.excendspace.spacename"));
        highLightElement(driver, element);
        return element;
    }

    /**
     *
     * @param driver
     * @return
     * @throws Exception
     */
    public static WebElement expiration_Date_in_Config_Space_Dialog(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.excendspace.expirationdate"));
        highLightElement(driver, element);
        return element;
    }

    /**
     *
     * @param driver
     * @return
     * @throws Exception
     */
    public static WebElement three_Month_in_Config__Space_Dialog(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("pass.excendspace.threemonth"));
        highLightElement(driver, element);
        return element;
    }
    /**
     * @param driver 浏览器驱动
     * @return 返回空间管理页面-空间扩容窗口中“cpu输入框”页面元素对象
     * @throws Exception:获取定位表达式失败
     */
    public static WebElement cpu_in_Config_Space_Dialog(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.excendspace.cpu"));
        highLightElement(driver, element);
        return element;
    }
    /**
     * @param driver 浏览器驱动
     * @return 返回空间管理页面-空间扩容窗口中“内存输入框”页面元素对象
     * @throws Exception:获取定位表达式失败
     */
    public static WebElement memory_in_Config_Space_Dialog(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.excendspace.mem"));
        highLightElement(driver, element);
        return element;
    }
    /**
     * @param driver 浏览器驱动
     * @return 返回空间管理页面-空间扩容窗口中“保存”按钮页面元素对象
     * @throws Exception:获取定位表达式失败
     */
    public static WebElement submit_Button_in_Config_Space_Dialog(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.excendspace.submit"));
        highLightElement(driver, element);
        return element;
    }

    /**
     * @param driver 浏览器驱动
     * @return 返回空间管理页面-空间扩容窗口中“取消”按钮页面元素对象
     * @throws Exception:获取定位表达式失败
     */
    public static WebElement cancel_Button_in_Config_Space_Dialog(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("paas.excendspace.cancelbutton"));
        highLightElement(driver, element);
        return element;
    }
    /**
     * @param driver 浏览器驱动
     * @return 返回空间列表页面"释放"按钮页面元素对象
     * @throws Exception:获取定位表达式失败
     */
    public static WebElement release_Button(WebDriver driver) throws Exception{
        //调用GetElementUtil中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
        element = driver.findElement(getElementUtil.getLocator("pass.spacemanagement.releasebutton"));
        highLightElement(driver, element);
        return element;
    }
    /**
     *
     * @param driver 浏览器驱动
     * @return 返回确认释放空间窗口的确定按钮
     * @throws Exception:获取定位表达式失败
     */
    public static WebElement release_Confirm_Button(WebDriver driver) throws Exception{
        element = driver.findElement(getElementUtil.getLocator("pass.spacemanagement.releaseconfirm"));
        highLightElement(driver, element);
        return element;
    }
}
