package programmers.p42842

fun main() {
    println(Solution().solution(8, 1).toMutableList())
    println(Solution().solution(24, 24).toMutableList())
}

class Solution {
    fun solution(brown: Int, yellow: Int): IntArray {
        var answer = intArrayOf(0, 0)

        var yellowBox: MutableList<List<Int>> = mutableListOf()

        yellowBox.add(listOf(1, yellow))
        for (i in 2..yellow / 2) {
            if (yellow % i == 0) {
                if (i > yellow / i) {
                    break
                }
                yellowBox.add(listOf(i, yellow / i))
            }
        }
        for (box in yellowBox) {
            val x = box[0]
            val y = box[1]
            if (x + y == (brown - 4) / 2) {
                answer[0] = y + 2
                answer[1] = x + 2
            }
        }

        return answer
    }
}
