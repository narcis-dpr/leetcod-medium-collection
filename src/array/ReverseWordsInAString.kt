package array

fun main() {
    val inputOne = "the sky is blue"
    val inputTwo = "a good   example"
    println(reverseWords(inputOne))
}
fun reverseWords(s: String): String {
    val words = s.trim().split(" ")
    val stringBuilder = StringBuilder()
    for ( i in words.size-1 downTo 0) {
        if (words[i].isNotBlank()) {
            stringBuilder.append(words[i])
            if (i != 0)
                stringBuilder.append(" ")
        }
    }
    return stringBuilder.toString()
}