package util.paas;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;

public class MongoDBVerification {

    public static void connectMongoDB(String address, int port)throws Exception{
        try{
            // 连接到 mongodb 服务
            MongoClient mongoClient = new MongoClient(address, port);
            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("admin");
            System.out.println("Connect to database successfully");
            mongoClient.close();
            }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }


    /**public static void connectMongoDB(String address, int port)throws Exception{
        try {
            //连接到MongoDB服务 如果是远程连接可以替换“localhost”为服务器所在IP地址
            //ServerAddress()两个参数分别为 服务器地址 和 端口
            ServerAddress serverAddress = new ServerAddress("210.13.50.105",27017);
            List<ServerAddress> addrs = new ArrayList<ServerAddress>();
            addrs.add(serverAddress);

            //MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码
            MongoCredential credential = MongoCredential.createScramSha1Credential("username", "databaseName", "password".toCharArray());
            List<MongoCredential> credentials = new ArrayList<MongoCredential>();
            credentials.add(credential);

            //通过连接认证获取MongoDB连接
            MongoClient mongoClient = new MongoClient(addrs,credentials);

            //连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("databaseName");
            System.out.println("Connect to database successfully");

        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }*/
    public static void createCollection(String address, int port)throws Exception{
        try{
            // 连接到 mongodb 服务
            MongoClient mongoClient = new MongoClient(address, port);
            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("admin");
            System.out.println("Connect to database successfully");
            mongoDatabase.createCollection("testpaas");
            System.out.println("集合创建成功");
            mongoClient.close();

        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }
    public static void insertCollection(String address, int port)throws Exception{
        try{
            // 连接到 mongodb 服务
            MongoClient mongoClient = new MongoClient(address, port);

            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("admin");
            System.out.println("Connect to database successfully");

            MongoCollection<Document> collection = mongoDatabase.getCollection("testpaas");
            System.out.println("集合 test 选择成功");
            //插入文档
            /**
             * 1. 创建文档 org.bson.Document 参数为key-value的格式
             * 2. 创建文档集合List<Document>
             * 3. 将文档集合插入数据库集合中 mongoCollection.insertMany(List<Document>) 插入单个文档可以用 mongoCollection.insertOne(Document)
             * */
            Document document = new Document("title", "MongoDB").
                    append("description", "database").
                    append("likes", 100).
                    append("by", "Fly");
            List<Document> documents = new ArrayList<Document>();
            documents.add(document);
            collection.insertMany(documents);
            System.out.println("文档插入成功");
        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }
    public static void getCollection(String address, int port)throws Exception{
        try{
            // 连接到 mongodb 服务
            MongoClient mongoClient = new MongoClient(address, port);

            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("admin");
            System.out.println("Connect to database successfully");

            MongoCollection<Document> collection = mongoDatabase.getCollection("testpaas");
            System.out.println("集合 test 选择成功");
        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }
    public static void getDocuments(String address, int port)throws Exception{
        try{
            // 连接到 mongodb 服务
            MongoClient mongoClient = new MongoClient(address, port);

            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("admin");
            System.out.println("Connect to database successfully");

            MongoCollection<Document> collection = mongoDatabase.getCollection("testpaas");
            System.out.println("集合 test 选择成功");

            //检索所有文档
            /**
             * 1. 获取迭代器FindIterable<Document>
             * 2. 获取游标MongoCursor<Document>
             * 3. 通过游标遍历检索出的文档集合
             * */
            FindIterable<Document> findIterable = collection.find();
            MongoCursor<Document> mongoCursor = findIterable.iterator();
            while(mongoCursor.hasNext()){
                System.out.println(mongoCursor.next());
            }

        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }
    public static void updateDocument(String address, int port)throws Exception{
        try{
            // 连接到 mongodb 服务
            MongoClient mongoClient = new MongoClient(address, port);

            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("admin");
            System.out.println("Connect to database successfully");

            MongoCollection<Document> collection = mongoDatabase.getCollection("testpaas");
            System.out.println("集合 test 选择成功");

            //更新文档   将文档中likes=100的文档修改为likes=200
            collection.updateMany(Filters.eq("likes", 100), new Document("$set",new Document("likes",200)));
            //检索查看结果
            FindIterable<Document> findIterable = collection.find();
            MongoCursor<Document> mongoCursor = findIterable.iterator();
            while(mongoCursor.hasNext()){
                System.out.println(mongoCursor.next());
            }

        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }
    public static void deleteDocuments(String address, int port)throws Exception{
        try{
            // 连接到 mongodb 服务
            MongoClient mongoClient = new MongoClient(address, port);

            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("admin");
            System.out.println("Connect to database successfully");

            MongoCollection<Document> collection = mongoDatabase.getCollection("testpaas");
            System.out.println("集合 test 选择成功");

            //删除符合条件的第一个文档
            collection.deleteOne(Filters.eq("likes", 200));
            //删除所有符合条件的文档
            collection.deleteMany (Filters.eq("likes", 200));
            //检索查看结果
            FindIterable<Document> findIterable = collection.find();
            MongoCursor<Document> mongoCursor = findIterable.iterator();
            while(mongoCursor.hasNext()){
                System.out.println(mongoCursor.next());
            }

        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }


}

