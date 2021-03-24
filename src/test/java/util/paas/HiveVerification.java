/*
 * @FileName HiveVerification: To operate Hive Service
 * @outhor davieyang
 * @create 2018-08-20 11:22
 */
package util.paas;
import java.sql.*;

import static constants.Constants.*;

public class HiveVerification {
    private static Connection conn = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;

    public static void connectHive() throws Exception {
        Class.forName(Hive_JDBC_DRIVER);
        conn = DriverManager.getConnection(Hive_url,Hive_user,Hive_password);
        stmt = conn.createStatement();
    }

    // 创建数据库
    public void createDatabase() throws Exception {
        String sql = "create database hive_jdbc_test";
        System.out.println("Running: " + sql);
        stmt.execute(sql);
    }

    // 查询所有数据库
    public void showDatabases() throws Exception {
        String sql = "show databases";
        System.out.println("Running: " + sql);
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }
    }

    // 创建表
    public void createTable() throws Exception {
        String sql = "create table emp(\n" +
                "empno int,\n" +
                "ename string,\n" +
                "job string,\n" +
                "mgr int,\n" +
                "hiredate string,\n" +
                "sal double,\n" +
                "comm double,\n" +
                "deptno int\n" +
                ")\n" +
                "row format delimited fields terminated by '\\t'";
        System.out.println("Running: " + sql);
        stmt.execute(sql);
    }

    // 查询所有表
    public void showTables() throws Exception {
        String sql = "show tables";
        System.out.println("Running: " + sql);
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }
    }

    // 查看表结构
    public void descTable() throws Exception {
        String sql = "desc emp";
        System.out.println("Running: " + sql);
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getString(1) + "\t" + rs.getString(2));
        }
    }

    // 加载数据
    public void loadData() throws Exception {
        String filePath = "/home/hadoop/data/emp.txt";
        String sql = "load data local inpath '" + filePath + "' overwrite into table emp";
        System.out.println("Running: " + sql);
        stmt.execute(sql);
    }

    // 查询数据
    public void selectData() throws Exception {
        String sql = "select * from emp";
        System.out.println("Running: " + sql);
        rs = stmt.executeQuery(sql);
        System.out.println("员工编号" + "\t" + "员工姓名" + "\t" + "工作岗位");
        while (rs.next()) {
            System.out.println(rs.getString("empno") + "\t\t" + rs.getString("ename") + "\t\t" + rs.getString("job"));
        }
    }

    // 统计查询（会运行mapreduce作业）
    public void countData() throws Exception {
        String sql = "select count(1) from emp";
        System.out.println("Running: " + sql);
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getInt(1) );
        }
    }

    // 删除数据库
    public void dropDatabase() throws Exception {
        String sql = "drop database if exists hive_jdbc_test";
        System.out.println("Running: " + sql);
        stmt.execute(sql);
    }

    // 删除数据库表
    public void deopTable() throws Exception {
        String sql = "drop table if exists emp";
        System.out.println("Running: " + sql);
        stmt.execute(sql);
    }

    // 释放资源
    public void destory() throws Exception {
        if ( rs != null) {
            rs.close();
        }
        if (stmt != null) {
            stmt.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
}
