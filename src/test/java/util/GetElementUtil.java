/*
 * @FileName GetElementUtil: this util is use for getting page element
 * @author davieyang
 * @create 2018-08-21 16:37
 */
package util;
import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetElementUtil {
    private Properties properties;
    /**
     * 用于读取存储页面元素的属性文件
     * @param propFile 属性文件的绝对路径，应定义为常量
     */
    public GetElementUtil(String propFile){
        properties = new Properties();
        try{
            FileInputStream in = new FileInputStream(propFile);
            properties.load(in);
            in.close();
        }catch (IOException e){
            System.out.println("读取对象文件出错");
            e.printStackTrace();
        }
    }

    /**
     * @param elementName 存储在属性文件中的元素名称"pass.spacemanagement.releasebutton"
     * @return 根据传入的页面元素名获取元素，返回元素定位
     * @throws Exception "输入的locator Type 未在程序中定义：" + locatorType
     */
    public By getLocator(String elementName) throws Exception{
        //根据变量ElementNameInproFile，从属性配置文件中读取对应的配置对象
        String locator = properties.getProperty(elementName);
        //将配置对象中的定位类型存到locatorType变量，将定位表达式的值存到locatorValue变量
        String locatorType = locator.split(">")[0];
        String locatorValue = locator.split(">")[1];
        /**
         * 配置文件均默认为ISO-8859-1编码存储，使用getBytes方法可以将字符串编码转换为UTF-8
         * 以此来解决读取中文为乱码的问题
         */
        locatorValue = new String(locatorValue.getBytes("ISO-8859-1"), "UTF-8");
        //输出locatorType变量值和locatorValue变量值，验证是否赋值正确
        System.out.println("获取的定位类型：" + locatorType + "\t获取的定位表达式" + locatorValue);
        //根据locatorType的变量值内容判断返回何种定位方式的By对象
        if(locatorType.toLowerCase().equals("id"))
            return By.id(locatorValue);
        else if(locatorType.toLowerCase().equals("name"))
            return By.name(locatorValue);
        else if(locatorType.toLowerCase().equals("classname")||(locatorType.toLowerCase().equals("class")))
            return By.className(locatorValue);
        else if(locatorType.toLowerCase().equals("tagname")||(locatorType.toLowerCase().equals("tag")))
            return By.tagName(locatorValue);
        else if(locatorType.toLowerCase().equals("linktext")||(locatorType.toLowerCase().equals("link")))
            return By.linkText(locatorValue);
        else if(locatorType.toLowerCase().equals("partiallinktext"))
            return By.partialLinkText(locatorValue);
        else if(locatorType.toLowerCase().equals("cssselector")||(locatorType.toLowerCase().equals("css")))
            return By.cssSelector(locatorValue);
        else if(locatorType.toLowerCase().equals("xpath"))
            return By.xpath(locatorValue);
        else
            throw new Exception("输入的locator Type 未在程序中定义：" + locatorType);
    }
}
