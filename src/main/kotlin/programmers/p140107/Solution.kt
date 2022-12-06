package programmers.p140107

import kotlin.math.sqrt

fun main() {
    val solution = Solution()
    println(solution.solution(2, 4))
}

// 형변환도 메소드를 이용하자
class Solution {
    fun solution(k: Int, d: Int): Long {
        var answer: Long = 0
        val zz = (d * d.toDouble())
        for (i in 0..d step k) {
            val xx = (i * i.toDouble())
            val y = sqrt((zz - xx)).toInt()
            answer += ((y / k) + 1)
        }
        return answer
    }
}
