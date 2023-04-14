package programmers.p64062

fun main() {
    val solution = Solution()
    println(solution.solution(intArrayOf(2, 4, 5, 3, 2, 1, 4, 2, 5, 1), 3))
//    println(solution.solution(intArrayOf(2, 4, 5, 3, 2, 1, 4, 2, 5, 1), 10))
//    println(solution.solution(intArrayOf(1, 2, 3), 1))
//    println(solution.solution(intArrayOf(1, 2, 3), 2))
//    println(solution.solution(intArrayOf(1, 2, 3), 3))
}

class Solution {
    fun solution(stones: IntArray, k: Int): Int {
        var start = 0
        var end = stones.maxOf { it }
        var answer = 0

        while (start <= end) {
            val mid = (start + end) / 2
//            println("$start, $end, $mid")
            if (canArrive(stones, mid, k)) {
                start = mid + 1
                answer = mid
            } else {
                end = mid - 1
            }
        }
        return answer
    }

    private fun canArrive(stones: IntArray, mid: Int, k: Int): Boolean {
        // mid 명이 지나갈 수 있는지 확인은
        // 1. mid - 1 만큼 다 깎아.
        // 2. 연속으로 k만큼 0보다 작은거 있는지 확인
        val copyStones = stones.clone()
        for (i in copyStones.indices) {
            copyStones[i] -= (mid - 1)
        }

        var maxZero = 0
        var zeroCount = 0
        for (stone in copyStones) {
            if (stone <= 0) {
                zeroCount++
                if (maxZero < zeroCount) {
                    maxZero = zeroCount
                }
            } else {
                zeroCount = 0
            }
        }
        return k > maxZero
    }
}
