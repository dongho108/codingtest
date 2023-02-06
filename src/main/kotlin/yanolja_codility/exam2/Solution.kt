package yanolja_codility.exam2

import kotlin.math.max

fun main() {
    println(solution("abccbd", intArrayOf(0, 1, 2, 3, 4, 5)))
    println(solution("aabbcc", intArrayOf(1, 2, 1, 2, 1, 2)))
    println(solution("aaaa", intArrayOf(3, 4, 5, 6)))
    println(solution("ababa", intArrayOf(10, 5, 10, 5, 10)))
    println(solution("a", intArrayOf(10)))
}

fun solution(S: String, C: IntArray): Int {
    var answer = 0
    var i = 0
    while (i < C.size) {

        var overRange = i
        for (j in i + 1 until C.size) {
            if (S[i] == S[j]) {
                overRange = j
            } else {
                break
            }
        }

        if (i == overRange) {
            i++
            continue
        }

        // i ~ over 까지 C 최대값 찾기, 최대 빼고 다 더하기
        var max = -1
        for (j in i..overRange) {
            max = max(max, C[j])
        }
        for (j in i..overRange) {
            if (C[j] != max) {
                answer += C[j]
            }
        }

        i = overRange + 1
    }

    return answer
}
