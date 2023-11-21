package hard

fun main() {
    val inputOne = intArrayOf(1,2,0)
    val inputTwo = intArrayOf(3,4,-1,1)
    val inputThree = intArrayOf(1,7,8,9,11,12)
    val inputFour = intArrayOf(-1,-2,-60,40,43)
    val inputFive = intArrayOf(4,3,4,1,1,4,1,4)
    val inputSix = intArrayOf(3,-3,6,3)
    println(firstMissingPositive(inputOne))
}

fun firstMissingPositiveHashMap(nums: IntArray): Int {
    val sortedNums = nums.sorted()
    val results = mutableMapOf<Int, Int>()
    var j = 1
    for (i in sortedNums.indices) {
        if (sortedNums[i] <= 0) {
            continue
        } else if (!results.containsValue(sortedNums[i])) {
            results[j] = sortedNums[i]
            j++
        }
    }
    println(results)
    if (results.isEmpty())
        return 1

    for (i in 1 until j) {
        if (results[i]!! > i)
            return i
    }
    return results[j-1]?.plus(1) ?: 1
}
fun firstMissingPositive(nums: IntArray): Int {
    val n: Int = nums.size
    val fakeNumber = n + 1

    // Step 1.

    // Step 1.
    for (i in 0 until n) {
        if (nums[i] <= 0 || nums[i] > n) {
            nums[i] = fakeNumber
        }
    }
    for (i in 0 until n) {
        var num = Math.abs(nums[i]) // point 1
        if (num == fakeNumber) { // point 2
            continue
        }
        num-- // point 3
        if (nums[num] > 0) {
            nums[num] *= -1
        }
    }
    for (i in 0 until n) {
        if (nums[i] >= 0) {
            return i + 1
        }
    }
    return n + 1
}