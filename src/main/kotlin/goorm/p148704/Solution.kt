package goorm.p148704

import java.util.Scanner
fun main(args: Array<String>) {
    val input = readLine().toString().split(" ")
    val n = input[0].toInt()
    val k = input[1].toInt()

    var words = mutableListOf<String>()
    for (i in 0 until n) {
        words.add(readLine().toString())
    }

    words.sortWith(compareBy({it.length}, {it}))
    println(words[k - 1])
}
