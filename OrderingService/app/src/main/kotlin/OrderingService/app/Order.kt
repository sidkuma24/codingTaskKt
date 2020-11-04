package OrderingService.app

import OrderingService.app.MessageProducer

class Order(var itemList: List<String>, var cost: Double = 0.0) {

    var appleQty = 0
    var orangeQty = 0

    fun computeCost() {
        for (item in itemList) {
            var itemName = item.trim().toLowerCase();
            if (itemName.equals("apple")) {
                cost += 0.60;
            } else if (itemName.equals("orange")) {
                cost += 0.25;
            }
        }
    }

    fun computeCostWithOffer() {
        var appleCount = 0
        var orangeCount = 0
        for (item in itemList) {
            var itemName = item.trim().toLowerCase();
            if (itemName.equals("apple")) {
                appleQty += 1;
                appleCount = appleQty / 2 + appleQty % 2;
            } else if (itemName.equals("orange")) {
                orangeQty += 1;
                orangeCount = ((orangeQty / 3) * 2) + orangeQty % 3;
            }
        }
        cost += appleCount * 0.60 + orangeCount * 0.25;
    }

    fun placeOrder() {
        var inventory = Inventory(10, 10)
        if (appleQty <= inventory.appleQty && orangeQty <= inventory.orangeQty) {
            println("Order Successful")
            orderSuccessEvent()
        } else {
            println("Order Failed")
            orderFailedEvent()
        }
    }

    data class Inventory(var appleQty: Int = 10, var orangeQty: Int = 10) {
    }

    override fun toString(): String {
        return "$itemList => $cost"
    }

    fun orderSuccessEvent() {
        MessageProducer("localhost:9092").produce("Order Successful")
    }

    fun orderFailedEvent() {
        MessageProducer("localhost:9092").produce("Order Failed")
    }
}