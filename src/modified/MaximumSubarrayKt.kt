package modified

import kotlin.math.max

fun main() {

    val input1 = intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)
    val input2 = intArrayOf(5, 4, -1, 7, 8)
    val input3 = intArrayOf(-1)
    println(maximumSubArrayKadane(input1))
}

private fun maximumSubarrayBruteForce(nums: IntArray): Int {
    var sum = nums.minOrNull() ?: 0
    val numLength = nums.size
    for (i in 0 until numLength) {
        val sumOfCurrentIndex: MutableList<Int> = mutableListOf()
        var localSum = nums[i]
        sumOfCurrentIndex.add(localSum)
        for (j in i + 1 until numLength) {
            localSum += nums[j]
            sumOfCurrentIndex.add(localSum)
        }
        val localMax = sumOfCurrentIndex.maxOrNull() ?: 0
        if (localMax > sum) {
            sum = localMax
        }
    }

    return sum
}

/////
private fun maximumSubArrayDivideAndConquer(nums: IntArray): Int {
    val low = 0
    val high = nums.size - 1
    return maxSub(nums, low, high)

}

private fun maxSub(nums: IntArray, low: Int, high: Int): Int {
    if (low > high)
        return Int.MIN_VALUE

    if (low == high)
        return nums[low]

    val mid = (low + high) / 2
    return max(
            max(maxSub(nums, low, mid - 1), maxSub(nums, mid + 1, high)),
            maxCrossSub(nums, low, mid, high))
}

private fun maxCrossSub(nums: IntArray, low: Int, mid: Int, high: Int): Int {

    var sum = 0
    var leftSum = Int.MIN_VALUE
    for (i in mid downTo low) {
        sum += nums[i]
        if (sum > leftSum)
            leftSum = sum
    }
    sum = 0
    var rightSum = Int.MIN_VALUE
    for (i in mid..high) {
        sum += nums[i]
        if (sum > rightSum)
            rightSum = sum

    }

    return (max((rightSum + leftSum - nums[mid]), max(leftSum, rightSum)))
}
//  ** \\\

private fun maximumSubArrayKadane(nums: IntArray): Int {
    var optimumSum = 0
    var totalSum = 0
    return if (nums.size == 1) {
        nums[0]
    } else {
        val numSize = nums.size - 1
        for (i in 0..numSize) {
            totalSum += nums[i]
            if (totalSum > optimumSum)
                optimumSum = totalSum
            if (totalSum < 0) {
                totalSum = 0
            }
        }

        optimumSum
    }
}

private fun maximumSubArrayKadaneWithAllMinusArray(nums: IntArray): Int {
    var optimumSum =  Integer.MIN_VALUE
    var totalSum = 0
        val numSize = nums.size - 1
        for (i in 0..numSize) {
            totalSum += nums[i]
            if (totalSum > optimumSum)
                optimumSum = totalSum
            if (totalSum < 0) {
                totalSum = 0
            }
        }

       return optimumSum
    }

private fun maxSubArrayLeetCodeSolution(nums: IntArray): Int {

    var max = Int.MIN_VALUE
    var dp = 0

    for( i in nums.indices){
        dp = Math.max(nums[i], dp + nums[i])
        max = Math.max(dp, max)
    }

    return max

}