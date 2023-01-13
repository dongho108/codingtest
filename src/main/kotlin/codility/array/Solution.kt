package codility.array

fun main() {
    println(solution(intArrayOf(3, 8, 9, 7, 6), 3).toMutableList())
    println(solution(intArrayOf(), 3).toMutableList())
}

fun solution(A: IntArray, K: Int): IntArray {
    if (A.isEmpty() || K == 0) {
        return A
    }

    val N = A.size
    val rotationCount = K % N
    var tempA = A.toMutableList()

    for (i in 0 until rotationCount) {
        tempA = rotation(tempA)
    }
    return tempA.toIntArray()
}

fun rotation(target: MutableList<Int>): MutableList<Int> {
    target.add(0, target.removeLast())
    return target
}
