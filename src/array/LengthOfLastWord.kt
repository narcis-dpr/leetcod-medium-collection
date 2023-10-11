package array

fun main() {
    val inputOne = "Hello World"
    val inputTwo = "   fly me   to   the moon  "
    val inputThree = "luffy is still joyboy"
    println(lengthOfLastWord(inputOne))
}

fun lengthOfLastWord(s: String): Int {
    val words = s.split(" ")
//    println(words)
    for (i in words.size - 1 downTo 0) {
        if (words[i].isNotBlank()) {
            return words[i].length
        }
    }
    return 0
}

fun lengthOfLastWordLeetCode(s: String): Int {
    var res = 0
    var currentLastWordLength = 0
    for (i in s.indices) {
        var currentChar = s[i]
        if (currentChar != ' ') {
            currentLastWordLength++
            res = currentLastWordLength
        } else {
            res = if (currentLastWordLength > 0) currentLastWordLength else res
            currentLastWordLength = 0
        }
    }
    return res
}