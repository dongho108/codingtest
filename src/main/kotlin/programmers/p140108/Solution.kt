package programmers.p140108

fun main() {
    val solution = Solution()
    println(solution.solution("banana"))
    println(solution.solution("abracadabra"))
    println(solution.solution("aaabbaccccabba"))
}

class Solution {
    fun solution(s: String): Int {
        var firstLetter = ""
        var firstCount = 0
        var diffCount = 0
        var result = 0

        for (letter in s) {
            if (firstLetter.isEmpty()) {
                firstLetter = letter.toString()
                firstCount += 1
                continue
            }

            if (firstLetter == letter.toString()) {
                firstCount += 1
            } else {
                diffCount += 1
            }
            if (firstCount == diffCount) {
                result += 1
                firstCount = 0
                diffCount = 0
                firstLetter = ""
            }
        }

        if (firstLetter.isNotEmpty()) {
            result += 1
        }

        return result
    }
}