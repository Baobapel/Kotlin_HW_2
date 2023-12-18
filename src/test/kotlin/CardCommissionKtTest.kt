import org.junit.Test

import org.junit.Assert.*

class CardCommissionKtTest {

    @Test
    fun maestroMastercardNoCommission() {
        val cardType = "Maestro"
        val amountTransfersInMonth = 10000.00
        val currentDaySum = 100.00


        val result = calculateCommission(cardType, amountTransfersInMonth, currentDaySum)

        assertEquals(0.0, result)
    }


    @Test
    fun maestroMaestroOverAmountTransferInMonth() {
        val cardType = "Maestro"
        val amountTransfersInMonth = 74000.00
        val currentDaySum = 2000.00


        val result = calculateCommission(cardType, amountTransfersInMonth, currentDaySum)

        assertEquals(26.0, result)
    }

    @Test
    fun maestroMastercardOverAmountTransferInMonth() {
        val cardType = "Mastercard"
        val amountTransfersInMonth = 74000.00
        val currentDaySum = 2000.00


        val result = calculateCommission(cardType, amountTransfersInMonth, currentDaySum)

        assertEquals(26.0, result)
    }

    @Test
    fun visaCommission() {
        val cardType = "Visa"
        val amountTransfersInMonth = 74000.00
        val currentDaySum = 2000.00


        val result = calculateCommission(cardType, amountTransfersInMonth, currentDaySum)

        assertEquals(35.0, result)
    }

    @Test
    fun mirCommission() {
        val cardType = "Мир"
        val amountTransfersInMonth = 74000.00
        val currentDaySum = 2000.00


        val result = calculateCommission(cardType, amountTransfersInMonth, currentDaySum)

        assertEquals(35.0, result)
    }

    @Test
    fun visaMirErrorLimit() {
        val cardType = "Visa"
        val amountTransfersInMonth = 600000.00
        val currentDaySum = 2000.00


        val result = calculateCommission(cardType, amountTransfersInMonth, currentDaySum)

        assertEquals(-2.0, result)
    }

    @Test
    fun vkPayCommission() {
        val cardType = "VKPay"
        val amountTransfersInMonth = 10000.00
        val currentDaySum = 2000.00


        val result = calculateCommission(cardType, amountTransfersInMonth, currentDaySum)

        assertEquals(0.0, result)
    }

    @Test
    fun vkPayCommissionOverDayLimit() {
        val cardType = "VKPay"
        val amountTransfersInMonth = 10000.00
        val currentDaySum = 16000.00


        val result = calculateCommission(cardType, amountTransfersInMonth, currentDaySum)

        assertEquals(-2.0, result)
    }

    @Test
    fun vkPayCommissionOverMonthLimit() {
        val cardType = "VKPay"
        val amountTransfersInMonth = 36000.00
        val currentDaySum = 10000.00


        val result = calculateCommission(cardType, amountTransfersInMonth, currentDaySum)

        assertEquals(-2.0, result)
    }

    @Test
    fun otherCardsOverDayLimit() {
        val cardType = "Maestro"
        val amountTransfersInMonth = 10000.00
        val currentDaySum = 150001.00


        val result = calculateCommission(cardType, amountTransfersInMonth, currentDaySum)

        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun otherCardsOverMonthLimit() {
        val cardType = "Maestro"
        val amountTransfersInMonth = 550000.0
        val currentDaySum = 140001.00


        val result = calculateCommission(cardType, amountTransfersInMonth, currentDaySum)

        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun errorType() {
        val cardType = "Maestrojjjj"
        val amountTransfersInMonth = 550000.0
        val currentDaySum = 140001.00


        val result = calculateCommission(cardType, amountTransfersInMonth, currentDaySum)

        assertEquals(ERROR_TYPE, result)
    }
}
