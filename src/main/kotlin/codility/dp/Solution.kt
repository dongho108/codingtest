package codility.dp

import kotlin.math.max

fun main() {
    println(solution(intArrayOf(1, -2, 0, 9, -1, -2)))
}

fun solution(A: IntArray): Int {

    val N = A.size
    val answer = MutableList(N + 6) { A[0] }

    for (i in 1 until N) {
        var max = -10001
        for (j in i until i + 6) {
            max = max(answer[j], max)
        }
        answer[i + 6] = A[i] + max
    }
    return answer.last()
}


