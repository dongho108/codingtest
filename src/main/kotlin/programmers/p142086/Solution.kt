package programmers.p142086

fun main() {
    println(Solution().solution("banana").toMutableList())
}

class Solution {
    fun solution(s: String): IntArray {
        var answer = MutableList(s.length) {-1}

        for ((i, c) in s.withIndex()) {
            if (i == 0) {
                continue
            }
            var count = 0
            for (j in i - 1 downTo 0) {
                count++
                if (s[j] == c) {
                    answer[i] = count
                    break
                }
            }
        }
        return answer.toIntArray()
    }
}
