package com.quangtn.kafka.cli;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quangtn.kafka.commons.Commons;
import org.quangtn.kafka.consumer.KafkaConsumerExample;
import org.quangtn.kafka.consumer.KafkaFlinkConsumerExample;
import org.quangtn.kafka.consumer.KafkaSparkConsumerExample;
import org.quangtn.kafka.consumer.KafkaProducerExample;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(final String... args) {
        String EXAMPLE_GOAL = System.getenv("EXAMPLE_GOAL") != null ?
                System.getenv("EXAMPLE_GOAL"): "producer";

        logger.info("Kafka Topic: {}", Commons.EXAMPLE_KAFKA_TOPIC);
        logger.info("Kafka Server: {}", Commons.EXAMPLE_KAFKA_SERVER);
        logger.info("Zookeeper Server: {}", Commons.EXAMPLE_ZOOKEEPER_SERVER);
        logger.info("GOAL: {}", EXAMPLE_GOAL);

        switch (EXAMPLE_GOAL.toLowerCase()) {
            case "producer":
                KafkaProducerExample.main();
                break;
            case "consumer.kafka":
                KafkaConsumerExample.main();
                break;
            case "consumer.spark":
                KafkaSparkConsumerExample.main();
                break;
            case "consumer.flink":
                KafkaFlinkConsumerExample.main();
                break;
            default:
                logger.error("No valid goal to run.");
                break;
        }
    }
}
