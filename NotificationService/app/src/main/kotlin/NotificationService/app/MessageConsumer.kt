package NotificationService.app

import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.clients.consumer.Consumer
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.kafka.common.serialization.StringDeserializer
import java.time.Duration

class MessageConsumer(brokers: String) {

    val consumer = createKafkaConsumer(brokers)

    fun createKafkaConsumer(brokers: String): Consumer<String, String> {
        val props = java.util.Properties()
        props["bootstrap.servers"] = brokers
        props["group.id"] = "orders"
        props["key.deserializer"] = StringDeserializer::class.java
        props["value.deserializer"] = StringDeserializer::class.java
        return KafkaConsumer<String, String>(props)
    }

    fun consume(): List<String> {
        val ordersTopic = "orders"
        consumer.subscribe(listOf(ordersTopic))
        val output = ArrayList<String>()
        while(true) {
            val results = consumer.poll(Duration.ofSeconds(1))
            results.iterator().forEach {
                val message = it.value()
                output.add(message)
                if (message.equals("Order Successful")) {
                    println("Thank you for your order")
                    println("The order will be delivered in 3 days")
                } else {
                    println("Sorry order could not be placed")
                }
            }
        }
    }
}