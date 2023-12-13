import kotlin.math.max

private const val ERROR_TYPE = -1.0
private const val ERROR_LIMIT = -2.0
fun main() {
    println(
        calculateCommission(
            cardType = "Maestro",
            amountTransfersInMonth = 74001.0,
            currentDaySum = 1000.0
        )
    )
}

val minCommissionOnMM = 20.0
val minCommissionOnVM = 35.0
val dayLimit = 150000.00
val monthLimit = 600000.00
val vkDayLimit = 15000.00
val vkMonthLimit = 40000.00

//_______________________________________________________
fun calculateCommission(
    cardType: String = "VKPay",
    amountTransfersInMonth: Double = 0.0,
    currentDaySum: Double
): Any {
    return when (cardType) {
        "Mastercard", "Maestro" -> {
            if (isInBaseLimits(currentDaySum, amountTransfersInMonth)) {
                if (currentDaySum + amountTransfersInMonth < 75000.0) {
                    0.0
                } else if (amountTransfersInMonth > 75000.0) {
                    (currentDaySum) * 0.006 + minCommissionOnMM
                } else if (currentDaySum + amountTransfersInMonth > 75000.0) {
                    ((currentDaySum + amountTransfersInMonth) - 75000.0) * 0.006 + minCommissionOnMM
                } else {
                    0.0
                }
            } else {
                ERROR_LIMIT
            }
        }

        "Visa", "Мир" -> {
            if (isInBaseLimits(currentDaySum, amountTransfersInMonth)) {
                max(currentDaySum * 0.0075, minCommissionOnVM)
            } else ERROR_LIMIT
        }

        "VKPay" -> {
            if (currentDaySum <= vkDayLimit && amountTransfersInMonth + currentDaySum <= vkMonthLimit) {
                0.0
            } else ERROR_LIMIT
        }

        else -> ERROR_TYPE
    }

}

fun isInBaseLimits(
    currentDaySum: Double,
    amountTransfersInMonth: Double
): Boolean = currentDaySum <= dayLimit && amountTransfersInMonth + currentDaySum <= monthLimit