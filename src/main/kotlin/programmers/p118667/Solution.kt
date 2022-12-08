package programmers.p118667

fun main() {
//    println(Solution().solution(intArrayOf(3, 2, 7, 2), intArrayOf(4, 6, 5, 1)))
    println(Solution().solution(intArrayOf(1, 2, 1, 2), intArrayOf(1, 10, 1, 2)))
}

class Solution {

    fun solution(queue1: IntArray, queue2: IntArray): Int {
        val q1 = queue1.toMutableList()
        val q2 = queue2.toMutableList()
        var sumQ1 = q1.sum().toLong()
        var sumQ2 = q2.sum().toLong()
        val target = (sumQ1 + sumQ2) / 2
        var i = 0
        var j = 0
        var maxQueueSize = q1.size * 2

        while (i < maxQueueSize && j < maxQueueSize && sumQ1 != sumQ2) {
            if (sumQ1 < target) {
                sumQ1 += q2[j]
                sumQ2 -= q2[j]
                q1.add(q2[j])
                j++
            } else {
                sumQ1 -= q1[i]
                sumQ2 += q1[i]
                q2.add(q1[i])
                i++
            }
        }

        return if (sumQ1 == target) {
            i + j
        } else {
            -1
        }
    }
}
