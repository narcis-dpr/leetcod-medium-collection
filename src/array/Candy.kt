package array

import kotlin.math.max

fun main() {
    val inputOne = intArrayOf(1, 0, 2)
    val inputTwo = intArrayOf(1, 2, 2)
    val inputThree = intArrayOf(1, 3, 2, 2, 1)
    val inputFour = intArrayOf(4, 3, 2, 2, 1)
    val inputFive = intArrayOf(29, 51, 87, 87, 72, 12)
    println(candy(inputTwo))
}

fun candy(ratings: IntArray): Int {
    val size = ratings.size
    val leftCandies = IntArray(size)
    val rightCandies = IntArray(size)
    var candies = size

    for (i in 1 until size) {
            if (ratings[i] > ratings[i - 1])
                leftCandies[i] = leftCandies[i-1] + 1
    }
    println("half candies ${leftCandies.joinToString()}")
    for (i in size - 2 downTo 0) {
        if (ratings[i] > ratings[i + 1])
            rightCandies[i] = rightCandies[i+1] + 1
    }

    for (i in 0 until size)
        candies += max(rightCandies[i], leftCandies[i])
    println(" candies ${leftCandies.joinToString()} ")
    return candies
}