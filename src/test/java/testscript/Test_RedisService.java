package testscript;
import util.KeyActionsUtil;
import util.ScrollBarUtil;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pageobject.resourcemanagement.RedisService;

public class Test_RedisService {
    private WebDriver driver = KeyActionsUtil.initBrowser("chrome");
    RedisService redisService = new RedisService(driver);
    private ScrollBarUtil scrollBarUtil = new ScrollBarUtil();
    JavascriptExecutor js = (JavascriptExecutor) driver;
    static {
        DOMConfigurator.configure("log4j.xml");
    }

    @Test
    public void testRedisService() throws Exception {
        String address = "210.13.50.105";
        int port = 30302;
        //connectRedis(address, port);
        for (int i = 1; i < 10000; i++) {
         //   insertData(address, port);
         //   insertListData(address, port);
        }
       // getData(address, port);
    }
}
