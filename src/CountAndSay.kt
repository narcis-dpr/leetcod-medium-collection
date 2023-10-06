fun main() {
println(countAndSayLeetCode(7))
}

private fun countAndSay(n: Int): String {
    val stringBuilder = StringBuilder()
    stringBuilder.append("1")
    val number = 1
    var stringResult = number.toString()
    for (i in 1 until n) {
        var portion = ""
        val numbers =  stringResult.toCharArray()  //number.toString().toCharArray()
        var j = 0
        var portionResult = ""
        while (j <numbers.size) {
            var partition = false
            if (portion=="")
            portion +=numbers[j]
            if (j == numbers.size -1) {
                partition = true
            } else if (numbers[j] == numbers[j+1]) {
                portion +=numbers[j+1]
            } else partition = true

             if (partition) {
//                portion +=numbers[j]
                println("portion : $portion")
                portionResult += readNumber(portion.toInt()).toString()
                println("portion read number : ${portionResult}")
                 portion = ""
                 stringResult = portionResult
            }
            j++
        }
    }
    return stringResult
}
private fun readNumber(numbers: Int) : Int {
    val charArrayOfNumbers = numbers.toString().toCharArray()
    val firstNumber = charArrayOfNumbers.size
    val secondNumber = firstNumber.toString()+charArrayOfNumbers[0]
    return secondNumber.toInt()
}


/// leetcode solution
fun countAndSayLeetCode(n: Int): String {
    if (n == 1) {
        return "1"
    }
    val p: String = countAndSayLeetCode(n - 1)
    val stringBuilder = StringBuilder()
    var i = 0
    var c = 1

    while (i < p.length) {
        while (i < p.length - 1 && p[i] == p[i + 1]) {
            c++
            i++
        }
        stringBuilder.append(c)
        stringBuilder.append(p[i])
        c = 1
        i++
    }
    return stringBuilder.toString()
}