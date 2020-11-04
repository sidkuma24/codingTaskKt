package NotificationService.app

import NotificationService.app.MessageConsumer

class Notifications {

    fun sendOrderNotifications() {
        MessageConsumer("localhost:9092").consume()
    }
}