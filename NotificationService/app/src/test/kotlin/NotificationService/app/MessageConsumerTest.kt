package NotificationService.app

import org.apache.kafka.clients.consumer.KafkaConsumer
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertTrue

class MessageConsumerTest {

    val mockBroker = "localhost:9092"

    @Test
    fun testCreateKafkaConsumer() {
        var messageConsumer = MessageConsumer(mockBroker)
        var actualConsumer = messageConsumer.createKafkaConsumer(mockBroker)
        assertTrue(actualConsumer is KafkaConsumer<String, String>);
    }
}