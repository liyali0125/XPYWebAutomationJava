package util.paas;
import java.util.Collections;
import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class KafkaVerification {
    /**
     * 创建生产者，发送消息
     * @param addressandport 服务地址及端口
     * @param topicname topic名称
     * @throws NullPointerException
     */
    public static void producer(String addressandport, String topicname)throws NullPointerException{
        Properties properties = new Properties();
        properties.put("bootstrap.servers", addressandport);
        properties.put("acks", "all");
        properties.put("retries", 0);
        properties.put("batch.size", 16384);
        properties.put("linger.ms", 1);
        properties.put("buffer.memory", 33554432);
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        try (Producer<String, String> producer = new KafkaProducer<>(properties)) {
            for (int i = 0; i < 100; i++) {
                String msg = String.format("Message %d", i);
                producer.send(new ProducerRecord<String, String>(topicname, msg));
                System.out.println("Sent:" + msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建消费者，接收消息
     * @param addressandport 服务地址及端口
     * @param topicname topic名称
     * @throws NullPointerException
     */
    public static void consumer(String addressandport, String topicname)throws NullPointerException{
        Properties properties = new Properties();
        properties.put("bootstrap.servers", addressandport);
        properties.put("group.id", "group-1");
        properties.put("enable.auto.commit", "true");
        properties.put("auto.commit.interval.ms", "1000");
        properties.put("auto.offset.reset", "earliest");
        properties.put("session.timeout.ms", "30000");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<>(properties);
        kafkaConsumer.subscribe(Collections.singletonList(topicname));
        do {
            ConsumerRecords<String, String> records = kafkaConsumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {
                System.out.printf("offset = %d, value = %s", record.offset(), record.value());
                System.out.println();
            }
        } while (true);
    }
}

