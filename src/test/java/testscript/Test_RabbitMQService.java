/*
 * @FileName Test_RabbitMQService: testing rabbitMQ
 * @outhor davieyang
 * @create 2018-08-15 17:04
 */
package testscript;

import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import static util.paas.RabbitMQVerification.Customer;
import static util.paas.RabbitMQVerification.Producer;

public class Test_RabbitMQService {
    @Test
    public void test_rabbitmq_service() throws IOException, TimeoutException, InterruptedException {
        Producer("210.13.50.105",31550,"rmq01","rmq01");
        Customer("210.13.50.105",31550,"rmq01","rmq01");
        Thread.sleep(5000);
    }
}
