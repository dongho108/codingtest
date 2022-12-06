package programmers.p135808

fun main() {
    val solution = Solution()
    println(solution.solution(4, 3, intArrayOf(4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2)))
}

class Solution {
    fun solution(k: Int, m: Int, score: IntArray): Int {
        var answer: Int = 0
        score.sortDescending()
        var boxSize = 0
        var price = 1
        for (s in score) {
            boxSize++
            if (boxSize == m) {
                price = s
//                println("${boxSize}, ${price}")
                answer += (boxSize) * price
                boxSize = 0
            }
        }
        return answer
    }
}
