package bjoon.p1260

import java.util.*

var dfsRecord: MutableList<Int> = mutableListOf()
var bfsRecord: MutableList<Int> = mutableListOf()

fun main(args: Array<String>) {
    val input = readLine().toString().split(" ").map { it.toInt() }
    val n = input[0]
    val m = input[1]
    val v = input[2]

    var graph: MutableList<MutableList<Int>> = MutableList(n) { mutableListOf() }

    for (i in 0 until n) {
        val input2 = readLine().toString().split(" ").map { it.toInt() }
        val v1 = input2[0]
        val v2 = input2[1]

        graph[v1 - 1].add(v2)
        graph[v2 - 1].add(v1)
    }

    var visited = MutableList(n) {false}
    dfs(v, graph, visited)
    visited = MutableList(n) {false}
//    bfs(v, graph, visited)

    println(dfsRecord.joinToString(" "))
    println(bfsRecord.joinToString(" "))
}

//fun bfs(x: Int, graph: MutableList<MutableList<Int>>, visited: MutableList<Boolean>) {
//    var queue: Queue<Int> = LinkedList<Int>()
//    queue.
//
//}

fun dfs(x: Int, graph: MutableList<MutableList<Int>>, visited: MutableList<Boolean>) {
    visited[x - 1] = true
    dfsRecord.add(x)

    for (g in graph[x - 1]) {
        if (visited[g - 1]) {
            continue
        }
        dfs(g, graph, visited)
    }
}
