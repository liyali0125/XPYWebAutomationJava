package util;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class WaitElementUtil {
    //public WebDriver driver = null;
    //private int timeOutInSeconds =10;
    /**用于测试执行过程中暂停程序执行的等待方法*/
    public static void sleep(long millsecond){
        try{
            Thread.sleep(millsecond);
            Reporter.log("强制等待"+ millsecond + "毫秒...");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 同上
     * @param driver
     * @param by
     * @param timeOutInSeconds
     */
    public static void waitWebElementPresence(WebDriver driver, By by, int timeOutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    /**
     * 显示等待页面元素可被点击状态，参数为页面元素xpath定位表达式
     * @param driver
     * @param by
     * @param timeOutInSeconds
     */
    public static void waitWebElementToBeClickable(WebDriver driver, By by,  int timeOutInSeconds){
        WebDriverWait waitElement = new WebDriverWait(driver, timeOutInSeconds);
        WebElement element = waitElement.until(ExpectedConditions.elementToBeClickable(by));
    }

    /**
     * 显示等待页面元素被选中状态，参数为页面元素xpath定位表达式
     * @param driver
     * @param xpathExpression
     * @param timeOutInSeconds
     */
    public static void waitWebElementToBeSelected(WebDriver driver, String xpathExpression, int timeOutInSeconds){
        WebDriverWait waitElement = new WebDriverWait(driver, timeOutInSeconds);
        Boolean element = waitElement.until(ExpectedConditions.elementToBeSelected(By.xpath(xpathExpression)));
    }

    /**
     * 显示等待页面元素出现，参数为页面元素xpath定位表达式
     * @param driver
     * @param xpathExpression
     * @param text
     * @param timeOutInSeconds
     */
    public static void waitWebElementToBePresentInElementValue(WebDriver driver, String xpathExpression, String text, int timeOutInSeconds){
        WebDriverWait waitElement = new WebDriverWait(driver, timeOutInSeconds);
        Boolean element = waitElement.until(ExpectedConditions.textToBePresentInElementValue(By.xpath(xpathExpression), text));
    }

    /**
     * 显示等待页面标题包含"title"元素出现，参数为页面元素xpath定位表达式
     * @param driver
     * @param title
     * @param timeOutInSeconds
     */
    public static void waitWebElementTitleContains(WebDriver driver, String title, int timeOutInSeconds){
        WebDriverWait waitElement = new WebDriverWait(driver, timeOutInSeconds);
        Boolean element = waitElement.until(ExpectedConditions.titleContains(title));
    }

    /**
     * 显示等待页面元素加载
     * @param by：等待元素elementName加载完成
     * @param timeOutInSeconds：等待时常
     * @throws Exception
     */
    public static void waitElement(WebDriver driver, By by, int timeOutInSeconds) throws Exception {
        try{
            waitWebElementPresence(driver, by, timeOutInSeconds);
            LogUtil.info("显示等待页面元素出现成功， 页面元素是" + by);
        }catch (Exception e){
            LogUtil.info("显示等待页面元素时出现异常，异常信息为：" + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 显示等待元素加载
     * @param driver:浏览器驱动
     * @param timeOut：等待时常
     * @param by：元素定位
     */
    public static void intelligentWait(WebDriver driver,int timeOut, final By by) {
        try {
            (new WebDriverWait(driver, timeOut)).until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver driver) {
                    WebElement element = driver.findElement(by);
                    return element.isDisplayed();
                }
            });
        } catch (TimeoutException e) {
            Assert.fail("超时L !! " + timeOut + " 秒之后还没找到元素 [" + by + "]", e);
        }
    }
}
