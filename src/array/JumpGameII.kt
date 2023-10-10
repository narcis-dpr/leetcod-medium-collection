package array

import kotlin.math.min

fun main() {
    val inputOne = intArrayOf(2, 3, 1, 1, 4)
    val inputTwo = intArrayOf(2, 3, 0, 1, 4)
    val inputThree = intArrayOf(2, 3, 1)
    println(jump(inputThree))
}

fun jump(nums: IntArray): Int {
    if (nums.size == 1) return 0
    var jump = 1
    var cur = nums[0]
    var next = nums[0]
    for (i in 1 until nums.size - 1) {
        next = next.coerceAtLeast(nums[i] + i)
        if (i == cur){
            ++jump
            cur = next
        }
    }
    return jump
}

fun jumpDynamic(nums: IntArray): Int {
    val numsSize = nums.size
    val store = IntArray(numsSize)
    store[0] = 0
    for (i in 1 until numsSize) {
        store[i] = Int.MAX_VALUE
        for (j in 0 until i) {
            if (i <= nums[j] + j && store[j] != Int.MAX_VALUE) {
                store[i] = min(store[i], store[j] + 1)
                break
            }
        }
    }
    return store[numsSize - 1]
}

lateinit var store: IntArray
fun minJumps(nums: IntArray, start: Int): Int {
    if (start >= nums.size - 1)
        return 0

    if (store[start] == 1)
        return store[start]
    var minJump = 10000

    for (i in start + 1..start + nums[start]) {
        minJump = min(minJump, 1 + minJumps(nums, i))
    }
    store[start] = minJump

    return store[start]
}

fun jumpTopDown(): Int {

    val inputThree = intArrayOf(2, 3, 1)
    store = IntArray(inputThree.size)
    return minJumps(nums = inputThree, 0)
}