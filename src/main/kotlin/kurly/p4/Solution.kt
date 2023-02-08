package kurly.p4

import kotlin.math.abs
import kotlin.math.max

fun main(args: Array<String>) {
    val n = readLine().toString().toInt()
    var containers = mutableListOf<Int>()
    for (i in 0 until n) {
        containers.add(readLine().toString().toInt())
    }
    containers.sortByDescending { abs(it) }

    var firstPos = -1
    var firstNeg = -1
    for ((i, c) in containers.withIndex()) {
        if (firstPos != -1 && firstNeg != -1) {
            break
        }
        if (firstPos == -1 && c > 0) {
            firstPos = i
            continue
        }
        if (firstNeg == -1 && c < 0) {
            firstNeg = i
            continue
        }
    }
    val answer = max(stackUp(containers, firstPos), stackUp(containers, firstNeg))
    println(answer)
}

fun stackUp(containers: MutableList<Int>, startIndex: Int): Int {
    var count = 1
    if (startIndex == -1) {
        return count
    }
    for (i in startIndex + 1 until containers.size) {
        if (!isSameSign(containers[i - 1], containers[i])) {
            count++
        }
    }
    return count
}

fun isSameSign(a: Int, b: Int): Boolean {
    return (a < 0 && b < 0) || (a > 0 && b > 0)
}
