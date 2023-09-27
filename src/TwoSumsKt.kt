fun main() {
    val sampleOne = intArrayOf(3, 2, 4)
    val sum = 6
    println(twoSum(sampleOne, sum).toString())
    twoSumLeetCodeHashMap(sampleOne, sum).forEach {
        println(it)
    }
}

fun twoSumForSortedArray(nums: IntArray, desiredSum: Int): List<Pair<Int, Int>> {
    val results: MutableList<Pair<Int, Int>> = mutableListOf()
    val numSize = nums.size
    for (i in 0 until numSize) {
        var firstPointer = 0
        var lastPointer = numSize - 1

        while (firstPointer < lastPointer) {
            val localSum = nums[firstPointer] + nums[lastPointer]
            if (localSum < desiredSum) {
                firstPointer++
            } else if (localSum > desiredSum) {
                lastPointer--
            } else {
                results.add(Pair(firstPointer, lastPointer))
                firstPointer++
                lastPointer--
            }
        }

    }
    return results
}

fun twoSum(nums: IntArray, desiredSum: Int): List<Pair<Int, Int>> { // rigged ! doest work when it finds the same index for you as i !
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

fun twoSumLeetCode(nums: IntArray, target: Int): IntArray {
    val results = IntArray(2)

    val numSize = nums.size
    for (i in 0 until numSize) {
        val desiredMissingNumber = target - nums[i]
        val newNums = nums.sliceArray(i + 1 until numSize)
        if (newNums.contains(desiredMissingNumber)) {
            val index = newNums.indexOf(desiredMissingNumber)
            results[0] = i
            results[1] = index + i + 1
        }

    }
    return results
}

fun twoSumLeetCodeHashMap(nums: IntArray, target: Int): IntArray {
    val result = IntArray(2)
    val differences: MutableMap<Int, Int> = HashMap()
    val numSize = nums.size
    for (i in 0 until numSize) {
        if (differences.contains(nums[i])) {
            result[0] = differences[nums[i]]!!
            result[1] = i
        } else {
            differences[target-nums[i]] = i
        }
    }
    return result
}