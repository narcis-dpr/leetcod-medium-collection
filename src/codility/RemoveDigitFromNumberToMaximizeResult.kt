package codility

fun main() {
    val inputOn = "123"
    val digitOn = '3'

    val inputTwo = "1231"
    val digitTwo = '1'

    val inputThree = "551"
    val digitThree = '5'

    val inputFour = "2998589353917872714814599237991174513476623756395992135212546127959342974628712329595771672911914471"
    val digitFour = '3'
    println(removeDigitWithHashMap("-5859", '5'))
}

fun removeDigitWithHashMap(number: String, digit: Char): String {
    val isNegative = number[0] == '-'
    val result = mutableSetOf<String>()
    val numArray = number.toCharArray().toMutableList()
    for (i in numArray.indices) {
        if (numArray[i] == digit) {
            numArray.removeAt(i)
            result.add(numArray.joinToString(""))
            numArray.add(i, digit)
        }
    }
    println(result)
    return result.maxBy { it.toBigInteger() }.toBigInteger().toString()
}
