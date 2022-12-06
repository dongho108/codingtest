package programmers.p138477


fun main() {
    val solution = Solution()
//    val message = solution.solution(3, intArrayOf(10, 100, 20, 150, 1, 100, 200))
//    for (i in message) {
//        println(i)
//    }

    val message = solution.solution(4, intArrayOf(0, 300, 40, 300, 20, 70, 150, 50, 500, 1000))
    for (i in message) {
        println(i)
    }
}

/*
1. 프로그래머스에서 정수 리스트 반환은 보통 IntArray로 한다. list에 toIntArray 메서드를 이용한다.
2. list 정렬 메서드를 잘 이용하자.
 */

class Solution {
    fun solution(k: Int, score: IntArray): IntArray {
        val answer: MutableList<Int> = mutableListOf()
        val rank: MutableList<Int> = mutableListOf()

        for (s in score) {
            rank.add(s)
            rank.sortDescending()
            if (rank.size > k) {
                rank.removeLast()
            }
            answer.add(rank.last())
        }
        return answer.toIntArray()
    }
}