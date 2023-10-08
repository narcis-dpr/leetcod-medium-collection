package array

fun main() {
    val inputOne = intArrayOf(1,2,3,4,5,6,7)
    val inputTwo = intArrayOf(-1)
    val inputThree = intArrayOf(1,2)
    println(rotate(inputThree, 3))
}
fun rotateBruteForce(nums: IntArray, k: Int): Unit {
    val numsSize = nums.size
    repeat(k) {
    var temp = nums[0]
    val last = nums[numsSize - 1]
    for (i in 0 until numsSize) {
        if (i < numsSize - 1) {
            val second = nums[i + 1]
            nums[i + 1] = temp
            temp = second
        } else {
            nums[0] = last
        }
    }
}
    nums.forEach { print(" " + it + " ") }
}
fun rotate(nums: IntArray, k: Int): Unit {
    val size = nums.size
    val result = IntArray(size)
    for (i in 0 until size) {
        result[(k+i)%size] = nums[i]
    }
    for (i in nums.indices) {
        nums[i] = result[i]
    }
}

fun rotateLeetCode(nums: IntArray, k: Int) {
    val a = IntArray(nums.size)
    for (i in nums.indices) {
        a[(i + k) % nums.size] = nums[i]
    }
    for (i in nums.indices) {
        nums[i] = a[i]
    }
}