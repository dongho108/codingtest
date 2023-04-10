package programmers.p12951

import java.util.*

fun main() {
    val solution = Solution()

    println(solution.solution("3people unFollowed me"))
    println(solution.solution("for the last week"))
    println(solution.solution(" for the last week "))
    println(solution.solution("for    the last week"))
    println(solution.solution("a a a"))
    println(solution.solution("a"))
    println(solution.solution("23peo UnFoLow me "))
    println(solution.solution("Peo unFoLow me "))
}

class Solution {
    fun solution(s: String): String {
        var answer = ""
        val lowerS = s.lowercase(Locale.getDefault())
        for ((index, lowerC) in lowerS.withIndex()) {
            if (index == 0) {
                if (lowerC.isLetter()) {
                    answer += lowerC.uppercaseChar()
                    continue
                }
                answer += lowerC
                continue
            }
            if (lowerS[index - 1].isWhitespace() && lowerC.isLetter()) {
                answer += lowerC.uppercaseChar()
                continue
            }
            answer += lowerC
        }
        return answer
    }
}
