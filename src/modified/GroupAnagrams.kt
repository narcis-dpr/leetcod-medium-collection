package modified

import kotlin.collections.HashMap


fun main() {
    val sampleOne = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")
    println(groupAnagramHashMap(strs = sampleOne).toString())
}

private fun groupAnagramBruteForceRigged(strs: Array<String>): List<List<String>> {
    val result = mutableListOf<MutableList<String>>()

    for (str in strs) {
        var isAnagramFound = false

        for (group in result) {
            if (isAnagram(str, group[0])) {
                group.add(str)
                isAnagramFound = true
                break
            }
        }

        if (!isAnagramFound) {
            val newGroup = mutableListOf(str)
            result.add(newGroup)
        }
    }

    return result
}

private fun groupAnagramHashMap(strs: Array<String>): List<List<String>> {
    val result: MutableList<List<String>> = mutableListOf()
    val size = strs.size
    val inventories: HashMap<String, MutableList<String>> = HashMap()
    for (i in 0 until size) {
        val currentStringCharacters = strs[i].toCharArray().sorted().joinToString()
        if (inventories[currentStringCharacters] == null) {
            val stringNewList: MutableList<String> = mutableListOf()
            stringNewList.add(strs[i])
            inventories[currentStringCharacters] = stringNewList
        } else {
            val currentStringList = inventories[currentStringCharacters]
            currentStringList!!.add(strs[i])
            inventories[currentStringCharacters] = currentStringList
        }
    }
    inventories.forEach { (key, value) ->
        result.add(value)
    }

    return result
}


fun isAnagram(str1: String, str2: String): Boolean {
    if (str1.length != str2.length) {
        return false
    }

    val charCount1 = str1.groupingBy { it }.eachCount()
    val charCount2 = str2.groupingBy { it }.eachCount()

    return charCount1 == charCount2
}
