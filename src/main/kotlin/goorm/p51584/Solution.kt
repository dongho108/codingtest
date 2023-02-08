package goorm.p51584

var n = 0
var m = 0

fun main(args: Array<String>) {
    val input1 = readLine().toString().split(" ")
    n = input1[0].toInt()
    m = input1[1].toInt()

    val lamps = mutableListOf<MutableList<Int>>()
    for (i in 0 until n) {
        lamps.add(readLine().toString()
            .split(" ")
            .map { it.toInt() }
            .toMutableList())
    }

    val p = readLine().toString().toInt()
    for (i in 0 until p) {
        val input2 = readLine().toString().split(" ")
        val dir = input2[0].toInt()
        val th = input2[1].toInt()

        process(dir, th, lamps)
    }

    for (i in 0 until n) {
        println(lamps[i].joinToString(" "))
    }
}

fun process(dir: Int, th: Int, lamps: MutableList<MutableList<Int>>) {
    if (dir == 0) {
        if (th > n) {
            return
        }
        for (j in 0 until m) {
            if (lamps[th - 1][j] == 0) {
                lamps[th - 1][j] = 1
            } else {
                lamps[th - 1][j] = 0
            }
        }
    } else {
        if (th > m) {
            return
        }
        for (i in 0 until n) {
            if (lamps[i][th - 1] == 0) {
                lamps[i][th - 1] = 1
            } else {
                lamps[i][th - 1] = 0
            }
        }
    }
}
