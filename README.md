## Coding Task in Kotlin

### Steps to run the program:

#### Commands To Run the Order Service
```
# OrderingService/
$ gradle run && gradle jar
$ java -jar app/build/libs/app.jar -I "Apple, Orange, Apple, Apple, Orange"
```

#### Commands To Run the Notification Service
+ Create a new terminal instance and run the following command.
```
# NotificationService/
$ gradle run
```

+ The Notification Service uses Kafka to consume messages and the Order service produces messages when an order is placed

#### Steps to get Kafka setup and running
+ Follow the step give [here](https://kafka.apache.org/quickstart).
+ Create the 'orders' topic: 
```
$ bin/kafka-console-consumer.sh --topic orders --from-beginning --bootstrap-server localhost:9092
```
