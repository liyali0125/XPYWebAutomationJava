/*
 * @FileName Demo: Demo
 * @author davieyang
 * @create 2018-11-06 16:01
 */
package testscript;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class Demo_Compatibility_Testing {
    static {
        //指定log4j配置文件为log4j.xml
        DOMConfigurator.configure("log4j.xml");
    }

    // 主要方法是使用 InternetExplorerDriver  FirefoxDriver  ChromeDriver 运行相同的测试脚本，
    // 将每一种Driver  的启动写成 @Test 的方法，如下所示：
    @Test
    @Parameters( { "webSite" })
    public void setUp_InternetExplorerDriver(String webSite) throws Exception {
        //.\\lib\\IEDriverServer.exe  是lib目录下的驱动
        System.setProperty("webdriver.ie.driver", ".\\lib\\IEDriverServer.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
        true);
        WebDriver driver = new InternetExplorerDriver(capabilities);
        String baseUrl = webSite;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        script(driver);
        }

    @Test
    @Parameters( { "firefox_dir", "webSite" })
    public void setUp_FirefoxDriver(String firefox_dir, String webSite)
        throws Exception {
        //firefox_dir 为本机 firefox安装目录
        System.setProperty("webdriver.firefox.bin", firefox_dir);
        WebDriver driver = new FirefoxDriver();
        String baseUrl = webSite;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        script(driver);
        }

    @Test
    @Parameters( { "webSite" })
    public void setUp_ChromeDriver(String webSite) throws Exception {
        //.\\lib\\IEDriverServer.exe  是lib目录下的驱动
        System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String baseUrl = webSite;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        script(driver);
        }
        // 对于具体的测试脚本，写成一个新的方法，每一个driver都会调用该方法，如下所示：
    private void script(WebDriver driver) throws Exception {
        try {
            String baseUrl = "http://www.baidu.com";
            Logger logger=Logger.getLogger(Demo_Compatibility_Testing.class);
            logger.info("开始");
            driver.get(baseUrl);
            driver.findElement(By.id("kw")).clear();
            driver.findElement(By.id("kw")).sendKeys("selenium");
            driver.findElement(By.id("kw")).submit();
            driver.findElement(By.linkText("下一页>")).click();
            driver.findElement(By.linkText("下一页>")).click();
            driver.findElement(By.linkText("下一页>")).click();
            assertEquals("selenium", driver.findElement(By.id("kw")).getAttribute("value"));
            logger.info("结束");
        } catch (Exception e) {
            throw e;
        } finally {
            driver.quit();
        }
    }
}


