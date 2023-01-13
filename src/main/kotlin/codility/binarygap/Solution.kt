package codility.binarygap

import kotlin.math.max

fun main() {
    println(solution(100))
}

fun solution(N: Int): Int {
    val binaryString = Integer.toBinaryString(N)
    var answer = 0
    var zeroCount = 0
    for (c in binaryString) {
        if (c == '1') {
            answer = max(zeroCount, answer)
            zeroCount = 0
        } else {
            zeroCount++
        }
    }
    return answer
}
