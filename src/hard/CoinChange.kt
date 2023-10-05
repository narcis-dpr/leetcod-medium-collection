package hard

import kotlin.math.min

fun coinChangeProblem(coins: IntArray, sum: Int): Int {
    val totalCoins = coins.size

    // Creating array which stores subproblems' solutions
    val arr = Array(totalCoins + 1) { DoubleArray(sum + 1) }

    // Initialising first row with +ve infinity
    for (j in 0..sum) {
        arr[0][j] = Double.POSITIVE_INFINITY
    }

    // Initialising first column with 0
    for (i in 1..totalCoins) {
        arr[i][0] = 0.0
    }

    // Implementing the recursive solution
    for (i in 1..totalCoins) {
        for (j in 1..sum) {
            if (coins[i - 1] <= j) arr[i][j] = min(1 + arr[i][j - coins[i - 1]], arr[i - 1][j]) else arr[i][j] = arr[i - 1][j]
        }
    }
    return arr[totalCoins][sum].toInt()
}

fun main() {
    val coins = intArrayOf(5, 7, 8, 9)
    val sum = 49
    println("At least " + coinChangeProblem(coins, sum)
            + " coins are required to make a value of " + sum)
}

