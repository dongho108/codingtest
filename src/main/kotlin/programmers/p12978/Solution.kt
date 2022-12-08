package programmers.p12978

import java.util.*

fun main() {
    println(
        Solution().solution(
            5, arrayOf(
                intArrayOf(1, 2, 1),
                intArrayOf(2, 3, 3),
                intArrayOf(5, 2, 2),
                intArrayOf(1, 4, 2),
                intArrayOf(5, 3, 1),
                intArrayOf(5, 4, 2)
            ), 3
        )
    )
}

class Solution {
    private lateinit var distance: MutableList<Int>
    private lateinit var graph: MutableList<MutableList<Pair<Int, Int>>>

    fun solution(N: Int, road: Array<IntArray>, k: Int): Int {
        graph = MutableList(N + 1) { mutableListOf() }
        distance = MutableList(N + 1) { Int.MAX_VALUE}

        for (r in road) {
            val a = r[0]
            val b = r[1]
            val c = r[2]
            graph[a].add(Pair(b, c))
            graph[b].add(Pair(a, c))
        }

        dijkstra(1)
        return distance.filter { it <= k }.size
    }

    private fun dijkstra(start: Int) {
        var q = PriorityQueue<Pair<Int, Int>> {a, b -> a.first - b.first}
        distance[start] = 0
        // first : 거리, second : 정점
        q.add(Pair(0, start))

        while (q.isNotEmpty()) {
            val element = q.poll()
            val dist = element.first
            val now = element.second

            // 이미 방문했거나 최솟값이 아닌 경우
            if (distance[now] < dist) {
                continue
            }

            for (node in graph[now]) {
                // node - first : 정점, second : 거리
                // 지금까지 온 거리 + 현재 정점에서 다음 정점 가는 거리
                var cost = dist + node.second
                if (cost < distance[node.first]) {
                    distance[node.first] = cost
                    q.add(Pair(cost, node.first))
                }
            }
        }
    }
}
