package util;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import static constants.Constants.MainPageandNavigation_Property;
import static constants.Constants.Path_BrowserDrivers;
import static util.LogUtil.info;

public class KeyActionsUtil {
    //声明静态的Webdriver对象，用于在此类中相关Driver的操作
    public static WebDriver driver;
    //声明存储定位表达式配置文件的ObjectMap对象
    private static GetElementUtil getElementUtil = new GetElementUtil(MainPageandNavigation_Property);
    static {
        //指定log4j配置文件为log4j.xml
        DOMConfigurator.configure("log4j.xml");
        }

    /**
     * 定义函数initBrowser
     * @param browser：字符串参数chrome/ie/xx
     * @return 并返回驱动
     */
    public static WebDriver initBrowser(String browser) {
        if(browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", Path_BrowserDrivers+"geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            info("启动Firefox浏览器");

        }else if (browser.equalsIgnoreCase("ie")){
            System.setProperty("webdriver.ie.driver",Path_BrowserDrivers+"IEDriverServer.exe");
            driver = new InternetExplorerDriver();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            info("启动IE浏览器");
        }else {
            System.setProperty("webdriver.chrome.driver",Path_BrowserDrivers+"chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            info("启动Chrome浏览器");
        }
        driver.manage().window().maximize();
        info("最大化浏览器");
        return driver;
    }

    /**
     * 进入页面url
     * @param url：驱动浏览器，打开的页面url
     * @param browser：字符串参数chrome/ie/xx
     * @param timeOutInSeconds：等待时常
     */
    public static void openBrowser(String url, String browser, int timeOutInSeconds) {
        driver = initBrowser(browser);
        driver.manage().timeouts().implicitlyWait(timeOutInSeconds, TimeUnit.SECONDS);
        driver.get(url);
    }
    //定义函数navigate，用于获取浏览器要访问的链接
    public static void navigate(String url){
        driver.get(url);
        info("访问地址为"+url);
    }


    //通过从剪切板黏贴的方式，在文件上传框体的文件名输入框中输入要上传文件的路径和名称"uploadpathandname"
    public static void uploadFileName(String uploadpathandname){
        try{
            KeyBoardUtil.setAndctrlVClipboardData(uploadpathandname);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //页面上不止一个相同功能并且xpath相同的元素，此种情况处理是将他们存储到List中，然后用索引的方式用其一
    public static void twoWay(String ElementNameInproFile){
        try {
            List<WebElement> elements = driver.findElements(getElementUtil.getLocator(ElementNameInproFile));
            elements.get(0).click();
            System.out.println("按钮被成功点击");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 断言文字内容
     * @param driver:浏览器驱动
     * @param assertstring：要断言的字符串
     */
    public static void assertString(WebDriver driver,String assertstring){
        try{
            Assert.assertTrue(driver.getPageSource().contains(assertstring));
            Reporter.log("成功断言关键字“"+ assertstring +"”");
        }catch (AssertionError e){
            Reporter.log("断言失败，具体失败信息为：" + e.getMessage());
            System.out.println("断言失败");
            throw e;
        }
    }
    //断言文字不存在
    public static void assertNoString(WebDriver driver, String assertstring){
        try{
            Assert.assertFalse(driver.getPageSource().contains(assertstring)); 
            info("成功断言关键字“"+ assertstring +"” + “不存在”");
        }catch (AssertionError e){
            info("断言失败，具体信息为：" + e.getMessage());
            System.out.println("断言失败");
        }
    }

    //关闭浏览器
    public static void closeBrowser(WebDriver driver){
        try{
            System.out.println("关闭浏览器");
            driver.quit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static WebDriver caseBrowser(String browser) {
        switch (browser) {
            case "ie":
                System.setProperty("webdriver.ie.driver",Path_BrowserDrivers+"IEDriverServer.exe");
                driver = new InternetExplorerDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", Path_BrowserDrivers+"geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver",Path_BrowserDrivers+"chromedriver.exe");
                driver = new ChromeDriver();
                break;
            default:
                try {
                    throw new Exception("浏览器错误!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
        return driver;
    }

    public static void closeAllBrowser() {
        driver.quit();
    }
    public static void closeCurrentBrowser() {
        driver.close();
    }

    /**
     * 最大化浏览器
     */
    public static void maxBrowser() {
        driver.manage().window().maximize();
    }

    /**
     * 根据下拉菜单的value选择
     * @param string
     * @param value
     */
    public static void selectByValue(String string, String value) {
        Select select = new Select(driver.findElement(By.xpath(string)));
        select.selectByValue(value);
    }

    /**
     * 根据下拉菜单的实际内容选择
     * @param string
     * @param text
     */
    public static void selectByText(String string, String text) {
        Select select = new Select(driver.findElement(By.xpath(string)));
        select.selectByVisibleText(text);
    }

    /**
     * 根据下拉菜单的索引选择
     * @param string
     * @param index
     */
    public static void selectByIndex(String string, int index) {
        Select select = new Select(driver.findElement(By.xpath(string)));
        select.selectByIndex(index);
    }

    /**
     * 切换进iframe
     * @param locator:iframe 定位
     */
    public static void switchToFrame(By locator) {
        driver.switchTo().frame(driver.findElement(locator));
    }

    /**
     * 切换出iframe
     */
    public static void switchToParentFrame() {
        driver.switchTo().defaultContent();
    }
    public static void dismissAlert() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }
    public static void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    public static String getAlertText() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }
    public static void inputTextToAlert(String text) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
    }
    public static void deleteCookie(String name) {
        driver.manage().deleteCookieNamed(name);
    }

    public static void deleteAllCookies() {
        driver.manage().deleteAllCookies();
    }
    public static Map<String, String> getCookieByName(String name) {
        Cookie cookie = driver.manage().getCookieNamed(name);
        if (cookie != null) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("name", cookie.getName());
            map.put("value", cookie.getValue());
            map.put("path", cookie.getPath());
            map.put("domain", cookie.getDomain());
            map.put("expiry", cookie.getExpiry().toString());
            return map;
        }
        return null;
    }
    public static Set<Cookie> getAllCookies() {
        return driver.manage().getCookies();
    }
    public static void addCookie(String name, String value) {
        driver.manage().addCookie(new Cookie(name, value));
    }
    public static void addCookie(String name, String value, String path) {
        driver.manage().addCookie(new Cookie(name, value, path));
    }

    public static void closeCurrentBrowser(WebDriver driver) {
        driver.close();
        info("关闭浏览器...");
    }

    public static void closeAllBrowser(WebDriver driver) {
        driver.quit();
        info("关闭浏览器...");
    }

    public static void maxBrowser(WebDriver driver) {
        driver.manage().window().maximize();
        info("浏览器最大化...");
    }
    public static void setBrowserSize(int width, int height) {
        driver.manage().window().setSize(new Dimension(width, height));
        info("设置浏览器为" + width + "高度为" + height);
    }
    /**获取当前URL*/
    public static String getURL(WebDriver driver) {
        return driver.getCurrentUrl();
    }
    /**获取当前浏览器页面的标题*/
    public static String getTitle(WebDriver driver) {
        return driver.getTitle();
    }
    /**在浏览器的历史中向后到上一个页面, 即点击浏览器返回*/
    public void returnToPreviousPage() {
        driver.navigate().back();
    }
    /**在浏览器的历史中向前到下一个页面, 如果我们在最新的页面上看, 什么也不做, 即点击浏览器下一页*/
    public void forwardToNextPage() {
        driver.navigate().forward();
    }

    /**刷新页面*/
    public static void refreshPage() {
        driver.navigate().refresh();
        LogUtil.info("刷新页面");
    }

    /**WebDriver切换到当前页面*/
    public static void switchToCurrentPage() {
        String handle = driver.getWindowHandle();
        for (String tempHandle : driver.getWindowHandles()) {
            if(tempHandle.equals(handle)) {
                driver.close();
            }else {
                driver.switchTo().window(tempHandle);
            }
        }
    }

    public static void inputText(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    public static void clickElement(By locator) {
        driver.findElement(locator).click();
    }

    public static String getElementText(By locator) {
        return driver.findElement(locator).getText();
    }

    public static void clearText(By locator) {
        driver.findElement(locator).clear();
    }

    public static void submitForm(By locator) {
        driver.findElement(locator).submit();
    }

    public static void uploadFile(By locator, String filePath) {
        driver.findElement(locator).sendKeys(filePath);
    }
}
