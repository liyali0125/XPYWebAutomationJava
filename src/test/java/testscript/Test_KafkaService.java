/*
 * @FileName Test_KafkaService: Test Kafka Scripts
 * @outhor davieyang
 * @create 2018-08-20 14:39
 */
package testscript;

import org.testng.annotations.Test;

import static util.paas.KafkaVerification.consumer;
import static util.paas.KafkaVerification.producer;

public class Test_KafkaService {
    @Test
    public void test_kafka(){
        producer("210.13.50.105:32511", "topicname");
        consumer("210.13.50.105:32511", "topicname");
    }
}
