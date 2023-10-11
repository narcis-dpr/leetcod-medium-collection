package twoPointers

fun main() {
    val inputOne = "abc"
    val sequenceOne = "ahbgdc"

    val inputTwo = "axc"
    val sequenceTwo = "ahbgdc"

    val inputThree = "acb"
    val sequenceThree = "ahbgdc"

    val inputFour = "aaaaaa"
    val sequenceFour = "bbaaaa"

    val inputFive = ""
    val sequenceFive = "ahbgdc"

    println(isSubsequence(inputFive, sequenceFive))
}
fun isSubsequence(s: String, t: String): Boolean {
    val subSequenceSize = s.length
    val sequenceSize = t.length
    var right = 0
    var left = 0
    while (right < sequenceSize && left < subSequenceSize) {
        if (s[left] == t[right]) {
            left++
            right++
        } else {
            right++
        }
    }

    return left==subSequenceSize
}