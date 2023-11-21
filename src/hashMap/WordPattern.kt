package hashMap

fun main() {
    val inputOne = "dog cat cat dog"
    println(wordPattern("abba", inputOne))
}
fun wordPattern(pattern: String, s: String): Boolean {
    val m: MutableMap<Char, String> = HashMap()
    val words = s.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    if (pattern.length != words.size) return false
    val n = words.size
    for (i in 0 until n) {
        val c = pattern[i]
        if (m.containsKey(c)) {
            if (words[i] != m[c]) return false
        } else {
            if (m.containsValue(words[i])) {
                return false
            }
            m[c] = words[i]
        }
    }
    return true
}