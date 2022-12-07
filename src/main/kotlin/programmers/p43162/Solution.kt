package programmers.p43162

fun main() {
    println(Solution().solution(3, arrayOf(
        intArrayOf(1, 1, 0),
        intArrayOf(1, 1, 0),
        intArrayOf(0, 0, 1)
    )))
}

class Solution {

    private lateinit var visited: MutableList<Boolean>

    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = 0
        var graph: MutableList<MutableList<Int>> = MutableList(n) { mutableListOf() }

        for (i in computers.indices) {
            for (j in 0 until computers[i].size) {
                if (i == j) {
                    continue
                }
                if (computers[i][j] == 1) {
                    graph[i].add(j)
                }
            }
        }

        visited = MutableList(n) {false}

        for (i in 0 until n) {
            if (!visited[i]) {
                dfs(i, graph)
                answer++
            }
        }

        return answer
    }

    private fun dfs(x: Int, graph: MutableList<MutableList<Int>>) {
        visited[x] = true

        for (g in graph[x]) {
            if (visited[g]) {
                continue
            }
            dfs(g, graph)
        }
    }
}
