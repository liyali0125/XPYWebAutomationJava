package util.paas;

import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class RedisVerification {
    /**
     * 链接服务
     * @param address
     * @param port
     * @throws Exception
     */
    public static void connectRedis(String address, int port)throws Exception {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis(address,port);
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
    }

    /**
     * 插入数据
     * @param address
     * @param port
     * @throws Exception
     */
    public static void insertData(String address, int port)throws Exception {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis(address, port);
        System.out.println("连接成功");
        //设置 redis 字符串数据
        jedis.set("passweb", "paasweb.tpaas.youedata.com");
        // 获取存储的数据并输出
        System.out.println("redis 存储的字符串为: "+ jedis.get("passweb"));
    }

    /**
     * 插入数据列表
     * @param address
     * @param port
     * @throws Exception
     */
    public static void insertListData(String address, int port)throws Exception {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis(address,port);
        System.out.println("连接成功");
        //存储数据到列表中
        jedis.lpush("weisite", "passweb1");
        jedis.lpush("weisite", "passweb2");
        jedis.lpush("weisite", "passweb3");
        // 获取存储的数据并输出
        List<String> list = jedis.lrange("site-list", 0 ,2);
        for(int i=0; i<list.size(); i++) {
            System.out.println("列表项为: "+list.get(i));
        }
    }

    /**
     * 获取数据
     * @param address
     * @param port
     * @throws Exception
     */
    public static void getData(String address, int port)throws Exception {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis(address,port);
        System.out.println("连接成功");

        // 获取数据并输出
        Set<String> keys = jedis.keys("*");
        Iterator<String> it=keys.iterator() ;
        while(it.hasNext()){
            String key = it.next();
            System.out.println(key);
        }
    }
}
