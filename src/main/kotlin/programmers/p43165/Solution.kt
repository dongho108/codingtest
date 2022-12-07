package programmers.p43165

fun main() {
    println(Solution().solution(intArrayOf(1, 1, 1, 1, 1), 3))
    println(Solution().solution(intArrayOf(4, 1, 2, 1), 4))
}

class Solution {

    private var answer = 0

    fun solution(numbers: IntArray, target: Int): Int {
        dfs(0, 0, numbers, target)
        return answer
    }

    private fun dfs(depth: Int, dfsSum: Int, numbers: IntArray, target: Int) {
        if (depth == numbers.size) {
            if (dfsSum == target) {
                answer++
            }
            return
        }
        dfs(depth + 1, dfsSum + numbers[depth], numbers, target)
        dfs(depth + 1, dfsSum - numbers[depth], numbers, target)
    }
}
