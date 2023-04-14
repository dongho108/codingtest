package bjoon.p2304

fun main() {
    val n = readLine().toString().toInt()
    val wareHouses = mutableListOf<Pair<Int, Int>>()
    for (i in 0 until n) {
        val inputs = readLine().toString().split(" ")
        wareHouses.add(Pair(inputs[0].toInt(), inputs[1].toInt()))
    }

    val maxWidth = wareHouses.maxOf { it.first }
    val maxHeight = wareHouses.maxOf { it.second }

    val expandWareHouses = MutableList(maxWidth + 1) {0}
    for (wareHouse in wareHouses) {
        expandWareHouses[wareHouse.first] = wareHouse.second
    }
    var indexOfMaxHeight = -1
    for ((i, wh) in expandWareHouses.withIndex()) {
        if (wh == maxHeight) {
            indexOfMaxHeight = i
            break
        }
    }

    var nowHeight = 0
    var answer = 0
    for (i in 0..indexOfMaxHeight) {
        if (nowHeight < expandWareHouses[i]) {
            nowHeight = expandWareHouses[i]
        }
        answer += nowHeight
    }

    nowHeight = 0
    for (i in maxWidth downTo indexOfMaxHeight + 1) {
        if (nowHeight < expandWareHouses[i]) {
            nowHeight = expandWareHouses[i]
        }
        answer += nowHeight
    }
    println(answer)
}
