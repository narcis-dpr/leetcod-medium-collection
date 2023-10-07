package array

fun main() {
    val inputOne = intArrayOf(3, 2, 2, 3)
    println(removeElement(inputOne, 2))
}

fun removeElement(nums: IntArray, `val`: Int): Int {
    val numsSize = nums.size
    var numberOfOccurrence = 0
    for (i in 0 until numsSize) {
        if (nums[i] == `val`) {
            nums[i] = Int.MAX_VALUE
            numberOfOccurrence++
        }
    }
   nums.sort()
    return numsSize - numberOfOccurrence
}
