package kurly.p1

fun main(args: Array<String>) {
    val input = readLine().toString().split(" ").map { it.toInt() }
    val n = input[0]
    val m = input[1]
    var answer = n
    var coupon = n

    while (coupon >= m) {
        val count = coupon / m
        answer += count
        coupon -= count * m
        coupon += count
    }
    println(answer)
}