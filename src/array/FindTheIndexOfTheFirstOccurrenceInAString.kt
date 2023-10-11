package array

fun main() {
    val haystackOne = "sadbutsad"
    val needleOne = "sad"
    val haystackTwo = "leetcode"
    val needleTwo = "leeto"
    val haystackThree = "sdjkfsdjkfhsdhkfsad"
    val needleThree = "sad"
    println(strStr(haystackOne, needleOne))
}
fun strStr(haystack: String, needle: String): Int {
    if (needle.length > haystack.length)
        return -1
    for (i in haystack.indices) {
        if (i+needle.length <= haystack.length) {
            val result = haystack.substring(i until i + needle.length)
            if (result == needle) {
                return i
            }
        }
    }
    return -1
}