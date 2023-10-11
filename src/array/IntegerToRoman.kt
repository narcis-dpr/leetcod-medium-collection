package array

import kotlin.math.pow

fun main() {
    println(intToRoman(100))
}
fun intToRoman(num: Int): String {
    val M = arrayOf("", "M", "MM", "MMM")
    val C = arrayOf("", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM")
    val X = arrayOf("", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC")
    val I = arrayOf("", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX")

    return M[num / 1000] + C[(num % 1000)/100] + X[(num % 100) / 10] + I[num % 10]
}

fun intToRomanLeetCode(num: Int): String {
    val values = intArrayOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
    val romanNumerals = arrayOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")

    val sb = StringBuilder()

    var i = 0
    var n = num // Use a copy of num so we can modify it

    while (n > 0) {
        if (n >= values[i]) {
            sb.append(romanNumerals[i])
            n -= values[i]
        } else {
            i++
        }
    }

    return sb.toString()
}