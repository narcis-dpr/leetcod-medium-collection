package array

fun main() {
    val inputOne = intArrayOf(7, 1, 5, 3, 6, 4)
    val inputTwo = intArrayOf(7, 6, 4, 3, 1)
    val inputThree = intArrayOf(2,4,1)
    val inputFour = intArrayOf()
    println(maxProfit(inputOne))
}

fun maxProfitBrutForce(prices: IntArray): Int {
    val size = prices.size
    var profit = 0
    for (i in prices.indices) {
        val tempMax = prices.sliceArray(i until size).toList().max()
        if (tempMax - prices[i] > profit)
            profit = tempMax - prices[i]
    }

    return profit
}
fun maxProfitBrutOptimized(prices: IntArray): Int {
    val size = prices.size
    var profit = 0
    val picks = mutableListOf<Int>()
    for (i in prices.indices) {
        if (i+1<size) {
            if (prices[i+1] > prices[i])
                picks.add(i+1)
        }
    }
    for (i in picks) {
       val tempMin = prices.sliceArray(0 until i).toList().min()
        if (prices[i] - tempMin > profit)
            profit = prices[i] - tempMin
    }
    println(picks)

    return profit
}

fun maxProfit(prices: IntArray): Int {
    var right = 0
    var left = 0
    var profit = 0
    for(i in prices.indices) {
            if (prices[right] < prices[i]) {
                right = i
                if (prices[right] - prices[left] > profit) {
                    profit = prices[right] - prices[left]
                }
            } else if (prices[left] > prices[i]){
                left = i
                right = i
                if (prices[right] - prices[left] > profit) {
                    profit = prices[right] - prices[left]
                }
            }
    }
    println(" $right  $left")
    return profit
}

fun maxProfitLeetCode(prices: IntArray): Int {
    var result = 0
    var min = prices[0]

    for (i in 1 until prices.size) {
        if (prices[i] < min) {
            min = prices[i]
        }

        if (result < (prices[i] - min)) {
            result = prices[i] - min
        }
    }

    return result
}