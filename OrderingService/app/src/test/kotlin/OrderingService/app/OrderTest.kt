
package OrderingService.app

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class OrderTest {

    val EXPECTED_COST = 2.05;
    val EXPECTED_COST_WITH_OFFER = 1.45;
    val ITEM_LIST = "apple, apple, orange, apple";

    @Test
    fun testComputeCost() {
        val order = Order(ITEM_LIST.split(","));
        order.computeCost();
        assertEquals(EXPECTED_COST, order.cost);
    }

    @Test
    fun testComputeCostWithOffer() {
        val order = Order(ITEM_LIST.split(","));
        order.computeCostWithOffer();
        assertEquals(EXPECTED_COST_WITH_OFFER, order.cost);
    }
}
