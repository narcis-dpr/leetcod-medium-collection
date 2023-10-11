package array

fun main() {
    val inputOne = "III"
    val inputTwo = "LVIII"
    println(romanToInt(inputTwo))
}

fun romanToInt(s: String): Int {
    val size = s.length
    val romanMap = mutableMapOf<Char, Int>()
    romanMap['I'] = 1
    romanMap['V'] = 5
    romanMap['X'] = 10
    romanMap['L'] = 50
    romanMap['C'] = 100
    romanMap['D'] = 500
    romanMap['M'] = 1000

    var number = romanMap[s[size - 1]]!!
    for (i in size-2 downTo 0) {
        if (romanMap[s[i]]!! >= romanMap[s[i+1]]!!) {
            number += romanMap[s[i]]!!
        } else {
            number -= romanMap[s[i]]!!
        }
    }
    return number
}