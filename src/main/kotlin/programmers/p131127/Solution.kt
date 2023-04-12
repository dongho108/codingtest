package programmers.p131127

fun main() {
    val solution = Solution()
    println(
        solution.solution(
            arrayOf("banana", "apple", "rice", "pork", "pot"),
            intArrayOf(3, 2, 2, 2, 1),
            arrayOf("chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana")
        )
    )
    println(
        solution.solution(
            arrayOf("apple"),
            intArrayOf(10),
            arrayOf("banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana")
        )
    )
}

class Solution {
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        var answer: Int = 0
        val wish = mutableMapOf<String, Int>()

        for ((i, w) in want.withIndex()) {
            wish[w] = number[i]
        }

        for (i in 0..discount.size) {
            // 매 i마다 10일안에 wish를 전부 다 살 수 있는지 확인
            if (checkPurchasableAllWishesBy10Days(i, wish.toMutableMap(), discount)) {
                answer++
            }
        }

        return answer
    }

    private fun checkPurchasableAllWishesBy10Days(
        startIndex: Int,
        wishes: MutableMap<String, Int>,
        discount: Array<String>
    ): Boolean {
        for (i in startIndex until startIndex + 10) {
            if (i == discount.size) {
                break
            }
            // discount[i]에 해당하는 wish를 1개씩 깎음
            val key = discount[i]
            if (wishes.containsKey(key)) {
                wishes.replace(key, wishes[key]!! - 1)
            }
        }

        // wish의 values가 전부 0이면 true
        return wishes.values.all { it <= 0 }
    }
}