fun main() {
    println(TimeChecker.agoToText())
}

val minutesEnding = when {
    TimeChecker.seconds/TimeChecker.minutes % 10 == 1 -> "минуту"
    TimeChecker.seconds/TimeChecker.minutes  % 10 in 2..4 -> "минуты"
    TimeChecker.seconds/TimeChecker.minutes  % 10 == 0
            || TimeChecker.seconds/TimeChecker.minutes % 10 in 5..9
            || TimeChecker.seconds/TimeChecker.minutes % 100 in 11..20 -> "минут"
    else -> "минут"
}

val hoursEnding = when {
    TimeChecker.seconds/TimeChecker.hours % 10 in 2..4 -> "часа"
    TimeChecker.seconds/TimeChecker.hours % 10 == 0
            || TimeChecker.seconds/TimeChecker.hours  in 5..9 -> "часов"
    else -> "час"
}

object TimeChecker {
    var seconds = 1800 // <-------------МЕНЯТЬ СЕКУНДЫ ЗДЕСЬ
    var minutes = 60
    var hours = 3600
    var day = 86400
    fun agoToText(): String {
        return when {
            seconds in 0..minutes -> "был(а) только что"
            seconds in minutes + 1..hours -> "был(а) ${seconds/minutes} $minutesEnding назад"
            seconds in hours + 1..day -> "был(а) ${seconds/hours} $hoursEnding назад"
            seconds in day + 1..day * 2 -> "был(а) вчера"
            seconds in 2 * day + 1..day * 3 -> "был(а) позавчера"
            else -> "был(а) давно"


        }
    }
}
