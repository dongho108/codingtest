package programmers.p86971

import kotlin.math.abs
import kotlin.math.min

fun main() {
    println(
        Solution().solution(
            9, arrayOf(
                intArrayOf(1, 3),
                intArrayOf(2, 3),
                intArrayOf(3, 4),
                intArrayOf(4, 5),
                intArrayOf(4, 6),
                intArrayOf(4, 7),
                intArrayOf(7, 8),
                intArrayOf(7, 9)
            )
        )
    )

    println(
        Solution().solution(
            4, arrayOf(
                intArrayOf(1, 2),
                intArrayOf(2, 3),
                intArrayOf(3, 4)
            )
        )
    )
}

class Solution {
    fun solution(n: Int, wires: Array<IntArray>): Int {
        var answer: Int = Int.MAX_VALUE

        for (i in wires.indices) {
            var graph: MutableList<MutableList<Int>> = MutableList(n) { mutableListOf() }
            for ((wIndex, wire) in wires.withIndex()) {
                if (i == wIndex) {
                    continue
                }
                val left = wire[0]
                val right = wire[1]
                graph[left - 1].add(right)
                graph[right - 1].add(left)
            }
//            println("cut ${wires[i].toMutableList()}")
//            println(graph)
            val dfsAnswer = dfs(1, graph, MutableList(n) { false })
//            println("$answer, $dfsAnswer")
            answer = min(answer, dfsAnswer)
        }

        return answer
    }

    private fun dfs(target: Int, graph: MutableList<MutableList<Int>>, visited: MutableList<Boolean>): Int {
        visited[target - 1] = true
//        println("$target, $visited")
        for (next in graph[target - 1]) {
            if (!visited[next - 1]) {
                dfs(next, graph, visited)
            }
        }
        return abs(visited.filter { it }.size - visited.filterNot { it }.size)
    }
}
