package naver.team.practice

var minCount = Int.MAX_VALUE
var minValue = -1

fun main() {
    val p = readLine().toString()

    dfs(p, 0)
    println("$minCount $minValue")
}

fun dfs(p: String, num: Int) {
    if (minCount < num) {
        return
    }
    if (p.length == 1) {
        if (num <= minCount) {
            minCount = num
            minValue = p.toInt()
            return
        }
    }
    for (i in 1 until p.length) {
        val left = p.substring(0, i)
        val right = p.substring(i)
        if (isZeroFirstNum(left) || isZeroFirstNum(right)) {
            continue
        }
        dfs((left.toInt() + right.toInt()).toString(), num + 1)
    }
}

fun isZeroFirstNum(value: String): Boolean {
    return value.length != value.toInt().toString().length
}
