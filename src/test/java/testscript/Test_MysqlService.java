package testscript;

import util.TestReport;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.Listeners;

@Listeners({TestReport.class})
public class Test_MysqlService{
    static {
        DOMConfigurator.configure("log4j.xml");
    }
}
