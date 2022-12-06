package programmers.p136798

class Solution {
    fun solution(number: Int, limit: Int, power: Int): Int {
        var answer: Int = 0

        for (n in 1..number) {
            var attack = getDivisorsSize(n)
            if (attack > limit) {
                attack = power
            }
            answer += attack
        }

        return answer
    }

    // 약수의 개수 구하는 시간 절반으로 줄이기
    fun getDivisorsSize(number: Int): Int {
        var count = 1
        for (i in 1..number / 2) {
            if (number % i == 0) {
                count++
            }
        }
        return count
    }
}
