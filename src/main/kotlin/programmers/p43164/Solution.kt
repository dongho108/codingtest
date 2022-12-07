package programmers.p43164

fun main() {
    println(
        "${
            Solution().solution(
                arrayOf(
                    arrayOf("ICN", "JFK"),
                    arrayOf("HND", "IAD"),
                    arrayOf("JFK", "HND")
                )
            ).toMutableList()
        }"
    )

    println(
        "${
            Solution().solution(
                arrayOf(
                    arrayOf("ICN", "SFO"),
                    arrayOf("ICN", "ATL"),
                    arrayOf("SFO", "ATL"),
                    arrayOf("ATL", "ICN"),
                    arrayOf("ATL", "SFO")
                )
            ).toMutableList()
        }"
    )

    println(
        "${
            Solution().solution(
                arrayOf(
                    arrayOf("ICN", "A"),
                    arrayOf("A", "B"),
                    arrayOf("A", "C"),
                    arrayOf("B", "A"),
                    arrayOf("C", "A")
                )
            ).toMutableList()
        }"
    )

    println(
        "${
            Solution().solution(
                arrayOf(
                    arrayOf("ICN", "A"),
                    arrayOf("ICN", "B"),
                    arrayOf("B", "ICN")
                )
            ).toMutableList()
        }"
    )
}

class Solution {

    private var visited: MutableMap<String, MutableList<Boolean>> = mutableMapOf()
    private lateinit var answer: ArrayList<String>

    fun solution(tickets: Array<Array<String>>): Array<String> {
//        var answer = arrayOf<String>()
        var graph: MutableMap<String, MutableList<String>> = mutableMapOf()

        for (ticket in tickets) {
            val from = ticket[0]
            val to = ticket[1]
            if (graph.contains(from)) {
                graph[from]?.add(to)
            } else {
                graph[from] = mutableListOf()
                graph[from]?.add(to)
            }
        }

        graph.values.map { it.sort() }

//        println(graph)
        for (next in graph["ICN"]!!) {
            answer = arrayListOf("ICN")
            for (mutableEntry in graph) {
                val size = mutableEntry.value.size
                visited[mutableEntry.key] = MutableList(size) {false}
            }
//            println(visited)
            dfs(next, graph)
            if (visited.values.flatMap { it.toList() }.filterNot { it }.isEmpty()) {
                break
            }
        }

        return answer.toArray(arrayOfNulls<String>(answer.size))
    }

    private fun dfs(target: String, graph: MutableMap<String, MutableList<String>>) {
        answer.add(target)
        if (!graph.containsKey(target)) {
            return
        }
        for ((i, next) in graph[target]!!.withIndex()) {
//            println("${target}, ${next}, ${visited[next]}, ${i}")
            if (!visited.containsKey(next)) {
                answer.add(next)
                return
            }
            if (!visited[target]?.get(i)!!) {
                visited[target]?.set(i, true)
                dfs(next, graph)
            }
        }
    }
}
