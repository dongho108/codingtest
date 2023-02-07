package goorm.p53763

fun main(args: Array<String>) {
    val N = Integer.parseInt(readLine())
    val difficulty = readLine().toString().split(" ")

    var answer: String
    val filteredDifficulty = difficulty.sorted().distinct()
    if (filteredDifficulty.size >= 3) {
        answer = "YES"
    } else {
        answer = "NO"
    }
    println(answer)
}
