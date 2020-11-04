package OrderingService.app

import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.Producer
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.serialization.StringSerializer

class MessageProducer(brokers: String) {

    val producer = createKafkaProducer(brokers)

    fun createKafkaProducer(brokers: String): Producer<String, String> {
        val props = java.util.Properties()
        props["bootstrap.servers"] = brokers
        props["key.serializer"] = StringSerializer::class.java
        props["value.serializer"] = StringSerializer::class.java
        return KafkaProducer<String, String>(props)
    }

    fun produce(orderStatus : String) {
        val ordersTopic = "orders"
        val resultFuture = producer.send(ProducerRecord(ordersTopic, orderStatus))
        resultFuture.get();
    }
}