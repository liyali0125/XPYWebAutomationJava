/*
 * @FileName PostgreSQLVerification: To operate PostgreSQL service
 * @outhor davieyang
 * @create 2018-08-20 11:25
 */
package util.paas;
import util.LogUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

import static constants.Constants.PSQDB_URL;


public class PostgreSQLVerification {
    /**
     * 链接服务
     * @param username
     * @param password
     */
    public static void connectPostgreSQL(String username, String password){
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            DriverManager.getConnection(PSQDB_URL, username, password);
            System.out.println("数据库连接成功");
            LogUtil.info("数据库连接成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
            LogUtil.info("数据库连接失败");
        }


    }

    /**
     * 建表
     * @param username
     * @param password
     */
    public static void createTable(String username, String password){
        Connection c;
        Statement stmt;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(PSQDB_URL, username, password);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "CREATE TABLE COMPANY " +
                    "(ID INT         NOT NULL," +
                    " NAME           TEXT    NOT NULL, " +
                    " AGE            INT     NOT NULL, " +
                    " ADDRESS        CHAR(50))";
            stmt.executeUpdate(sql);
            System.out.println("建表成功");
            LogUtil.info("建表成功");
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            e.printStackTrace();
            System.out.println("建表失败");
            LogUtil.info("建表失败");
        }

    }

    /**
     * 插入数据
     * @param username
     * @param password
     */
    public static void insertData(String username, String password) {
        Connection c;
        Statement stmt;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(PSQDB_URL,username,password);
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS) "
                    + "VALUES (1, 'paas', 34, 'beijing');";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS) "
                    + "VALUES (2, 'paas', 35, 'chengdu');";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS) "
                    + "VALUES (3, 'paas', 36, 'nanjing');";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS) "
                    + "VALUES (4, 'paas', 37, 'shandong ');";
            stmt.executeUpdate(sql);
            System.out.println("插入数据成功");
            LogUtil.info("插入数据成功");
            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("插入数据失败");
            LogUtil.info("插入数据失败");
        }

    }

    /**
     * 检索数据
     * @param username
     * @param password
     */
    public static void searchData(String username, String password) {
        Connection c;
        Statement stmt;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(PSQDB_URL, username, password);
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM COMPANY;" );
            while ( rs.next() ) {
                int id = rs.getInt("id");
                String  name = rs.getString("name");
                int age  = rs.getInt("age");
                String  address = rs.getString("address");
                System.out.println( "ID = " + id );
                System.out.println( "NAME = " + name );
                System.out.println( "AGE = " + age );
                System.out.println( "ADDRESS = " + address );
                System.out.println();
                System.out.println("检索数据成功");
                LogUtil.info("检索数据成功");
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            e.printStackTrace();
            System.out.println("检索数据失败");
            LogUtil.info("检索数据失败");
        }
    }

    /**
     * 更新数据
     * @param username
     * @param password
     */
    public static void updateData(String username, String password) {
        Connection c;
        Statement stmt;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(PSQDB_URL, username, password);
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "UPDATE COMPANY set AGE = 10000 where ID=1;";
            stmt.executeUpdate(sql);
            c.commit();

            ResultSet rs = stmt.executeQuery( "SELECT * FROM COMPANY;" );
            while ( rs.next() ) {
                int id = rs.getInt("id");
                String  name = rs.getString("name");
                int age  = rs.getInt("age");
                String  address = rs.getString("address");
                System.out.println( "ID = " + id );
                System.out.println( "NAME = " + name );
                System.out.println( "AGE = " + age );
                System.out.println( "ADDRESS = " + address );
                System.out.println();
                System.out.println("更新表成功");
                LogUtil.info("更新表成功");
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            e.printStackTrace();
            System.out.println("更新表失败");
            LogUtil.info("更新表失败");
        }
    }

    /**
     * 删除数据
     * @param username
     * @param password
     */
    public static void deleteData(String username, String password) {
        Connection c;
        Statement stmt;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(PSQDB_URL, username, password);
            c.setAutoCommit(false);
            System.out.println("Open database successfully");
            stmt = c.createStatement();
            String sql = "Drop table COMPANY;";
            stmt.executeUpdate(sql);
            System.out.println("删除表成功");
            LogUtil.info("删除表成功");
            c.commit();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            e.printStackTrace();
            System.out.println("删除表失败");
            LogUtil.info("删除表失败");
        }
    }
}
