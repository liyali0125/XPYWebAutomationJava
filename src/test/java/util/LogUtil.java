package util;
import org.apache.log4j.Logger;

import java.io.IOException;

public class LogUtil {
    private static Logger Log = Logger.getLogger(LogUtil.class.getName());
    //定义测试用例开始执行的打印方法，在日志中打印开始执行测试用例的信息
    public static void startTestCases(String testCaseName){
        Log.info("------------------    \"" + testCaseName + "\"开始执行   -----------------");
    }
    //定义测试用例执行完毕的打印方法，在日志中打印测试用例执行完毕的心
    public static void endTestCases(String testCaseName){
        Log.info("------------------    \"" + testCaseName + "\"执行结束   -----------------");
    }
    //定义打印info级别日志的方法
    public static void info(String message){
        Log.info(message);
    }
    //定义打印error级别日志的方法
    public static void error(String message, IOException e){
        Log.error(message);
    }
    //定义打印debug级别日志的方法
    public static void debug(String message){
        Log.debug(message);
    }
}
