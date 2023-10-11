package twoPointers

fun main() {
    val inputOne = "A man, a plan, a canal: Panama"
    val inputTwo = "race a car"
    val inputThree = " "
    println(isPalindrome(inputThree))
}
fun isPalindrome(s: String): Boolean {
    val pureString = s.replace("[^A-Za-z0-9]".toRegex(), "").lowercase()
    println(pureString)
    var left = 0
    var right = pureString.length-1
    while (left < right) {
        if (pureString[left] == pureString[right]) {
            left++
            right--
        } else {
            return false
        }
    }


    return true
}
