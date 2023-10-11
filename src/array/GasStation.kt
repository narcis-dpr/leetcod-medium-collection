package array

import kotlin.math.cos

fun main() {
    val gasOne = intArrayOf(1,2,3,4,5)
    val costOne = intArrayOf(3,4,5,1,2)

    val gasTwo = intArrayOf(2,3,4)
    val costTwo = intArrayOf(3,4,3)
    println(canCompleteCircuit(gasOne, costOne))
}

fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
    var remainedGas = 0
    var totalGas = 0
    var startIndex = 0
    for (i in gas.indices) {
        val currentRemaining = gas[i] - cost[i]
        if (remainedGas < 0) {
            startIndex = i
            remainedGas = currentRemaining
        } else {
            remainedGas += currentRemaining
        }
        totalGas += currentRemaining
    }
    if (totalGas < 0)
        return -1

    return startIndex
}