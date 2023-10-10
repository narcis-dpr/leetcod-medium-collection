package array

fun main() {
    val inputOne = intArrayOf(2,3,1,1,4)
    val inputTwo = intArrayOf(3,2,1,0,4)
    val inputThree = intArrayOf(2,0,0)
    val inputFour = intArrayOf(2)
    val inputFive = intArrayOf(2,0,2)
    println(canJump(inputFour))
}

fun canJump(nums: IntArray): Boolean {
   val size = nums.size
    var currentGoal = size-1
    for (i in size-2 downTo 0) {
        if (nums[i] >= (currentGoal - i)) {
            currentGoal = i
                }
        println(currentGoal)
    }

    return currentGoal==0
}
fun canJumpLeetCode(nums: IntArray): Boolean {
    var lastPos = nums.size - 1

    for (i in nums.size - 2 downTo 0) {
        if (i + nums[i] >= lastPos) {
            lastPos = i
        }
    }

    return lastPos == 0
}

