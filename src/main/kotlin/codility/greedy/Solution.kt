package codility.greedy

fun main() {
    println(solution(intArrayOf(1, 3, 7, 9, 9), intArrayOf(5, 6, 8, 9, 10)))
    println(solution(intArrayOf(), intArrayOf()))
    println(solution(intArrayOf(1), intArrayOf(5)))
}

fun solution(A: IntArray, B: IntArray): Int {
    if (A.isEmpty()) {
        return 0
    }

    if (A.size == 1) {
        return 1
    }

    var standard = B[0]
    var count = 1
    for (i in 1 until A.size) {
        if (standard < A[i]) {
            count++
            standard = B[i]
        }
    }
    return count
}
