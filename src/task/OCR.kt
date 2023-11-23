package task

fun main() {
    println(solution("A2Le", "2pL1")) // should return true
    println(solution("a10", "10a"))   // should return true
    println(solution("ba1", "1Ad"))   // should return false
    println(solution("3x2x", "8"))    // should return false
}

fun solution(S: String, T: String): Boolean {


    val expansionForS = stringExpansion(S)
    val expansionForT = stringExpansion(T)

    if (expansionForS.length != expansionForT.length) {
        return false
    }

    for (i in expansionForS.indices) {
        if (expansionForS[i] != '_' &&
                expansionForT[i] != '_' &&
                expansionForS[i] != expansionForT[i]) {
            return false
        }
    }

    return true
}

fun stringExpansion(str: String): String {
    return str.fold("") { accumulator, character ->
        accumulator + if (character.isDigit()) {
            "_".repeat(character.toString().toInt())
        } else {
            character.toString()
        }
    }
}
// Testing the function

