package library.bfs

fun main() {
//    println(
//        "${
//            Solution1().solution(
//                arrayOf(
//                    arrayOf("ICN", "JFK"),
//                    arrayOf("HND", "IAD"),
//                    arrayOf("JFK", "HND")
//                )
//            ).toMutableList()
//        }"
//    )
//
//    println(
//        "${
//            Solution1().solution(
//                arrayOf(
//                    arrayOf("ICN", "SFO"),
//                    arrayOf("ICN", "ATL"),
//                    arrayOf("SFO", "ATL"),
//                    arrayOf("ATL", "ICN"),
//                    arrayOf("ATL", "SFO")
//                )
//            ).toMutableList()
//        }"
//    )

//    println(
//        "${
//            Solution1().solution(
//                arrayOf(
//                    arrayOf("ICN", "A"),
//                    arrayOf("A", "B"),
//                    arrayOf("A", "C"),
//                    arrayOf("B", "A"),
//                    arrayOf("C", "A")
//                )
//            ).toMutableList()
//        }"
//    )

//    println(
//        "${
//            Solution1().solution(
//                arrayOf(
//                    arrayOf("ICN", "A"),
//                    arrayOf("ICN", "B"),
//                    arrayOf("B", "ICN")
//                )
//            ).toMutableList()
//        }"
//    )

    println(
        "${
            Solution1().solution(
                arrayOf(
                    arrayOf("ICN", "A"),
                    arrayOf("ICN", "A"),
                    arrayOf("ICN", "A"),
                    arrayOf("A", "ICN"),
                    arrayOf("A", "ICN")
                )
            ).toMutableList()
        }"
    )

    println(
        "${
            Solution1().solution(
                arrayOf(
                    arrayOf("ICN", "A"),
                    arrayOf("A", "C"),
                    arrayOf("A", "B"),
                    arrayOf("C", "A"),
                    arrayOf("B", "D")
                )
            ).toMutableList()
        }"
    )
}

class Solution1 {

    fun solution(tickets: Array<Array<String>>): Array<String> {
        var answer: ArrayList<String> = arrayListOf()
        var paths: MutableMap<String, MutableList<String>> = mutableMapOf()

        for (i in tickets.indices) {
            val a = tickets[i][0]
            val b = tickets[i][1]
            if (!paths.containsKey(a)) {
                paths[a] = mutableListOf()
            }
            paths[a]?.add(b)
        }

        paths.values.map { it.sort() }

        var q = mutableListOf("ICN")
        while (q.isNotEmpty()) {
            var start = q.last()
            if (!paths.containsKey(start)) {
                paths[start] = mutableListOf()
            }

            if (paths[start]?.isEmpty()!!) {
                answer.add(q.removeLast())
            } else {
                q.add(paths[start]!!.removeLast())
            }
        }
        answer.reverse()
        return answer.toArray(arrayOfNulls<String>(answer.size))
    }
}