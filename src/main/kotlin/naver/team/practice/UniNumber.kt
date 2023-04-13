package naver.team.practice

import java.lang.StringBuilder

fun main() {
    val n = readLine()
    var uni = 0
    var base = 0

    for (i in 2..9) {
        val convertedS = convertBase(n!!, i)
        val multiple = convertMultipleExcludeZero(convertedS)
        if (uni <= multiple) {
            uni = multiple
            base = i
        }
    }
    println("$base $uni")
}

fun convertMultipleExcludeZero(convertedS: String): Int {
    var temp = 1
    for (c in convertedS) {
        if (c != '0') {
            temp *= c.toString().toInt()
        }
    }
    return temp
}

fun convertBase(n: String, base: Int): String {
    var value = n.toInt()
    val builder: StringBuilder = StringBuilder()
    while (value >= 1) {
        builder.insert(0, value % base)
        value /= base
    }
    return builder.toString()
}
