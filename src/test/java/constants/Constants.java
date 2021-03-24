package constants;

public class Constants {
        // 定义存储测试数据的文件的路径
        public static final String Path_ExcelFile = "./src/test/java/testdata/TestData.xlsx";

        // 定义存储页面元素定位的属性文件路径
        public static final String MainPageandNavigation_Property = "./src/test/java/propertyfile/MainPageandNavigation.properties";
        public static final String SpaceManagement_Property = "./src/test/java/propertyfile/SpaceManagement.properties";
        public static final String DatabaseManagement_Property = "./src/test/java/propertyfile/DatabaseManagement.properties";
        public static final String MysqlService_Property = "./src/test/java/propertyfile/MysqlService.properties";
        public static final String MongodbService_Property = "./src/test/java/propertyfile/MongodbService.properties";
        public static final String RedisService_Property = "./src/test/java/propertyfile/RedisService.properties";
        public static final String ElasticSearchService_Property = "./src/test/java/propertyfile/ElasticSearchService.properties";
        public static final String Neo4jService_Property = "./src/test/java/propertyfile/Neo4jService.properties";
        public static final String PostgreSQLService_Property = "./src/test/java/propertyfile/PostgreSQLService.properties";

        public static final String CommunicationServiceManagement_Property ="./src/test/java/propertyfile/CommunicationServiceManagement.properties";
        public static final String BigDataBaseService_Property = "./src/test/java/propertyfile/BigDataBaseService.properties";
        public static final String DataInterface_Property = "./src/test/java/propertyfile/DataInterface.properties";
        public static final String DataFiles_Property = "./src/test/java/propertyfile/DataFiles.properties";
        public static final String DataPipeline_Property = "./src/test/java/propertyfile/DataPipeline.properties";
        public static final String BasicCompetence_Property = "./src/test/java/propertyfile/BasicCompetence.properties";
        public static final String APIManagement_Property = "./src/test/java/propertyfile/APIManagement.properties";
        public static final String MirrorStore_Property = "./src/test/java/propertyfile/MirrorStore.properties";
        public static final String ApplicationsStore_Property = "./src/test/java/propertyfile/ApplicationsStore.properties";
        public static final String LogCenter_Property = "./src/test/java/propertyfile/LogCenter.properties";
        public static final String MonitorintCenter_Property = "./src/test/java/propertyfile/MonitoringCenter.properties";
        public static final String OperationLog_Property = "./src/test/java/propertyfile/OperationLog.properties";
        public static final String AccountCenter_Property = "./src/test/java/propertyfile/AccountCenter.properties";
        public static final String TenantManagement_Property = "./src/test/java/propertyfile/TenantManagement.properties";
        // 定义历览器驱动路径
        public static final String Path_BrowserDrivers = "./src/test/java/browserdriver/";
        // 定义直接进入各模块的链接
        public static final String LoginPage = "http://paasweb.tpaas.youedata.com/#/front/login";
        public static final String Database_Main= "http://paasweb.tpaas.youedata.com/#/front/databaseServicePage/main";
        public static final String Spacemanagement_Main = "http://paasweb.tpaas.youedata.com/#/front/spaceManage/main";
        public static final String Storagemanagement_Main = "http://paasweb.tpaas.youedata.com/#/front/ossService/main";
        public static final String Messageservice_Main = "http://paasweb.tpaas.youedata.com/#/front/messageServicePage/main";
        public static final String AccountCenter_Main = "http://paasweb.tpaas.youedata.com/#/front/controlPanel/userManage";
        public static final String LogCenter_Main = "http://paasweb.tpaas.youedata.com/#/front/logmonitor/log";
        public static final String MonitorCenter_Main = "http://paasweb.tpaas.youedata.com/#/front/logmonitor/tenant";
        public static final String MirrorStorage_Main= "http://paasweb.tpaas.youedata.com/#/front/image/imageList";
        public static final String ApplicationStorage_Main = "http://paasweb.tpaas.youedata.com/#/front/AppLocation/AppLocation";
        public static final String APIManagement_Main = "http://paasweb.tpaas.youedata.com/#/front/apiAllList/apiAllList";

        // 定义页面元素常量，该元素必须属于业务流程、测试流程等公共部分
        public static final String paas_landPage_controller = "//*[@id='app']/section/header/div[1]/div[2]/p/span[1]";
        public static final String paas_navigation_resources = "//*[@id='app']/section/section/aside/ul/li[2]/div/a/span";
        public static final String paas_resources_spacemanagement = "//*[@id='app']/section/section/aside/ul/li[2]/ul/li[1]/a/span";

        // JDBC 驱动名及数据库 URL
        public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        public static final String DB_URL = "jdbc:mysql://210.13.50.105:30456/mysql?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        public static final String NEWDBURL = "jdbc:mysql://210.13.50.105:30456/mysqltest?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        // 数据库的用户名与密码，需要根据自己的设置
        public static final String USERNAME = "root";
        public static final String PASSWORD = "111111";
        //SQL语句
        public static final String CREATEDATABASE = "create database mysqltest;";
        public static final String CREATETABLE = "CREATE TABLE `test` (`id` int, `name` char(20),`url` varchar(255),`country` char(10));";
        public static final String INSERTDATA = "INSERT INTO `test` VALUES ('1', 'Google', 'https://www.google.cm/', 'USA'), ('2', '淘宝', 'https://www.taobao.com/','CN'), ('3', '菜鸟教程', 'http://www.runoob.com','aaa'), ('4', '微博', 'http://weibo.com/','CN'), ('5', 'Facebook', 'https://www.facebook.com/', 'USA');";
        public static final String SEARCHDATA = "select * from test";
        public static final String DROPDB = "drop DATABASE mysqltest";

        //postgreSQL
        public static final String PSQDB_URL = "jdbc:postgresql://210.13.50.105:32636/postgres";
        //测试数据sheet中的列号常量设定
        //第一列用0表示，测试用例序列号列
        public static final int Col_TestCaseID = 0;

        //Hive
        public static final String Hive_JDBC_DRIVER = "org.apache.hive.jdbc.HiveDriver";
        public static final String Hive_url = "jdbc:hive2://192.168.0.33:10000/goage1e65t870yen";
        public static final String Hive_user = "goage1e65t870yen";
        public static final String Hive_password = "870yen";

}



