FROM openjdk:8u151-jdk-alpine3.7

# Install bash
RUN apk add --no-cache bash libc6-compat

# Copy resources
WORKDIR /
COPY wait-for-it.sh wait-for-it.sh
COPY target/kafka-spark-flink-project-1.0-SNAPSHOT-jar-with-dependencies.jar kafka-spark-flink-example.jar

RUN ["chmod", "+x", "./wait-for-it.sh"]

# wait for zookeeper and kafka to be available and run application
CMD ./wait-for-it.sh -s  -t 30 $EXAMPLE_ZOOKEEPER_SERVER -- ./wait-for-it.sh -s -t 30 $EXAMPLE_KAFKA_SERVER -- java -Xmx512m -jar kafka-spark-flink-example.jar