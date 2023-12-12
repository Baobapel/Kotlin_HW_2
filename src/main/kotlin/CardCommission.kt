const val ERROR_TYPE = -1
const val ERROR_LIMIT = -2
fun main() {
 println(commissionCalculation("Mastercard", 10000.00, 1000.00 ))
}

fun commissionCalculation(
    cardType: String,
    amountTransfersInMonth: Double,
    currentDaySum: Double
): Double {
    var commission = 0.0
    val minCommissionOnMM = 20.0
    val minCommissionOnVM = 35.0
    val dayLimit = 150000.00
    val monthLimit = 600000.00
    val vkDayLimit = 15000.00
    val vkMonthLimit = 40000.00
    if ((cardType == "Mastercard" || cardType == "Maestro") && amountTransfersInMonth <= 75000.00) {
        commission = 0.0
    } else if (currentDaySum >= dayLimit || amountTransfersInMonth >= monthLimit) {ERROR_LIMIT}
    else {
        commission = currentDaySum * 0.006 + minCommissionOnMM
    }

         if (cardType == "Visa" || cardType == "Мир") {
             if (currentDaySum > dayLimit || amountTransfersInMonth > monthLimit) {ERROR_LIMIT}
        } else if (currentDaySum * 0.0075 < minCommissionOnVM) {
             commission = minCommissionOnVM
         } else {
             currentDaySum * 0.0075
         }

        if (cardType == "VKPay") {
            commission = 0.0
        } else if (currentDaySum > vkDayLimit || amountTransfersInMonth > vkMonthLimit) {ERROR_LIMIT}
     return commission
}


