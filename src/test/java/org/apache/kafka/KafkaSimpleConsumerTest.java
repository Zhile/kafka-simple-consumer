package org.apache.kafka;


import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
