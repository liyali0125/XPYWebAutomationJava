package testscript;

import util.paas.ElasticSearchVerification;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.Test;

import java.io.IOException;


public class Test_ElasticSearchService {
    //private WebDriver driver = KeyActionsUtil.initBrowser("chrome");
    //ElasticSearchService elasticSearchService = new ElasticSearchService(driver);
    //private ScrollBarUtil scrollBarUtil = new ScrollBarUtil();
    //JavascriptExecutor js = (JavascriptExecutor) driver;
    static {
        DOMConfigurator.configure("D:\\PaaSWebTest\\log4j.xml");
    }

    @Test
    public void testservice() throws IOException {
        ElasticSearchVerification elasticSearchVerification = new ElasticSearchVerification();
        elasticSearchVerification.connectES();
        elasticSearchVerification.createIndex();
        //elasticSearchVerification.insertJson();
        //elasticSearchVerification.insertMap();
        //elasticSearchVerification.insertJsonObject();
        //elasticSearchVerification.getData();
    }
}
