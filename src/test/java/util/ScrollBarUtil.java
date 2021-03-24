package util;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ScrollBarUtil {
    /**
     * 控制滚动条向下拉到底
     * @param driver 浏览器驱动
     */
    public static void toBottom(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //向下拉到底//
        js.executeScript("document.documentElement.scrollTop=10000");
    }

    /**
     * 控制滚动条向上拉到顶
     * @param driver 浏览器驱动
     */
    public static void toTop(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //向上拉到顶
        js.executeScript("document.documentElement.scrollTop=0");
    }

    /**
     * 控制滚动条向下拉到底
     * @param driver 浏览器驱动
     */
    public static void scrolltoBottom(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //向下拉到底
        js.executeScript("window.scrollTo(0,100000)");
    }

    /**
     * 控制滚动条向上拉到顶
     * @param driver 浏览器驱动
     */
    public static void scrolltoTop(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //向上拉到顶
        js.executeScript("window.scrollTo(0,1)");
    }

    /**
     * 控制滚动条拉到中间
     * @param driver 浏览器驱动
     */
    public static void verticaltoMiddle(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //上下拉到中间
        js.executeScript("window.scrollBy(0, 0-document.body.scrollHeight *1/2)");
    }

    /**
     * 控制水平滚动条左右拉到中间
     * @param driver 浏览器驱动
     */
    public static void horizontaltoMiddle(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //左右拉到中间
        js.executeScript("window.scrollBy(0, 0-document.body.scrollWidht *1/2)");
    }

    /**
     * 控制滚动条拉到元素可见
     * @param driver 浏览器驱动
     * @param element 页面元素定位
     */
    public static void scrolltoPresence(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //移动到元素element对象的“顶端”与当前窗口的“顶部”对齐
        //js.executeScript("arguments[0].scrollIntoView();", element);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        //移动到元素element对象的“底端”与当前窗口的“底部”对齐
        //js.executeScript("arguments[0].scrollIntoView(false);", element);
    }

    /**
     * 使用JavaScript的ScrollTo函数和document.body.scrollHeight参数
     * 将页面滚动到最下方
     * @param driver 浏览器驱动
     */
    public static void scrollingToBottomofPage(WebDriver driver){
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    /**
     * 使用JavaScript的ScrollTo函数，使用0和800的横纵坐标参数
     * 将页面的滚动条纵向下滑800个像素
     * @param driver 浏览器驱动
     */
    public static void scrollingByCoordinateofPage(WebDriver driver){

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,200)");
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
