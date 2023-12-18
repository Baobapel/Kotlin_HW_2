import kotlin.math.max

 const val ERROR_TYPE = -1.0
 const val ERROR_LIMIT = -2.0
fun main() {
    println(
        calculateCommission(
            cardType = " ",
            amountTransfersInMonth = 74000.0,
            currentDaySum = 2000.0
        )
    )
}


//_______________________________________________________
fun calculateCommission(
    cardType: String = "VKPay",
    amountTransfersInMonth: Double = 0.0,
    currentDaySum: Double
): Any {
    return when (cardType) {
        "Mastercard", "Maestro" -> {
            if (isInBaseLimits(currentDaySum, amountTransfersInMonth)) {
                if (currentDaySum + amountTransfersInMonth > 75000.0) {
                    ((currentDaySum + amountTransfersInMonth) - 75000.0) * 0.006 + 20.0
                } else {
                    0.0
                }
            } else {
                ERROR_LIMIT
            }
        }

        "Visa", "Мир" -> {
            if (isInBaseLimits(currentDaySum, amountTransfersInMonth)) {
                max(currentDaySum * 0.0075, 35.0)
            } else ERROR_LIMIT
        }

        "VKPay" -> {
            if (currentDaySum <= 15_000.00 && amountTransfersInMonth + currentDaySum <= 40000.00) {
                0.0
            } else ERROR_LIMIT
        }

        else -> ERROR_TYPE
    }

}

fun isInBaseLimits(
    currentDaySum: Double,
    amountTransfersInMonth: Double
): Boolean = currentDaySum <= 150_000.00 && amountTransfersInMonth + currentDaySum <= 600_000.00