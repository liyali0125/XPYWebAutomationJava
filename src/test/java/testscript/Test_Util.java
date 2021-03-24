package testscript;
import util.JavaScriptToDo;
import util.KeyActionsUtil;
import util.ScreenShotUtil;
import util.TableUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static util.KeyActionsUtil.closeBrowser;
import static util.KeyActionsUtil.initBrowser;

/*
 * This script is used for testing util
 *
 * @author davieyang
 * @create 2018-08-06 15:06
 */
public class Test_Util {
    private WebDriver driver = initBrowser("chrome");
    @Test
    public void testUtil() throws InterruptedException {
        KeyActionsUtil.navigate("http://www.baidu.com/");
        Thread.sleep(3000);
        WebElement element = driver.findElement(By.id("kw"));
        JavaScriptToDo.highLightElement(driver, element);
        Thread.sleep(5000);
        element.sendKeys("selenium");
        Thread.sleep(3000);
        JavaScriptToDo.javaScriptClick(driver, "//*[@id='su']");
        Thread.sleep(5000);
    }
    @Test
    public void testDate()throws InterruptedException{
        driver.get("http://jqueryui.com/resources/demos/datepicker/other-months.html");
        Thread.sleep(3000);
        driver.findElement(By.id("datepicker")).sendKeys("12/31/2015");
        Thread.sleep(5000);
    }

    @Test
    public void testTakeScreenshot()throws InterruptedException{
        ScreenShotUtil screenShots = new ScreenShotUtil(driver);
        driver.get("http://www.sogou.com/");
        driver.findElement(By.id("query")).sendKeys("自动化测试");
        driver.findElement(By.id("stb")).click();
        Thread.sleep(3000);
        try{
            Assert.assertTrue(driver.getPageSource().contains("事在人为"));
            System.out.println("assert后继续执行了");
        }catch (AssertionError e){
            System.out.println("catch中的代码被执行");
            //ScreenShots.Screenshot(driver);
            //screenShots.takeScreen("D:\\Programs\\Java\\JavaKeyWordFrameWork\\FrameWork\\src\\test\\java\\TestResults\\abc.jpg");
            screenShots.takeScreenshot(driver);
        }
    }

    @Test
    public void testTable()throws InterruptedException{
        driver.get("D:\\Programs\\Java\\JavaKeyWordFrameWork\\FrameWork\\src\\test\\java\\testdata\\ToBeTest\\table.html");
        Thread.sleep(3000);
        //获取页面表格，并存储到webTable中
        WebElement webTable = driver.findElement(By.xpath("//*[@id='table']"));
        //使用webTable进行TableUtil的实例化
        TableUtil tableUtil = new TableUtil(webTable);
        //获取表格中第三行第二列单元格的对象
        WebElement cell = tableUtil.getCell(3,2);
        Thread.sleep(5000);
        String text = cell.getText();
        System.out.println(text);
        //断言第三行第二列单元格的对象中的文字是否和“第三行第二列”一致
        Assert.assertEquals(cell.getText(), "第三行第二列");
        //获取表格中第三行第二列单元格中的输入框对象
        WebElement cellInput = tableUtil.getWebElementInCell(3,2, By.tagName("input"));
        //在输入框对象中输入关键字“第三行的第二列表格被找到”
        Thread.sleep(5000);
        cellInput.sendKeys("第三行的第二列表格被找到");

    }
    @AfterMethod
    public void tearDown(){
        closeBrowser(driver);
        System.out.println("thank you~!");
    }
}
