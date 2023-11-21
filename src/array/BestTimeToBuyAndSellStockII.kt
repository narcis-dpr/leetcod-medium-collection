package array

fun main() {
    val inputOne = intArrayOf(7, 1, 5, 3, 6, 4)
    val inputTwo = intArrayOf(1, 2, 3, 4, 5)
    val inputThree = intArrayOf(7, 6, 4, 3, 1,0,1,2,12)
    val inputFour = intArrayOf(2, 2, 5)
    println(maxProfitTwo(inputThree))
}

fun maxProfitTwo(prices: IntArray): Int {
    var profit = 0
    var right = 0
    var left = 0
    val pricesSize = prices.size

    while (right < pricesSize) {
        val localProfit = prices[right] - prices[left]
        if (localProfit == 0) {
            right++
        } else if (localProfit < 0) {
            left = right
            right++
        } else if (localProfit > 0) {
            if (right + 1 < pricesSize && (prices[right + 1] > prices[right])) {
                right++
            } else {
                profit += localProfit
                right += 1
                left = right
            }

        }
    }

    return profit
}

fun maxProfitTwoLeetCode(prices: IntArray): Int {
    var profit = 0
    for(i in 0..prices.size-2) {
        val pr = prices[i+1] - prices[i]
        if(pr > 0) profit += pr
    }
    return profit
}