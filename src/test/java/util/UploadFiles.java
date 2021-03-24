/*
 * 描述:Some methods of uploading files that is used to be invoked when automation testing.
 * @author davieyang
 * @create 2018-08-04 21:02
 */
package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class UploadFiles {
    /**
     *
     * @param driver 浏览器驱动
     * @param xpath  上传文件输入窗口
     * @param filepath 文件绝对路径
     * @param submitxpath 提交按钮
     * @param string 等待上传成功返回信息
     */
    public static void uploadfile_BySendKeys (WebDriver driver, String xpath, String filepath, String submitxpath, String string){
        WebElement element = driver.findElement(By.xpath(xpath));
        element.sendKeys(filepath);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(submitxpath)));
        WebElement submitbutton = driver.findElement(By.xpath(submitxpath));
        submitbutton.click();
        wait.until(ExpectedConditions.titleContains(string));
    }

    public void uploadFiles(WebDriver driver) throws Exception {
        System.out.println("upload start");
        // 获取上传控件元素
        WebElement uploadButton = driver.findElement(By.name("html5uploader"));
        // 构建上传文件路径，将需要上传的文件添加到 CharSequence 数组
        CharSequence[] files = new CharSequence[5];
        files[0] = "C:\\test\\test1.txt";
        files[1] = "C:\\test\\test2.txt";
        files[2] = "C:\\test\\test3.txt";
        files[3] = "C:\\test\\test4.txt";
        files[4] = "C:\\test\\test5.txt";
        // 循环列出每支需要上传的文件路径，做单一上传动作
        for(CharSequence file: files){
            uploadButton.sendKeys(file);
        }
        Thread.sleep(2000);
        System.out.println("upload end");
    }

}