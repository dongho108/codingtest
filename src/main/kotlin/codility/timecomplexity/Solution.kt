package codility.timecomplexity

fun main() {
    println(solution(intArrayOf(2, 3, 1, 4)))
}

fun solution(A: IntArray): Int {
    A.sort()
    var current = 0
    for (i in A) {
        current++
        if (i != current) {
            return current
        }
    }
    return ++current
}
