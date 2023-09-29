fun main() {
    val input1 = " babad"
    val input2 = "cbbd"
    val input3 = "aacabdkacaa"
//    println(longestPalindromicSubstringBruteForce(input3))
    println(longestPalindrome(input1))
}


private fun longestPalindromicSubstringBruteForce(str: String): String {
    var result = ""
    var resultSize = 0
    val strSize = str.length
    for (i in 0 until strSize) {
        for (j in i until strSize) {
            val subString = str.substring(i..j)
            if (checkPalindromic(subString)) {
                if (subString.length > resultSize) {
                    resultSize = subString.length
                    result = subString
                }
            }
        }
    }
    return result
}

private fun checkPalindromic(str: String): Boolean {
    val size = str.length
    var isPalidrom = true
    for (i in 0 until size / 2) {
        if (str[i] != str[size - i - 1]) {
            isPalidrom = false
            break
        }
    }
    return isPalidrom
}

/// dynamic solution

fun longestPalindrome(s: String?): Int {
    if (s.isNullOrEmpty()) return s!!.length
    var start = 0
    var end = 0
    for (i in s.indices) {
        val len1 = expandAroundCenter(s, i, i)
        val len2 = expandAroundCenter(s, i, i + 1)
        val len = len1.coerceAtLeast(len2)
        if (len > end - start) {
            start = i - (len - 1) / 2
            end = i + len / 2
        }
    }
    val substring = s.substring(start..end)
    println(substring)
    return end - start + 1
}

private fun expandAroundCenter(s: String, left: Int, right: Int): Int {
    var leftIndex = left
    var rightIndex = right
    while (leftIndex >= 0 && rightIndex < s.length && s[leftIndex] == s[rightIndex]) {
        leftIndex--
        rightIndex++
    }
    return rightIndex - leftIndex - 1
}