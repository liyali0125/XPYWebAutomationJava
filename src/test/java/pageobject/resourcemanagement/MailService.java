/*
 * @FileName StoreManagement: sms
 * @outhor wanglingyue
 * @create 2018-08-22 15:01
 */
package pageobject.resourcemanagement;
import util.GetElementUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static constants.Constants.CommunicationServiceManagement_Property;

public class MailService {
    private static WebElement element = null;
    /**
     * 指定页面元素定位表达式配置文件的绝对路径
     */
    private static GetElementUtil getElementUtil = new GetElementUtil(CommunicationServiceManagement_Property);
    private WebDriver driver;
    public MailService(WebDriver driver){
        this.driver = driver;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return 返回基本信息页面“发信地址”按钮的页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement senderBtn(WebDriver driver) throws Exception {
        //调用ObjectMap中的getLocator方法获取配置文件中关于'创建发信地址'的定位方式和定位表达式
        element=driver.findElement(getElementUtil.getLocator("paas.mailsenders.senderBtn"));
        return element;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @return 返回“发件地址”列表页面搜索输入框页面元素
     * @throws Exception 获取定位信息失败
     */
    public WebElement senderssearch(WebDriver driver) throws Exception {
        //调用ObjectMap中的getLocator方法获取配置文件中关于'创建发信地址'的定位方式和定位表达式
        element=driver.findElement(getElementUtil.getLocator("paas.mailsenders.search"));
        return element;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @return 返回“发信地址”-“创建发信地址”按钮的页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement sendercerateBtn(WebDriver driver) throws Exception {
        element=driver.findElement(getElementUtil.getLocator("paas.mailsenders.cerateBtn"));
        return element;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @return 返回“发信地址”-“创建发信地址”-“发件地址”的页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement sendercerateaddress(WebDriver driver) throws Exception {
        element=driver.findElement(getElementUtil.getLocator("paas.mailsenders.cerateaddress"));
        return element;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @return 返回“发信地址”-“创建发信地址”-“邮件服务器”的页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement senderceratesmtp(WebDriver driver) throws Exception {
        element=driver.findElement(getElementUtil.getLocator("paas.mailsenders.ceratesmtp"));
        return element;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @return 返回“发信地址”-“创建发信地址”-“密码”的页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement senderceratepassword(WebDriver driver) throws Exception {
        element=driver.findElement(getElementUtil.getLocator("paas.mailsenders.ceratepassword"));
        return element;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @return 返回“发信地址”-“创建发信地址”-“确认密码”的页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement sendercerateconfirm(WebDriver driver) throws Exception {
        element=driver.findElement(getElementUtil.getLocator("paas.mailsenders.cerateconfirm"));
        return element;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @return 返回“发信地址”-“创建发信地址”-“测试验证”按钮的页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement senderceratesendtestBtn(WebDriver driver) throws Exception {
        element=driver.findElement(getElementUtil.getLocator("paas.mailsenders.ceratesendtestBtn"));
        return element;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @return 返回“发信地址”-“创建发信地址”-“提交”按钮的页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement senderceratesubmitBtn(WebDriver driver) throws Exception {
        element=driver.findElement(getElementUtil.getLocator("paas.mailsenders.ceratesubmitBtn"));
        return element;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @return 返回“发信地址”-“...”按钮的页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement senderoperation(WebDriver driver) throws Exception {
        element=driver.findElement(getElementUtil.getLocator("paas.mailsenders.operation"));
        return element;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @return 返回“发信地址”-“...”-“删除”按钮的页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement senderoperationdelete(WebDriver driver) throws Exception {
        element=driver.findElement(getElementUtil.getLocator("paas.mailsenders.operationdelete"));
        return element;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @return 返回“发信地址”-“...”-“编辑”按钮的页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement senderoperationrelease(WebDriver driver) throws Exception {
        element=driver.findElement(getElementUtil.getLocator("paas.mailsenders.operationrelease"));
        return element;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @return 返回“发信地址”-“编辑”-“验证测试”按钮的页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement senderreleasesendtestBtn(WebDriver driver) throws Exception {
        element=driver.findElement(getElementUtil.getLocator("paas.mailsenders.releasesendtestBtn"));
        return element;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @return 返回“发信地址”-“编辑”-“提交”按钮的页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement senderreleasesubmitBtn(WebDriver driver) throws Exception {
        element=driver.findElement(getElementUtil.getLocator("paas.mailsenders.releasesubmitBtn"));
        return element;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @return 返回“发信地址”-“返回”按钮的页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement senderreturnBtn(WebDriver driver) throws Exception {
        element=driver.findElement(getElementUtil.getLocator("paas.mailsenders.returnBtn"));
        return element;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @return 返回基本信息页面“收件人管理”按钮的页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement addressBtn(WebDriver driver) throws Exception {
        element=driver.findElement(getElementUtil.getLocator("paas.mailaddress.addressBtn"));
        return element;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @return 返回“收件人管理”-“创建收件人”按钮的页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement addresscerateBtn(WebDriver driver) throws Exception {
        element=driver.findElement(getElementUtil.getLocator("paas.mailaddress.cerateBtn"));
        return element;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @return 返回“收件人管理”-“创建收件人”-“邮件地址”页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement addresscerateaddressBtnn(WebDriver driver) throws Exception {
        element=driver.findElement(getElementUtil.getLocator("paas.mailaddress.cerateaddressBtn"));
        return element;
    }

    /**
     *
     * @param driver 浏览器驱动
     * @return 返回“收件人管理”-“创建收件人”-“真实姓名”页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement addressceratenameBtn(WebDriver driver) throws Exception {
        element=driver.findElement(getElementUtil.getLocator("paas.mailaddress.ceratenameBtn"));
        return element;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return 返回“收件人管理”-“创建收件人”-“提交”按钮的页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement addressceratesubmitBtn(WebDriver driver) throws Exception {
        element=driver.findElement(getElementUtil.getLocator("paas.mailaddress.ceratesubmitBtn"));
        return element;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return 返回“收件人管理”-“...”按钮的页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement addressoperationBtn(WebDriver driver) throws Exception {
        element=driver.findElement(getElementUtil.getLocator("paas.mailaddress.operationBtn"));
        return element;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return 返回“收件人管理”-“...”-“删除”按钮的页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement addressoperationdelete(WebDriver driver) throws Exception {
        element=driver.findElement(getElementUtil.getLocator("paas.mailaddress.operationdelete"));
        return element;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return 返回“收件人管理”-“...”-“编辑”按钮的页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement addressoperationrelease(WebDriver driver) throws Exception {
        element=driver.findElement(getElementUtil.getLocator("paas.mailaddress.operationrelease"));
        return element;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return 返回“收件人管理”-“...”-“编辑”-“邮件地址”页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement addressreleaseseaddress(WebDriver driver) throws Exception {
        element=driver.findElement(getElementUtil.getLocator("paas.mailaddress.releaseseaddress"));
        return element;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return 返回“收件人管理”-“...”-“编辑”-“真实姓名”页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement addressreleasename(WebDriver driver) throws Exception {
        element=driver.findElement(getElementUtil.getLocator("paas.mailaddress.releasename"));
        return element;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return 返回“收件人管理”-“...”-“编辑”-“提交”按钮页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement addressreleasesubmitBtn(WebDriver driver) throws Exception {
        element=driver.findElement(getElementUtil.getLocator("paas.mailaddress.releasesubmitBtn"));
        return element;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return 返回“收件人管理”-“返回”按钮页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement addressreleaseturnBtn(WebDriver driver) throws Exception {
        element=driver.findElement(getElementUtil.getLocator("paas.mailaddress.releaseturnBtn"));
        return element;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return 返回基本信息页面“模板管理”按钮的页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement templettempletBtn(WebDriver driver) throws Exception {
        element=driver.findElement(getElementUtil.getLocator("paas.mailtemplet.templetBtn"));
        return element;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return 返回基本信息页面“模板管理”-“创建模板”按钮的页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement templetcreateBtn(WebDriver driver) throws Exception {
        element=driver.findElement(getElementUtil.getLocator("paas.mailtemplet.createBtn"));
        return element;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return 返回基本信息页面“模板管理”-“创建模板”-“模板名称”页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement templetcreatename(WebDriver driver) throws Exception {
        element=driver.findElement(getElementUtil.getLocator("paas.mailtemplet.createname"));
        return element;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return 返回基本信息页面“模板管理”-“创建模板”-“邮件标题”页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement templetcreatetitle(WebDriver driver) throws Exception {
        element=driver.findElement(getElementUtil.getLocator("paas.mailtemplet.createtitle"));
        return element;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return 返回基本信息页面“模板管理”-“创建模板”-“发送人名称”页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement templetcreatesendname(WebDriver driver) throws Exception {
        element=driver.findElement(getElementUtil.getLocator("paas.mailtemplet.createsendname"));
        return element;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return 返回基本信息页面“模板管理”-“创建模板”-“邮件正文”页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement templetcreatetxt(WebDriver driver) throws Exception {
        element=driver.findElement(getElementUtil.getLocator("paas.mailtemplet.createtxt"));
        return element;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return 返回基本信息页面“模板管理”-“创建模板”-“提交”按钮页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement templetcreatesubmitBtn(WebDriver driver) throws Exception {
        element=driver.findElement(getElementUtil.getLocator("paas.mailtemplet.createsubmitBtn"));
        return element;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return 返回基本信息页面“模板管理”-“...”按钮页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement templetoperationBtn(WebDriver driver) throws Exception {
        element=driver.findElement(getElementUtil.getLocator("paas.mailtemplet.operationBtn"));
        return element;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return 返回基本信息页面“模板管理”-“...”-“删除”按钮页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement templetoperationdelete(WebDriver driver) throws Exception {
        element=driver.findElement(getElementUtil.getLocator("paas.mailtemplet.operationdelete"));
        return element;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return 返回基本信息页面“模板管理”-“...”-“编辑”按钮页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement templetoperationrelease(WebDriver driver) throws Exception {
        element=driver.findElement(getElementUtil.getLocator("paas.mailtemplet.operationrelease"));
        return element;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return 返回基本信息页面“模板管理”-“...”-“编辑”-“模板名称”按钮页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement templetreleasetempletname(WebDriver driver) throws Exception {
        element=driver.findElement(getElementUtil.getLocator("paas.mailtemplet.releasetempletname"));
        return element;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return 返回基本信息页面“模板管理”-“...”-“编辑”-“邮件标题”按钮页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement tempreltitlereleasetitle(WebDriver driver) throws Exception {
        element=driver.findElement(getElementUtil.getLocator("paas.mailtemplet.releasetitle"));
        return element;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return 返回基本信息页面“模板管理”-“...”-“编辑”-“发送人名称”按钮页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement templetreleasesendername(WebDriver driver) throws Exception {
        element=driver.findElement(getElementUtil.getLocator("paas.mailtemplet.releasesendername"));
        return element;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return 返回基本信息页面“模板管理”-“...”-“编辑”-“邮件正文”按钮页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement tempreltxtreleasetxt(WebDriver driver) throws Exception {
        element=driver.findElement(getElementUtil.getLocator("paas.mailtemplet.releasetxt"));
        return element;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return 返回基本信息页面“模板管理”-“...”-“编辑”-“提交”按钮页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement templetreleasesubmitBtn(WebDriver driver) throws Exception {
        element=driver.findElement(getElementUtil.getLocator("paas.mailtemplet.releasesubmitBtn"));
        return element;
    }

    /**
     * 
     * @param driver 浏览器驱动
     * @return 返回基本信息页面“模板管理”-“返回”按钮页面元素对象
     * @throws Exception 获取定位信息失败
     */
    public static WebElement templetreleaseturnBtn(WebDriver driver) throws Exception {
        element=driver.findElement(getElementUtil.getLocator("paas.mailtemplet.releaseturnBtn"));
        return element;
    }
}
