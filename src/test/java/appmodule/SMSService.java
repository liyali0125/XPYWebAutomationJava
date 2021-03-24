/*
 * @FileName SMSService: 封装短信服务相关通用操作
 * @author davieyang
 * @create 2018-08-08 11:39
 */
package appmodule;

import org.apache.log4j.xml.DOMConfigurator;

public class SMSService {
    static {
        //制定log配置文件
        DOMConfigurator.configure("log4j.xml");
    }
}
