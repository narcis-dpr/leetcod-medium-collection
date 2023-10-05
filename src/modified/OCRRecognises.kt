package modified

fun canBeEqual(s1: String, s2: String): Boolean {
    var i = 0
    var j = 0
    while (i < s1.length && j < s2.length) {
        if (s1[i].isDigit()) {
            i = skipNumbers(s1, i)
        } else if (s2[j].isDigit()) {
            j = skipNumbers(s2, j)
        } else {
            if (s1[i] != s2[j]) return false
            i++
            j++
        }
    }

    return (i == s1.length && j == s2.length)
}

fun skipNumbers(s: String, start: Int): Int {
    var i = start
    var num = 0
    while (i < s.length && s[i].isDigit()) {
        num = num * 10 + (s[i] - '0')
        i++
    }

    return i + num
}

fun main() {
    println(canBeEqual("A3BCD", "A6"))  // should return true
    println(canBeEqual("A3BCD", "A3BC1"))  // should return true
    println(canBeEqual("A3BCD", "A2BCD"))  // should return false
}