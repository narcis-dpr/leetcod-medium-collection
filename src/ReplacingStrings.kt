fun main() {
    val text = "This is a sample text to split into words"
    println(replaceInText(text, '@'))
}

private fun replaceInText(text: String, symbol: Char): String {
    val words: MutableList<String> = text.split(" ").toMutableList()
    for (i in 0 until words.size) {
        if (words[i].length > 1)
            words[i] = replaceSecondCharacter(words[i], symbol)
    }
    return words.joinToString(" ")
}

private fun replaceSecondCharacter(word: String, symbol: Char): String {
    val wordCharArray = word.toCharArray()
    wordCharArray[1] = symbol
    return String(wordCharArray)
}