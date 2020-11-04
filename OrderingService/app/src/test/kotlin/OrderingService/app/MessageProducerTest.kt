package OrderingService.app

import org.apache.kafka.clients.producer.KafkaProducer
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertTrue


class MessageProducerTest {

    val mockBroker = "localhost:9092"
    val mockOrderStatus = ""

    @Test
    fun testCreateKafkaProducer() {
        var msgProducer = MessageProducer(mockBroker)
        var actualProducer = msgProducer.createKafkaProducer(mockBroker)
        assertTrue(actualProducer is KafkaProducer<String, String>)
    }
}