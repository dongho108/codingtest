package yanolja.demo

fun main() {
//    println(solution(intArrayOf(1, 2, 3)))
//    println(solution(intArrayOf(-1, -3)))
//    println(solution(intArrayOf(1, 3, 6, 4, 1, 2)))
    println(solution(intArrayOf(1, -2, 3, 0)))
}

fun solution(A: IntArray): Int {
    var positiveNumber = 1

    val arr = A.toMutableList()
    mergeSort(arr, 0, arr.lastIndex)

    for ((index, a) in arr.withIndex()) {
        if (a <= 0 || (index > 0 && a == arr[index - 1])) {
            continue
        }
        if (a != positiveNumber) {
            return positiveNumber
        }
        positiveNumber++
    }
    return positiveNumber
}

fun mergeSort(array: MutableList<Int>, start: Int, end: Int) {
    if (start >= end) return

    val mid = (start + end) / 2
    mergeSort(array, start, mid)
    mergeSort(array, mid + 1, end)

    merge(array, start, mid, end)
}

fun merge(array: MutableList<Int>, start: Int, mid:Int, end: Int) {
    val newList = mutableListOf<Int>()
    var idxA = start
    var idxB = mid + 1

    while (idxA <= mid && idxB <= end) {
        if (array[idxA] <= array[idxB]) {
            newList.add(array[idxA])
            idxA++
        } else {
            newList.add(array[idxB])
            idxB++
        }
    }

    if (idxA > mid) {
        for (i in idxB..end) {
            newList.add(array[i])
        }
    }

    if (idxB > end) {
        for (i in idxA..mid) {
            newList.add(array[i])
        }
    }

    for (e in newList.indices) {
        array[start + e] = newList[e]
    }
}