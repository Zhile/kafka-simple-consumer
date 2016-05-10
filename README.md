## kafka-simple-consumer  
This project is for consuming a kafka message freely. If we only use the default kafka-console-consumer.sh, we don't have too much free space to control the consume behavior. If we want to get only one message from Kafka, if there's a large volume data, it is not convenient. so this class comes up. 
## Usage
	KafkaSimpleConsumer kafkaSimpleConsumer = new KafkaSimpleConsumer(1, "localhost:9092", 9092);
	System.out.println(kafkaSimpleConsumer.getOneMessage("test-topic", 3, OFFSET_DIRECTION.FROM_END));