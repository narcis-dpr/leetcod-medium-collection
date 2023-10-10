package array

fun main() {
    val inputOne = intArrayOf(3, 0, 6, 1, 5)
    val inputTwo = intArrayOf(1, 3, 1)
    val inputFour = intArrayOf(11, 15, 16)
    val inputFive = intArrayOf(1)
    println(hIndex(inputFive))
}

fun hIndex(citations: IntArray): Int {
    val citationsSize = citations.size
    val sortedCitations = citations.sorted()
    var maxCitation = 0
    for (i in 0 until citationsSize) {
      if(sortedCitations[i] >= citationsSize-i)
          if (citationsSize-i > maxCitation)
              maxCitation = citationsSize-i
    }

    return maxCitation
}