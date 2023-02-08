package kurly.p3

import kotlin.math.max

// 이미 정해진 수는 다시 할 필요 없다.
// 저장해서 가져오면 될듯

// 2의 제곱수에 도착한 순간 이미 정해짐.


fun main(args: Array<String>) {
    val input = readLine().toString().split(" ").map { it.toInt() }
    val a = input[0]
    val b = input[1]

    var answer = 0
    for (n in a..b) {
        answer = max(answer, cycle(n))
    }
    println(answer)
}

fun cycle(n: Int): Int {
    var tempN = n
    var count = 1
    while (tempN != 1) {
        count++
        if (tempN % 2 == 0) {
            tempN /= 2
        } else {
            tempN = tempN * 3 + 1
        }
    }
    return count
}
