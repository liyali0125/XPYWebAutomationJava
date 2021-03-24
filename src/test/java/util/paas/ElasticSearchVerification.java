package util.paas;
import com.google.gson.JsonObject;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class ElasticSearchVerification {
    private Logger logger = LoggerFactory.getLogger(ElasticSearchVerification.class);
    public void connectES() throws UnknownHostException {
        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("210.13.50.105"),32153));
        logger.info("Elasticsearch connect info:" + client.toString());
        System.out.println(client.toString());
        //关闭客户端
        client.close();
    }
    public void createIndex() throws IOException {
        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("210.13.50.105"),32153));
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject()
                .field("name","zhangsan")
                .field("age",27)
                .field("position","technique english")
                .field("country","China")
                .field("join_date","2017-01-01")
                .field("salary","10000")
                .endObject();
        IndexResponse response = client.prepareIndex("company", "employee", "6").setSource(builder).get();
        logger.info("索引名称:" + response.getIndex() + "\n类型:" + response.getType()
                + "\n文档ID:" + response.getId() + "\n当前实例状态:" + response.status());
        System.out.println(response.getResult());
        //关闭客户端
        client.close();
    }
    public void insertJson() throws UnknownHostException {
        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("210.13.50.105"),32153));
        String jsonStr = "{" +
                "\"userName\":\"张三\"," +
                "\"sendDate\":\"2017-11-30\"," +
                "\"msg\":\"你好李四\"" +
                "}";
        IndexResponse response = client.prepareIndex("weixin", "tweet").setSource(jsonStr,XContentType.JSON).get();
        logger.info("json索引名称:" + response.getIndex() + "\njson类型:" + response.getType()
                + "\njson文档ID:" + response.getId() + "\n当前实例json状态:" + response.status());
        //关闭客户端
        client.close();
    }
    public void insertMap() throws UnknownHostException {
        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("210.13.50.105"),32153));
        Map<String, Object> map = new HashMap<String,Object>();
        map.put("userName", "张三");
        map.put("sendDate", new Date());
        map.put("msg", "你好李四");
        IndexResponse response = client.prepareIndex("momo", "tweet").setSource(map).get();
        System.out.println("map索引名称:" + response.getIndex() + "\n map类型:" + response.getType()
                + "\n map文档ID:" + response.getId() + "\n当前实例map状态:" + response.status());
        //关闭客户端
        client.close();
    }
    public void insertJsonObject() throws UnknownHostException {
        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("210.13.50.105"),32153));
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("userName", "张三");
        jsonObject.addProperty("sendDate", "2017-11-23");
        jsonObject.addProperty("msg","你好李四");
        IndexResponse response = client.prepareIndex("qq", "tweet").setSource(jsonObject, XContentType.JSON).get();
        System.out.println("jsonObject索引名称:" + response.getIndex() + "\n jsonObject类型:" + response.getType()
                + "\n jsonObject文档ID:" + response.getId() + "\n当前实例jsonObject状态:" + response.status());
        //关闭客户端
        client.close();
    }
    public void getData() throws UnknownHostException {
        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("210.13.50.105"),32153));
        GetResponse getResponse = client.prepareGet("msg", "tweet", "1").get();
        System.out.println("索引库的数据:" + getResponse.getSourceAsString());
        //关闭客户端
        client.close();
    }
    public void updateData() throws UnknownHostException {
        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("210.13.50.105"),32153));
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("userName", "王五");
        jsonObject.addProperty("sendDate", "2008-08-08");
        jsonObject.addProperty("msg","你好,张三，好久不见");
        UpdateResponse updateResponse = client.prepareUpdate("msg", "tweet", "1")
                .setDoc(jsonObject.toString(),XContentType.JSON).get();
        System.out.println("updateResponse索引名称:" + updateResponse.getIndex() + "\n updateResponse类型:" + updateResponse.getType()
                + "\n updateResponse文档ID:" + updateResponse.getId() + "\n当前实例updateResponse状态:" + updateResponse.status());
        //关闭客户端
        client.close();
    }
    public void deleteData() throws UnknownHostException {
        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("210.13.50.105"),32153));
        DeleteResponse deleteResponse = client.prepareDelete("msg", "tweet", "1").get();
        System.out.println("deleteResponse索引名称:" + deleteResponse.getIndex() + "\n deleteResponse类型:" + deleteResponse.getType()
                + "\n deleteResponse文档ID:" + deleteResponse.getId() + "\n当前实例deleteResponse状态:" + deleteResponse.status());
        //关闭客户端
        client.close();
    }
}

