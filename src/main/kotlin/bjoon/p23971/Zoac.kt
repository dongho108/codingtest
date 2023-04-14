package bjoon.p23971

import kotlin.math.ceil

fun main() {
    val inputs = readLine().toString().split(" ")
    val h = inputs[0].toInt()
    val w = inputs[1].toInt()
    val n = inputs[2].toInt()
    val m = inputs[3].toInt()

    val a = ceil(w.toDouble() / (m + 1))
    val b = ceil(h.toDouble() / (n + 1))
    println((a * b).toInt())
}
