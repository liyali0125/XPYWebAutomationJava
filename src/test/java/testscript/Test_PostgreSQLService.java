/*
 * @FileName Test_PostgreSQLService: Test scripts fo PostgreSQL
 * @author davieyang
 * @create 2018-08-24 17:08
 */
package testscript;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test_PostgreSQLService {
    static {
        //指定log4j配置文件为log4j.xml
        DOMConfigurator.configure("log4j.xml");
    }
    private Connection conn;
    @Test
    public void test_connectDB()throws Exception{

        //deleteData("postgresql99", "postgresql99");
        //createTable("postgresql99", "postgresql99");
        Thread.sleep(3);
        //insertData("postgresql99", "postgresql99");
        Thread.sleep(3);
        for (int i=1; i<100; i++){
           // searchData("postgresql99", "postgresql99");
            Thread.sleep(10);
        }

    }
    @BeforeMethod
    public void init() throws Exception {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://210.13.50.105:31637/postgresql034";
        conn = DriverManager.getConnection(url, "postgresql034", "postgresql034");
        //Statement stmt = conn.createStatement();
        //stmt.execute("CREATE TABLE testgeom(gid serial PRIMARY KEY, the_geom geometry(MULTIPOLYGON, 4326));");
        //stmt.close();
    }
    @AfterMethod
    public void destroy() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }
    @Test
    public void insertCircle() throws SQLException {
        PreparedStatement ps = conn.prepareStatement("INSERT INTO testgeom(the_geom) VALUES (‘SRID=4326;MULTIPOLYGON(((120.5311 31.3652,120.5578 31.3390,120.5623 31.3383,120.5923 31.2795,120.5949 31.2685,120.606803 31.2659,120.6066 31.2707,120.6143 31.2711,120.6178 31.2846,120.63531 31.2870,120.6372 31.2837,120.64341 31.2892,120.653707 31.28808,120.6587 31.2859,120.660157 31.288142,120.661709 31.298719,120.655937 31.3194,120.654671 31.32327,120.648623 31.334765,120.6525 31.3399,120.6469 31.3422,120.6545 31.3430,120.6462 31.3426,120.6373 31.3529,120.6226 31.3525,120.6122 31.3627,120.5937 31.3667,120.5869 31.3618,120.5809 31.3627,120.5745 31.3767,120.5599 31.3852,120.5311 31.3652)))’);");
        ps.close();
    }

    @Test
    public void retrieveCircle() throws SQLException{
        Statement stmt = conn.createStatement();
        ResultSet rs1 = stmt.executeQuery("SELECT ST_Contains(the_geom, ST_SetSRID(ST_Point(120.591482,31.307665), 4326)) from testgeom where gid = 1;");
        rs1.next();
        ResultSet rs2 = stmt.executeQuery("SELECT ST_Contains(the_geom, ST_SetSRID(ST_Point(120.656411,31.317506), 4326)) from testgeom where gid = 1;");
        rs2.next();
        ResultSet rs3 = stmt.executeQuery("SELECT ST_Contains(the_geom, ST_SetSRID(ST_Point(120.657489,31.317013), 4326)) from testgeom where gid = 1;");
        rs3.next();

    }
}
