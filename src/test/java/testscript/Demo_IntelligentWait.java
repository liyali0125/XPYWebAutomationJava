/*
 * @FileName Demo_IntelligentWait:
 * @author davieyang
 * @create 2018-11-28 14:44
 */
package testscript;
import util.TestReport;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import util.KeyActionsUtil;
import java.util.concurrent.TimeUnit;
import static util.WaitElementUtil.*;

@Listeners({TestReport.class})
public class Demo_IntelligentWait {
    private WebDriver driver = KeyActionsUtil.initBrowser("chrome");
    static {
        //指定log4j配置文件为log4j.xml
        DOMConfigurator.configure("log4j.xml");
    }
    @BeforeClass
    public void setUp() {
    }
    @Test
    public void test_waitElementTest() {
        //设置等待页面完全加载的时间是10秒，如果在10秒内加载完毕，剩余时间不在等待　　
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.get("https://www.baidu.com/");
        By inputBox = By.id("kw");
        By searchButton = By.id("su");
        //智能等待元素加载出来　　
        intelligentWait(driver, 10, inputBox);
        //智能等待元素加载出来　　
        intelligentWait(driver, 10, searchButton);
        //输入内容
        driver.findElement(inputBox).sendKeys("JAVA");
        //点击查询　　
        driver.findElement(searchButton).click();
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}