package util.paas;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.AMQP;

public class RabbitMQVerification {
    private final static String QUEUE_NAME="rabbitMQ.test";

    /**
     * 创建生产者，发送消息
     * @param address
     * @param port
     * @param username
     * @param password
     * @throws IOException
     * @throws TimeoutException
     */
    public static void Producer(String address, int port, String username, String password) throws IOException, TimeoutException {
        //创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //设置RabbitMQ相关信息
        factory.setHost(address);
        factory.setUsername(username);
        factory.setPassword(password);
        factory.setPort(port);
        //创建一个新的连接
        Connection connection = factory.newConnection();
        //创建一个通道
        Channel channel = connection.createChannel();
        // 声明一个队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        for (int i = 1; i<=50000;i++){
            String message = "paas test the RabbitMQ sending and receiving messqge"+i;
            //发送消息到队列中
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
            System.out.println("Producer Send +'" + message + "'");
        }
        //关闭通道和连接
        //channel.close();
        //connection.close();
    }

    /**
     * 创建消费者，接收生产者发送的消息
     * @param address
     * @param port
     * @param username
     * @param password
     * @throws IOException
     * @throws TimeoutException
     */
    public static void Customer (String address, int port, String username, String password) throws IOException, TimeoutException {
        // 创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();

        //设置RabbitMQ地址
        factory.setHost(address);
        factory.setUsername(username);
        factory.setPassword(password);
        factory.setPort(port);

        //创建一个新的连接
        Connection connection = factory.newConnection();

        //创建一个通道
        Channel channel = connection.createChannel();

        //声明要关注的队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println("Customer Waiting Received messages");

        //DefaultConsumer类实现了Consumer接口，通过传入一个频道，
        // 告诉服务器我们需要那个频道的消息，如果频道中有消息，就会执行回调函数handleDelivery
        Consumer consumer = new DefaultConsumer(channel) {
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println("Customer Received '" + message + "'");
            }
        };
        //自动回复队列应答 -- RabbitMQ中的消息确认机制
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }
}
