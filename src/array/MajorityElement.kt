package array

fun main() {
    val inputOne = intArrayOf(3,2,3)
    val inputTwo = intArrayOf(1,2,3,4,5,6,7,8,9,2)
    println(majorityElementHashMap(inputTwo))
}
fun majorityElementHashMap(nums: IntArray): Int {
    val numsSize = nums.size
    val result = mutableMapOf<Int, Int>()
    for (i in 0 until numsSize) {
        if (result.contains(nums[i])) {
            result[nums[i]] = result[nums[i]]!! + 1
        } else {
            result[nums[i]] = 1
        }
    }
//    var maxValue = result.maxBy { it.value }
//    println(maxValue.key)
    return result.maxBy { it.value }.key
}