package codility

fun main() {
    val inputOne = "15958"
    val inputTwo = "-5859"
    val inputThree = "-5000"
    println(maxValueForFive("-15958"))
}

fun maxValueForFive(n: String): String {
    val isNegative = n[0] == '-'
    val numbers = n.toCharArray().toMutableList()
    val result = mutableSetOf<String>()
    if (isNegative) numbers.removeFirst()
    for (i in numbers.indices) {
        if (numbers[i] =='5') {
            numbers.removeAt(i)
            result.add(numbers.joinToString(""))
            numbers.add(i, '5')
        }
    }

    return if (!isNegative) {
        result.maxBy { it.toInt() }.toBigInteger().toString()
    } else {
        (("-")+result.minBy { it.toInt() }).toBigInteger().toString()
    }
}
