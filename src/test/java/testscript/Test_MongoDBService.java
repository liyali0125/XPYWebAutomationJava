package testscript;
import util.TestReport;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import util.KeyActionsUtil;

import static appmodule.MysqlService.linkToMysqlPage;
import static util.WaitElementUtil.sleep;

@Listeners({TestReport.class})
public class Test_MongoDBService {
    static {
        DOMConfigurator.configure("log4j.xml");
    }
    @BeforeClass
    public void setUp()throws Exception{
        WebDriver driver = KeyActionsUtil.initBrowser("chrome");
        linkToMysqlPage(driver, "yangdawei", "alex005x");
        sleep(2000);
    }

    @Test
    public void testMonitorMongoDBService() throws Exception {
        //connectMongoDB("210.13.50.105", 30695);
        //createCollection("210.13.50.105", 30695);
        //insertCollection("210.13.50.105", 30695);
        //getCollection("210.13.50.105", 30695);
        //getDocuments("210.13.50.105", 30695);
        //updateDocument("210.13.50.105", 30695);
        //deleteDocuments("210.13.50.105", 30695);

    }
}
