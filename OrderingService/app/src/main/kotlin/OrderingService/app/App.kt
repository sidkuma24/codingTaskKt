package OrderingService.app

import kotlinx.cli.*
import OrderingService.app.Order

fun main(args: Array<String>) {
    val parser = ArgParser(" ")

    // define parser options
    val items by parser.option(ArgType.String, shortName = "I", description = "Items").default("")

    // parse CLI aruments
    parser.parse(args)

    if (!items.equals("")) {
        var itemList = items.split(",")
        var order = Order(itemList)

        order.computeCostWithOffer();

        // Output
        println(order.toString())
        order.placeOrder();
    }
}




