package array

fun main() {
    val firstList: Array<String> = arrayOf("flower", "flow", "flight")
    val secondInput = arrayOf("dog","racecar","car")
    val thirdInput = arrayOf("cir","car")
    println(longestCommonPrefix(thirdInput))
}

fun longestCommonPrefix(strs: Array<String>): String {
    val wordsInventory = mutableMapOf<Int, List<Char>>()
    var common = ""
    for (i in strs.indices) {
        wordsInventory[i] = strs[i].toList()
    }
    val pivot = wordsInventory.minBy { it.value.size }
    for (i in 0 until pivot.value.size) {
        var occurenc = 0
        (wordsInventory.values.forEach {
            if (it[i] == pivot.value[i]) {
                occurenc++
            }

        })
        if (occurenc==strs.size)
            common += pivot.value[i]
        else
            break
    }

    return common
}

fun longestCommonPrefixLeetCode(strs: Array<String>): String {
    val res = StringBuilder()
    val first = strs[0]

    var i = 0

    while (true) {
        if (!strs.all { it.length > i && it[i] == first[i] }) break
        res.append(first[i++])
    }

    return res.toString()
}