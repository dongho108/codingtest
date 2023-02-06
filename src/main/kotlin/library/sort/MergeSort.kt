package library

fun main() {
//    mergeSort(arr, 0, arr.lastIndex())
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