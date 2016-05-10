package org.apache.kafka;


import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by jiyongwang on 5/9/16.
 */
public class KafkaSimpleConsumerTest {
    @Test
    public void testConsumerConfig() {
        KafkaSimpleConsumer kafkaSimpleConsumer = new KafkaSimpleConsumer(1, "localhost:9092", 9092);
        Assert.assertEquals(kafkaSimpleConsumer.getPort(), 9092, "Port is not 9092");
        Assert.assertEquals(kafkaSimpleConsumer.getBrokerList(), "localhost:9092", "BrokerList is not right");
    }

    @Test(enabled = false)
    public void testGetOneMessage() {
        KafkaSimpleConsumer kafkaSimpleConsumer = new KafkaSimpleConsumer(1, "localhost", 9092);
        try {
            String oneMessage = kafkaSimpleConsumer.getOneMessage(1, "test", 0, kafkaSimpleConsumer.getM_replicaBrokers(),
                    kafkaSimpleConsumer.getPort(), KafkaSimpleConsumer.OFFSET_DIRECTION.FROM_BEGINNING, 1);
            System.out.println(oneMessage);
            String lastOneMessage = kafkaSimpleConsumer.getOneMessage(1, "test", 0, kafkaSimpleConsumer.getM_replicaBrokers(),
                    kafkaSimpleConsumer.getPort(), KafkaSimpleConsumer.OFFSET_DIRECTION.FROM_END, 1);
            System.out.println(lastOneMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
