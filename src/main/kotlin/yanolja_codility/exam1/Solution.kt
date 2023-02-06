package yanolja_codility.exam1

fun main() {
    println(solution("NAABXXAN"))
    println(solution("NAANAAXNABABYNNBZ"))
    println(solution("QABAAAWOBL"))
    println(solution("A"))
}

fun solution(S: String): Int {
    var answer = 0
    var tempS = S

    while (true) {
        tempS = removeBanana(tempS)
        if (tempS == "-") {
            return answer
        }
        answer++
    }
}

private fun removeBanana(S: String): String {
    var BCount = 1
    var NCount = 2
    var ACount = 3
    var newS = ""

    for (c in S) {
        if (c == 'B' && BCount > 0) {
            BCount--
            continue
        }

        if (c == 'N' && NCount > 0) {
            NCount--
            continue
        }

        if (c == 'A' && ACount > 0) {
            ACount--
            continue
        }
        newS += c
    }

    if (BCount > 0 || NCount > 0 || ACount > 0) {
        return "-"
    }
    return newS
}
