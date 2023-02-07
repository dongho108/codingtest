package goorm.p88520

import kotlin.math.min

fun main(args: Array<String>) {
    var test = readLine().toString().toInt()

    for (t in 0 until test) {
        val input = readLine().toString().split(" ")
        val n = input[0].toInt()
        val k = input[1].toInt()

        var land = mutableListOf<List<Int>>()
        for (nn in 0 until n) {
            land.add(readLine().toString().split(" ").map { it.toInt() })
        }

        var min = n * n + 1
        for (i in 0..(n - k)) {
            for (j in 0..(n - k)) {
                var count = 0
                for (x in i until i + k) {
                    for (y in j until j + k) {
                        if (land[x][y] == 1) {
                            count++
                        }
                    }
                }
                min = min(min, count)
            }
        }
        println(min)
    }
}
