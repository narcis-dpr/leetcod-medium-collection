package array

fun main() {
    val inputOne = intArrayOf(1, 1, 1, 2, 2, 3)
    println(removeDuplicatesLeetCode1(inputOne))
}

fun removeDuplicatesTwoHashMap(nums: IntArray): Int {
    val numsSize = nums.size
    val result = mutableMapOf<Int, Int>()
    for (i in 0 until numsSize) {
        if (result.contains(nums[i])) {
            if (result[nums[i]]!! < 2)
            result[nums[i]] = result[nums[i]]!! + 1
        } else {
            result[nums[i]] = 1
        }
    }
    var mainIndex = 0
    for (key in result.keys) {
        repeat(result[key]!!){
            nums[mainIndex] = key
            mainIndex++
        }
    }
    return mainIndex
}

fun removeDuplicatesLeetCode1(nums: IntArray): Int {
    var count = 0
    var writePointer = 0
    var lastSeen: Int? = null
    var sndLastSeen: Int? = null
    for (i in 0..nums.size - 1) {
        if ( nums[i] == lastSeen && lastSeen == sndLastSeen) {
            continue
        } else {
            sndLastSeen = lastSeen
            lastSeen = nums[i]
            nums[writePointer] = nums[i]
            count++
            writePointer++
        }
    }
    return count
}

fun removeDuplicatesLeetCodeTwo(nums: IntArray): Int {
    var k = 1
    for (i in 2..nums.lastIndex) {
        if (nums[k] != nums[i] || nums[i] != nums[k - 1]) {
            k++
            nums[k] = nums[i]
        }
    }

    return k + 1
}
