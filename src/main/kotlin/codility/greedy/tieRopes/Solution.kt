package codility.greedy.tieRopes

fun main() {
    println(solution(4, intArrayOf(1, 2, 3, 4, 1, 1, 3)))
}

fun solution(K: Int, A: IntArray): Int {
    var sum = 0
    var answer = 0

    for (a in A) {
        sum += a
        if (sum >= K) {
            answer++
            sum = 0
        }
    }
    return answer
}
