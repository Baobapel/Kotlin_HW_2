fun main() {
    println(agoToText())
}

var seconds = 60*60*12 // <-------------МЕНЯТЬ СЕКУНДЫ ЗДЕСЬ
var minutes = 60
var hours = 3600
var day = 86400

fun minutesEnding() = when {
    seconds / minutes % 10 in 2..4 -> "минуты"
    seconds / minutes % 10 == 0
            || seconds / minutes % 10 in 5..9
            || seconds / minutes % 100 in 11..20 -> "минут"
            seconds / minutes % 10 == 1 -> "минуту"

    else -> "минут"
}

fun hoursEnding() = when {

    seconds / hours % 10 == 0
            || seconds / hours in 5..9
            || seconds / hours % 100 in 11..20 -> "часов"
               seconds / hours % 10 in 2..4 -> "часа"
    else -> "час"
}

fun agoToText(): String {
    return when {
        seconds in 0..minutes -> "был(а) только что"
        seconds in minutes + 1..hours -> "был(а) ${seconds / minutes} ${minutesEnding()} назад"
        seconds in hours + 1..day -> "был(а) ${seconds / hours} ${hoursEnding()} назад"
        seconds in day + 1..day * 2 -> "был(а) вчера"
        seconds in 2 * day + 1..day * 3 -> "был(а) позавчера"
        else -> "был(а) давно"
    }
}

