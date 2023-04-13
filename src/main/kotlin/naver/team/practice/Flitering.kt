package naver.team.practice

fun main() {
    var s = readLine().toString()
    val p = readLine().toString()
    var t = ""
    for (pc in p) {
        var sameCIndex = 0
        for ((i, sc) in s.withIndex()) {
            if (pc == sc) {
                sameCIndex = i
                break
            }
        }
        t += s.substring(0 until sameCIndex)
        s = s.substring(sameCIndex + 1)
    }
    t += s
    println(t)
}
/*
egfbkvcuan
fbvca
*/