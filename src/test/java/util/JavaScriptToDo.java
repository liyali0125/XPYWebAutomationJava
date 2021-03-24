/*
 * the method of invoking js to do something
 *
 * @author davieyang
 * @create 2018-08-05 1:37
 */
package util;
import org.openqa.selenium.*;
import java.util.Arrays;

public class JavaScriptToDo {
    /**
     *
     * @param driver 浏览器驱动
     * @param xpath xpath定位表达式
     */
    public static void javaScriptClick(WebDriver driver, String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        try{
            if(element.isEnabled() && element.isDisplayed()){
                System.out.println("使用JS进行也面元素单击");
                //执行JS语句arguments[0].click();
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
            }else {
                System.out.println("页面上元素无法进行单击操作");
            }
        }catch (StaleElementReferenceException e){
            System.out.println("页面元素没有附加在页面中" + Arrays.toString(e.getStackTrace()));
        }catch (NoSuchElementException e){
            System.out.println("在页面中没有找到要操作的元素" + Arrays.toString(e.getStackTrace()));
        }catch (Exception e){
            System.out.println("无法完成单击操作" + Arrays.toString(e.getStackTrace()));
        }
    }

    /**
     *
     * @param driver 浏览器驱动
     * @param element 页面元素对象
     */
    public static void highLightElement(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        /*调用js将传入参数的页面元素对象的背景颜色和边框颜色分别设定为黄色和红色*/
        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "background: yellow; border:2px solid red;");
    }
}