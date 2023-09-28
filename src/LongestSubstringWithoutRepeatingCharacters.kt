fun main() {
    val input1 = "abcabcbb"
    val input2 = "bbbbb"
    val input3 = "aab"
    val input4 = "abcabcbb"
    val input5 = "dvdf"
    val input6 = "evdabcerd"
    println(lengthOfLongestSubstringWithSet(input2))
    println(lengthOfLongestSubstring(input5))
}

private fun lengthOfLongestSubstring(str: String): Int {
    val strSize = str.length
    var size = 0
    var list: MutableList<Char> = mutableListOf()
    for (i in 0 until strSize) {
        if (list.contains(str[i])) {
            val duplicateIndex = list.indexOf(str[i])
            list = list.drop(duplicateIndex + 1).toMutableList()
        }
        list.add(str[i])
        if (list.size > size)
            size = list.size
    }
    return size
}

private fun lengthOfLongestSubstringWithSet(str: String): Int {
    val strSize = str.length
    val set = hashSetOf<Char>()
    var leftIndex = 0
    var rightIndex = 0
    var length = 0
    var localLength = 0
    while (rightIndex < strSize) {
        localLength += 1
        if (set.contains(str[rightIndex])) {
            set.clear()
            leftIndex += 1
            rightIndex = leftIndex
            localLength = 0
            continue
        }
        length = maxOf(localLength, length)
        set.add(str[rightIndex])
        rightIndex += 1
    }
    return length
}