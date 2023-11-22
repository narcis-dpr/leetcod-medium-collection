package codility

fun main() {
    val numberOne = "73"
    val digitOne = 6
    val numberTwo = "-13"
    val digitTwo = 2
    val numberThree = "99"
    val digitThree = 9
    val numberFour = "-55"
    val digitFour = 2
    val numberFive = "-132"
    val digitFive = 3
    val numberSix = "28824579515"
    val digitSix = 8
    println(maxValue("-136576", 5))
}

fun maxValue(n: String, x: Int): String {
    val isNegative = n[0] == '-'

    for (i in n.indices) {
        if (!isNegative && n[i] - '0' < x ||
                isNegative && n[i] - '0' > x)
            return n.substring(0, i) + x + n.substring(i)
    }

    return n + x
}