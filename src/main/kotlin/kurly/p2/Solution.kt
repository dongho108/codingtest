package kurly.p2

fun main(args: Array<String>) {
    val n = readLine().toString().toInt()
    val input1 = readLine().toString().split(" ").map { it.toInt() }
    val input2 = readLine().toString().split(" ").map { it.toInt() }

    if (n < 1) {
        return
    }
    var hambergers: MutableList<Pair<Int, Int>> = mutableListOf()
    for (i in input1.indices) {
        hambergers.add(Pair(input1[i], input2[i]))
    }

    hambergers.sortWith(compareBy({-it.first}, {-it.second}))
    var answer = hambergers[0].second +
            hambergers[0].first +
            (hambergers.sumOf { it.second } - hambergers[0].second - hambergers[0].first) +
            hambergers.last().first
    println(answer)
}
