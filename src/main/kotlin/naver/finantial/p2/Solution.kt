package naver.finantial.p2

import java.time.LocalDateTime

fun main() {
    println(Solution().solution("2021:04:12:16:08:35", arrayOf("01:06:30:00", "01:04:12:00")).toMutableList())
}

class Solution {

    fun solution(s: String, times: Array<String>): IntArray {

        val date = s.split(":")
        val dateTime = LocalDateTime.of(
            date[0].toInt(),
            date[1].toInt(),
            date[2].toInt(),
            date[3].toInt(),
            date[4].toInt(),
            date[5].toInt(),
        )

        var dateTimes: MutableList<LocalDateTime> = mutableListOf()
        dateTimes.add(dateTime)

        for (time in times) {
            val split = time.split(":")
            var last = dateTimes.last()
            println("+++")
            println(split)
            println(last)
            last = last.plusSeconds(split[3].toLong())
            last = last.plusMinutes(split[2].toLong())
            last = last.plusHours(split[1].toLong())
            last = last.plusDays(split[0].toLong())
            println(last)
            dateTimes.add(last)
        }

        println(dateTimes)

        val period = dateTimes.last().dayOfMonth - dateTimes.first().dayOfMonth + 1
        var answer: MutableList<Int> = mutableListOf(1, period)
        for (i in 1 until dateTimes.size) {
            if (dateTimes[i].dayOfMonth - dateTimes[i - 1].dayOfMonth > 1) {
                answer[0] = 0
                break
            }
        }

        return answer.toIntArray()
    }
}
