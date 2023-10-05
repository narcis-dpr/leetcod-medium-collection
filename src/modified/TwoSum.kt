package modified

fun main() {
    val input1 = intArrayOf(1, 1, 2, 23, 4, 9, 13, 6, 9)
    val desiredSum = 10
    // result : [[0,8],[1,5]]
    println(twoSum(input1, desiredSum))
}

private fun twoSum(inputNumbers: IntArray, desiredSum: Int): List<Pair<Int, Int>> {
    val size = inputNumbers.size
    val result: MutableList<Pair<Int, Int>> = mutableListOf()
    val matchMap = mutableMapOf<Int, Int>()
    for (i in 0 until size) {
        if (matchMap.contains(inputNumbers[i])) {
            result.add(Pair(matchMap[inputNumbers[i]]!!, i))
        } else {
            matchMap[desiredSum - inputNumbers[i]] = i
        }
    }
    return result.toList()
}
/// without hashmap
fun twoSumSlicedArray(nums: IntArray, desiredSum: Int): List<Pair<Int, Int>> {
    val results: MutableList<Pair<Int, Int>> = mutableListOf()

    val numSize = nums.size
    for (i in 0 until numSize) {
        val desiredMissingNumber = desiredSum - nums[i]
        val newNums = nums.sliceArray(i + 1 until numSize)
        if (newNums.contains(desiredMissingNumber)) {
            val index = newNums.indexOf(desiredMissingNumber)
            results.add(Pair(i, index + i + 1))
        }

    }
    return results
}